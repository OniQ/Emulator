/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emulator;

import emulator.vm.VMController;

/**
 *
 * @author Oni-Q
 */
public class Main {
    
    private static VMController vmc; 
    
    public static void main(String args[]) {
        vmc = new VMController(); 
        vmc.run();
    }

    public Main() {
        
    }
}
