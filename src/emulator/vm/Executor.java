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
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) { }
            int adress = Integer.parseInt(vmc.registers.getIC(), 16);
            vmc.vm.setSelected(adress);
            command = Memory.getMemory(vmc.vm, adress);
            vmc.comInter.execute(command);
            vmc.comInter.toNext();
        }
    }
    
    public void restart(){
        command = "";
        vmc.vm.clearConsole();
        vmc.vm.setSelected(0);
    }
    
    public void back(){
        
    }

    public synchronized void inputData(String data) {
        command = data;
        try{
            vmc.comInter.execute(command);
        }
        catch(NumberFormatException e){
            System.err.println(e.getMessage());
        }
    }
}