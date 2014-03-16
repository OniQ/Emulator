/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emulator.vm; 

/**
 *
 * @author Oni-Q
 */
public class VMController{
    
    private Memory memory = new Memory();
    
    public void run(){
        test();
    }
    
    private void test(){
        memory.setMemory(5, "2222");
        String s = memory.getMemory(5);
        System.out.println(s);
    }
}
