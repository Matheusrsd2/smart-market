/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PesquisarProduto;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab04
 */
public class MyModel extends DefaultTableModel{
    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 2: 
                return ImageIcon.class;
            default: 
                return String.class;
        }
    }
}
