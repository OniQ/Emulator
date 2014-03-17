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
        if (command.length() != 4){
            System.err.println("Unsupported command: " + command);
        }
        else{
            String opcode = command.substring(0, 2);
            String adress = command.substring(2, 4);
            switch(opcode){
                case("PD"):
                    vmc.vm.writeToConsole(Memory.getMemory(vmc.vm, adress));
                    break;
                case("LD"):
                    String memory = Memory.getMemory(vmc.vm, adress);
                    vmc.registers.setReg("R", memory);
                    break;
                case("GD"):
                    String data = vmc.vm.readData();
                    vmc.vm.writeToConsole(": " + data + vmc.newLine);
                    Memory.setMemory(vmc.vm, adress, data);
                    break;
                case("HA"):
                    vmc.vm.writeToConsole(vmc.newLine + "Program terminated");
                    break;
                case("00"):
                    //System.err.println("Empty memory");
                    break;
                default:
                    System.err.println("Unsupported command: " + command);
            }
        }
    }
}
