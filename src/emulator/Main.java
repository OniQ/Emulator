package emulator;

import emulator.vm.VMController;

/**
 *
 * @author Oni-Q
 */
public class Main {
    
    public static void main(String args[]) {
        VMController vmc;
        vmc = new VMController();
        vmc.run();
//        VMController vmc2;
//        vmc2 = new VMController();
//        vmc2.run();
    }
}
