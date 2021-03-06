/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadastro_Cliente;

import java.util.LinkedList;
import java.util.List;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import projetointegrador1.NewTelaHome;

/**
 *
 * @author moyad
 */
public class ListarCliente extends javax.swing.JFrame {

    /**
     * Creates new form ListarCliente
     */
    public ListarCliente() {
        ClienteDAO cliente = new ClienteDAO();
        ClienteDAO cd = new ClienteDAO();
        lstClientes = cd.listar();
        initComponents();
       
        BindingGroup bg = new BindingGroup();
        JTableBinding tb = SwingBindings.createJTableBinding(
                    AutoBinding.UpdateStrategy.READ_WRITE,
                    lstClientes, tbCliente);
        JTableBinding.ColumnBinding cb = tb.addColumnBinding(BeanProperty.create("id_Cliente"));
        cb.setColumnName("ID");
        cb.setColumnClass(String.class);
        
         cb = tb.addColumnBinding(BeanProperty.create("cpf"));
        cb.setColumnName("Cpf");
        cb.setColumnClass(String.class);
        
        cb = tb.addColumnBinding(BeanProperty.create("nome"));
        cb.setColumnName("Nome");
        cb.setColumnClass(String.class);
        
        cb = tb.addColumnBinding(BeanProperty.create("sobrenome"));
        cb.setColumnName("Sobrenome");
        cb.setColumnClass(String.class);
        
        bg.addBinding(tb);
        bg.bind();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btb_ApagarCliente = new javax.swing.JButton();
        btbListar = new javax.swing.JButton();
        btbAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "E-mail", "Sobrenome"
            }
        ));
        jScrollPane1.setViewportView(tbCliente);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("LISTAGEM CLIENTE");

        btb_ApagarCliente.setText("Apagar");
        btb_ApagarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btb_ApagarClienteActionPerformed(evt);
            }
        });

        btbListar.setText("Listar Cliente");
        btbListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbListarActionPerformed(evt);
            }
        });

        btbAlterar.setText("Alterar");
        btbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btbAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btbListar)
                        .addGap(159, 159, 159)
                        .addComponent(btb_ApagarCliente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btb_ApagarCliente)
                    .addComponent(btbListar)
                    .addComponent(btbAlterar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbListarActionPerformed
        ClienteDAO cliente = new ClienteDAO();
        //cliente.listar();
        
        ClienteDAO cd = new ClienteDAO();
        lstClientes = cd.listar();
        initComponents();
       
        BindingGroup bg = new BindingGroup();
        JTableBinding tb = SwingBindings.createJTableBinding(
                    AutoBinding.UpdateStrategy.READ_WRITE,
                    lstClientes, tbCliente);
        JTableBinding.ColumnBinding cb = tb.addColumnBinding(BeanProperty.create("id_cliente"));
        cb.setColumnName("ID");
        cb.setColumnClass(String.class);
        
        cb = tb.addColumnBinding(BeanProperty.create("cpf"));
        cb.setColumnName("Cpf");
        cb.setColumnClass(String.class);
        
        cb = tb.addColumnBinding(BeanProperty.create("nome"));
        cb.setColumnName("Nome");
        cb.setColumnClass(String.class);
        
        cb = tb.addColumnBinding(BeanProperty.create("sobrenome"));
        cb.setColumnName("Sobrenome");
        cb.setColumnClass(String.class);
        
        bg.addBinding(tb);
        bg.bind();
        
    }//GEN-LAST:event_btbListarActionPerformed

       
    private void btbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbAlterarActionPerformed
      ClienteDAO cd = new ClienteDAO();
      for(Cliente c: lstClientes){
          cd.alterar(c);
      }      
    }//GEN-LAST:event_btbAlterarActionPerformed

    private void btb_ApagarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btb_ApagarClienteActionPerformed
        //int idx[] = tbCliente.getSelectedRows();
        int idx[] = tbCliente.getSelectedRows();
        List<Cliente> apagar = new LinkedList<>();
        ClienteDAO cd = new ClienteDAO();        
        tbCliente.getSelectionModel().setSelectionInterval(0,0);
        for(int i=0;i < idx.length;i++){
            int idxTab = idx[i];
            int idxLista = tbCliente.convertRowIndexToModel(idxTab);
            apagar.add(lstClientes.get(idxLista));
            cd.excluir(lstClientes.get(idxLista));
        }
            lstClientes.removeAll(apagar);
        
    }//GEN-LAST:event_btb_ApagarClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    private List<Cliente> lstClientes;
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
            java.util.logging.Logger.getLogger(ListarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarCliente().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbAlterar;
    private javax.swing.JButton btbListar;
    private javax.swing.JButton btb_ApagarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCliente;
    // End of variables declaration//GEN-END:variables
}
