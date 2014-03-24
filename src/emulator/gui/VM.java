/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emulator.gui;

import emulator.vm.ButtonHandler;
import emulator.vm.Data;
import static emulator.vm.Memory.VIRTUAL_MEMORY_SIZE;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Oni-Q
 */
public class VM extends javax.swing.JFrame {
    JFileChooser fc = new JFileChooser(); 
    ButtonHandler buttonsHandler;
    Data data;
    /**
     * Creates new form VM
     * @param handler
     * @param data
     */ 
    public VM(ButtonHandler handler, Data data) {
        buttonsHandler = handler;
        this.data = data;
        initComponents();
        initMemory();
        fc.setCurrentDirectory(new File("data"));
    }
    
    private final DefaultListModel listModel = new DefaultListModel();
    
    public void setMemory(int adress, String word){
        this.data.memoryBuffer[adress] = word;
        String _data = String.format("%02X: %s", adress & 0xFF, this.data.memoryBuffer[adress]);
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
        word = word.substring(4);
        return word;
    }
    
    public void initMemory(){
        data.memoryBuffer = new String[VIRTUAL_MEMORY_SIZE];
        
        for (int i = 0; i < VIRTUAL_MEMORY_SIZE; i++){
            data.memoryBuffer[i] = "0000";
            String _data = String.format("%02X: %s", i & 0xFF, data.memoryBuffer[i]);
            //String data = String.format("%03d: %s", i, memoryBuffer[i]);
            listModel.addElement(_data);
        }
        listMemory.setModel(listModel);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jButtonLoad = new javax.swing.JButton();
        jButtonReload = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonForward = new javax.swing.JButton();
        jButtonRun = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMemory = new javax.swing.JList();
        panelRegisters = new javax.swing.JPanel();
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
        IC1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        C = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        input = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Virtual Machine");
        setResizable(false);

        jButtonLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emulator/gui/resourses/open.png"))); // NOI18N
        jButtonLoad.setToolTipText("Loads program from file");
        jButtonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadActionPerformed(evt);
            }
        });

        jButtonReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emulator/gui/resourses/reload.png"))); // NOI18N
        jButtonReload.setToolTipText("Reload program");
        jButtonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReloadActionPerformed(evt);
            }
        });

        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emulator/gui/resourses/back.png"))); // NOI18N
        jButtonBack.setToolTipText("One Step Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emulator/gui/resourses/forward.png"))); // NOI18N
        jButtonForward.setToolTipText("One Step Forward");
        jButtonForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForwardActionPerformed(evt);
            }
        });

        jButtonRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emulator/gui/resourses/run.png"))); // NOI18N
        jButtonRun.setToolTipText("Run Program");
        jButtonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRunActionPerformed(evt);
            }
        });

        listMemory.setBackground(new java.awt.Color(204, 255, 255));
        listMemory.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        listMemory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listMemory.setToolTipText("");
        listMemory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listMemory.setSelectionBackground(new java.awt.Color(153, 255, 204));
        listMemory.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(listMemory);

        panelRegisters.setBackground(new java.awt.Color(204, 204, 204));
        panelRegisters.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(51, 0, 102))); // NOI18N

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

        IC1.setEditable(false);
        IC1.setForeground(new java.awt.Color(0, 51, 51));
        IC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IC1.setText("0");
        IC1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        IC1.setSelectedTextColor(new java.awt.Color(0, 51, 51));
        IC1.setSelectionColor(new java.awt.Color(240, 240, 240));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("IC");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("C");

        C.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        C.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C.setText("false");
        C.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelRegistersLayout = new javax.swing.GroupLayout(panelRegisters);
        panelRegisters.setLayout(panelRegistersLayout);
        panelRegistersLayout.setHorizontalGroup(
            panelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistersLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistersLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegistersLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegistersLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRegistersLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IC1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRegistersLayout.setVerticalGroup(
            panelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(R4)
                        .addComponent(R3)
                        .addComponent(R2)
                        .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(D4)
                        .addComponent(D3)
                        .addComponent(D2)
                        .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(IC1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(C)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        output.setEditable(false);
        output.setBackground(new java.awt.Color(0, 0, 0));
        output.setColumns(20);
        output.setForeground(new java.awt.Color(153, 255, 0));
        output.setRows(5);
        output.setToolTipText("");
        output.setCaretColor(new java.awt.Color(153, 255, 51));
        output.setSelectedTextColor(new java.awt.Color(0, 0, 153));
        output.setSelectionColor(new java.awt.Color(255, 153, 51));
        jScrollPane2.setViewportView(output);

        input.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(input)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonReload, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelRegisters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonForward, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonReload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonForward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(panelRegisters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonLoad.getAccessibleContext().setAccessibleName("Load");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadActionPerformed
        int returnVal = fc.showOpenDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            final File file = fc.getSelectedFile();
            buttonsHandler.load(file);
        }
    }//GEN-LAST:event_jButtonLoadActionPerformed

    private void jButtonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReloadActionPerformed
        buttonsHandler.reload();
    }//GEN-LAST:event_jButtonReloadActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        buttonsHandler.back();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForwardActionPerformed
        buttonsHandler.next();
    }//GEN-LAST:event_jButtonForwardActionPerformed

    private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRunActionPerformed
        buttonsHandler.runApp();
    }//GEN-LAST:event_jButtonRunActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        //this.writeToConsole(input.getText());//remove later
        buttonsHandler.inputData(input.getText());
        input.setText("");
        
    }//GEN-LAST:event_inputActionPerformed

    public void writeToConsole(String line){
        output.append(line); 
    } 
    
    public void clearConsole(){
        output.setText(""); 
    }
    
    public void setSelected(int id){
        listMemory.setSelectedIndex(id);
    }
    
    public String readData(){
        String[] options = {"OK"};
        JPanel panel = new JPanel();
        //JLabel lbl = new JLabel("");
        JTextField txt = new JTextField(4);
        txt.addAncestorListener( new RequestFocusListener() );
        //panel.add(lbl);
        panel.add(txt);
        int selectedOption = JOptionPane.showOptionDialog(null, panel, "Input", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
        String _data = "";
        if(selectedOption == 0)
        {
            _data = txt.getText();
            while (_data.length() < 4){
                _data = "0" + _data;
            }
            if(_data.length() > 4){
                _data = _data.substring(0, 4);
            }
        }
        return _data;
    }
    
    public void run() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLocationRelativeTo(null);
                input.requestFocus();
                setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel C;
    private javax.swing.JTextField D1;
    private javax.swing.JTextField D2;
    private javax.swing.JTextField D3;
    private javax.swing.JTextField D4;
    private javax.swing.JTextField IC1;
    private javax.swing.JTextField R1;
    private javax.swing.JTextField R2;
    private javax.swing.JTextField R3;
    private javax.swing.JTextField R4;
    private javax.swing.JTextField input;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonForward;
    private javax.swing.JButton jButtonLoad;
    private javax.swing.JButton jButtonReload;
    private javax.swing.JButton jButtonRun;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listMemory;
    private javax.swing.JTextArea output;
    private javax.swing.JPanel panelRegisters;
    // End of variables declaration//GEN-END:variables

}

class RequestFocusListener implements AncestorListener
{
	private boolean removeListener;

	/*
	 *  Convenience constructor. The listener is only used once and then it is
	 *  removed from the component.
	 */
	public RequestFocusListener()
	{
		this(true);
	}

	/*
	 *  Constructor that controls whether this listen can be used once or
	 *  multiple times.
	 *
	 *  @param removeListener when true this listener is only invoked once
	 *                        otherwise it can be invoked multiple times.
	 */
	public RequestFocusListener(boolean removeListener)
	{
		this.removeListener = removeListener;
	}

	@Override
	public void ancestorAdded(AncestorEvent e)
	{
		JComponent component = e.getComponent();
		component.requestFocusInWindow();

		if (removeListener)
			component.removeAncestorListener( this );
	}

	@Override
	public void ancestorMoved(AncestorEvent e) {}

	@Override
	public void ancestorRemoved(AncestorEvent e) {} 
}