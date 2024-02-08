package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener
{
JButton back,Submit;
JTable table;
JComboBox bedtype;
JCheckBox Available;

SearchRoom()
{
getContentPane().setBackground(Color.WHITE);
setLayout(null);


JLabel text = new JLabel("Search For Rooms");
text.setFont(new Font("Tahoma",Font.PLAIN,20));
text.setBounds(400,30,200,30);
add(text);

JLabel lblbed = new JLabel("BedType");
lblbed.setBounds(50,100,100,20);
add(lblbed);


bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
bedtype.setBounds(150,100,150,25);
bedtype.setBackground(Color.WHITE);
add(bedtype);

Available = new JCheckBox("Only Display Available ");
Available.setBounds(650,100,250,25);
Available.setBackground(Color.WHITE);
add(Available);

JLabel l1 = new JLabel("Room Number");
l1.setBounds(35,175,100,20);
add(l1);

JLabel l2 = new JLabel("Availability");
l2.setBounds(215,175,100,20);
add(l2);

JLabel l3 = new JLabel("Cleaning Status");
l3.setBounds(410,175,100,20);
add(l3);

JLabel l4 = new JLabel("Price");
l4.setBounds(605,175,100,20);
add(l4);

JLabel l5 = new JLabel("Bed-Tpe");
l5.setBounds(805,175,100,20);
add(l5);

table = new JTable();
table.setBounds(0,200,1000,300);
add(table);

try
{
 Conn c = new Conn();
 ResultSet rs = c.s.executeQuery("select * from room");
 table.setModel(DbUtils.resultSetToTableModel(rs));
}
catch(Exception e)
{
    e.printStackTrace();
}

Submit = new JButton("Submit");
Submit.setBackground(Color.BLACK);
Submit.setForeground(Color.WHITE);
Submit.addActionListener(this);
Submit.setBounds(300,500,120,30);
add(Submit);

back = new JButton("Back");
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
back.setBounds(500,500,120,30);
add(back);

setBounds(200,100,1000,600);
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==Submit)
    {
      try{
    
 String query1="select * from room where bed_type ='"+bedtype.getSelectedItem()+"'";
 String query2="select * from room where availability = 'Available' AND bed_type='"+ bedtype.getSelectedItem()+"'";
 Conn conn = new Conn();
 ResultSet rs;
 if(Available.isSelected())
 {
 rs = conn.s.executeQuery(query2);
 }
 else
 {
    rs= conn.s.executeQuery(query1);
 }
 table.setModel(DbUtils.resultSetToTableModel(rs));
 }

catch(Exception e)
{
e.printStackTrace();
}
}
    else {
        setVisible(false);
        new Reception();
    }
}
public static void main(String args[])
{
    new SearchRoom();
    
}
}
