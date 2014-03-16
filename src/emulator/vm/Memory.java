package emulator.vm;

import static emulator.gui.VM.vm;

/**
 *
 * @author Oni-Q
 */
public class Memory {
    public static final int VIRTUAL_MEMORY_SIZE = 256;
    
    public void setMemory(int adress, String word){
        if (word.length() != 4){
            System.err.println("Word must be 4 bytes");
            return;
        }
        try{
            vm.setMemory(adress, word);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Wrong adress");
        }
    }
    
    public String getMemory(int adress){
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
