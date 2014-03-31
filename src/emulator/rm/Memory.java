package emulator.rm;

import emulator.gui.RM;
import static emulator.vm.Memory.VIRTUAL_MEMORY_SIZE;

public class Memory {
    public static final int MEMORY_SIZE = VIRTUAL_MEMORY_SIZE + 64;
    public static String[] memoryBuffer = new String[MEMORY_SIZE];
    public static final int BLOCK_SIZE = 16;
    
    public static void setMemory(RMController rmc, int adress, String word){
        if (word.length() != 4){
            System.err.println("Word must be 4 bytes");
            return;
        }
        try{
            rmc.rm.setMemory(adress, word);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
            rmc.registers.setReg("PI", "1");
        }
    }
    
    public static void setMemory(RMController rmc, String adress, String word){
        if (word.length() != 4){
            System.err.println("Word must be 4 bytes");
            return;
        }
        try{
            rmc.rm.setMemory(adress, word);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
            rmc.registers.setReg("PI", "1");
        }
    }
    
    public static String getMemory(RM rm, int adress){
        String word = null;
        try{
            word = rm.getMemory(adress);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
        }
        return word;
    }
    
    public static String getMemory(RM rm, String adress){
        String word = null;
        try{
            word = rm.getMemory(adress);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
        }
        return word;
    }
}
