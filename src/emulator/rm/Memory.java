package emulator.rm;

import emulator.gui.RM;
import static emulator.gui.RM.MEMORY_SIZE;

/**
 *
 * @author Oni-Q
 */
public class Memory {
    public static final int VIRTUAL_MEMORY_SIZE = 256;
    public static String[] memoryBuffer = new String[MEMORY_SIZE];
    
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
