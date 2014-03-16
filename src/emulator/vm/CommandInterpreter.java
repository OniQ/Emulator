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
    
    public void execute(String command){
        String opcode = command.substring(0, 2);
        String adressHex = command.substring(2, 4);  
        int adress;
        switch(opcode){
            case("PD"):
                adress = Integer.parseInt(adressHex, 16);
                vmc.vm.writeToConsole(Memory.getMemory(vmc.vm, adress));
                break;
            case("LD"):
                adress = Integer.parseInt(adressHex, 16);
                break;
            case("GD"):
                vmc.vm.writeToConsole(vmc.newLine);
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
        int newAdress = Integer.parseInt(vmc.registers.getIC(), 16);
        newAdress = newAdress < 255 ? (newAdress + 1) : 0;
        vmc.registers.setReg("IC", String.valueOf(newAdress));
    }
}
