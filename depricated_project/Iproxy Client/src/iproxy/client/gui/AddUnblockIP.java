/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iproxy.client.gui;

import iproxy.client.Beans.UnblockableBean;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author root
 */
public class AddUnblockIP extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    public String ip = "";
    private int protocol = 6; //Default TCP
    public UnblockableBean unblockableBean;
    /**
     * Creates new form AddUnblockIP
     */
    public AddUnblockIP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        IpInput1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IpInput2 = new javax.swing.JTextField();
        IpInput3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        IpInput4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        blockedPortLabel = new javax.swing.JTextField();
        udpButton = new javax.swing.JRadioButton();
        tcpButton = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        IpInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IpInput1ActionPerformed(evt);
            }
        });
        IpInput1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IpInput1KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IpInput1KeyPressed(evt);
            }
        });

        jLabel1.setText("IP :");

        jLabel3.setText(".");

        jLabel4.setText(".");

        IpInput2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IpInput2ActionPerformed(evt);
            }
        });
        IpInput2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IpInput2KeyTyped(evt);
            }
        });

        IpInput3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IpInput3ActionPerformed(evt);
            }
        });
        IpInput3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IpInput3KeyTyped(evt);
            }
        });

        jLabel5.setText(".");

        IpInput4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IpInput4ActionPerformed(evt);
            }
        });
        IpInput4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IpInput4KeyTyped(evt);
            }
        });

        jLabel2.setText("Agregar Nueva IP");

        jLabel6.setText("Puerto:");

        blockedPortLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockedPortLabelActionPerformed(evt);
            }
        });
        blockedPortLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                blockedPortLabelKeyPressed(evt);
            }
        });

        buttonGroup2.add(udpButton);
        udpButton.setText("UDP");
        udpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                udpButtonActionPerformed(evt);
            }
        });

        buttonGroup2.add(tcpButton);
        tcpButton.setSelected(true);
        tcpButton.setText("TCP");
        tcpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcpButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Protocolo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IpInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IpInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IpInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IpInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(udpButton)
                                    .addComponent(blockedPortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tcpButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 180, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IpInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(IpInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IpInput3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(IpInput4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(blockedPortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(udpButton)
                    .addComponent(tcpButton)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        ip = IpInput1.getText() + "." + IpInput2.getText() + "." + IpInput3.getText() + "." + IpInput4.getText();
        unblockableBean = new UnblockableBean();
        unblockableBean.setBlockedIP(ip);
        int port = blockedPortLabel.getText().equals("")?-1:Integer.parseInt(blockedPortLabel.getText());
        unblockableBean.setBlockedPort(port);
        unblockableBean.setProtocol(protocol);
        int identifier = (port == -1 && ip.equals("..."))?-1:(port == -1)?1:ip.equals("...")?3:2;
        unblockableBean.setIdentifier(identifier);
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void IpInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IpInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IpInput1ActionPerformed

    private void IpInput2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IpInput2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IpInput2ActionPerformed

    private void IpInput3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IpInput3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IpInput3ActionPerformed

    private void IpInput4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IpInput4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IpInput4ActionPerformed

    private void IpInput1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IpInput1KeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (IpInput1.getText().length() >= 3) {
                if (IpInput1.getText().length() >= 3) {
                    evt.consume();
                }
                IpInput2.requestFocusInWindow();
            }

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_IpInput1KeyTyped

    private void IpInput1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IpInput1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_IpInput1KeyPressed

    private void IpInput2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IpInput2KeyTyped
        // TODO add your handling code here: 
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (IpInput2.getText().length() >= 3) {
                if (IpInput2.getText().length() >= 3) {
                    evt.consume();
                }
                IpInput3.requestFocusInWindow();
            }

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_IpInput2KeyTyped

    private void IpInput3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IpInput3KeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (IpInput3.getText().length() >= 2) {
                if (IpInput3.getText().length() >= 3) {
                    evt.consume();
                }
                IpInput4.requestFocusInWindow();
            }

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_IpInput3KeyTyped

    private void IpInput4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IpInput4KeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (IpInput4.getText().length() >= 3) {
                if (IpInput4.getText().length() >= 3) {
                    evt.consume();
                    okButton.requestFocusInWindow();
                }
            }

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_IpInput4KeyTyped

    private void blockedPortLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockedPortLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blockedPortLabelActionPerformed

    private void tcpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcpButtonActionPerformed
        // TODO add your handling code here:
        protocol = 6;
    }//GEN-LAST:event_tcpButtonActionPerformed

    private void udpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_udpButtonActionPerformed
        // TODO add your handling code here:
        protocol = 17;
    }//GEN-LAST:event_udpButtonActionPerformed

    private void blockedPortLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_blockedPortLabelKeyPressed
        // TODO add your handling code here:
           if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (blockedPortLabel.getText().length() >= 3) {
                if (blockedPortLabel.getText().length() >= 3) {
                    evt.consume();
                }
                blockedPortLabel.requestFocusInWindow();
            }

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_blockedPortLabelKeyPressed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddUnblockIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUnblockIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUnblockIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUnblockIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                AddUnblockIP dialog = new AddUnblockIP(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField IpInput1;
    private javax.swing.JTextField IpInput2;
    private javax.swing.JTextField IpInput3;
    private javax.swing.JTextField IpInput4;
    private javax.swing.JTextField blockedPortLabel;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton tcpButton;
    private javax.swing.JRadioButton udpButton;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
}
