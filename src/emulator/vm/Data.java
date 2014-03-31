package emulator.vm;

import emulator.rm.RMController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Data {
    public String[] memoryBuffer;
    public String[] R;
    public String[] D;
    public String IC;
    public boolean C;
    public static RMController rmc;
    public ArrayList<File> files;
    //public ArrayList<FileReader> in;
    //public ArrayList<PrintWriter> out;

    public Data() {
        //in = new ArrayList<>();
        //out = new ArrayList<>();
        files = new ArrayList<>();
    }
    
    public String readFile(int descriptor){
        try {
            BufferedReader br = new BufferedReader(new FileReader(files.get(descriptor)));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
    public void writeFile(int descriptor, String str){
        try {
            try (PrintWriter out = new PrintWriter(files.get(descriptor))) {
                out.write(str);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }
    
    public boolean registerFile(String fName){
        try {
            File file = new File(fName);
            if (!file.exists())
                file.createNewFile();
            //in.add(new FileReader(file));
            //out.add(new PrintWriter(file));
            files.add(file);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            return false;
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return true;
    }
}
