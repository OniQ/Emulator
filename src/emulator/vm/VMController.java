/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emulator.vm; 

import emulator.gui.VM;

/**
 *
 * @author Oni-Q
 */
public class VMController{
    
    final VM vm;
    final Registers registers;
    final ButtonHandler hButtons;
    
    public VMController(){
        registers = new Registers();
        hButtons = new ButtonHandler(registers);
        vm = new VM(hButtons);
        
    }
    
    public void run(){
        vm.run();
        test();
    }
    
    private void test(){
        Memory.setMemory(vm ,5, "2222");
        String s = Memory.getMemory(vm, 5);
        registers.setReg(vm, "R", new byte[]{1, 2, 3, 4});
        registers.setReg(vm, "C", false);
        registers.setReg(vm, "D", new byte[]{7, 7, 7, 7});
        System.out.println(registers.getR()[3]);
        System.out.println(s);
        vm.writeToConsole("wnjeoginwoihgnowbhowbnhownohg");
        vm.writeToConsole("-------------------");
    }
}
