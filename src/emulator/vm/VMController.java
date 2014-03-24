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
    Data data;
    
    public VMController(){
        data = new Data();
        registers = new Registers(this, data);
        comInter = new CommandInterpreter(this);
        hButtons = new ButtonHandler(this);
        exe = new Executor(this);
        vm = new VM(hButtons, data);
        
    }
    
    public void run(){
        vm.run();
        test();
    }
    
    public void reset(){
        registers.reset();
        vm.initMemory();
        vm.clearConsole();
    }
    
    private void test(){
//        Memory.setMemory(vm , 5, "2222");
//        String s = Memory.getMemory(vm, 5);
//        registers.setReg("C", false);
//        System.out.println(registers.getR());
//        System.out.println(s);
    }
}
