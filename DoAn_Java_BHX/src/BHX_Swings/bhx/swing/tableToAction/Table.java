package BHX_Swings.bhx.swing.tableToAction;

import BHX_Swings.bhx.swing.tableToAction.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Table extends JTable {

    public Table() {
        setRowHeight(40);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultRenderer(Object.class, centerRenderer);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.CENTER);
                TableHeader header = new TableHeader(o + "");
                header.setBackground(new Color(56, 138, 112));
                header.setHorizontalAlignment(JLabel.CENTER);
                header.setForeground(new Color(255,255,255));
                header.setFont( new Font("Times New Roman", Font.BOLD, 18));
                return header;
            }
        });
    }

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void clearDataTable() {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.setNumRows(0);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
}
