package emulator.vm;

import static emulator.vm.Data.rmc;

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
                int address = Integer.parseInt(vmc.registers.getIC(), 16);
                vmc.vm.setSelectedMemory(address);
                rmc.setSelectedMemory(rmc.getRealAdress(vmc, address));
                command = Memory.getMemory(vmc.vm, address);
                vmc.comInter.execute(command);
                vmc.comInter.toNext();
            } catch (InterruptedException e) { 
                System.err.println(e); 
                Data.rmc.registers.setReg("PI", "3");
            }
        }
    }
    
    public void restart(){
        command = "";
        vmc.vm.clearConsole();
        vmc.vm.setSelectedMemory(0);
    }
    
    public void back(){
        
    }

    public void inputData(String data) {
        command = data;
        try{
            vmc.comInter.execute(command);
        }
        catch(NumberFormatException e){
            System.err.println(e);
        }
    }
}