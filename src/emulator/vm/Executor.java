package emulator.vm;

/**
 *
 * @author Oni-Q
 */
public class Executor {
    
    VMController vmc;
    String command = "";
    
    public Executor(VMController vmc){
        this.vmc = vmc;
    }

    public void run(){
        while (!"HALT".equals(command)){
            next();
        }
    }
    
    public void next(){
        if (!"HALT".equals(command)){
            int adress = Integer.parseInt(vmc.registers.getIC(), 16);
            command = Memory.getMemory(vmc.vm, adress);
            vmc.comInter.execute(command);
        }
    }
    
    public void restart(){
        command = "";
        vmc.vm.clearConsole();
    }
    
    public void back(){
        
    }
}