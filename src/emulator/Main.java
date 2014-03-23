package emulator;

import emulator.rm.RMController;
import emulator.vm.VMController;
import java.util.ArrayList;

/**
 *
 * @author Oni-Q
 */
public class Main {
    
    public static void main(String args[]) {
        ArrayList<VMController> vmcs = new ArrayList<>();
        VMController vmc = new VMController();
        vmcs.add(vmc);
        RMController rmc = new RMController(vmcs);
        rmc.run();
    }
}
