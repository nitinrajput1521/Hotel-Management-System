
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JTextField username;
    JPasswordField pass;
    JButton login,cancel;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        JLabel User = new JLabel("Username");
        User.setBounds(40,20,100,30);
        add(User);
        
        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        
        JLabel Password = new JLabel("Password");
        Password.setBounds(40,70,100,30);
        add(Password);
        
        pass = new JPasswordField();
        pass.setBounds(150,70,150,30);
        add(pass);
        
        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,200);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
        
        
        setBounds(500,200,600,300);
        setVisible(true);
        
    }
public void actionPerformed(ActionEvent ae)
{
  if(ae.getSource()==login)
  {
  String user = username.getText();
  String password = pass.getText();
  
  try{
      Conn c = new Conn();
      String query = "select * from login where username = '"+ user + "' and password ='"+password +"'";
      ResultSet rs = c.s.executeQuery(query);
      
      if(rs.next()){
      setVisible(false);
      new Dashboard();
      }
      else{
          JOptionPane.showMessageDialog(null,"Invalid username or password");
          setVisible(false);
      }
      
  }
  catch(Exception e){
      e.printStackTrace();
      }
  }
  else if(ae.getSource()==cancel)
          {
           setVisible(false);   
          }
}
public static void main(String args[])
{
    new Login();
}
}
