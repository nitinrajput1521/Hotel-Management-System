package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener
{
JButton back,Submit;
JTable table;
Choice cartype;


Pickup()
{
getContentPane().setBackground(Color.WHITE);
setLayout(null);


JLabel text = new JLabel("Pickup Service");
text.setFont(new Font("Tahoma",Font.PLAIN,20));
text.setBounds(400,30,200,30);
add(text);

JLabel lblbed = new JLabel("Car Type");
lblbed.setBounds(50,100,100,20);
add(lblbed);

cartype = new Choice();
cartype.setBounds(150,100,200,25);
add(cartype);

try{
    Conn c = new Conn();
    ResultSet rs = c.s.executeQuery("select * from driver");
    while(rs.next())
    {
        cartype.add(rs.getString("brand"));
    }
}
catch(Exception e)
{
    e.printStackTrace();
}


JLabel l1 = new JLabel("Name");
l1.setBounds(15,175,100,20);
add(l1);

JLabel l2 = new JLabel("Age");
l2.setBounds(165,175,100,20);
add(l2);

JLabel l3 = new JLabel("Gender");
l3.setBounds(310,175,100,20);
add(l3);

JLabel l4 = new JLabel("Company");
l4.setBounds(450,175,100,20);
add(l4);

JLabel l5 = new JLabel("Brand");
l5.setBounds(590,175,100,20);
add(l5);

JLabel l6 = new JLabel("Availability");
l6.setBounds(735,175,100,20);
add(l6);

JLabel l7 = new JLabel("Location");
l7.setBounds(880,175,100,20);
add(l7);

table = new JTable();
table.setBounds(0,200,1000,300);
add(table);

try
{
 Conn c = new Conn();
 ResultSet rs = c.s.executeQuery("select * from driver");
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
    
 String query ="select * from driver where brand ='"+cartype.getSelectedItem()+"'";
 
 Conn conn = new Conn();
 ResultSet rs;
 
 rs = conn.s.executeQuery(query);


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
    new Pickup();
    
}
}
