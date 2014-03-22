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
    private final Data data;

    Registers(VMController aThis, Data _data) {
        this.vmc = aThis;
        this.data = _data;
        data.R = new String[]{"0", "0", "0", "0"};
        data.D = new String[]{"0", "0", "0", "0"};
        data.IC = "0";
        data.C = false;
    }
    
    public void setReg(String reg, boolean value){
        if(reg.equals("C")){
            data.C = value;
            vmc.vm.setC(data.C);
        }
        else{
            System.err.println("No register named " + reg);
        }
    }
    
    public void setReg(String reg, String value){
        switch (reg){
            case("R"):
                if (value.length() == 4){
                    data.R[0] = String.valueOf(value.charAt(0));
                    data.R[1] = String.valueOf(value.charAt(1));
                    data.R[2] = String.valueOf(value.charAt(2));
                    data.R[3] = String.valueOf(value.charAt(3));
                    vmc.vm.setR(data.R);
                }
                else{
                    System.err.println(reg + "size must be 4");
                }
                break;
            case("D"):
                if (value.length() == 4){
                    data.D[0] = String.valueOf(value.charAt(0));
                    data.D[1] = String.valueOf(value.charAt(1));
                    data.D[2] = String.valueOf(value.charAt(2));
                    data.D[3] = String.valueOf(value.charAt(3));
                    vmc.vm.setD(data.D);
                }
                else{
                    System.err.println(reg + "size must be 4");
                }
                break;
            case("C"):
                System.err.println(reg + " value must be boolean");
                break;
            case("IC"):
                String _data = String.format("%02X", Integer.parseInt(value) & 0xFF);
                data.IC = _data;
                vmc.vm.setIC(data.IC);
                break;
            default:
                System.err.println("No register named " + reg);
        }
    }

    public String getR() {
        return data.R[0] + data.R[1] + data.R[2] + data.R[3];
    }

    public String getD() {
        return data.D[0] + data.D[1] + data.D[2] + data.D[3];
    }

    public String getIC() {
        return data.IC;
    }

    public boolean getC() {
        return data.C;
    }
}
