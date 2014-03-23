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
    
    public static void setMemory(RM rm, int adress, String word){
        if (word.length() != 4){
            System.err.println("Word must be 4 bytes");
            return;
        }
        try{
            rm.setMemory(adress, word);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
        }
    }
    
    public static void setMemory(RM rm, String adress, String word){
        if (word.length() != 4){
            System.err.println("Word must be 4 bytes");
            return;
        }
        try{
            rm.setMemory(adress, word);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
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
