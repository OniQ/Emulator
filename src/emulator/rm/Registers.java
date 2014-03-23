package emulator.rm; 

public class Registers {
    RMController rmc;
    private final Data data;

    Registers(RMController aThis, Data _data) {
        this.rmc = aThis;
        this.data = _data;
        data.R = new String[]{"0", "0", "0", "0"};
        data.D = new String[]{"0", "0", "0", "0"};
        data.IC = "0";
        data.C = false;
        data.PTR = new String[]{"0", "0", "0", "0"};
        data.IC = "0";
        data.PI = "0";
        data.IOI = "0";
        data.TI = "0";
        data.SI = "0";
        data.MODE = "0";
        data.C = false;
    }
    
    public void setReg(String reg, boolean value){
        if(reg.equals("C")){
            data.C = value;
            rmc.rm.setC(data.C);
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
                    rmc.rm.setR(data.R);
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
                    rmc.rm.setD(data.D);
                }
                else{
                    System.err.println(reg + "size must be 4");
                }
                break;
            case("PTR"):
                String ptr = String.format("%04X", Integer.parseInt(value));
                data.PTR[0] = String.valueOf(ptr.charAt(0));
                data.PTR[1] = String.valueOf(ptr.charAt(1));
                data.PTR[2] = String.valueOf(ptr.charAt(2));
                data.PTR[3] = String.valueOf(ptr.charAt(3));
                rmc.rm.setPTR(data.PTR);
                break;
            case("C"):
                System.err.println(reg + " value must be boolean");
                break;
            case("IC"):
                String _data = String.format("%02X", Integer.parseInt(value) & 0xFF);
                data.IC = _data;
                rmc.rm.setIC(data.IC);
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
