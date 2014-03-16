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
public class Registers {
    private byte[] R;
    private byte[] D;
    private byte[] IC;
    private boolean C;
    private final VM vm;
    
    public Registers(VM vm){
        R = new byte[4];
        D = new byte[4];
        IC = new byte[2];
        C = false;
        this.vm = vm;
    }
    
    public void setReg(String reg, boolean value){
        if(reg.equals("C")){
            C = value;
            vm.setC(C);
        }
        else{
            System.err.println("No register named " + reg);
        }
    }
    
    public void setReg(String reg, byte[] value){
        switch (reg){
            case("R"):
                if (value.length == 4){
                    R = value.clone();
                    vm.setR(R);
                }
                else{
                    System.err.println(reg + "size must be 4");
                }
                break;
            case("D"):
                if (value.length == 4){
                    D = value.clone();
                    vm.setD(D);
                }
                else{
                    System.err.println(reg + "size must be 4");
                }
                break;
            case("IC"):
                if (value.length == 2){
                    IC = value.clone();
                    vm.setIC(IC);
                }
                else{
                    System.err.println(reg + "size must be 2");
                }
                break;
            case("C"):
                System.err.println(reg + " value must be boolean");
                break;
            default:
                System.err.println("No register named " + reg);
        }
    }

    public byte[] getR() {
        return R;
    }

    public byte[] getD() {
        return D;
    }

    public byte[] getIC() {
        return IC;
    }

    public boolean getC() {
        return C;
    }
    
}
