package longpipe;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

public class AddPipe extends javax.swing.JDialog {

    private ArrayList pipeOrder;
    private int type;

    /**
     * Create a new dialog window to allow the user to add a new pipe
     *
     * @param parent The form that the dialog box was created from
     * @param modal Whether the dialog box allows for the parent form to be
     * selected
     * @param inPipeOrder The current list of pipes ordered
     */
    public AddPipe(java.awt.Frame parent, boolean modal, ArrayList inPipeOrder) {
        super(parent, modal);
        initComponents(); //Initialise the components of the dialog box
        this.setLocationRelativeTo(null); //Set window location to the centre of the screen
        pipeOrder = inPipeOrder;
        btnAddPipe.setEnabled(false); //Automatically disable the "Add Pipe" button
        type = -1; //Set the default value of the pipe type
    }

    private AddPipe(JFrame jFrame, boolean b) {
        //Ignore
    }

    /**
     * Returns the list of pipes within the current order
     *
     * @return Returns the list of pipes from the order
     */
    public ArrayList returnPipeOrder() {
        return pipeOrder;
    }

    /**
     * Check the validity of the value entered into the length text field
     *
     * @return The length entered into the text field if valid otherwise the
     * default value
     */
    public double getLengthValue() {
        tfLengthInput.setForeground(Color.black); //Set the default font colour
        double length;
        try {
            length = Double.parseDouble(tfLengthInput.getText()); //Try to parse the entered string to a double
        } catch (NullPointerException ex) {
            //The text field is empty
            tfLengthInput.setText("0.00"); //Set to the default value of the text field
            tfLengthInput.setForeground(Color.red); //Highlight to the user that the value within the text field was invalid
            length = 0.00; //Set the length to the default value
        } catch (NumberFormatException ex) {
            //Entered value is not a double or integer
            tfLengthInput.setText("0.00"); //Set to the default value of the text field
            tfLengthInput.setForeground(Color.red); //Highlight to the user that the value within the text field is invalid
            length = 0.00; //Set the length to the default value
            System.out.println("Entered Value is not a double or integer");
        }
        return length;
    }

    /**
     * Check the validity of the value entered into the width text field
     *
     * @return The width entered into the text field if valid otherwise the default value
     */
    public double getWidthValue() {
        tfWidthInput.setForeground(Color.black); //Set the default font colour
        double width;
        try {
            width = Double.parseDouble(tfWidthInput.getText()); //Try to parse the entered string to a double
        } catch (NullPointerException ex) {
            //The text field is empty
            tfWidthInput.setText("0.00"); //Set to the default value of the text field
            tfWidthInput.setForeground(Color.red); //Highlight to the user that the value within the text field was invalid
            width = 0.00; //Set width to the default value
        } catch (NumberFormatException ex) {
            //Entered value is not a double or integer
            tfWidthInput.setText("0.00"); //Set to the default value of the text field
            tfWidthInput.setForeground(Color.red); //Highlight to the user that the value within the text field was invalid
            width = 0.00; //Set width to the default value
        }
        return width;
    }

    /**
     * Check the validity of the value entered into the quantity text field
     * 
     * @return The quantity entered into the text field if valid, otherwise the default value
     */
    public int getQuantityValue() {
        tfQuantityInput.setForeground(Color.black); // Set the default font colour
        int quantity;
        try {
            quantity = Integer.parseInt(tfQuantityInput.getText()); //Try to parse the entered string to an integer
        } catch (NumberFormatException ex) {
            //Entered value is not an integer
            quantity = 1; //Set to a default value
            tfQuantityInput.setForeground(Color.red);
            System.out.println("Entered Value is not an integer");
        } catch (NullPointerException ex) {
            //There is not value in the text field
            quantity = 1; //Set to a default value
            tfQuantityInput.setForeground(Color.red);
            System.out.println("There is a null value in a text field");
        }
        if (quantity > 99 || quantity <= 0) {
            //Check if value entered is within reasonable bounds
            quantity = 1;
            tfQuantityInput.setForeground(Color.red); //Set font colour to red to show that the value entered is not within valid limits
            System.out.println("Entered Quantity is too high or too low. Please enter a value between 1 and 99");
        }
        tfQuantityInput.setText(Integer.toString(quantity));
        return quantity;
    }

    public PipeMain createPipe() {
        PipeMain p = null;
        switch (type) {
            case 1:
                p = new Pipe1(getLengthValue(), getWidthValue(), cboPlasticGrade.getSelectedIndex() + 1, cbChemResis.isSelected());
                break;
            case 2:
                p = new Pipe2(getLengthValue(), getWidthValue(), cboPlasticGrade.getSelectedIndex() + 1, cbChemResis.isSelected());
                break;
            case 3:
                p = new Pipe3(getLengthValue(), getWidthValue(), cboPlasticGrade.getSelectedIndex() + 1, cbChemResis.isSelected());
                break;
            case 4:
                p = new Pipe4(getLengthValue(), getWidthValue(), cboPlasticGrade.getSelectedIndex() + 1, cbChemResis.isSelected());
                break;
            case 5:
                p = new Pipe5(getLengthValue(), getWidthValue(), cboPlasticGrade.getSelectedIndex() + 1, cbChemResis.isSelected());
                break;
            default:
                break;
        }
        return p;
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
        cboColour = new javax.swing.JComboBox<>();
        lblPlasticGrade = new javax.swing.JLabel();
        cboPlasticGrade = new javax.swing.JComboBox<>();
        cbInnerInsulation = new javax.swing.JCheckBox();
        cbOuterRein = new javax.swing.JCheckBox();
        cbChemResis = new javax.swing.JCheckBox();
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

        cboColour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        cboColour.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboColourItemStateChanged(evt);
            }
        });

        lblPlasticGrade.setText("Plastic Grade");

        cboPlasticGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cboPlasticGrade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPlasticGradeItemStateChanged(evt);
            }
        });

        cbInnerInsulation.setText(" Inner Insulation");
        cbInnerInsulation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cbInnerInsulation.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cbInnerInsulation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbInnerInsulationItemStateChanged(evt);
            }
        });

        cbOuterRein.setText("Outer Reinforcement");
        cbOuterRein.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cbOuterRein.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cbOuterRein.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOuterReinItemStateChanged(evt);
            }
        });

        cbChemResis.setText("Chemical Resistance");
        cbChemResis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cbChemResis.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cbChemResis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbChemResisItemStateChanged(evt);
            }
        });

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
                    .addComponent(cboPlasticGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColours))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbInnerInsulation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbOuterRein)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbChemResis)
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
                    .addComponent(lblPlasticGrade))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfWidthInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWidth))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboPlasticGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbChemResis)
                    .addComponent(cbOuterRein)
                    .addComponent(cbInnerInsulation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfPipeValidOutput.setEditable(false);
        tfPipeValidOutput.setText("Pipe is not valid");

        lblCost.setText("Cost: £");

        tfCostOutput.setEditable(false);
        tfCostOutput.setText("0.00");

        btnTestValid.setText("Test Valid");
        btnTestValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestValidActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
        tfCostOutput.setText("0.00");
        cboPlasticGrade.setSelectedIndex(0);
        cboColour.setSelectedIndex(0);
        cbInnerInsulation.setSelected(false);
        cbOuterRein.setSelected(false);
        cbChemResis.setSelected(false);
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void btnAddPipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPipeActionPerformed
        double length = getLengthValue();
        double width = getWidthValue();
        //Create a new pipe using items from combo boxes and add to arraylist then return to the order form window

        for (int i = 0; i < Integer.parseInt(tfQuantityInput.getText()); i++) {
            //Add Pipes
            PipeMain p = createPipe();
            pipeOrder.add(p);
        }

        setVisible(false); //Set the visibility to false to allow the parent form to retrieve the new ArrayList before the dialog closes
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

    private void btnTestValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestValidActionPerformed
        //Test the validity of the pipe
        boolean innerInsul = cbInnerInsulation.isSelected();
        boolean outerRein = cbOuterRein.isSelected();
        boolean chemResis = cbChemResis.isSelected();
        int plasticGrade = cboPlasticGrade.getSelectedIndex() + 1;
        int colour = cboColour.getSelectedIndex();

        Test test = new Test();
        type = test.TestPipeValid(outerRein, innerInsul, chemResis, colour, plasticGrade, getLengthValue(), getWidthValue());

        if (type == -1 || getLengthValue() == 0 || getWidthValue() == 0) {
            //pipe is invalid
            btnAddPipe.setEnabled(false);
            tfPipeValidOutput.setText("Pipe is invalid");
        } else {
            btnAddPipe.setEnabled(true);
            tfPipeValidOutput.setText("Pipe is of type " + type);
            PipeMain pipePrice = createPipe();
            tfCostOutput.setText(String.format("%.2f", pipePrice.Price() * Double.parseDouble(tfQuantityInput.getText())));
        }
    }//GEN-LAST:event_btnTestValidActionPerformed

    private void cboColourItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboColourItemStateChanged
        //Disable the add pipe button
        btnAddPipe.setEnabled(false);
    }//GEN-LAST:event_cboColourItemStateChanged

    private void cboPlasticGradeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPlasticGradeItemStateChanged
        //Disable the add pipe button
        btnAddPipe.setEnabled(false);
    }//GEN-LAST:event_cboPlasticGradeItemStateChanged

    private void cbOuterReinItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOuterReinItemStateChanged
        //Disable the add pipe button
        btnAddPipe.setEnabled(false);
    }//GEN-LAST:event_cbOuterReinItemStateChanged

    private void cbInnerInsulationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbInnerInsulationItemStateChanged
        //Disable the add pipe button
        btnAddPipe.setEnabled(false);
    }//GEN-LAST:event_cbInnerInsulationItemStateChanged

    private void cbChemResisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbChemResisItemStateChanged
        //Disable the add pipe button
        btnAddPipe.setEnabled(false);
    }//GEN-LAST:event_cbChemResisItemStateChanged

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
    private javax.swing.JCheckBox cbChemResis;
    private javax.swing.JCheckBox cbInnerInsulation;
    private javax.swing.JCheckBox cbOuterRein;
    private javax.swing.JComboBox<String> cboColour;
    private javax.swing.JComboBox<String> cboPlasticGrade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblColours;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblLength;
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
