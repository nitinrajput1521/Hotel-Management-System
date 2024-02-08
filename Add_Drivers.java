
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddDrivers extends JFrame implements ActionListener {
JButton addroom,cancel;
    JTextField tfage,tfname,tfcompany,tfmodel,tflocation;
    JComboBox bedtypecombo,gendercombo,availablecombo; 
    
AddDrivers(){
    
    
  
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel heading = new JLabel("ADD DRIVERS");
      heading.setFont(new Font("Tahoma", Font.BOLD,18));
      heading.setBounds(150,10,200,20);
      add(heading);
      
      JLabel lblname = new JLabel("Name");
      lblname.setFont(new Font("Tahoma", Font.PLAIN,18));
      lblname.setBounds(60,70,120,30);
      add(lblname);
      
      tfname = new JTextField();
      tfname.setBounds(200,70,150,30);
      add(tfname);
      
      JLabel lblage = new JLabel("Age");
      lblage.setFont(new Font("Tahoma", Font.PLAIN,18));
      lblage.setBounds(60,120,120,30);
      add(lblage);
      
      tfage = new JTextField();
      tfage.setBounds(200,120,150,30);
      add(tfage);
      
      
      
      JLabel lblgender = new JLabel("Gender");
      lblgender.setFont(new Font("Tahoma", Font.PLAIN,18));
      lblgender.setBounds(60,160,120,30);
      add(lblgender);
      
      String genderoptions [] = {" ","Male", "Female"};
      gendercombo = new JComboBox(genderoptions);
      gendercombo.setBounds(200,160,150,30);
      gendercombo.setBackground(Color.WHITE);
      add(gendercombo);
      
      JLabel lblcompany = new JLabel("Car Company");
      lblcompany.setFont(new Font("Tahoma", Font.PLAIN,18));
      lblcompany.setBounds(60,200,120,30);
      add(lblcompany);
      
      tfcompany = new JTextField();
      tfcompany.setBounds(200,200,150,30);
      add(tfcompany);
      
      JLabel lblcartype = new JLabel("Car Model");
      lblcartype.setFont(new Font("Tahoma", Font.PLAIN,18));
      lblcartype.setBounds(60,240,120,30);
      add(lblcartype);
      
      tfmodel = new JTextField();
      tfmodel.setBounds(200,240,150,30);
      add(tfmodel);
      
      JLabel lblavailable = new JLabel("Availability");
      lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
      lblavailable.setBounds(60,280,120,30);
      add(lblavailable);
      
      String driveroptions [] = {" ","Available", "Not Available"};
      availablecombo = new JComboBox(driveroptions);
      availablecombo.setBounds(200,280,150,30);
      availablecombo.setBackground(Color.WHITE);
      add(availablecombo);
      
      JLabel lbllocation = new JLabel("Location");
      lbllocation.setFont(new Font("Tahoma", Font.PLAIN,18));
      lbllocation.setBounds(60,320,120,30);
      add(lbllocation);
      
      tflocation = new JTextField();
      tflocation.setBounds(200,320,150,30);
      add(tflocation);
      
      
      
      addroom = new JButton("Add Drivers");
      addroom.setForeground(Color.WHITE);
      addroom.setBackground(Color.BLACK);
      addroom.setBounds(60,380,130,30);
      addroom.addActionListener(this);
      add(addroom);
      
      cancel = new JButton("Cancel");
      cancel.setForeground(Color.WHITE);
      cancel.setBackground(Color.BLACK);
      cancel.setBounds(220,380,130,30);
      cancel.addActionListener(this);
      add(cancel);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
      Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(400,30,500,300);
      add(image);
      
      
  setBounds(300,200,980,470);
  setVisible(true);
  }
  
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()== addroom)
{
String name = tfname.getText();
String age = tfage.getText();
String gender = (String)gendercombo.getSelectedItem();
String company = tfcompany.getText();
String location = tflocation.getText();
String availability = (String) availablecombo.getSelectedItem();
String brand = tfmodel.getText();

try{
Conn conn = new Conn();
String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"','"+company+"','"+brand+"','"+availability+"','"+location+"')";
conn.s.executeUpdate(str);
JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
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
 new AddDrivers();   
}
}

