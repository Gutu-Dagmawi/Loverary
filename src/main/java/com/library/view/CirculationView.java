/*
 * Created by JFormDesigner on Mon Jul 29 13:54:27 EAT 2024
 */

package com.library.view;

import java.awt.event.*;
import java.beans.*;

import com.library.model.BookCopyDAO;
import com.library.model.BookDAO;
import com.library.model.Librarian;
import com.library.utils.BasicUtils;

import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Loverary Team
 */
public class CirculationForm extends JFrame {
    public CirculationForm() throws SQLException {
        initComponents();
    }

    private String getRowData(int row, int column) {
        System.out.println(row);
        System.out.println(column);
        var value = (String) table1.getValueAt(row,column);
        System.out.println(value);
        return value;
    }

    private void checkOutMouseClicked(MouseEvent e) throws SQLException {
        if((table1.getSelectedRow()!= -1) && (Boolean.parseBoolean(getRowData(table1.getSelectedRow(),4)))){
        var crd =changeCard();
        label4.setBounds(50,100, 100, 100);
        crd.last(panel2);

        // Populating form components with selected row data
        // Setting the model of the ComboBox so that it's drop down list entails available copies of the selected Book.

        comboBox2.setModel(new DefaultComboBoxModel<>(new BookCopyDAO().getBookCopies(getRowData(table1.getSelectedRow(), 0))));
        titleField.setText(getRowData(table1.getSelectedRow(), 1));

        // Setting DateFields
        coDateField.setText(LocalDate.now().toString());
        dueDateField.setText(LocalDate.now().plusDays(30).toString());
    }
    }

    public void backButtonMouseClicked(MouseEvent e) {
        var layout = changeCard();
        layout.show(getPanel2(), "card2");
    }

    private void confConfirmBtnMouseClicked(MouseEvent e) throws SQLException {
        new Librarian().checkOut(1,Date.valueOf(coDateField.getText()) , Date.valueOf(dueDateField.getText()), (String) comboBox2.getSelectedItem(), 1, this);
    }

    


    private CardLayout changeCard() {
        CardLayout crd = (CardLayout) panel2.getLayout();
        button2.setVisible(true);
        textField1.setVisible(true);
        button1.setVisible(true);
        label2.setVisible(true);
        label3.setVisible(true);
        comboBox1.setVisible(true);
        return crd;
    }



    public JDialog getSuccessDialog() {
        return successDialog;
    }

    private void table1PropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }
    
    private void successDialogWindowClosing() {
        var crdLayout = changeCard();
        crdLayout.show(getPanel2(), "card2");
    }
    

    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dagmawi Gutu
        panel5 = new JPanel();
        panel1 = new JPanel();
        textField1 = new JTextField();
        comboBox1 = new JComboBox<>();
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        button5 = new JButton();
        panel6 = new JPanel();
        label10 = new JLabel();
        button6 = new JButton();
        label11 = new JLabel();
        label12 = new JLabel();
        comboBox3 = new JComboBox<>();
        textField2 = new JTextField();
        button7 = new JButton();
        button8 = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        setTableModel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        button3 = new JButton();
        patronField = new JTextField();
        label1 = new JLabel();
        coDateField = new JTextField();
        label5 = new JLabel();
        dueDateField = new JTextField();
        label6 = new JLabel();
        comboBox2 = new JComboBox();
        label7 = new JLabel();
        button4 = new JButton();
        titleField = new JTextField();
        label8 = new JLabel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        panel7 = new JPanel();
        successDialog = new JDialog();
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label9 = new JLabel();

        //======== this ========
        setTitle("Loverary");
        setMinimumSize(new Dimension(1000, 750));
        setPreferredSize(new Dimension(1200, 800));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel5 ========
        {
            panel5.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel5. getBorder( )) ); panel5. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );
            panel5.setLayout(new CardLayout());

            //======== panel1 ========
            {
                panel1.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));

                //---- comboBox1 ----
                comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getSize() + 6f));
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Available",
                    "Checked Out",
                    "On Hold"
                }));

                //---- button1 ----
                button1.setText("Search");
                button1.setFont(button1.getFont().deriveFont(Font.BOLD, button1.getFont().getSize() + 5f));
                button1.setBackground(new Color(0x240bff));

                //---- button2 ----
                button2.setText("Checkout");
                button2.setFont(button2.getFont().deriveFont(button2.getFont().getStyle() | Font.BOLD, button2.getFont().getSize() + 6f));
                button2.setBackground(new Color(0xb85e05));
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
checkOutMouseClicked(e);} catch (SQLException ex) {
    throw new RuntimeException(ex);
}
                    }
                });

                //---- label2 ----
                label2.setText("Show:");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 6f));

                //---- label3 ----
                label3.setText("Search:");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 6f));

                //---- label4 ----
                label4.setText(null);
                label4.setIcon(new ImageIcon(getClass().getResource("/assets/logo-no-background(resize2).png")));

                //---- button5 ----
                button5.setFont(button5.getFont().deriveFont(button5.getFont().getStyle() | Font.BOLD, button5.getFont().getSize() + 7f));
                button5.setBackground(new Color(0xf38414));
                button5.setText("Logout");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24)
                                    .addComponent(label2)
                                    .addGap(0, 0, 0)
                                    .addComponent(comboBox1)
                                    .addGap(10, 10, 10)
                                    .addComponent(label3)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(576, 576, 576)))
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(button5)))
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2)
                                    .addComponent(label3)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            panel5.add(panel1, "card1");

            //======== panel6 ========
            {
                panel6.setBorder(new MatteBorder(1, 1, 1, 1, Color.darkGray));
                panel6.setMaximumSize(new Dimension(33448, 328));
                panel6.setPreferredSize(new Dimension(930, 70));
                panel6.setMinimumSize(new Dimension(766, 62));

                //---- label10 ----
                label10.setText(null);
                label10.setIcon(new ImageIcon(getClass().getResource("/assets/logo-no-background(resize2).png")));
                label10.setHorizontalAlignment(SwingConstants.LEFT);

                //---- button6 ----
                button6.setText("Check In");
                button6.setFont(button6.getFont().deriveFont(button6.getFont().getStyle() | Font.BOLD, button6.getFont().getSize() + 6f));
                button6.setBackground(new Color(0xb85e05));
                button6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
checkOutMouseClicked(e);} catch (SQLException ex) {
    throw new RuntimeException(ex);
}
                    }
                });

                //---- label11 ----
                label11.setText("Search:");
                label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 6f));

                //---- label12 ----
                label12.setText("Show:");
                label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 6f));

                //---- comboBox3 ----
                comboBox3.setFont(comboBox3.getFont().deriveFont(comboBox3.getFont().getSize() + 6f));
                comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Available",
                    "Checked Out",
                    "On Hold"
                }));

                //---- textField2 ----
                textField2.setPreferredSize(new Dimension(500, 30));
                textField2.setFont(textField2.getFont().deriveFont(textField2.getFont().getSize() + 10f));

                //---- button7 ----
                button7.setFont(button7.getFont().deriveFont(button7.getFont().getStyle() | Font.BOLD, button7.getFont().getSize() + 7f));
                button7.setBackground(new Color(0x0066ff));
                button7.setText("Logout");

                //---- button8 ----
                button8.setText("Search");
                button8.setFont(button8.getFont().deriveFont(Font.BOLD, button8.getFont().getSize() + 5f));
                button8.setBackground(new Color(0x240bff));

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                    panel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addComponent(button6, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label11)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(button8, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6))
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label12, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                                    .addComponent(button7, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                );
                panel6Layout.setVerticalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel6Layout.createParallelGroup()
                                .addComponent(button7)
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label12)
                                        .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                            .addGroup(panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button8)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button6)
                                    .addComponent(label11)))
                            .addContainerGap())
                );
            }
            panel5.add(panel6, "card2");
        }
        contentPane.add(panel5, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setLayout(new CardLayout());

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setFont(table1.getFont().deriveFont(table1.getFont().getStyle() & ~Font.BOLD, table1.getFont().getSize() + 3f));
                table1.setForeground(null);
                table1.setRowHeight(30);
                table1.setRowMargin(11);
                table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table1.addPropertyChangeListener("selectedRow", e -> {
			table1PropertyChange(e);
			table1PropertyChange(e);
		});
                scrollPane1.setViewportView(table1);
            }
            panel2.add(scrollPane1, "card2");

            //======== panel3 ========
            {
                panel3.setBorder(new BevelBorder(BevelBorder.LOWERED));

                //======== panel4 ========
                {
                    panel4.setMaximumSize(new Dimension(65802, 900));
                    panel4.setBorder(null);
                    panel4.setPreferredSize(new Dimension(800, 800));
                    panel4.setMinimumSize(new Dimension(711, 900));

                    //---- button3 ----
                    button3.setText("Back");
                    button3.setBackground(new Color(0xb85e05));
                    button3.setFont(button3.getFont().deriveFont(button3.getFont().getStyle() | Font.BOLD, button3.getFont().getSize() + 7f));
                    button3.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            backButtonMouseClicked(e);
                        }
                    });

                    //---- patronField ----
                    patronField.setFont(patronField.getFont().deriveFont(patronField.getFont().getSize() + 7f));

                    //---- label1 ----
                    label1.setText(" Patron :");
                    label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
                    label1.setHorizontalAlignment(SwingConstants.RIGHT);
                    label1.setVerticalAlignment(SwingConstants.BOTTOM);

                    //---- coDateField ----
                    coDateField.setFont(coDateField.getFont().deriveFont(coDateField.getFont().getSize() + 7f));

                    //---- label5 ----
                    label5.setText("   Checkout Date :");
                    label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
                    label5.setHorizontalAlignment(SwingConstants.CENTER);
                    label5.setVerticalTextPosition(SwingConstants.BOTTOM);

                    //---- dueDateField ----
                    dueDateField.setFont(dueDateField.getFont().deriveFont(dueDateField.getFont().getSize() + 5f));

                    //---- label6 ----
                    label6.setText("Due Date : ");
                    label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 6f));
                    label6.setHorizontalAlignment(SwingConstants.RIGHT);
                    label6.setVerticalTextPosition(SwingConstants.BOTTOM);

                    //---- comboBox2 ----
                    comboBox2.setFont(comboBox2.getFont().deriveFont(comboBox2.getFont().getSize() + 6f));

                    //---- label7 ----
                    label7.setText("Copy Barcode :");
                    label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 6f));
                    label7.setHorizontalAlignment(SwingConstants.RIGHT);
                    label7.setVerticalTextPosition(SwingConstants.BOTTOM);

                    //---- button4 ----
                    button4.setText("Confirm Checkout");
                    button4.setFont(button4.getFont().deriveFont(button4.getFont().getStyle() | Font.BOLD, button4.getFont().getSize() + 6f));
                    button4.setBackground(new Color(0xb85e05));
                    button4.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
confConfirmBtnMouseClicked(e);} catch (SQLException ex) {
    throw new RuntimeException(ex);
}
                        }
                    });

                    //---- titleField ----
                    titleField.setFont(titleField.getFont().deriveFont(titleField.getFont().getSize() + 7f));

                    //---- label8 ----
                    label8.setText(" Book Title : ");
                    label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 6f));
                    label8.setHorizontalAlignment(SwingConstants.RIGHT);
                    label8.setVerticalAlignment(SwingConstants.BOTTOM);

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel4Layout.createParallelGroup()
                                            .addComponent(titleField)
                                            .addComponent(patronField)))
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGroup(panel4Layout.createParallelGroup()
                                            .addGroup(panel4Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel4Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(label7)
                                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(comboBox2, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                                                    .addComponent(dueDateField)
                                                    .addComponent(coDateField))))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                        .addGap(0, 504, Short.MAX_VALUE)
                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(button3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                        .addGroup(panel4Layout.createParallelGroup()
                                            .addComponent(titleField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(patronField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59)
                                        .addComponent(label5))
                                    .addComponent(coDateField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label7)
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(dueDateField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                    );
                }

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 821, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 105, Short.MAX_VALUE))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            panel2.add(panel3, "card1");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(table2);
            }
            panel2.add(scrollPane2, "card4");

            //======== panel7 ========
            {

                GroupLayout panel7Layout = new GroupLayout(panel7);
                panel7.setLayout(panel7Layout);
                panel7Layout.setHorizontalGroup(
                    panel7Layout.createParallelGroup()
                        .addGap(0, 930, Short.MAX_VALUE)
                );
                panel7Layout.setVerticalGroup(
                    panel7Layout.createParallelGroup()
                        .addGap(0, 610, Short.MAX_VALUE)
                );
            }
            panel2.add(panel7, "card3");
        }
        contentPane.add(panel2, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //======== successDialog ========
        {
            successDialog.setModal(true);
            successDialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    successDialogWindowClosing();
                }
            });
            var successDialogContentPane = successDialog.getContentPane();

            //======== dialogPane ========
            {
                dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
                dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0
                ,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
                ,new java.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),java.awt.Color.red),
                dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
                ){if("\u0062or\u0064er".equals(e.getPropertyName()))throw new RuntimeException();}});

                //======== contentPanel ========
                {

                    //---- label9 ----
                    label9.setText("Checked Out Successfully!");
                    label9.setFont(label9.getFont().deriveFont(label9.getFont().getStyle() | Font.ITALIC, label9.getFont().getSize() + 9f));
                    label9.setHorizontalAlignment(SwingConstants.CENTER);
                    label9.setForeground(new Color(0x07f807));

                    GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                    contentPanel.setLayout(contentPanelLayout);
                    contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(70, Short.MAX_VALUE))
                    );
                    contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(116, Short.MAX_VALUE))
                    );
                }

                GroupLayout dialogPaneLayout = new GroupLayout(dialogPane);
                dialogPane.setLayout(dialogPaneLayout);
                dialogPaneLayout.setHorizontalGroup(
                    dialogPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, dialogPaneLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15))
                );
                dialogPaneLayout.setVerticalGroup(
                    dialogPaneLayout.createParallelGroup()
                        .addGroup(dialogPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(93, Short.MAX_VALUE))
                );
            }

            GroupLayout successDialogContentPaneLayout = new GroupLayout(successDialogContentPane);
            successDialogContentPane.setLayout(successDialogContentPaneLayout);
            successDialogContentPaneLayout.setHorizontalGroup(
                successDialogContentPaneLayout.createParallelGroup()
                    .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
            successDialogContentPaneLayout.setVerticalGroup(
                successDialogContentPaneLayout.createParallelGroup()
                    .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
            successDialog.pack();
            successDialog.setLocationRelativeTo(successDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public JTable getTable1() {
        return table1;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public ArrayList<JTextField> getCheckOutFormFields(){
         return new ArrayList<>(Arrays.asList(titleField, patronField, coDateField, dueDateField));
        }

    // Utility methods
    private void setTableModel() throws SQLException {
        table1.setModel(new DefaultTableModel(
                BasicUtils.getBookRowArray(new BookDAO().readAll()), BasicUtils.getColumns("book", "Library")
        ));
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dagmawi Gutu
    private JPanel panel5;
    private JPanel panel1;
    private JTextField textField1;
    private JComboBox<String> comboBox1;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton button5;
    private JPanel panel6;
    private JLabel label10;
    private JButton button6;
    private JLabel label11;
    private JLabel label12;
    private JComboBox<String> comboBox3;
    private JTextField textField2;
    private JButton button7;
    private JButton button8;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel3;
    private JPanel panel4;
    private JButton button3;
    private JTextField patronField;
    private JLabel label1;
    private JTextField coDateField;
    private JLabel label5;
    private JTextField dueDateField;
    private JLabel label6;
    private JComboBox comboBox2;
    private JLabel label7;
    private JButton button4;
    private JTextField titleField;
    private JLabel label8;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JPanel panel7;
    private JDialog successDialog;
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
