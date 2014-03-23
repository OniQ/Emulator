/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emulator.rm;

import emulator.gui.RM;
import static emulator.gui.RM.MEMORY_SIZE;
import emulator.vm.VMController;
import java.util.ArrayList;

/**
 *
 * @author Oni-Q
 */
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
        rm.setCHST(1, true);//for test
    }
    
    public void addVM(VMController vm){
        vmcs.add(vm);
        vm.run();
    }
    
    public void run(){
        emulator.vm.Data.rmc = this;
        int ptBlock = MEMORY_SIZE;
        rm.run();
        for(VMController ctrl : vmcs){
            ptBlock -= 16;
            if (Memory.getMemory(rm, ptBlock) != null){
                System.err.println("Not enough memory for page table");
                break;
            }
            pts.add(ptBlock);
            registers.setReg("PTR", String.valueOf(ptBlock));
            ctrl.run();
        }
    }
    
    public boolean memory(VMController vm, int address, String value){
        int pt = pts.get(vmcs.indexOf(vm));
        int block = address / 16;
        if (Memory.getMemory(rm, pt + block) == null){
            String realBlock = null;
            for (int i = 0; i < 16; i++){
                if (blocks[i] == null){
                    realBlock = String.format("%04X", i & 0xFFF);
                    blocks[i] = block;
                    break;
                }
            }
            if (realBlock != null)
                Memory.setMemory(rm, pt + block, realBlock);
            else{
                System.err.println("Not enough memory");
                return false;
            }
                
        }
        int ra = Integer.parseInt(Memory.getMemory(rm, pt + block), 16)*16 + address - block*16;
        Memory.setMemory(rm, ra, value);
        return true;
    }
}
