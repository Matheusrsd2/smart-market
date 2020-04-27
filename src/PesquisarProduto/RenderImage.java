/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PesquisarProduto;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Lab04
 */
public class RenderImage extends DefaultTableCellRenderer{
          @Override
            protected void setValue(Object value) {
                if (value instanceof Icon) {
                    setText(null);
                    setIcon((Icon) value);
                } else {
                    super.setValue(value);
                }
            }
   
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
//            boolean hasFocus, int row, int column) {
//          lbl.setText((String) value);
//          lbl.setIcon(icon);
//          return lbl;
//
//        }
}