package emulator.vm;

import emulator.gui.VM;
import emulator.rm.RMController;

/**
 *
 * @author Oni-Q
 */
public class Memory {
    public static final int VIRTUAL_MEMORY_SIZE = 256;
    public static RMController rmc;
    
    public static void setMemory(VMController vmc, int adress, String word){
        if (word.length() != 4){
            System.err.println("Word must be 4 bytes");
            return;
        }
        try{
            if (rmc.memory(vmc, adress, word))
                vmc.vm.setMemory(adress, word);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
        }
    }
    
    public static void setMemory(VMController vmc, String adress, String word){
        if (word.length() != 4){
            System.err.println("Word must be 4 bytes");
            return;
        }
        try{
            if (rmc.memory(vmc, Integer.parseInt(adress, 16), word))
                vmc.vm.setMemory(adress, word);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
        }
    }
    
    public static String getMemory(VM vm, int adress){
        String word = null;
        try{
            word = vm.getMemory(adress);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
        }
        return word;
    }
    
    public static String getMemory(VM vm, String adress){
        String word = null;
        try{
            word = vm.getMemory(adress);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
        }
        return word;
    }
}
