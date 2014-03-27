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
public class CommandInterpreter {
    
    VMController vmc;
    
    public CommandInterpreter(VMController vmc){
        this.vmc = vmc;
    }
    
    public void toNext(){
        int newAdress = Integer.parseInt(vmc.registers.getIC(), 16);
        newAdress = newAdress < 255 ? (newAdress + 1) : 0;
        vmc.registers.setReg("IC", String.valueOf(newAdress));
    }
    
    public void execute(String command){
        Data.rmc.registers.setReg("SI", "0");
        Data.rmc.registers.setReg("PI", "0");
        Data.rmc.registers.setReg("CHST2", false);
        Data.rmc.registers.setIOI(2, false);
        if (command.length() != 4){
            System.err.println("Unsupported command: " + command);
        }
        else{
            String opcode = command.substring(0, 2);
            String adress = command.substring(2, 4);
            switch(opcode){
                case("PD"):
                    vmc.vm.writeToConsole(Memory.getMemory(vmc.vm, adress));
                    Data.rmc.registers.setReg("SI", "2");
                    Data.rmc.registers.setReg("CHST2", true);
                    Data.rmc.registers.setIOI(2, true);
                    break;
                case("GD"):
                    Data.rmc.registers.setReg("SI", "1");
                    Data.rmc.registers.setReg("CHST1", true);
                    Data.rmc.registers.setIOI(1, true);
                    String data = vmc.vm.readData();
                    Data.rmc.registers.setReg("CHST1", false);
                    Data.rmc.registers.setIOI(1, false);
                    vmc.vm.writeToConsole(": " + data + vmc.newLine);
                    Memory.setMemory(vmc, adress, data);
                    break;
                case("LR"):
                    vmc.registers.setReg("R", Memory.getMemory(vmc.vm, adress));
                    break;
                case("LD"):
                    vmc.registers.setReg("D", Memory.getMemory(vmc.vm, adress));
                    break;
                case("SR"):
                    Memory.setMemory(vmc, adress, vmc.registers.getR());
                    break;
                case("SD"):
                    Memory.setMemory(vmc, adress, vmc.registers.getD());
                    break;
                case("JP"):
                    vmc.registers.setReg("IC", adress);
                    break;
                case("JT"):
                    if (vmc.registers.getC())
                        vmc.registers.setReg("IC", adress);
                    break;
                case("SU"):
                {
                    int R = Integer.parseInt(vmc.registers.getR());
                    R -= Integer.parseInt(Memory.getMemory(vmc.vm, adress));
                    vmc.registers.setReg("R", String.valueOf(R));
                    break;
                }
                case("AD"):
                {
                    int R = Integer.parseInt(vmc.registers.getR());
                    R += Integer.parseInt(Memory.getMemory(vmc.vm, adress));
                    vmc.registers.setReg("R", String.valueOf(R));
                    break;
                }
                case("MU"):
                {
                    int R = Integer.parseInt(vmc.registers.getR());
                    R *= Integer.parseInt(Memory.getMemory(vmc.vm, adress));
                    if (R > 9999){
                        String value = String.format("%08d", R);
                        String hi = value.substring(0, 4);
                        String lo = value.substring(4, 8);
                        vmc.registers.setReg("R", lo);
                        vmc.registers.setReg("D", hi);
                    }
                    else{
                        vmc.registers.setReg("R", String.valueOf(R));
                        vmc.registers.setReg("D", "0000");
                    }
                    break;
                }
                case("DI"):
                {
                    int R = Integer.parseInt(vmc.registers.getR());
                    int D = R % Integer.parseInt(Memory.getMemory(vmc.vm, adress));
                    R /= Integer.parseInt(Memory.getMemory(vmc.vm, adress));
                    vmc.registers.setReg("D", String.valueOf(D));
                    vmc.registers.setReg("R", String.valueOf(R));
                    break;
                }
                case("CH"):{
                    int R = Integer.parseInt(vmc.registers.getR());
                    if (R > Integer.parseInt(Memory.getMemory(vmc.vm, adress))){
                        vmc.registers.setReg("C", true);
                    }
                    else{
                        vmc.registers.setReg("C", false);
                    }
                    break;
                }
                case("CE"):{
                    int R = Integer.parseInt(vmc.registers.getR());
                    if (R == Integer.parseInt(Memory.getMemory(vmc.vm, adress))){
                        vmc.registers.setReg("C", true);
                    }
                    else{
                        vmc.registers.setReg("C", false);
                    }
                    break;
                }
                case("HA"):
                    Data.rmc.registers.setReg("SI", "3");
                    vmc.vm.writeToConsole(vmc.newLine + "Program terminated");
                    break;
                case("00"):
                    //System.err.println("Empty memory");
                    break;
                default:
                    Data.rmc.registers.setReg("PI", "2");
                    System.err.println("Unsupported command: " + command);
            }
        }
    }
}
