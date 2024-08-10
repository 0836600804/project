package BHX_Swings.bhx.component;

import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
    }

    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }

    public void setName(String name) {
        lbUserName.setText(name);
    }

    public void setRole(String role) {
        lbRole.setText(role);
    }

    public void setImage(ImageIcon image) {
        pic.setIcon(image);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new BHX_Swings.bhx.swing.Button();
        lbUserName = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(671, 70));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BHX_Swings/bhx/icon/menu.png"))); // NOI18N

        lbUserName.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbUserName.setText("User Name");

        lbRole.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbRole.setText("Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 430, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbRole, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbRole)))
                .addContainerGap())
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private BHX_Swings.bhx.swing.Button cmdMenu;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JLabel pic;
    // End of variables declaration//GEN-END:variables
}
