package longpipe;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrderForm extends javax.swing.JFrame {

    private ArrayList<Pipe> pipeOrder;
    private DefaultTableModel model;

    /**
     * Create the Order Form and set the model for the table.
     */
    public OrderForm() {
        initComponents();
        setResizable(false); //Disable window resizing
        pipeOrder = new ArrayList(); //Create a new arraylist to keep track of the pipe order
        Object[] columnName = {"Type", "Length", "Width", "Chemical Resistance", "Price"}; //Set the column names
        model = new DefaultTableModel(columnName, 0);
        tblOrder.setModel(model);
    }

    /**
     * Display the current pipe order within the gui JTable
     */
    public void displayPipes() {
        double totalcost = 0;
        clearTable();
        for (Pipe pipe : pipeOrder) {
            Object[] data = {pipe.getType(), String.format("%.2f",pipe.convertToMeters(pipe.getLength())) + " M", pipe.getDiameter() + " Inch", pipe.getChemicalResistance(), "£" + String.format("%.2f", pipe.getPrice())};
            model.addRow(data);
            totalcost += pipe.getPrice();
        }
        tfOutputCost.setText(String.format("%.2f", totalcost));
    }

    /**
     * Create the option pane to ask the user to confirm or cancel an action
     *
     * @param message The message to be displayed on the option pane
     * @param title The title displayed in the window border
     * @return 0 if the user selected "Yes" otherwise 1 if the user selected
     * "Cancel"
     */
    public int createOptionPane(String message, String title) {
        Object[] options = {"Yes",
            "Cancel"}; //Set the names of the buttons on the option dialog
        int n = JOptionPane.showOptionDialog(this, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]); //Create the option pane
        return n;
    }

    /**
     * Clear the table of all rows
     */
    public void clearTable() {
        model.setRowCount(0); //Clear the table
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfOutputCost = new javax.swing.JTextField();
        btnRemovePipe = new javax.swing.JButton();
        btnAddPipe = new javax.swing.JButton();
        btnRemoveAll = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        scrlTableScroll = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Longpipes Order Form");

        lblTitle.setText("Long Pipes Order Form");

        pnlMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Total Cost: £");

        tfOutputCost.setEditable(false);

        btnRemovePipe.setText("Remove Last Pipe");
        btnRemovePipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovePipeActionPerformed(evt);
            }
        });

        btnAddPipe.setText("Add Pipe");
        btnAddPipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPipeActionPerformed(evt);
            }
        });

        btnRemoveAll.setText("Remove All");
        btnRemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAllActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfOutputCost))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnRemoveAll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemovePipe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddPipe, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfOutputCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemovePipe)
                    .addComponent(btnAddPipe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveAll)
                    .addComponent(btnExit))
                .addContainerGap())
        );

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblOrder.setEnabled(false);
        scrlTableScroll.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setResizable(false);
            tblOrder.getColumnModel().getColumn(1).setResizable(false);
            tblOrder.getColumnModel().getColumn(2).setResizable(false);
            tblOrder.getColumnModel().getColumn(3).setResizable(false);
            tblOrder.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrlTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrlTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemovePipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovePipeActionPerformed
        if (!pipeOrder.isEmpty()) { //Check if theres orders to delete
            //Ask the user to confirm deletion of the last pipe
            int n = createOptionPane("Are you sure you want to remove the last pipe in the order?", "Warning");
            if (n == 0) {
                pipeOrder.remove(pipeOrder.size() - 1); //Remove the last pipe in the order list
                displayPipes(); //Reprint out the list
            }
        }
    }//GEN-LAST:event_btnRemovePipeActionPerformed

    private void btnAddPipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPipeActionPerformed
        //Open the dialog box to add a new pipe
        AddPipe ap = new AddPipe(this, true, pipeOrder);
        ap.setVisible(true);
        pipeOrder = ap.returnPipeOrder(); //Return a value before closing the window
        ap.dispose(); //Close the dialog window
        displayPipes(); //Display all pipes on the order to the table
    }//GEN-LAST:event_btnAddPipeActionPerformed

    private void btnRemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAllActionPerformed
        //Clear all added pipes after confirmation
        if (!pipeOrder.isEmpty()) { //Check if theres orders to delete
            int n = createOptionPane("Are you sure you want to remove all pipes?", "Warning");
            if (n == 0) {
                pipeOrder.clear(); //Clear the entire order list
                clearTable(); //Reprint the list of items
            }
        }
        // resets total cost to 0
        displayPipes();
        
    }//GEN-LAST:event_btnRemoveAllActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        //Exit the system after confirmation
        int n = createOptionPane("Are you sure you want to exit?", "Warning");
        if (n == 0) {
            System.exit(1);
        }
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPipe;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRemoveAll;
    private javax.swing.JButton btnRemovePipe;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JScrollPane scrlTableScroll;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField tfOutputCost;
    // End of variables declaration//GEN-END:variables
}
