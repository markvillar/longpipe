package longpipe;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

public class AddPipe extends javax.swing.JDialog {
    private ArrayList PipeOrder;

    public AddPipe(java.awt.Frame parent, boolean modal, ArrayList inPipeOrder) {
        super(parent, modal);
        //Need to pass the Arraylist, pass by reference
        initComponents();
        PipeOrder = inPipeOrder;
    }

    private AddPipe(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList returnPipeOrder(){
        return PipeOrder;
    }

    public double getLengthValue() {
        tfLengthInput.setForeground(Color.black);
        double length;
        try {
            length = Double.parseDouble(tfLengthInput.getText());
        } catch (NullPointerException ex) {
            tfLengthInput.setText("0.00");
            tfLengthInput.setForeground(Color.red);
            length = 0.00;
            System.out.println("There is a null value in a text field");
        } catch (NumberFormatException ex) {
            tfLengthInput.setText("0.00");
            tfLengthInput.setForeground(Color.red);
            length = 0.00;
            System.out.println("Entered Value is not a double or integer");
        }
        return length;
    }
    
    public double getWidthValue() {
        tfWidthInput.setForeground(Color.black); //Set to default colour in case value is valid
        double width;
        try {
            String value = tfWidthInput.getText();
            width = Double.parseDouble(value);
        } catch (NullPointerException ex) {
            //There is not value in the text field
            tfWidthInput.setText("0.00");
            tfWidthInput.setForeground(Color.red);
            width = 0.00;
            System.out.println("There is a null value in a text field");
        } catch (NumberFormatException ex) {
            //Entered value is not an integer or double
            tfWidthInput.setText("0.00");
            tfWidthInput.setForeground(Color.red);
            width = 0.00;
            System.out.println("Entered Value is not a double or integer");
        }
        
        
        return width;
    }
    
    /**
     *
     * @return Quantity value entered into quantity text field
     */
    public int getQuantityValue(){
        int quantity;
        tfQuantityInput.setForeground(Color.black); // Set to default text colour in case value is valid
        try{
            quantity = Integer.parseInt(tfQuantityInput.getText()); // Attempt to get the value out of the text box
        } catch (NumberFormatException ex){
            //Entered Value is not an integer
            quantity = 1; //Set to a default value
            tfQuantityInput.setForeground(Color.red);
            System.out.println("Entered Value is not an integer");
        } catch (NullPointerException ex) {
            //There is not value in the text field
            quantity = 1; //Set to a default value
            tfQuantityInput.setForeground(Color.red);
            System.out.println("There is a null value in a text field");
        }
        if(quantity > 99 || quantity <=0){
            //Check if value entered is within reasonable bounds
            quantity = 1;
            tfQuantityInput.setForeground(Color.red); //Set font colour to red to show that the value entered is not within valid limits
            System.out.println("Entered Quantity is too high or too low. Please enter a value between 1 and 99");
        }
        tfQuantityInput.setText(Integer.toString(quantity));
        return quantity;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfWidthInput = new javax.swing.JTextField();
        tfLengthInput = new javax.swing.JTextField();
        lblLength = new javax.swing.JLabel();
        lblWidth = new javax.swing.JLabel();
        lblColours = new javax.swing.JLabel();
        cboColourInput = new javax.swing.JComboBox<>();
        lblInnerInsulation = new javax.swing.JLabel();
        cboInnerInsInput = new javax.swing.JComboBox<>();
        lblOuterReinforcement = new javax.swing.JLabel();
        cboOutReinInput = new javax.swing.JComboBox<>();
        lblChemResis = new javax.swing.JLabel();
        cboChemResis = new javax.swing.JComboBox<>();
        lblPlasticGrade = new javax.swing.JLabel();
        cboPlasticGradeInput = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        tfPipeValidOutput = new javax.swing.JTextField();
        lblCost = new javax.swing.JLabel();
        tfCostOutput = new javax.swing.JTextField();
        btnTestValid = new javax.swing.JButton();
        lblQuantity = new javax.swing.JLabel();
        tfQuantityInput = new javax.swing.JTextField();
        btnAddPipe = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfWidthInput.setText("0.00");
        tfWidthInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfWidthInputFocusLost(evt);
            }
        });

        tfLengthInput.setText("0.00");
        tfLengthInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfLengthInputFocusLost(evt);
            }
        });

        lblLength.setText("Length (m):");

        lblWidth.setText("Width (inch):");

        lblColours.setText("Colours");

        cboColourInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));

        lblInnerInsulation.setText("Inner Insulation");

        cboInnerInsInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "YES" }));

        lblOuterReinforcement.setText("Outer Reinforcement");

        cboOutReinInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "YES" }));

        lblChemResis.setText("Chemical Resistance");

        cboChemResis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "YES" }));

        lblPlasticGrade.setText("Plastic Grade");

        cboPlasticGradeInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLength)
                    .addComponent(lblWidth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfWidthInput, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(tfLengthInput))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlasticGrade)
                    .addComponent(cboPlasticGradeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblColours)
                    .addComponent(cboColourInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInnerInsulation)
                    .addComponent(cboInnerInsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboOutReinInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOuterReinforcement))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChemResis)
                    .addComponent(cboChemResis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLengthInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLength)
                    .addComponent(lblColours)
                    .addComponent(lblInnerInsulation)
                    .addComponent(lblOuterReinforcement)
                    .addComponent(lblChemResis)
                    .addComponent(lblPlasticGrade))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfWidthInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWidth)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboPlasticGradeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboColourInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboInnerInsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboOutReinInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboChemResis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfPipeValidOutput.setEditable(false);
        tfPipeValidOutput.setText("Pipe is not valid");

        lblCost.setText("Cost: £");

        tfCostOutput.setEditable(false);
        tfCostOutput.setText("0.00");

        btnTestValid.setText("Test Valid");

        lblQuantity.setText("Quantity:");

        tfQuantityInput.setText("1");
        tfQuantityInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfQuantityInputFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfPipeValidOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTestValid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(tfQuantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCostOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPipeValidOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCost)
                    .addComponent(tfCostOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTestValid)
                    .addComponent(lblQuantity)
                    .addComponent(tfQuantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAddPipe.setText("Add Pipe");
        btnAddPipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPipeActionPerformed(evt);
            }
        });

        btnClearForm.setText("Clear Form");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClearForm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddPipe)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPipe)
                    .addComponent(btnClearForm))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        //Clear the form and reset the from back to default values
        tfWidthInput.setText("0.00");
        tfLengthInput.setText("0.00");
        tfQuantityInput.setText("1");
        cboPlasticGradeInput.setSelectedIndex(0);
        cboColourInput.setSelectedIndex(0);
        cboInnerInsInput.setSelectedIndex(0);
        cboOutReinInput.setSelectedIndex(0);
        cboChemResis.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void btnAddPipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPipeActionPerformed
        double length = getLengthValue();
        double width = getWidthValue();
        //Create a new pipe using items from combo boxes and add to arraylist then return to the order form window
        
        //if valid
        Pipe1 p = new Pipe1(getLengthValue(),getWidthValue(),true);
        
        //Set the visibility to false to allow the parent form to retrieve the new ArrayList before the dialog closes
        setVisible(false);
    }//GEN-LAST:event_btnAddPipeActionPerformed

    private void tfLengthInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfLengthInputFocusLost
        //Check the validity of the length value entered
        getLengthValue();
    }//GEN-LAST:event_tfLengthInputFocusLost

    private void tfWidthInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfWidthInputFocusLost
        //Check the validity of the width value entered
        getWidthValue();
    }//GEN-LAST:event_tfWidthInputFocusLost

    private void tfQuantityInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantityInputFocusLost
        //Check the validity of the quantity value entered
        getQuantityValue();
    }//GEN-LAST:event_tfQuantityInputFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AddPipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddPipe dialog = new AddPipe(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPipe;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnTestValid;
    private javax.swing.JComboBox<String> cboChemResis;
    private javax.swing.JComboBox<String> cboColourInput;
    private javax.swing.JComboBox<String> cboInnerInsInput;
    private javax.swing.JComboBox<String> cboOutReinInput;
    private javax.swing.JComboBox<String> cboPlasticGradeInput;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblChemResis;
    private javax.swing.JLabel lblColours;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblInnerInsulation;
    private javax.swing.JLabel lblLength;
    private javax.swing.JLabel lblOuterReinforcement;
    private javax.swing.JLabel lblPlasticGrade;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JTextField tfCostOutput;
    private javax.swing.JTextField tfLengthInput;
    private javax.swing.JTextField tfPipeValidOutput;
    private javax.swing.JTextField tfQuantityInput;
    private javax.swing.JTextField tfWidthInput;
    // End of variables declaration//GEN-END:variables
}
