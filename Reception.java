
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener {
    
    JButton newcustomer,rooms,department,allemployee,managerinfo,customers;
    JButton checkout,logout,searchRoom,update,roomstatus,pickup;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        allemployee = new JButton("All Employee");
        allemployee.setBounds(10,150,200,30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        allemployee.addActionListener(this);
        add(allemployee);
        
        customers = new JButton("Customers Info");
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.BLACK);
        customers.addActionListener(this);
        customers.setForeground(Color.WHITE);
        add(customers);
        
        managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(10,230,200,30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        roomstatus = new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        
        
        setBounds(350,100,800,570);
        setVisible(true);
        
    }
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==newcustomer)
{
    setVisible(false);
    new AddCustomer();
}
else if(ae.getSource()==rooms)
{
    setVisible(false);
    new AllRooms();
}
else if(ae.getSource()== department)
{
setVisible(false);
new Departments();
}

else if (ae.getSource()== allemployee)
{
    setVisible(false);
    new EmployeeInfo();
}
else if(ae.getSource()== managerinfo)
{
    setVisible(false);
    new ManagerInfo();
}
else if (ae.getSource()== customers)
{
    setVisible(false);
    new CustomerInfo();
}
else if(ae.getSource()== searchRoom)
{
    setVisible(false);
    new SearchRoom();
}
else if(ae.getSource()== update)
{
    setVisible(false);
    new UpdateCheck();
}
else if(ae.getSource()== roomstatus)
{
    setVisible(false);
    new UpdateRoom();
}
else if(ae.getSource()== pickup)
{
    setVisible(false);
    new Pickup();
}
else if(ae.getSource()== checkout)
{
    setVisible(false);
    new Checkout();
}
else if(ae.getSource()== logout)
{
    setVisible(false);
    System.exit(0);
}

}
public static void main(String args[])
{
    
    new Reception();
}
}
