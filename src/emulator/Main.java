package emulator;

import emulator.rm.RMController;
import emulator.vm.VMController;
import java.util.ArrayList;

public class Main {
    
    public static void main(String args[]) {
        ArrayList<VMController> vmcs = new ArrayList<>();
        for (int i = 0; i < 1; i++){
            VMController vmc = new VMController();
            vmcs.add(vmc);
        }
        
        RMController rmc = new RMController(vmcs);
        rmc.run();
    }
}
