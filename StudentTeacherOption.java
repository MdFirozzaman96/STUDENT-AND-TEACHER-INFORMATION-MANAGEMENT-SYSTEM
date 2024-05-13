
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
import javax.swing.JPanel;


public class StudentTeacherOption extends JFrame{
    
    Common common=new Common();
    
    private JLabel title;
    private JButton studentManagement,teacherManagement;
    
    public StudentTeacherOption()
    {  
        createFrame();
        createLabels();
        createButtons();
        
        keepInsideContainer();
        
        addAction();
    }
    private void createFrame()
    {
        this.setSize(1320,750);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("MD.FIROZZAMAN_180201130");
        this.setIconImage(common.frameIcon("Md_Firozzaman.png").getImage());
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel() {
                           
            @Override   
            protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = common.getIcon("baust1.jpg");
            Image image = imageIcon.getImage();
            g.drawImage(image, 0, 0, getWidth(),getHeight(), this);
        }
    };
        this.setContentPane(panel);
    }
    private void createLabels()
    {
        Font f = common.getBoldTimesNewRoman(28);
        
        title=new JLabel();
        title.setBounds(160,20,1000,50);
        title.setFont(f);
        title.setText("STUDENT AND TEACHER INFORMATION MANAGEMENT SYSTEM");
        title.setForeground(Color.DARK_GRAY);
    }
    private void createButtons()
    {
        Font f = common.getBoldFont(15);
        
        int x=420,y=270,k=80,x1=450,y1=28;
        
        studentManagement = new JButton("STUDENT  INFORMATION  MANAGEMENT");
        studentManagement.setBounds(x,y,x1,y1);
        studentManagement.setFont(f);
        studentManagement.setCursor(common.getCursor());
        
        teacherManagement = new JButton("TEACHER  INFORMATION  MANAGEMENT");
        teacherManagement.setBounds(x,(y+k),x1,y1);
        teacherManagement.setFont(f);
        teacherManagement.setCursor(common.getCursor());
    }
    private void keepInsideContainer()
    {
        Container c = this.getContentPane();
        
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
        // Add Labels :
        c.add(title);
        
        /// Add Buttons : 
        c.add(studentManagement);
        c.add(teacherManagement);
    }
    private void addAction()
    {
        ActionHandler action = new ActionHandler();
        
        studentManagement.addActionListener(action);
        teacherManagement.addActionListener(action);
    }
    
    class ActionHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ev) {
            
            if(ev.getSource()==studentManagement)
            {
                StudentManagement option = new StudentManagement();
                option.setVisible(true);
            }
            else if(ev.getSource()==teacherManagement)
            {
                TeacherManagement option = new TeacherManagement();
                option.setVisible(true);
            }
        }
    }
    public static void main(String[] args) {
        
        StudentTeacherOption obj = new StudentTeacherOption();
        obj.setVisible(true);
    }
    
}
