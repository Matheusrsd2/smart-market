/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PesquisarProduto;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author natalia
 */
public class Loading {
    
    private JLabel message;
    private JLabel iconLoad;
    
    public Loading(JFrame window){
        
        JDialog dialog = new JDialog(window, false);
        dialog.setSize(window.getWidth(), window.getHeight());
        dialog.setUndecorated(true);
        dialog.getRootPane().setOpaque(false);
        dialog.setLocationRelativeTo(window);
                
        JPanel background = new JPanel();
        background.setSize(300, 150);
        background.setBackground(new Color(255, 255, 255));
        background.setLayout(null);
        
        iconLoad = new JLabel();
        iconLoad.setBounds(0, 15, 300, 70);
        iconLoad.setHorizontalAlignment(SwingConstants.CENTER);
        
        message = new JLabel();
        message.setBounds(0, 80, 300, 30);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        background.add(iconLoad);
        background.add(message);
        dialog.add(background);

        
        
        dialog.setVisible(true);
        
    }
    
    public void setMessage(String text){
        ImageIcon img = new ImageIcon(getClass().getResource("/projetointegrador1/hourglass.gif"));
        iconLoad.setIcon(img);
        message.setText(text);
    }
    
    public void setError(String text){
        ImageIcon img = new ImageIcon(getClass().getResource("/projetointegrador1/cancel.png"));
        iconLoad.setIcon(img);
        message.setText(text);
    }
    
    public void setSuccess(String text){
        ImageIcon img = new ImageIcon(getClass().getResource("/projetointegrador1/checked.png"));
        iconLoad.setIcon(img);
        message.setText(text);
    }
}
