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
    final CommandInterpreter comInter;
    final Executor exe;
    final String newLine = System.getProperty("line.separator");
    
    public VMController(){
        registers = new Registers(this);
        comInter = new CommandInterpreter(this);
        hButtons = new ButtonHandler(this);
        exe = new Executor(this);
        vm = new VM(hButtons);
        
    }
    
    public void run(){
        vm.run();
        test();
    }
    
    private void test(){
        Memory.setMemory(vm , 5, "2222");
        String s = Memory.getMemory(vm, 5);
        registers.setReg("R", new String[]{"1", "2", "3", "4"});
        registers.setReg("C", false);
        registers.setReg("D", new String[]{"7", "7", "7", "7"});
        System.out.println(registers.getR()[3]);
        System.out.println(s);
    }
}
