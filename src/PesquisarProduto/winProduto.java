package PesquisarProduto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import PesquisarProduto.Produto;
import java.awt.Component;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JWindow;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.JTableBinding.ColumnBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.JSONObject;

/**
 *
 * @author Laboratorio
 */
public class winProduto extends javax.swing.JFrame {
    
    private List<Produto> lstProducts;
    private DefaultTableModel model;
    private String mercado;
        
    /**
     * Creates new form winProduto
     */
    public winProduto() {
        lstProducts = new LinkedList<>();
        lstProducts = ObservableCollections.observableList(lstProducts);
        initComponents();
        
        BindingGroup bg = new BindingGroup();
        JTableBinding tb = SwingBindings.createJTableBinding(
                    AutoBinding.UpdateStrategy.READ_WRITE,
                    lstProducts, listProducts);
        ColumnBinding cb = tb.addColumnBinding(BeanProperty.create("nome"));
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

        TausteSul = new javax.swing.JPanel();
        buttonTaauste = new javax.swing.JButton();
        txtTauste = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProducts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        container_img = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonTaauste.setText("Extrair");
        buttonTaauste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTaausteActionPerformed(evt);
            }
        });

        txtTauste.setEditable(false);
        txtTauste.setText("http://smart-market-api.herokuapp.com/tauste");
        txtTauste.setToolTipText("");
        txtTauste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTausteActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(listProducts);
        if (listProducts.getColumnModel().getColumnCount() > 0) {
            listProducts.getColumnModel().getColumn(2).setResizable(false);
            listProducts.getColumnModel().getColumn(3).setResizable(false);
            listProducts.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jLabel1.setText("Pesquisar: ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
                        .addContainerGap(176, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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

        javax.swing.GroupLayout TausteSulLayout = new javax.swing.GroupLayout(TausteSul);
        TausteSul.setLayout(TausteSulLayout);
        TausteSulLayout.setHorizontalGroup(
            TausteSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TausteSulLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TausteSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TausteSulLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonTaauste))
                    .addComponent(txtTauste, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        TausteSulLayout.setVerticalGroup(
            TausteSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TausteSulLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtTauste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TausteSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTaauste, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TausteSul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TausteSul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTaausteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTaausteActionPerformed
        mercado = "Tauste";
        System.out.println("Carregando...");
      
        Loading windowLoading = new Loading(this);
        
        Busca busca = new Busca();
       // busca.getAll(lstProducts, windowLoading);
        
    }//GEN-LAST:event_buttonTaausteActionPerformed

    private void txtTausteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTausteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTausteActionPerformed

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
            java.util.logging.Logger.getLogger(winProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(winProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(winProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(winProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new winProduto().setVisible(true);
            }
        });
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
    private javax.swing.JLabel name;
    private javax.swing.JTextField txtTauste;
    // End of variables declaration//GEN-END:variables
}