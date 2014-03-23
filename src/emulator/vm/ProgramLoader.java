package emulator.vm;

import emulator.gui.VM;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 *
 * @author Oni-Q
 */
public class ProgramLoader {
    
    static public void loadToMemory(VMController vmc, File file){
        try {
            Scanner fileScan = new Scanner(new BufferedReader(
                    new FileReader(file)));
            fileScan.useDelimiter(System.getProperty("line.separator"));
            String command;
            int adress = 0;
            while (fileScan.hasNext()){
                command = fileScan.next();
                if (command.equalsIgnoreCase("CODE") || command.equalsIgnoreCase("DATA")|| command.isEmpty()){
                }
                else if (command.startsWith("#")){
                    adress = Integer.parseInt(command.substring(1, 5));
                }
                else if (command.length() != 4){
                    throw new DataFormatException("Wrong code");
                }
                else{
                    Memory.setMemory(vmc, adress, command);
                    adress++;
                }
            }
        } 
        catch (FileNotFoundException e) {
        } 
        catch (DataFormatException e) {
            System.err.println(e.getMessage());
        } 
    }
}
