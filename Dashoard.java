
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    Dashboard()
    {
        setBounds(0,0,1550,1000);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tomoha",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.BLUE);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        hotel.add(reception);
        reception.addActionListener(this);
        
        JMenu admin = new JMenu("admin");
        admin.setForeground(Color.RED);
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        admin.add(addemployee);
        addemployee.addActionListener(this);
        
        JMenuItem addroom = new JMenuItem("ADD ROOMS");
        admin.add(addroom);
        addroom.addActionListener(this);
        
        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        admin.add(adddrivers);
        adddrivers.addActionListener(this);
       
        
        
        
        setVisible(true);
    }
    
public void actionPerformed(ActionEvent ae)
{
if(ae.getActionCommand().equals("ADD EMPLOYEE")) 
{
    new AddEmployee();
}
else if(ae.getActionCommand().equals("ADD ROOMS"))
{
    new AddRooms();
}

else if(ae.getActionCommand().equals("ADD DRIVERS"))
{
    new AddDrivers();    
}
else if(ae.getActionCommand().equals("RECEPTION"))
{
    new Reception();
}
}   
public static void main(String args[])
{
    new Dashboard();
}
    
}
