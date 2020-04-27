/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PesquisarProduto;

import PesquisarProduto.Busca;
import PesquisarProduto.Loading;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author natalia
 */
public class BuscaProduto extends javax.swing.JPanel {
    
    private List<Produto> lstProducts;
    
    /**
     * Creates new form BuscaProduto
     */
    public BuscaProduto() {
        
        lstProducts = new LinkedList<>();
        lstProducts = ObservableCollections.observableList(lstProducts);
        
        initComponents();
        
        txtAPI.setVisible(false);
        
        listProducts.setRowHeight(30);
        
        BindingGroup bg = new BindingGroup();
        JTableBinding tb = SwingBindings.createJTableBinding(
                    AutoBinding.UpdateStrategy.READ_WRITE,
                    lstProducts, listProducts);
        JTableBinding.ColumnBinding cb = tb.addColumnBinding(BeanProperty.create("nome"));
        cb.setColumnName("Produto");
        cb.setColumnClass(String.class);
        
        bg.addBinding(tb);
        
        Binding b;
        b = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                listProducts, BeanProperty.create("selectedElement.imagem"),
                image, BeanProperty.create("icon"));
        bg.addBinding(b);
        
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
        java.awt.GridBagConstraints gridBagConstraints;

        TausteSul = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtAPI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        buttonTaauste = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        container_img = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProducts = new javax.swing.JTable();
        mensagemSistema1 = new projetointegrador1.MensagemSistema();

        setLayout(new java.awt.BorderLayout());

        TausteSul.setLayout(new java.awt.GridBagLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        txtAPI.setEditable(false);
        txtAPI.setText("http://smart-market-api.herokuapp.com/tauste");
        txtAPI.setToolTipText("");
        txtAPI.setPreferredSize(new java.awt.Dimension(600, 19));
        txtAPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAPIActionPerformed(evt);
            }
        });
        jPanel1.add(txtAPI);

        jLabel1.setText("Pesquisar: ");
        jPanel1.add(jLabel1);

        jTextField1.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel1.add(jTextField1);

        buttonTaauste.setText("Extrair");
        buttonTaauste.setPreferredSize(new java.awt.Dimension(100, 30));
        buttonTaauste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTaausteActionPerformed(evt);
            }
        });
        jPanel1.add(buttonTaauste);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 204));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("R$ 0,00");

        name.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        name.setText("Nome do Produto");

        container_img.setBackground(new java.awt.Color(240, 240, 240));
        container_img.setPreferredSize(new java.awt.Dimension(220, 220));
        container_img.setLayout(new javax.swing.OverlayLayout(container_img));

        image.setBackground(new java.awt.Color(255, 255, 255));
        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        container_img.add(image);

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Adicionar na Lista");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container_img, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 198, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(22, 22, 22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(container_img, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(name)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 300));

        listProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        listProducts.setPreferredSize(new java.awt.Dimension(300, 300));
        jScrollPane1.setViewportView(listProducts);

        jPanel1.add(jScrollPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 389;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 12, 12);
        TausteSul.add(jPanel1, gridBagConstraints);

        add(TausteSul, java.awt.BorderLayout.CENTER);
        add(mensagemSistema1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTaausteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTaausteActionPerformed

        //Loading windowLoading = new Loading(this);

        Busca busca = new Busca();
        busca.getAll(lstProducts, mensagemSistema1);

    }//GEN-LAST:event_buttonTaausteActionPerformed

    private void txtAPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAPIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPIActionPerformed
    
    public static void main(String args[]){
        JFrame janela = new JFrame();
        janela.setSize(550, 400);
        
        BuscaProduto tela = new BuscaProduto();
        janela.add(tela);
        janela.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TausteSul;
    private javax.swing.JButton buttonTaauste;
    private javax.swing.JPanel container_img;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable listProducts;
    private projetointegrador1.MensagemSistema mensagemSistema1;
    private javax.swing.JLabel name;
    private javax.swing.JTextField txtAPI;
    // End of variables declaration//GEN-END:variables
}