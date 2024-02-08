
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class AddRooms extends JFrame implements ActionListener {
    JButton addroom,cancel;
    JTextField tfprice,tfroom;
    JComboBox bedtypecombo,cleancombo,availablecombo;
    
  AddRooms(){
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel heading = new JLabel("ADD ROOMS");
      heading.setFont(new Font("Tahoma", Font.BOLD,18));
      heading.setBounds(150,20,200,20);
      add(heading);
      
      JLabel lblroomno = new JLabel("Room Number");
      lblroomno.setFont(new Font("Tahoma", Font.PLAIN,18));
      lblroomno.setBounds(60,80,120,30);
      add(lblroomno);
      
      tfroom = new JTextField();
      tfroom.setBounds(200,80,150,30);
      add(tfroom);
      
      JLabel lblavailable = new JLabel("Availability");
      lblavailable.setFont(new Font("Tahoma", Font.PLAIN,18));
      lblavailable.setBounds(60,130,120,30);
      add(lblavailable);
      
      String availableoptions [] = {" ","Available", "Not Available"};
      availablecombo = new JComboBox(availableoptions);
      availablecombo.setBounds(200,130,150,30);
      availablecombo.setBackground(Color.WHITE);
      add(availablecombo);
      
      
      JLabel lblclean = new JLabel("Cleaning Status");
      lblclean.setFont(new Font("Tahoma", Font.PLAIN,18));
      lblclean.setBounds(60,180,120,30);
      add(lblclean);
      
      String cleanoptions [] = {" ","Cleaned", "Not Cleaned"};
      cleancombo = new JComboBox(cleanoptions);
      cleancombo.setBounds(200,180,150,30);
      cleancombo.setBackground(Color.WHITE);
      add(cleancombo);
      
      JLabel lblprice = new JLabel("Price");
      lblprice.setFont(new Font("Tahoma", Font.PLAIN,18));
      lblprice.setBounds(60,230,120,30);
      add(lblprice);
      
      tfprice = new JTextField();
      tfprice.setBounds(200,230,150,30);
      add(tfprice);
      
      JLabel lblbedtype = new JLabel("Bed Type");
      lblbedtype.setFont(new Font("Tahoma", Font.PLAIN,18));
      lblbedtype.setBounds(60,280,120,30);
      add(lblbedtype);
      
      String bedtypeoptions [] = {" ","Single", "Double"};
      bedtypecombo = new JComboBox(bedtypeoptions);
      bedtypecombo.setBounds(200,280,150,30);
      bedtypecombo.setBackground(Color.WHITE);
      add(bedtypecombo);
      
      addroom = new JButton("Add Room");
      addroom.setForeground(Color.WHITE);
      addroom.setBackground(Color.BLACK);
      addroom.setBounds(60,350,130,30);
      addroom.addActionListener(this);
      add(addroom);
      
      cancel = new JButton("Cancel");
      cancel.setForeground(Color.WHITE);
      cancel.setBackground(Color.BLACK);
      cancel.setBounds(220,350,130,30);
      cancel.addActionListener(this);
      add(cancel);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
      JLabel image = new JLabel(i1);
      image.setBounds(400,30,500,300);
      add(image);
      
      
  setBounds(330,200,940,470);
  setVisible(true);
  }
  
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()== addroom)
{
String roomnumber = tfroom.getText();
String availability = (String) availablecombo.getSelectedItem();
String status = (String)cleancombo.getSelectedItem();
String type = (String)bedtypecombo.getSelectedItem();
String price = tfprice.getText();

try{
Conn conn = new Conn();
String str = "insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"','"+price+"','"+type+"')";
conn.s.executeUpdate(str);
JOptionPane.showMessageDialog(null,"New Room Added Successfully");
setVisible(false);
}
catch(Exception e)
{
    e.printStackTrace();
}
}
else
{
  setVisible(false);
}
}
public static void main(String args[])
{
 new AddRooms();   
}
}
