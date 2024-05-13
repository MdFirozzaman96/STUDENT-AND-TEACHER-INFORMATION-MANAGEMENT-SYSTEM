
package STUDENT_TEACHER_INFORMATION_MANAGEMENT;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LogIn extends JFrame{
 
    private JLabel userNameLabel,passwordLabel,title;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton clear,login;
    
    Common common=new Common();
    
    public LogIn()
    {
        createFrame();
        clearIcon();
        loginIcon();
        createLabel();
        createTextField();
        createButton();
        
        putToContainer();
        addAction();
    }
    
    
    private void createFrame()
    {
        this.setSize(1320,700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Log In");
        this.setIconImage(common.frameIcon("Md_Firozzaman.png").getImage());
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        JPanel panel = new JPanel() {
                           
            @Override   
            protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = common.getIcon("baust2.jpg");
            Image image = imageIcon.getImage();
            g.drawImage(image,0,0,getWidth(),getHeight(), this);
        }
    };
        this.setContentPane(panel);
        //this.setVisible(true);
        
    }
    
    private ImageIcon clearIcon()
    {
        ImageIcon img=new ImageIcon(getClass().getResource("clear.jpg"));
        return img;
    }
    private ImageIcon loginIcon()
    {
        ImageIcon img=new ImageIcon(getClass().getResource("login.png"));
        return img;
    }
    
    private void createLabel()
    {
        Font f=common.getBoldItalicFont(21);
        
        int x=660,y=220,k=60,x1=200,y1=50;
        
        userNameLabel=new JLabel("Enter your user name");
        userNameLabel.setBounds(x,y,x1,y1);
        userNameLabel.setFont(f);
        userNameLabel.setForeground(Color.BLACK);
        
        passwordLabel=new JLabel("Enter your password");
        passwordLabel.setBounds(x,(y+k),x1,y1);
        passwordLabel.setFont(f);
        passwordLabel.setForeground(Color.BLACK);
        
        title=new JLabel();
        title.setBounds(160,20,1000,50);
        title.setFont(common.getBoldTimesNewRoman(28));
        title.setText("STUDENT AND TEACHER INFORMATION MANAGEMENT SYSTEM");
        title.setForeground(Color.DARK_GRAY);
    }
    private void createTextField()
    {
        
        int x=870,y=230,k=60,x1=310,y1=28;
        Font f=common.getItalicFont(16);
        
        nameField=new JTextField();
        nameField.setBounds(x,y,x1,y1);
        nameField.setFont(f);
        nameField.setForeground(Color.BLACK);
        nameField.setToolTipText("Username");
        
        passwordField=new JPasswordField();
        passwordField.setBounds(x,(y+k),x1,y1);
        passwordField.setFont(f);
        passwordField.setForeground(Color.BLACK);
        passwordField.setEchoChar('*');
        passwordField.setToolTipText("Password");
    }
  
    private void createButton()
    {
        int x=1105,k=100,y=350,x1=75,y1=28;
        
        login=new JButton();
        login.setBounds(x,y,x1,y1);
        login.setIcon(loginIcon());
        login.setCursor(common.getCursor());
        
        clear=new JButton();
        clear.setBounds((x-k),y,x1,y1);
        clear.setIcon(clearIcon());
        clear.setCursor(common.getCursor());
    }
    private void putToContainer()
    {
        Container c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
        // Add Label :
        c.add(title);
        c.add(userNameLabel);
        c.add(passwordLabel);
        c.add(nameField);
        c.add(passwordField);
        
        // Add Buttons :
        c.add(clear);
        c.add(login);
    }
    
    private void addAction()
    {
        ActionHandler action=new ActionHandler();
        
        clear.addActionListener(action);
        login.addActionListener(action);
        passwordField.addActionListener(action);
    }
  
 
    class ActionHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource()==clear)
            {
                String str=nameField.getText();
                if(str.isEmpty()==true)
                {
                    JOptionPane.showMessageDialog(null, "You did not enter anythig.");
                }
                nameField.setText("");
                passwordField.setText("");
            }
            if(event.getSource()==passwordField)
            {
                String pass=passwordField.getText();
                JOptionPane.showMessageDialog(null,pass);
            }
            if(event.getSource()==login)
            {
                String userName,password;
                userName=nameField.getText();
                password=passwordField.getText();
                if(userName.equals("firoz96")&&password.equals("130"))
                {
                    JOptionPane.showMessageDialog(null,"Your are successfully loged in.");
                    
                    StudentTeacherOption option = new StudentTeacherOption();
                    option.setVisible(true);
                    //dispose(); 
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong passowrd or username !");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        LogIn obj = new LogIn();
        
        obj.setVisible(true);
    }
    
}
