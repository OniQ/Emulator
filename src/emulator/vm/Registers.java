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
public class Registers {
    VMController vmc;
    private final String[] R;
    private final String[] D;
    private String IC;
    private boolean C;
    
    public Registers(VMController vmc){
        this.vmc = vmc;
        R = new String[]{"0", "0", "0", "0"};
        D = new String[]{"0", "0", "0", "0"};
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
            case("R"):
                if (value.length() == 4){
                    R[0] = String.valueOf(value.charAt(0));
                    R[1] = String.valueOf(value.charAt(1));
                    R[2] = String.valueOf(value.charAt(2));
                    R[3] = String.valueOf(value.charAt(3));
                    vmc.vm.setR(R);
                }
                else{
                    System.err.println(reg + "size must be 4");
                }
                break;
            case("D"):
                if (value.length() == 4){
                    D[0] = String.valueOf(value.charAt(0));
                    D[1] = String.valueOf(value.charAt(1));
                    D[2] = String.valueOf(value.charAt(2));
                    D[3] = String.valueOf(value.charAt(3));
                    vmc.vm.setD(D);
                }
                else{
                    System.err.println(reg + "size must be 4");
                }
                break;
            case("C"):
                System.err.println(reg + " value must be boolean");
                break;
            case("IC"):
                String data = String.format("%02X", Integer.parseInt(value) & 0xFF);
                IC = data;
                vmc.vm.setIC(IC);
                break;
            default:
                System.err.println("No register named " + reg);
        }
    }

    public String getR() {
        return R[0] + R[1] + R[2] + R[3];
    }

    public String getD() {
        return D[0] + D[1] + D[2] + D[3];
    }

    public String getIC() {
        return IC;
    }

    public boolean getC() {
        return C;
    }
}
