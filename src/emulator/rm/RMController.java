package emulator.rm;

import emulator.gui.RM;
import static emulator.rm.Memory.BLOCK_SIZE;
import static emulator.rm.Memory.MEMORY_SIZE;
import static emulator.vm.Memory.VIRTUAL_MEMORY_SIZE;
import emulator.vm.VMController;
import java.util.ArrayList;

public class RMController {
    
    ArrayList<VMController> vmcs = new ArrayList<>();
    ArrayList<Integer> pts;
    Integer[] blocks = new Integer[16];
    RM rm = new RM();
    Data data = new Data();
    public Registers registers;
    
    public RMController(ArrayList<VMController> _vmcs){
        pts = new ArrayList<>();
        vmcs = _vmcs;
        registers = new Registers(this, data);
        for (int i = 0; i < blocks.length; i++)
            blocks[i] = null;
    }
    
    public void addVM(VMController vm){
        vmcs.add(vm);
        vm.run();
    }
    
    public void setSelectedMemory(int id){
        rm.setSelectedMemory(id);
    }
    
    public void run(){
        emulator.vm.Data.rmc = this;
        int ptBlock = MEMORY_SIZE;
        rm.run();
        for(VMController vmc : vmcs){
            ptBlock -= BLOCK_SIZE;
            if(ptBlock < VIRTUAL_MEMORY_SIZE){
                System.err.println("Not enough memory for page table");
                break;
            }
            else if (Memory.getMemory(rm, ptBlock) != null){
                System.err.println("Not enough memory for page table");
                break;
            }
            pts.add(ptBlock);
            registers.setReg("PTR", String.valueOf(ptBlock));
            vmc.run();
        }
    }
    
    public int getRealAdress(VMController vmc, int address){
        int pt = pts.get(vmcs.indexOf(vmc));
        int block = address / BLOCK_SIZE;
        return Integer.parseInt(Memory.getMemory(rm, pt + block), 16)*16 + address - block*16;
    }
    
    public boolean memory(VMController vmc, int address, String value){
        int pt = pts.get(vmcs.indexOf(vmc));
        int block = address / BLOCK_SIZE;
        if (Memory.getMemory(rm, pt + block) == null){
            String realBlock = null;
            for (int i = 0; i < BLOCK_SIZE; i++){
                if (blocks[i] == null){
                    realBlock = String.format("%04X", i & 0xFFF);
                    blocks[i] = block;
                    break;
                }
            }
            if (realBlock != null)
                Memory.setMemory(this, pt + block, realBlock);
            else{
                System.err.println("Not enough memory");
                return false;
            }
                
        }
        int ra = getRealAdress(vmc, address);
        Memory.setMemory(this, ra, value);
        return true;
    }
}
