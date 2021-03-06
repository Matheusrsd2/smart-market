/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produto;

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
public class TelaProdutos extends javax.swing.JPanel {
    
    private List<TipoProduto> lstTipoProduto;
    
    /**
     * Creates new form TelaProdutos
     */
    public TelaProdutos() {
        lstTipoProduto = new LinkedList<>();
        lstTipoProduto = ObservableCollections.observableList(lstTipoProduto);
        
        TipoProdutoDAO tpDAO = new TipoProdutoDAO();
        lstTipoProduto = tpDAO.listar();
        
        initComponents();
        
        BindingGroup bg = new BindingGroup();
        JTableBinding tb = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                lstTipoProduto, tabelaTipoProduto);
        
        JTableBinding.ColumnBinding cb = tb.addColumnBinding(BeanProperty.create("descricao"));
        cb.setColumnName("Descrição");
        cb.setColumnClass(String.class);
        
        bg.addBinding(tb);
        
        Binding b;
        b = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                txtDescricao, BeanProperty.create("text"),
                tabelaTipoProduto, BeanProperty.create("selectedElement.descricao"));
        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtDescricao = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTipoProduto = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 50));

        txtDescricao.setPreferredSize(new java.awt.Dimension(350, 30));
        jPanel2.add(txtDescricao);

        btnCadastrar.setBackground(new java.awt.Color(255, 51, 51));
        btnCadastrar.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCadastrar);

        jPanel1.add(jPanel2);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(453, 200));

        tabelaTipoProduto.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaTipoProduto.setPreferredSize(new java.awt.Dimension(500, 200));
        jScrollPane1.setViewportView(tabelaTipoProduto);

        jPanel1.add(jScrollPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 385;
        gridBagConstraints.ipady = 393;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 22, 12, 12);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        TipoProduto tp = new TipoProduto();
        tp.setDescricao(txtDescricao.getText());

        lstTipoProduto.add(tp);

        TipoProdutoDAO tpd = new TipoProdutoDAO();

        for(TipoProduto item:lstTipoProduto){
            if(item.getId() == null){
                tpd.inserir(item);
            }
        }

        System.out.printf("Adicionado na lista: %s", tp.getDescricao());
    }//GEN-LAST:event_btnCadastrarActionPerformed
    
    public static void main(String args[]){
        JFrame janela = new JFrame();
        janela.setSize(550, 400);
        
        TelaProdutos tela = new TelaProdutos();
        janela.add(tela);
        janela.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaTipoProduto;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
