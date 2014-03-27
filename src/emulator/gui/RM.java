/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emulator.gui;

import static emulator.rm.Memory.memoryBuffer;
import static emulator.vm.Memory.VIRTUAL_MEMORY_SIZE;
import java.awt.Color;
import javax.swing.DefaultListModel;


/**
 *
 * @author Oni-Q
 */
public class RM extends javax.swing.JFrame {

    private final DefaultListModel listModel = new DefaultListModel();
    public static final int MEMORY_SIZE = VIRTUAL_MEMORY_SIZE + 64;
    
    public RM() {
        initComponents();
        initMemory();
    }
    
    private void initMemory(){ 
        
        for (int i = 0; i < MEMORY_SIZE; i++){
            memoryBuffer[i] = null;
            String _data = String.format("%03X: %s", i & 0xFFF, memoryBuffer[i]);
            listModel.addElement(_data);
        }
        listMemory.setModel(listModel);
    }
    
    public void setMemory(int adress, String word){
        memoryBuffer[adress] = word;
        String _data = String.format("%03X: %s", adress & 0xFFF, memoryBuffer[adress]);
        listModel.setElementAt(_data, adress);
    }
    
    public void setMemory(String adressHex, String word){
        int adress = Integer.parseInt(adressHex, 16);
        setMemory(adress, word);
    }
    
    public String getMemory(String adress){
        return getMemory(Integer.parseInt(adress, 16));
    }
    
    public String getMemory(int adress){
        String word;
        word = (String) listModel.get(adress);
        word = word.substring(5);
        if (word.equals("null"))
            return null;
        return word;
    }
    
    public void setD(String[] value){
        D4.setText(value[0]);
        D3.setText(value[1]);
        D2.setText(value[2]);
        D1.setText(value[3]);
    }
    
    public void setR(String[] value) {
        R4.setText(value[0]);
        R3.setText(value[1]);
        R2.setText(value[2]);
        R1.setText(value[3]);
    }

    public void setIC(String value) { 
        IC1.setText(value);
    }
    
    public void setC(boolean value) {
        C.setText(String.valueOf(value));
    }
    
    public void setIOI(String value) { 
        IOI.setText(value);
    }
    
    public void setSI(String value) {
        SI.setText(value);
    }
    
    public void setTI(String value) {
        TI.setText(value);
    }
    
    public void setPI(String value) {
        TI.setText(value);
    }
    
    public void setCHST(int nr, boolean value) {
        switch(nr){
            case(1):
                if (value)
                    CHST1.setBackground(Color.red);
                else
                    CHST1.setBackground(Color.green);
                break;
            case(2):
                if (value)
                    CHST2.setBackground(Color.red);
                else
                    CHST2.setBackground(Color.green);
                break;
            case(3):
                if (value)
                    CHST3.setBackground(Color.red);
                else
                    CHST3.setBackground(Color.green);
            break;
        }
    }
    
    public void setPTR(String[] value) {
        PTR1.setText(value[0]);
        PTR2.setText(value[1]);
        PTR3.setText(value[2]);
        PTR4.setText(value[3]);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        R4 = new javax.swing.JTextField();
        R3 = new javax.swing.JTextField();
        R2 = new javax.swing.JTextField();
        R1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        D4 = new javax.swing.JTextField();
        D3 = new javax.swing.JTextField();
        D2 = new javax.swing.JTextField();
        D1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        IC1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        C = new javax.swing.JLabel();
        CHST1 = new javax.swing.JPanel();
        ST1 = new javax.swing.JLabel();
        PTR = new javax.swing.JLabel();
        PTR1 = new javax.swing.JTextField();
        PTR2 = new javax.swing.JTextField();
        PTR3 = new javax.swing.JTextField();
        PTR4 = new javax.swing.JTextField();
        HLP = new javax.swing.JLabel();
        CHST3 = new javax.swing.JPanel();
        ST3 = new javax.swing.JLabel();
        CHST2 = new javax.swing.JPanel();
        ST2 = new javax.swing.JLabel();
        lPI = new javax.swing.JLabel();
        PI = new javax.swing.JTextField();
        lTI = new javax.swing.JLabel();
        TI = new javax.swing.JTextField();
        lSI = new javax.swing.JLabel();
        SI = new javax.swing.JTextField();
        lIOI = new javax.swing.JLabel();
        IOI = new javax.swing.JTextField();
        C1 = new javax.swing.JLabel();
        lMODE = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMemory = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("R");

        R4.setEditable(false);
        R4.setForeground(new java.awt.Color(0, 51, 51));
        R4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        R4.setText("0");
        R4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        R4.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        R4.setSelectionColor(new java.awt.Color(240, 240, 240));

        R3.setEditable(false);
        R3.setForeground(new java.awt.Color(0, 51, 51));
        R3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        R3.setText("0");
        R3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        R3.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        R3.setSelectionColor(new java.awt.Color(240, 240, 240));

        R2.setEditable(false);
        R2.setForeground(new java.awt.Color(0, 51, 51));
        R2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        R2.setText("0");
        R2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        R2.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        R2.setSelectionColor(new java.awt.Color(240, 240, 240));

        R1.setEditable(false);
        R1.setForeground(new java.awt.Color(0, 51, 51));
        R1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        R1.setText("0");
        R1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        R1.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        R1.setSelectionColor(new java.awt.Color(240, 240, 240));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("D");

        D4.setEditable(false);
        D4.setForeground(new java.awt.Color(0, 51, 51));
        D4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D4.setText("0");
        D4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        D4.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        D4.setSelectionColor(new java.awt.Color(240, 240, 240));

        D3.setEditable(false);
        D3.setForeground(new java.awt.Color(0, 51, 51));
        D3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D3.setText("0");
        D3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        D3.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        D3.setSelectionColor(new java.awt.Color(240, 240, 240));

        D2.setEditable(false);
        D2.setForeground(new java.awt.Color(0, 51, 51));
        D2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D2.setText("0");
        D2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        D2.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        D2.setSelectionColor(new java.awt.Color(240, 240, 240));

        D1.setEditable(false);
        D1.setForeground(new java.awt.Color(0, 51, 51));
        D1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D1.setText("0");
        D1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        D1.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        D1.setSelectionColor(new java.awt.Color(240, 240, 240));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("IC");

        IC1.setEditable(false);
        IC1.setForeground(new java.awt.Color(0, 51, 51));
        IC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IC1.setText("0");
        IC1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        IC1.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        IC1.setSelectionColor(new java.awt.Color(240, 240, 240));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("C");

        C.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        C.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C.setText("false");
        C.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CHST1.setBackground(new java.awt.Color(51, 204, 0));
        CHST1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        ST1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ST1.setText("CHST1");

        javax.swing.GroupLayout CHST1Layout = new javax.swing.GroupLayout(CHST1);
        CHST1.setLayout(CHST1Layout);
        CHST1Layout.setHorizontalGroup(
            CHST1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ST1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CHST1Layout.setVerticalGroup(
            CHST1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ST1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PTR.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PTR.setText("PTR");

        PTR1.setEditable(false);
        PTR1.setForeground(new java.awt.Color(0, 51, 51));
        PTR1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PTR1.setText("0");
        PTR1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PTR1.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        PTR1.setSelectionColor(new java.awt.Color(240, 240, 240));

        PTR2.setEditable(false);
        PTR2.setForeground(new java.awt.Color(0, 51, 51));
        PTR2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PTR2.setText("0");
        PTR2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PTR2.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        PTR2.setSelectionColor(new java.awt.Color(240, 240, 240));

        PTR3.setEditable(false);
        PTR3.setForeground(new java.awt.Color(0, 51, 51));
        PTR3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PTR3.setText("0");
        PTR3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PTR3.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        PTR3.setSelectionColor(new java.awt.Color(240, 240, 240));

        PTR4.setEditable(false);
        PTR4.setForeground(new java.awt.Color(0, 51, 51));
        PTR4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PTR4.setText("0");
        PTR4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PTR4.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        PTR4.setSelectionColor(new java.awt.Color(240, 240, 240));

        HLP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        HLP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HLP.setText("HLP");
        HLP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        CHST3.setBackground(new java.awt.Color(51, 204, 0));
        CHST3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        ST3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ST3.setText("CHST3");

        javax.swing.GroupLayout CHST3Layout = new javax.swing.GroupLayout(CHST3);
        CHST3.setLayout(CHST3Layout);
        CHST3Layout.setHorizontalGroup(
            CHST3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ST3)
        );
        CHST3Layout.setVerticalGroup(
            CHST3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CHST3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ST3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        CHST2.setBackground(new java.awt.Color(51, 204, 0));
        CHST2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        ST2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ST2.setText("CHST2");

        javax.swing.GroupLayout CHST2Layout = new javax.swing.GroupLayout(CHST2);
        CHST2.setLayout(CHST2Layout);
        CHST2Layout.setHorizontalGroup(
            CHST2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ST2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CHST2Layout.setVerticalGroup(
            CHST2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CHST2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ST2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lPI.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lPI.setText("PI");

        PI.setEditable(false);
        PI.setForeground(new java.awt.Color(0, 51, 51));
        PI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PI.setText("0");
        PI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PI.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        PI.setSelectionColor(new java.awt.Color(240, 240, 240));

        lTI.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lTI.setText("TI");

        TI.setEditable(false);
        TI.setForeground(new java.awt.Color(0, 51, 51));
        TI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TI.setText("0");
        TI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TI.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        TI.setSelectionColor(new java.awt.Color(240, 240, 240));

        lSI.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lSI.setText("SI");

        SI.setEditable(false);
        SI.setForeground(new java.awt.Color(0, 51, 51));
        SI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SI.setText("0");
        SI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SI.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        SI.setSelectionColor(new java.awt.Color(240, 240, 240));

        lIOI.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lIOI.setText("IOI");

        IOI.setEditable(false);
        IOI.setForeground(new java.awt.Color(0, 51, 51));
        IOI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IOI.setText("0");
        IOI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        IOI.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        IOI.setSelectionColor(new java.awt.Color(240, 240, 240));

        C1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C1.setText("false");
        C1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lMODE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lMODE.setText("MODE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(HLP, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CHST1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(lPI)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CHST2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lTI)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lSI)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lIOI)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(IOI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(CHST3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(PTR)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PTR1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PTR2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PTR3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PTR4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IC1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(171, 171, 171)
                        .addComponent(lMODE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HLP)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(R4)
                                .addComponent(R3)
                                .addComponent(R2)
                                .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(D4)
                                .addComponent(D3)
                                .addComponent(D2)
                                .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(IC1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(C)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(C1)
                                        .addComponent(lMODE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lPI)
                                    .addComponent(PI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lTI)
                                    .addComponent(TI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lSI)
                                    .addComponent(SI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lIOI)
                                    .addComponent(IOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(CHST1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CHST2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CHST3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(PTR1)
                                .addComponent(PTR2)
                                .addComponent(PTR3)
                                .addComponent(PTR4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(PTR, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        listMemory.setBackground(new java.awt.Color(230, 55, 120));
        listMemory.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        listMemory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listMemory.setToolTipText("");
        listMemory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listMemory.setSelectionBackground(new java.awt.Color(255, 102, 153));
        listMemory.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(listMemory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public void run() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel C;
    private javax.swing.JLabel C1;
    private javax.swing.JPanel CHST1;
    private javax.swing.JPanel CHST2;
    private javax.swing.JPanel CHST3;
    private javax.swing.JTextField D1;
    private javax.swing.JTextField D2;
    private javax.swing.JTextField D3;
    private javax.swing.JTextField D4;
    private javax.swing.JLabel HLP;
    private javax.swing.JTextField IC1;
    private javax.swing.JTextField IOI;
    private javax.swing.JTextField PI;
    private javax.swing.JLabel PTR;
    private javax.swing.JTextField PTR1;
    private javax.swing.JTextField PTR2;
    private javax.swing.JTextField PTR3;
    private javax.swing.JTextField PTR4;
    private javax.swing.JTextField R1;
    private javax.swing.JTextField R2;
    private javax.swing.JTextField R3;
    private javax.swing.JTextField R4;
    private javax.swing.JTextField SI;
    private javax.swing.JLabel ST1;
    private javax.swing.JLabel ST2;
    private javax.swing.JLabel ST3;
    private javax.swing.JTextField TI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lIOI;
    private javax.swing.JLabel lMODE;
    private javax.swing.JLabel lPI;
    private javax.swing.JLabel lSI;
    private javax.swing.JLabel lTI;
    private javax.swing.JList listMemory;
    // End of variables declaration//GEN-END:variables
}
