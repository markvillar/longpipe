package longpipe;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddPipe extends javax.swing.JDialog {

    private ArrayList pipeOrder;
    private int type;
    private Color darkGreen;
    private Color darkRed;
    private Color black;

    /*
    TODO:
    html printing IF THERES TIME
    UML DIAGRAM
    TEST PLANS AND TESTING WHATEVER
    Write Assumptions
     */
 /*
    BUG LIST:
    When the length or width is != int then the error message only flashes up for a short time and cant be read.
     */
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
        pipeOrder = inPipeOrder;
        btnAddPipe.setEnabled(false); //Automatically disable the "Add Pipe" button
        type = -1; //Set the default value of the pipe type
        black = new Color(0, 0, 0);
        darkGreen = new Color(39, 142, 43);
        darkRed = new Color(229, 48, 48);
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

    public void checkIfPipeIsValid() {
        //Test the validity of the pipe
        boolean innerInsul = cbInnerInsulation.isSelected();
        boolean outerRein = cbOuterRein.isSelected();
        boolean chemResis = cbChemResis.isSelected();
        int plasticGrade = cboPlasticGrade.getSelectedIndex() + 1;
        int colour = cboColour.getSelectedIndex();
        
        Test test = new Test();
        type = test.TestPipeValid(outerRein, innerInsul, colour, plasticGrade);

        double length = getLengthValue();
        double width = getWidthValue();

        if (tfLengthInput.getForeground() == darkRed || tfWidthInput.getForeground() == darkRed || tfQuantityInput.getForeground() == darkRed) {
            //Error
        } else if (type == -1 || length == 0 || width == 0) {
            //pipe is invalid
            String reasonNotValidPipe = test.whyNotValid(outerRein, innerInsul, colour, plasticGrade);
            btnAddPipe.setEnabled(false); //Disable the AddPipe button
            tfErrorOutput.setForeground(darkRed);
            tfErrorOutput.setText(reasonNotValidPipe);
        } else {

            btnAddPipe.setEnabled(true);
            tfErrorOutput.setForeground(darkGreen);
            tfErrorOutput.setText("This pipe is stocked and is of type " + type);
            PipeMain pipePrice = createPipe();
            tfTotalCostOutput.setText(String.format("%.2f", pipePrice.getPrice() * Integer.parseInt(tfQuantityInput.getText())));
            tfCostPerPipeOutput.setText(String.format("%.2f", pipePrice.getPrice()));
        }
    }

    /**
     * Check the validity of the value entered into the length text field
     *
     * @return The length entered into the text field if valid otherwise the
     * default value
     */
    public double getLengthValue() {
        tfLengthInput.setForeground(black); //Set the default font colour
        boolean valid = true;
        double length = 1.0;
        
        try {
            //Try to parse the entered string to a double
            length = Double.parseDouble(tfLengthInput.getText());
        } catch (NullPointerException | NumberFormatException ex) {
            //The text field is empty or the entered value is not a double or integer
            valid = false;
        }
        
        
        if (length > 6 || length <= 0) {
            valid = false;
        }
        if (!valid) {
            length = 1.0;
            tfLengthInput.setForeground(darkRed);
            printError("Value entered into length field is either nothing or invalid, please enter a decimal number greater than 0 and less than 6");
        }
        tfLengthInput.setText(Double.toString(length));
        return length;
    }

    /**
     * Check the validity of the value entered into the width text field
     *
     * @return The width entered into the text field if valid otherwise the
     * default value
     */
    public double getWidthValue() {
        tfWidthInput.setForeground(black); //Set the default font colour
        double width = 1.0; //Set width to the default value
        boolean valid = true;
        try {
            width = Double.parseDouble(tfWidthInput.getText()); //Try to parse the entered string to a double
        } catch (NullPointerException | NumberFormatException ex) {
            //The text field is empty or the entered value is not a double or integer
            valid = false;
        }
        if (width <= 0 || width > 99) {
            valid = false;
        }
        if (!valid) {
            width = 1.0;
            tfWidthInput.setForeground(darkRed);
            //Alert the user that the entered value is invalid
            printError("Value entered into width field is either nothing or invalid, please enter a decimal number greater than 0 and less than 99");
        }
        tfWidthInput.setText(Double.toString(width));
        return width;
    }

    /**
     * Check the validity of the value entered into the quantity text field
     *
     * @return The quantity entered into the text field if valid, otherwise the
     * default value
     */
    public int getQuantityValue() {
        tfQuantityInput.setForeground(black); // Set the default font colour
        int quantity = 1;
        boolean valid = true;
        try {
            quantity = Integer.parseInt(tfQuantityInput.getText()); //Try to parse the entered string to an integer
        } catch (NumberFormatException | NullPointerException ex) {
            //Entered value is not an integer
            valid = false;
        }
        if (quantity > 99 || quantity <= 0) {
            //Check if value entered is within reasonable bounds
            valid = false;
        }
        if (!valid) {
            quantity = 1;
            tfQuantityInput.setForeground(darkRed); //Set font colour to red to show that the value entered is not within valid limits
            printError("Entered quantity is either nothing or not a decimal number. Please enter a whole number between 1 and 99");
        }
        tfQuantityInput.setText(Integer.toString(quantity));
        return quantity;
    }

    /**
     * Creates a pipe based on the user's specified configuration
     *
     * @return The newly created pipe depending on the inputs from the GUI
     */
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
    
    /**
     * Used to print errors messages on the graphical user interface for the user.
     * @param input 
     */
    public void printError(String input) {
        tfErrorOutput.setText(input);
        tfErrorOutput.setForeground(darkRed);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAttributes = new javax.swing.JPanel();
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
        pnlCosting = new javax.swing.JPanel();
        lblCostPerPipe = new javax.swing.JLabel();
        tfCostPerPipeOutput = new javax.swing.JTextField();
        btnTestValid = new javax.swing.JButton();
        lblQuantity = new javax.swing.JLabel();
        tfQuantityInput = new javax.swing.JTextField();
        tfTotalCostOutput = new javax.swing.JTextField();
        lblTotalCost = new javax.swing.JLabel();
        btnAddPipe = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        tfErrorOutput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Pipe to Order");

        pnlAttributes.setBorder(javax.swing.BorderFactory.createTitledBorder("Pipe Properties"));

        tfWidthInput.setText("1.00");

        tfLengthInput.setText("1.00");

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

        javax.swing.GroupLayout pnlAttributesLayout = new javax.swing.GroupLayout(pnlAttributes);
        pnlAttributes.setLayout(pnlAttributesLayout);
        pnlAttributesLayout.setHorizontalGroup(
            pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAttributesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLength)
                    .addComponent(lblWidth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfWidthInput, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(tfLengthInput))
                .addGap(18, 18, 18)
                .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblPlasticGrade)
                    .addComponent(cboPlasticGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblColours)
                    .addComponent(cboColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbInnerInsulation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbOuterRein)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbChemResis)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAttributesLayout.setVerticalGroup(
            pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAttributesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAttributesLayout.createSequentialGroup()
                        .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfLengthInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLength)
                            .addComponent(lblColours)
                            .addComponent(lblPlasticGrade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblWidth)
                                .addComponent(tfWidthInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboPlasticGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlAttributesLayout.createSequentialGroup()
                        .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbChemResis)
                            .addComponent(cbOuterRein)
                            .addComponent(cbInnerInsulation))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pnlCosting.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCostPerPipe.setText("Cost Per Pipe: £");

        tfCostPerPipeOutput.setEditable(false);
        tfCostPerPipeOutput.setText("0.00");

        btnTestValid.setText("Test Valid");
        btnTestValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestValidActionPerformed(evt);
            }
        });

        lblQuantity.setText("Quantity:");

        tfQuantityInput.setText("1");

        tfTotalCostOutput.setEditable(false);
        tfTotalCostOutput.setText("0.00");

        lblTotalCost.setText("Total Cost: £");

        javax.swing.GroupLayout pnlCostingLayout = new javax.swing.GroupLayout(pnlCosting);
        pnlCosting.setLayout(pnlCostingLayout);
        pnlCostingLayout.setHorizontalGroup(
            pnlCostingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCostingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTestValid)
                .addGap(18, 18, 18)
                .addGroup(pnlCostingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblQuantity)
                    .addComponent(tfQuantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addGroup(pnlCostingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCostPerPipe, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalCost, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCostingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTotalCostOutput)
                    .addComponent(tfCostPerPipeOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCostingLayout.setVerticalGroup(
            pnlCostingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCostingLayout.createSequentialGroup()
                .addGroup(pnlCostingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCostingLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCostingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCostPerPipe)
                            .addComponent(tfCostPerPipeOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCostingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCostingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfTotalCostOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTotalCost))
                            .addComponent(tfQuantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCostingLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnTestValid)))
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

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tfErrorOutput.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCosting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddPipe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearForm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)
                        .addGap(6, 6, 6))
                    .addComponent(tfErrorOutput))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCosting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfErrorOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPipe)
                    .addComponent(btnClearForm)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        //Clear the form and reset the from back to default values
        tfWidthInput.setText("0.00");
        tfLengthInput.setText("0.00");
        tfQuantityInput.setText("1");
        tfCostPerPipeOutput.setText("0.00");
        tfTotalCostOutput.setText("0.00");
        tfWidthInput.setForeground(black);
        tfLengthInput.setForeground(black);
        tfQuantityInput.setForeground(black);
        tfErrorOutput.setText("");
        cboPlasticGrade.setSelectedIndex(0);
        cboColour.setSelectedIndex(0);
        cbInnerInsulation.setSelected(false);
        cbOuterRein.setSelected(false);
        cbChemResis.setSelected(false);
        btnAddPipe.setEnabled(false);
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void btnAddPipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPipeActionPerformed
        Object[] options = {"Yes",
            "Cancel"};

        String warningText = "Are you sure you want to add th";
        int numOfPipes = Integer.parseInt(tfQuantityInput.getText());
        if (numOfPipes == 1) {
            warningText += "is pipe to your order?";
        } else {
            warningText += "ese pipes to your order?";
        }
        int n = JOptionPane.showOptionDialog(this,
                warningText,
                "Warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[1]);
        if (n == 0) {
            double length = getLengthValue();
            double width = getWidthValue();
            //Create a new pipe using items from combo boxes and add to arraylist then return to the order form window
            for (int i = 0; i < numOfPipes; i++) {
                //Add Pipes
                PipeMain p = createPipe();
                pipeOrder.add(p);
            }
            setVisible(false); //Set the visibility to false to allow the parent form to retrieve the new ArrayList before the dialog closes
        }

    }//GEN-LAST:event_btnAddPipeActionPerformed

    private void btnTestValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestValidActionPerformed
        checkIfPipeIsValid();
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

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Object[] options = {"Yes",
            "Cancel"};
        int n = JOptionPane.showOptionDialog(this,
                "Are you sure you want to exit?",
                "Warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[1]);
        if (n == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnTestValid;
    private javax.swing.JCheckBox cbChemResis;
    private javax.swing.JCheckBox cbInnerInsulation;
    private javax.swing.JCheckBox cbOuterRein;
    private javax.swing.JComboBox<String> cboColour;
    private javax.swing.JComboBox<String> cboPlasticGrade;
    private javax.swing.JLabel lblColours;
    private javax.swing.JLabel lblCostPerPipe;
    private javax.swing.JLabel lblLength;
    private javax.swing.JLabel lblPlasticGrade;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JPanel pnlAttributes;
    private javax.swing.JPanel pnlCosting;
    private javax.swing.JTextField tfCostPerPipeOutput;
    private javax.swing.JTextField tfErrorOutput;
    private javax.swing.JTextField tfLengthInput;
    private javax.swing.JTextField tfQuantityInput;
    private javax.swing.JTextField tfTotalCostOutput;
    private javax.swing.JTextField tfWidthInput;
    // End of variables declaration//GEN-END:variables
}
