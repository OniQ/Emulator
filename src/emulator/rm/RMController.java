/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emulator.rm;

import emulator.gui.RM;
import emulator.vm.VMController;
import java.util.ArrayList;

/**
 *
 * @author Oni-Q
 */
public class RMController {
    
    ArrayList<VMController> vmcs = new ArrayList<>();
    RM rm = new RM();
    
    public RMController(ArrayList<VMController> _vmcs){
        vmcs = _vmcs;
    }
    
    public void addVM(VMController vm){
        vmcs.add(vm);
    }
    
    public void run(){
        rm.run();
        for(VMController ctrl : vmcs){
            ctrl.run();
        }
    }
}
