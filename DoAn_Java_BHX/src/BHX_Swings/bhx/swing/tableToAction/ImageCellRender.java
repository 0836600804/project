/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_Swings.bhx.swing.tableToAction;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author VanPhu
 */
public class ImageCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        if (o != null && o instanceof String) {
            String imageName = (String) o;
            ImageIcon imageIcon = new ImageIcon(imageName);
            if (imageIcon != null) {
                Image scaledImage = imageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                if (scaledImage != null) {
                    imageIcon = new ImageIcon(scaledImage);
                    return new JLabel(imageIcon);
                }
            }
        }
        return new JLabel(new ImageIcon(new ImageIcon("src\\BHX_IMG\\folderImages\\images\\icons\\null.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
    }
}
