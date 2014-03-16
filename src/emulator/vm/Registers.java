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
    VMController vmc;
    private final String[] R;
    private final String[] D;
    private String IC;
    private boolean C;
    
    public Registers(VMController vmc){
        this.vmc = vmc;
        R = new String[4];
        D = new String[4];
        IC = "0";
        C = false;
    }
    
    public void setReg(String reg, boolean value){
        if(reg.equals("C")){
            C = value;
            vmc.vm.setC(C);
        }
        else{
            System.err.println("No register named " + reg);
        }
    }
    
    public void setReg(String reg, String value){
        switch (reg){
            case("IC"):
                String data = String.format("%02X", Integer.parseInt(value) & 0xFF);
                IC = data;
                vmc.vm.setIC(IC);
                break;
            default:
                System.err.println(reg + " value must not be single string");
                break;
        }
    }
    
    public void setReg(String reg, String[] value){
        switch (reg){
            case("R"):
                if (value.length == 4){
                    R[0] = value[0];
                    R[1] = value[1];
                    R[2] = value[2];
                    R[3] = value[3];
                    vmc.vm.setR(R);
                }
                else{
                    System.err.println(reg + "size must be 4");
                }
                break;
            case("D"):
                if (value.length == 4){
                    D[0] = value[0];
                    D[1] = value[1];
                    D[2] = value[2];
                    D[3] = value[3];
                    vmc.vm.setD(D);
                }
                else{
                    System.err.println(reg + "size must be 4");
                }
                break;
            case("C"):
                System.err.println(reg + " value must be boolean");
                break;
            default:
                System.err.println("No register named " + reg);
        }
    }

    public String[] getR() {
        return R;
    }

    public String[] getD() {
        return D;
    }

    public String getIC() {
        return IC;
    }

    public boolean getC() {
        return C;
    }
}
