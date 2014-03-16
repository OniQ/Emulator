package emulator.vm;

import emulator.gui.VM;
import static emulator.vm.ProgramLoader.loadToMemory;
import java.io.File;

/**
 *
 * @author Oni-Q
 */
public class ButtonHandler{
    
    Registers registers;
    private File file;
    
    ButtonHandler(Registers registers){
        this.registers = registers;
    }
            
    public void load(VM vm, File file){
        this.file = file;
        loadToMemory(vm, file);
    }
    
    public void reload(VM vm){
        if (file != null){
            registers.setReg(vm, "IC", new byte[]{0, 0});
            loadToMemory(vm, file);
        }
    }
    
}
