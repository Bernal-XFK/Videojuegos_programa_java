package videojuegos;

import javax.swing.JOptionPane;

public class Multas extends javax.swing.JDialog {

    ListaDoble lista;

    public Multas(java.awt.Frame parent, boolean modal, ListaDoble x) {
        super(parent, modal);
        initComponents();
        lista = x;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMultar = new javax.swing.JButton();
        btnQuitarMulta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TxtCedulamulta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Multar Usuarios!!");

        btnMultar.setBackground(new java.awt.Color(255, 255, 255));
        btnMultar.setText("Agregar Multa");
        btnMultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultarActionPerformed(evt);
            }
        });

        btnQuitarMulta.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitarMulta.setText("Quitar Multa");
        btnQuitarMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarMultaActionPerformed(evt);
            }
        });

        jLabel2.setText("Cedula Cliente:");

        TxtCedulamulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCedulamultaActionPerformed(evt);
            }
        });
        TxtCedulamulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCedulamultaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCedulamulta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuitarMulta)
                            .addComponent(btnMultar))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtCedulamulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMultar))
                .addGap(18, 18, 18)
                .addComponent(btnQuitarMulta)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private NodoUsuario buscarUsuarioPorCedula(int cedula) {
        NodoUsuario aux = lista.pri;

        while (aux != null && aux.id != cedula) {
            aux = aux.sig;
        }

        return aux;
    }

    private void btnMultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultarActionPerformed

        if (TxtCedulamulta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Una Cedula ");
            TxtCedulamulta.requestFocus();

        }
        int cedula = Integer.parseInt(TxtCedulamulta.getText());

        NodoUsuario usuario = buscarUsuarioPorCedula(cedula);

        if (usuario != null) {
            NodoAlquilar primerAlquiler = usuario.priAlquilar;

            if (primerAlquiler != null) {
                primerAlquiler.agregarMulta();
                JOptionPane.showMessageDialog(this, "Multa agregada al usuario.");
            } else {
                JOptionPane.showMessageDialog(this, "El usuario no tiene alquileres registrados.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "El usuario no existe.");
        }
    }//GEN-LAST:event_btnMultarActionPerformed

    private void btnQuitarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarMultaActionPerformed
        if (TxtCedulamulta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Una Cedula ");
            TxtCedulamulta.requestFocus();

        }
        int cedula = Integer.parseInt(TxtCedulamulta.getText());

        NodoUsuario usuario = buscarUsuarioPorCedula(cedula);

        if (usuario != null) {
            NodoAlquilar primerAlquiler = usuario.priAlquilar;

            if (primerAlquiler != null) {
                if (primerAlquiler.tieneMultas()) {
                    primerAlquiler.quitarMulta();
                    JOptionPane.showMessageDialog(this, "Multa quitada al usuario.");
                } else {
                    JOptionPane.showMessageDialog(this, "El usuario no tiene multas que quitar.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El usuario no tiene alquileres registrados.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "El usuario no existe.");
        }
    }//GEN-LAST:event_btnQuitarMultaActionPerformed

    private void TxtCedulamultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCedulamultaActionPerformed
        if (TxtCedulamulta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Una Cedula ");
            TxtCedulamulta.requestFocus();

        }
    }//GEN-LAST:event_TxtCedulamultaActionPerformed

    private void TxtCedulamultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCedulamultaKeyTyped
        int key = evt.getKeyChar();
        boolean entrada = key >= 48 && key <= 57;
        if (!entrada) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtCedulamultaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtCedulamulta;
    private javax.swing.JButton btnMultar;
    private javax.swing.JButton btnQuitarMulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
