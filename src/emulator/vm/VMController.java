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
    private final Registers registers;
    
    public VMController(){
        vm = new VM();
        registers = new Registers(vm);
    }
    
    public void run(){
        vm.run();
        test();
    }
    
    private void test(){
        Memory.setMemory(vm ,5, "2222");
        String s = Memory.getMemory(vm, 5);
        registers.setReg("R", new byte[]{1, 2, 3, 4});
        registers.setReg("C", false);
        registers.setReg("D", new byte[]{7, 7, 7, 7});
        System.out.println(registers.getR()[3]);
        System.out.println(s);
        vm.writeToConsole("wnjeoginwoihgnowbhowbnhownohg");
        vm.writeToConsole("-------------------");
    }
}
