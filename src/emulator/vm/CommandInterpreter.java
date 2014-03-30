package emulator.vm;

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
    
    private String getMemoryPiece(String address){
        String memory = Memory.getMemory(vmc.vm, address);
        int counter = 0;
        while(!memory.contains("$")){
            address = Memory.next(address);
            memory += Memory.getMemory(vmc.vm, address);
            counter++;
            if (counter > 10)
                return null;
        }
        return memory;
    }
    
    public void execute(String command){
        Data.rmc.registers.setReg("SI", "0");
        Data.rmc.registers.setReg("PI", "0");
        Data.rmc.registers.setReg("CHST2", false);
        Data.rmc.registers.setReg("CHST3", false);
        Data.rmc.registers.setIOI(2, false);
        Data.rmc.registers.setIOI(3, false);
        if (command.length() != 4){
            System.err.println("Unsupported command: " + command);
        }
        else{
            String opcode = command.substring(0, 2);
            String address = command.substring(2, 4);
            switch(opcode){
                case("PD"):
                    vmc.vm.writeToConsole(Memory.getMemory(vmc.vm, address));
                    Data.rmc.registers.setReg("SI", "2");
                    Data.rmc.registers.setReg("CHST2", true);
                    Data.rmc.registers.setIOI(2, true);
                    break;
                case("GD"):{
                    Data.rmc.registers.setReg("SI", "1");
                    Data.rmc.registers.setReg("CHST1", true);
                    Data.rmc.registers.setIOI(1, true);
                    String data = vmc.vm.readData();
                    Data.rmc.registers.setReg("CHST1", false);
                    Data.rmc.registers.setIOI(1, false);
                    vmc.vm.writeToConsole(": " + data + vmc.newLine);
                    String word;
                    while (data.length() > 4){
                        word = data.substring(0, 4);
                        data = data.substring(4);
                        Memory.setMemory(vmc, address, word);
                        address = Memory.next(address);
                    }
                    word = String.format("%-4s", data).replace(' ', '0');
                    Memory.setMemory(vmc, address, word);
                    break;
                }
                case("LR"):
                    vmc.registers.setReg("R", Memory.getMemory(vmc.vm, address));
                    break;
                case("LD"):
                    vmc.registers.setReg("D", Memory.getMemory(vmc.vm, address));
                    break;
                case("SR"):
                    Memory.setMemory(vmc, address, vmc.registers.getR());
                    break;
                case("SD"):
                    Memory.setMemory(vmc, address, vmc.registers.getD());
                    break;
                case("JP"):
                    vmc.registers.setReg("IC", address);
                    break;
                case("JT"):
                    if (vmc.registers.getC())
                        vmc.registers.setReg("IC", address);
                    break;
                case("SU"):
                {
                    int R = Integer.parseInt(vmc.registers.getR());
                    R -= Integer.parseInt(Memory.getMemory(vmc.vm, address));
                    vmc.registers.setReg("R", String.valueOf(R));
                    break;
                }
                case("AD"):
                {
                    int R = Integer.parseInt(vmc.registers.getR());
                    R += Integer.parseInt(Memory.getMemory(vmc.vm, address));
                    vmc.registers.setReg("R", String.valueOf(R));
                    break;
                }
                case("MU"):
                {
                    int R = Integer.parseInt(vmc.registers.getR());
                    R *= Integer.parseInt(Memory.getMemory(vmc.vm, address));
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
                    int D = R % Integer.parseInt(Memory.getMemory(vmc.vm, address));
                    R /= Integer.parseInt(Memory.getMemory(vmc.vm, address));
                    vmc.registers.setReg("D", String.valueOf(D));
                    vmc.registers.setReg("R", String.valueOf(R));
                    break;
                }
                case("CH"):{
                    int R = Integer.parseInt(vmc.registers.getR());
                    if (R > Integer.parseInt(Memory.getMemory(vmc.vm, address))){
                        vmc.registers.setReg("C", true);
                    }
                    else{
                        vmc.registers.setReg("C", false);
                    }
                    break;
                }
                case("CE"):{
                    int R = Integer.parseInt(vmc.registers.getR());
                    if (R == Integer.parseInt(Memory.getMemory(vmc.vm, address))){
                        vmc.registers.setReg("C", true);
                    }
                    else{
                        vmc.registers.setReg("C", false);
                    }
                    break;
                }
                case("FO"):{
                    Data.rmc.registers.setReg("CHST3", true);
                    Data.rmc.registers.setIOI(2, false);
                    int descriptor = vmc.data.files.size();
                    String fName = getMemoryPiece(address);
                    fName = fName.substring(0, fName.indexOf("$", fName.length() - 4));
                    if (fName != null){
                        vmc.data.registerFile(fName);
                        vmc.registers.setReg("D", String.valueOf(descriptor));
                    }
                    break;
                }
                case("FW"):{
                    Data.rmc.registers.setReg("CHST3", true);
                    Data.rmc.registers.setIOI(2, false);
                    String memory = getMemoryPiece(address);
                    memory = memory.substring(0, memory.indexOf("$", memory.length() - 4));
                    int descriptor = Integer.parseInt(vmc.registers.getD());
                    vmc.data.writeFile(descriptor, memory);
                    break;
                }
                case("FR"):{
                    Data.rmc.registers.setReg("CHST3", true);
                    Data.rmc.registers.setIOI(2, false);
                    int descriptor = Integer.parseInt(vmc.registers.getD());
                    String fileData = vmc.data.readFile(descriptor);
                    String word;
                    while (fileData.length() > 4){
                        word = fileData.substring(0, 4);
                        fileData = fileData.substring(4);
                        Memory.setMemory(vmc, address, word);
                        address = Memory.next(address);
                    }
                    word = String.format("%-4s", fileData).replace(' ', '0');
                    Memory.setMemory(vmc, address, word);
                    break;
                }
                case("FD"):{
                    Data.rmc.registers.setReg("CHST3", true);
                    Data.rmc.registers.setIOI(2, false);
                    int descriptor = Integer.valueOf(vmc.registers.getD());
                    vmc.data.files.get(descriptor).delete();
                    vmc.data.files.remove(descriptor);
                    break;
                }
                case("FC"):{
                    Data.rmc.registers.setReg("CHST3", true);
                    Data.rmc.registers.setIOI(2, false);
                    /*int descriptor = Integer.valueOf(vmc.registers.getD());
                    try{
                        vmc.data.in.get(descriptor).close();
                        vmc.data.out.get(descriptor).close();
                    }
                    catch(IndexOutOfBoundsException  ex){
                        System.err.println("Wrong descriptor");
                    } catch (IOException ex) {
                        System.err.println(ex);
                    }*/
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
