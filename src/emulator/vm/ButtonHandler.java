package emulator.vm;

import static emulator.vm.ProgramLoader.loadToMemory;
import java.io.File;

public class ButtonHandler{
    
    VMController vmc;
    private File file;
    
    
    ButtonHandler(VMController vmc){
        this.vmc = vmc; 
    }
            
    public void load(File file){
        this.file = file;
        loadToMemory(vmc, file);
    }
    
    public void reload(){
        if (file != null){
            vmc.registers.setReg("IC", String.valueOf(0));
            loadToMemory(vmc, file);
            vmc.exe.restart();
        }
    }
    
    public void inputData(String data){
        vmc.exe.inputData(data);
    }
    
    public void runApp(){
        try{
            if (file != null){
                vmc.exe.run();
            }
        }
        catch (NumberFormatException e) { 
            System.err.println(e);
            vmc.reset();
        }
    }
    
    public void next(){
        try{
            if (file != null)
                vmc.exe.next();
        }
        catch (NumberFormatException e) { 
            System.err.println(e);
            vmc.reset();
        }
    }
    
    public void back(){
        if (file != null)
            vmc.exe.back();
    }
}
