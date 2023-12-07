
import database.MethodsUser;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlo
 */
public class SelectOne extends javax.swing.JFrame {

    private final String adminName;
    private final int adminId;
    
    MethodsUser object = new MethodsUser();

    /**
     * Creates new form SelectOne
     * @param adminId
     * @param adminName
     */
    public SelectOne(int adminId, String adminName) {
        initComponents();
        this.adminId=adminId;
        this.adminName = adminName;
    }

    private SelectOne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSelectOneMenu = new javax.swing.JButton();
        lblSelectOne = new javax.swing.JLabel();
        lblSelectOneIns = new javax.swing.JLabel();
        lblConsultEmail = new javax.swing.JLabel();
        txtConsultEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSelectOne = new javax.swing.JTable();
        btnSelectOne = new javax.swing.JButton();
        fondoSelectOne = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSelectOneMenu.setBackground(new java.awt.Color(0, 0, 0));
        btnSelectOneMenu.setFont(new java.awt.Font("Century Schoolbook", 3, 12)); // NOI18N
        btnSelectOneMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnSelectOneMenu.setText("Main Menu");
        btnSelectOneMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectOneMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelectOneMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 345, -1, -1));

        lblSelectOne.setFont(new java.awt.Font("Century Schoolbook", 3, 36)); // NOI18N
        lblSelectOne.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectOne.setText("Consult one contact");
        getContentPane().add(lblSelectOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, -1));

        lblSelectOneIns.setFont(new java.awt.Font("Century Schoolbook", 3, 14)); // NOI18N
        lblSelectOneIns.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectOneIns.setText("You can search them for:");
        getContentPane().add(lblSelectOneIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        lblConsultEmail.setFont(new java.awt.Font("Century Schoolbook", 3, 14)); // NOI18N
        lblConsultEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblConsultEmail.setText("Email");
        getContentPane().add(lblConsultEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        txtConsultEmail.setBackground(new java.awt.Color(0, 0, 0));
        txtConsultEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtConsultEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        getContentPane().add(txtConsultEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 240, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblSelectOne.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tblSelectOne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Name", "Last Name", "Email", "Phone Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSelectOne);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 390, 80));

        btnSelectOne.setFont(new java.awt.Font("Century Schoolbook", 3, 14)); // NOI18N
        btnSelectOne.setText("Consult");
        btnSelectOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectOneActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelectOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        fondoSelectOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_lindo.jpg"))); // NOI18N
        fondoSelectOne.setText("jLabel1");
        getContentPane().add(fondoSelectOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectOneMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectOneMenuActionPerformed
        MainMenu newFrame=new MainMenu(adminId, adminName);
        newFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSelectOneMenuActionPerformed

    private void btnSelectOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectOneActionPerformed
        try{    
            String email=txtConsultEmail.getText();
            if (!email.isEmpty()) {
                
                List<String> cadena = object.oneContact(email, adminId);

                DefaultTableModel model = (DefaultTableModel) tblSelectOne.getModel();

                // Limpiar la tabla antes de agregar nuevos datos
                model.setRowCount(0);

                // Agregar filas con los datos de la lista a la tabla
                for (String contactDetails : cadena) {
                    String[] rowData = contactDetails.split("\n");
                    model.addRow(rowData);
                }

                // Actualizar la tabla dentro del JScrollPane
                tblSelectOne.setModel(model);
                jScrollPane1.setViewportView(tblSelectOne);

                tblSelectOne.setRowHeight(40);
            }else{
                JOptionPane.showMessageDialog(null, "El usuario no existe, trata de buscar de nuevo validando correctamente la búsqueda");
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btnSelectOneActionPerformed

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
            java.util.logging.Logger.getLogger(SelectOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectOne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelectOne;
    private javax.swing.JButton btnSelectOneMenu;
    private javax.swing.JLabel fondoSelectOne;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConsultEmail;
    private javax.swing.JLabel lblSelectOne;
    private javax.swing.JLabel lblSelectOneIns;
    private javax.swing.JTable tblSelectOne;
    private javax.swing.JTextField txtConsultEmail;
    // End of variables declaration//GEN-END:variables
}
