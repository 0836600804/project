package BHX_Swings.bhx.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;

public class MenuButton extends JButton {

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    private boolean hovered = false;
    private boolean pressed = false;

    private int index;

    public MenuButton(Icon icon, String text) {
        super(text);
        setIcon(icon);
        init();
    }

    public MenuButton(String text) {
        super(text);
        init();
    }

    public MenuButton(String text, boolean subMenu) {
        super(text);
        init();
    }

    private void init() {
        setContentAreaFilled(false);
        setForeground(new Color(255, 255, 255));
        setHorizontalAlignment(JButton.LEFT);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent me) {
                pressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                pressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        if (pressed || hovered) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(255, 255, 255, 100)); // Màu trắng với độ trong suốt 100
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
