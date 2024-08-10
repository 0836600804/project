package BHX_Swings.bhx.component;

import BHX_Swings.bhx.event.EventMenu;
import BHX_Swings.bhx.event.EventMenuSelected;
import BHX_Swings.bhx.event.EventShowPopupMenu;
import BHX_MODEL.Swing.model.ModelMenu;
import BHX_Swings.bhx.swing.MenuAnimation;
import BHX_Swings.bhx.swing.MenuItem;
import BHX_Swings.bhx.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;

    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
    }

    public void initMenuItem() {
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\home_admin.png", 25, 25), "Home"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\banhang.png", 25, 25), "Bán Hàng"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\nhaphang.png", 25, 25), "Nhập Hàng"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\nhanvien.png", 25, 25), "Quản lý nhân viên"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\account.png", 25, 25), "Quản lý Account"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\product.png", 25, 25), "Quản lý mặt hàng"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\groupproduct.png", 25, 25), "Quản lý nhóm loại"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\typeproduct.png", 25, 25), "Quản lý loại mặt hàng"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\price.png", 25, 25), "Quản lý giá bán"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\sale.png", 25, 25), "Quản lý giảm giá"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\thongke.png", 25, 25), "Thống kê"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\report_admin.png", 25, 25), "Báo cáo"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\revenue.png", 25, 25), "Doanh thu"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\system.png", 25, 25), "Hệ thống"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\log-out.png", 25, 25), "Logout"));
        addMenu(new ModelMenu(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\update.png", 25, 25), "Cập nhật thông tin"));
    }

    private ImageIcon getIScaleImage(String url, int w, int h) {
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage();
        Image scale = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon scalIcon = new ImageIcon(scale);
        return scalIcon;
    }

    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile2 = new BHX_Swings.bhx.component.Profile();

        setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(profile2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(124, 181, 30), getWidth(), 0, new Color(6, 117, 60));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private BHX_Swings.bhx.component.Profile profile2;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
