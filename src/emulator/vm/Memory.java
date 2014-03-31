package emulator.vm;

import emulator.gui.VM;
import static emulator.vm.Data.rmc;

public class Memory {
    public static final int VIRTUAL_MEMORY_SIZE = 256;
    
    public static void setMemory(VMController vmc, int address, String word){
        if (word.length() != 4){
            System.err.println("Word must be 4 bytes");
            return;
        }
        try{
            if (rmc.memory(vmc, address, word)){
                vmc.vm.setMemory(address, word);
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
        }
    }
    
    public static void setMemory(VMController vmc, String address, String word){
        setMemory(vmc, Integer.parseInt(address, 16), word);
    }
    
    public static String getMemory(VM vm, int address){
        String word = null;
        try{
            word = vm.getMemory(address);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
        }
        return word;
    }
    
    public static String getMemory(VM vm, String address){
        return getMemory(vm, Integer.parseInt(address, 16));
    }
    
    public static String next(String address){
        int intAddress = Integer.parseInt(address, 16) + 1;
        if (intAddress > VIRTUAL_MEMORY_SIZE)
            intAddress = 0;
        return String.format("%02X", intAddress & 0xFF);
    }
}
