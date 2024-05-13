
package STUDENT_TEACHER_INFORMATION_MANAGEMENT;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

        
public class StudentManagement extends JFrame{
    
    Common common=new Common();
    
    private JLabel idLabel,nameLabel,departmentLabel,emailLabel,phoneLabel,sexLabel,dobLabel,addressLabel,searchBy;
    private JTextField idField,nameField,departmentField,emailField,phoneField,dobField,searchField;
    private JButton addButton,updateButton,deleteButton,displayButton,clearButton,searchButton,selectAll;
    private JComboBox sexOption,searchOption;
    private JTextArea addressArea;
    private String[] columns = {"ID","Name","Department","Email","Phone","Sex","DOB","Address"};
    private String[] row = new String[8];
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane addressScroll,tableScroll;
    
    public StudentManagement()
    {  
        createFrame();
        createLabels();
        createFields();
        createComboBox();
        createTextArea();
        createTable();
        createScrollPane();
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
    }
    private void createLabels()
    {
        Font f=common.getBoldItalicFont(16);
        
        int x=35,x1=95,y=15,k=44,y1=50;
        
        idLabel=new JLabel();
        idLabel.setText("ID");
        idLabel.setBounds(x,y,x1,y1);
        idLabel.setFont(f);
        
        nameLabel=new JLabel();
        nameLabel.setText("Name");
        nameLabel.setBounds(x,(y+k),x1,y1);
        nameLabel.setFont(f);
        
        departmentLabel=new JLabel();
        departmentLabel.setText("Department");
        departmentLabel.setBounds(x,(y+2*k),x1,y1);
        departmentLabel.setFont(f);
        
        emailLabel=new JLabel();
        emailLabel.setText("Email");
        emailLabel.setBounds(x,(y+3*k),x1,y1);
        emailLabel.setFont(f);
        
        phoneLabel=new JLabel();
        phoneLabel.setText("Phone");
        phoneLabel.setBounds(x,(y+4*k),x1,y1);
        phoneLabel.setFont(f);
        
        sexLabel=new JLabel();
        sexLabel.setText("Sex");
        sexLabel.setBounds(x,((y+5*k)+4),x1,y1);
        sexLabel.setFont(f);
        
        dobLabel=new JLabel();
        dobLabel.setText("D.O.B");
        dobLabel.setBounds(x,((y+6*k)+5),x1,y1);
        dobLabel.setFont(f);
        
        addressLabel=new JLabel();
        addressLabel.setText("Address");
        addressLabel.setBounds(x,((y+7*k)+10),x1,y1);
        addressLabel.setFont(f);
        
        searchBy=new JLabel();
        searchBy.setBounds(550,15,70,y1);
        searchBy.setText("Search By");
        searchBy.setFont(f);
        
    }
    private void createFields()
    {
        Font f=common.getItalicFont(14);
        
        int x=150,x1=250,y=25,k=45,y1=26;
        
        idField=new JTextField();
        idField.setBounds(x,y,x1,y1);
        idField.setFont(f);
        idField.setToolTipText("Enter student's id.");
        
        nameField=new JTextField();
        nameField.setBounds(x,(y+k),x1,y1);
        nameField.setFont(f);
        nameField.setToolTipText("Enter the student's name.");
        
        departmentField=new JTextField();
        departmentField.setBounds(x,(y+2*k),x1,y1);
        departmentField.setFont(f);
        departmentField.setToolTipText("Enter the department of the student.");
        
        
        emailField=new JTextField();
        emailField.setBounds(x,(y+3*k),x1,y1);
        emailField.setFont(f);
        emailField.setToolTipText("Enter the email id of the student");
        
        phoneField=new JTextField();
        phoneField.setBounds(x,(y+4*k),x1,y1);
        phoneField.setFont(f);
        phoneField.setToolTipText("Enter the phone number of the student");
        
        dobField=new JTextField();
        dobField.setBounds(x,(y+6*k),x1,y1);
        dobField.setFont(f);
        dobField.setToolTipText("Enter the date of birth of the student.");
        
        searchField=new JTextField();
        searchField.setBounds(840,25,220,y1);
        searchField.setFont(f);
        searchField.setToolTipText("You didn't choose any option to search.");
        
    }
    
    private void createComboBox()
    {
        String sex[]={"Male","Female"};
        sexOption=new JComboBox(sex);
        
        sexOption.setBounds(150,(25+5*45),250,26);
        sexOption.setFont(common.getItalicFont(14));
        sexOption.setBackground(Color.WHITE);
        sexOption.setToolTipText("Enter the sex of the student.");
        
        String search[]={"ID","Name","Mobile Number","Email"};
        searchOption=new JComboBox(search);
        
        searchOption.setBounds(645,25,175,26);
        searchOption.setFont(common.getItalicFont(14));
        searchOption.setBackground(Color.WHITE);
        searchOption.setToolTipText("Choose an option to search.");
    }
    
    private void createTextArea()
    {
        addressArea=new JTextArea();
        
        addressArea.setFont(common.getItalicFont(13));
        addressArea.setToolTipText("Enter the address of the student.");
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
    }
    private void createTable()
    {
        table=new JTable();
        model=new DefaultTableModel();
        
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setSelectionBackground(Color.MAGENTA);
        table.setBackground(Color.WHITE);
        table.setRowHeight(25);
    }
    
    private void createScrollPane()
    {
        addressScroll=new JScrollPane(addressArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        addressScroll.setBounds(150,(25+7*45),250,110);
        
        tableScroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tableScroll.setBounds(550,95,730,590);
    }
    
   private void createButtons()
    {
        Font f=common.getBoldItalicFont(16);
        
        int x=30,x1=200,y=475,k=45,y1=26;
        
        addButton=new JButton();
        addButton.setBounds(x,y,x1,y1);
        addButton.setText("ADD");
        addButton.setFont(f);
        addButton.setCursor(common.getCursor());
        //addButton.setBackground(Color.CYAN);
        //addButton.setForeground(Color.white);
        
        updateButton=new JButton();
        updateButton.setBounds(x,(y+k),x1,y1);
        updateButton.setText("UPDATE");
        updateButton.setFont(f);
        updateButton.setCursor(common.getCursor());
        //updateButton.setBackground(Color.CYAN);
        //updateButton.setForeground(Color.white);
        
        deleteButton=new JButton();
        deleteButton.setBounds(30,(y+2*k),x1,y1);
        deleteButton.setText("DELETE");
        deleteButton.setFont(f);
        deleteButton.setCursor(common.getCursor());
        //deleteButton.setBackground(Color.CYAN);
        //deleteButton.setForeground(Color.white);
        
        displayButton=new JButton();
        displayButton.setBounds(30,(y+3*k),x1,y1);
        displayButton.setText("DISPLAY");
        displayButton.setFont(f);
        displayButton.setCursor(common.getCursor());
        //displayButton.setBackground(Color.CYAN);
        //displayButton.setForeground(Color.white);
        
        clearButton=new JButton();
        clearButton.setBounds(30,(y+4*k),x1,y1);
        clearButton.setText("CLEAR");
        clearButton.setFont(f);
        clearButton.setCursor(common.getCursor());
        //clearButton.setBackground(Color.CYAN);
        //clearButton.setForeground(Color.white);
        
        int bx=1080,by=25,bx1=85,by1=26;
        
        searchButton=new JButton();
        searchButton.setBounds(bx,by,bx1,by1);
        searchButton.setText("Search");
        searchButton.setFont(common.getBoldItalicFont(16));
        searchButton.setCursor(common.getCursor());
        searchButton.setBackground(Color.RED);
        searchButton.setForeground(Color.WHITE);
        
        selectAll=new JButton();
        selectAll.setBounds((bx+bx1+20),by,(bx1+10),by1);
        selectAll.setText("Select All");
        selectAll.setFont(common.getBoldItalicFont(15));
        selectAll.setCursor(common.getCursor());
        selectAll.setBackground(Color.MAGENTA);
        selectAll.setForeground(Color.DARK_GRAY);
    }
    
    private void keepInsideContainer()
    {
        Container c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
        // Addition of All Labels With Container :
        c.add(idLabel);
        c.add(nameLabel);
        c.add(departmentLabel);
        c.add(emailLabel);
        c.add(phoneLabel);
        c.add(sexLabel);
        c.add(dobLabel);
        c.add(addressLabel);
        
        // Addition of All Fields With Container :
        c.add(idField);
        c.add(nameField);
        c.add(departmentField);
        c.add(emailField);
        c.add(phoneField);
        c.add(dobField);
        c.add(searchField);
        
        // Addtion of ComboBox of Sex with Container : 
        c.add(sexOption);
        c.add(searchOption);
        
        // Additon of All Buttons  with Container :
        c.add(addButton);
        c.add(updateButton);
        c.add(deleteButton);
        c.add(displayButton);
        c.add(clearButton);
        c.add(searchButton);
        c.add(selectAll);
        
        //c.add(panel);
        
        c.add(searchBy);
        
        // Additon of TextArea of Address with Container :
        c.add(addressScroll);
        
        // Additon of table with Container :
        c.add(tableScroll);
    }
    
    private void addAction()
    {
        ActionHandler action = new ActionHandler();
        
        // Fields Action : 
        idField.addActionListener(action);
        nameField.addActionListener(action);
        departmentField.addActionListener(action);
        emailField.addActionListener(action);
        phoneField.addActionListener(action);
        searchField.addActionListener(action);
        
        // ComboBox Action : 
        sexOption.addActionListener(action);
        searchOption.addActionListener(action);
        
        // Buttons Action :  
        addButton.addActionListener(action);
        updateButton.addActionListener(action);
        deleteButton.addActionListener(action);
        displayButton.addActionListener(action);
        clearButton.addActionListener(action);
        searchButton.addActionListener(action);
        selectAll.addActionListener(action);
        
        // Table Action : 
        table.addMouseListener(new MouseAdapter(){
      
          @Override
          public void mouseClicked(MouseEvent mouse)
          {
              int RowNum=table.getSelectedRow();
              String id,name,department,email,phone,sex,dob,address;
              
              id=model.getValueAt(RowNum,0).toString();
              name=model.getValueAt(RowNum, 1).toString();
              department=model.getValueAt(RowNum, 2).toString();
              email=model.getValueAt(RowNum, 3).toString();
              phone=model.getValueAt(RowNum, 4).toString();
              sex=model.getValueAt(RowNum, 5).toString();
              dob=model.getValueAt(RowNum, 6).toString();
              address=model.getValueAt(RowNum, 7).toString();
              
              //Set Founded Data Into Field :
              idField.setText(id);
              nameField.setText(name);
              departmentField.setText(department);
              emailField.setText(email);
              phoneField.setText(phone);
              if(sex.equals("Male"))
              {
                  sexOption.setSelectedIndex(0);
              }
              else
              {
                  sexOption.setSelectedIndex(1);
              }
              addressArea.setText(address);
          }
      });
    }
    
    class ActionHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            if(ev.getSource()==idField)
            {
                String id=idField.getText();
                if(id.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty information. Please enter the student's id.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "id : "+id);
                }
            }
            else if(ev.getSource()==nameField)
            {
                String s=nameField.getText();
                if(s.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty information. Please enter the teacher's name.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Name : "+s);
                }
            }
            else if(ev.getSource()==departmentField)
            {
                String s=departmentField.getText();
                if(s.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty information. Please enter the department of the teacher.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Department : "+s);
                }
            }
            else if(ev.getSource()==emailField)
            {
                String s=emailField.getText();
                if(s.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty information. Please enter enter the teacher's email.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Email : "+s);
                }
            }
            
            else if(ev.getSource()==phoneField)
            {
                String s=phoneField.getText();
                if(s.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty information. Please enter the phone number of the teacher.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Phone : "+s);
                }
            }
            else if(ev.getSource()==sexOption)
            {
                String sex=sexOption.getSelectedItem().toString();
            }
            else if(ev.getSource()==addButton)
            {
                row[0]=idField.getText();
                row[1]=nameField.getText();
                row[2]=departmentField.getText();
                row[3]=emailField.getText();
                row[4]=phoneField.getText();
                row[5]=sexOption.getSelectedItem().toString();
                row[6]=dobField.getText();
                row[7]=addressArea.getText();
                
                model.addRow(row);
                
                try 
                {
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    
                    String url,userName,password;
                    url="jdbc:mysql://localhost:3306/university";
                    userName="root";
                    password="";
                    
                    Connection connection = DriverManager.getConnection(url,userName,password);
                    Statement statement = connection.createStatement();
                    String query = "INSERT INTO student_baust(ID,Name,Department,Email,Phone,Sex,DOB,Address) VALUES('"+row[0]+"','"+row[1]+"','"+row[2]+"','"+row[3]+"','"+row[4]+"','"+row[5]+"','"+row[6]+"','"+row[7]+"')";
                    statement.executeUpdate(query);
                    
                    statement.close();
                    connection.close();
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else if(ev.getSource()==updateButton)
            {
                int RowNumber=-1;
                
                RowNumber=table.getSelectedRow();
                
                if(RowNumber==-1)
                {
                    JOptionPane.showMessageDialog(null,"You did not select any row. Please select one.");
                }
                else
                {
                    String id,name,department,email,phone,sex,dob,address;
                    
                    id=idField.getText();
                    name=nameField.getText();
                    department=departmentField.getText();
                    email=emailField.getText();
                    phone=phoneField.getText();
                    sex=sexOption.getSelectedItem().toString();
                    dob=dobField.getText();
                    address=addressArea.getText();

                    model.setValueAt(id,RowNumber,0);
                    model.setValueAt(name,RowNumber,1);
                    model.setValueAt(department,RowNumber,2);
                    model.setValueAt(email,RowNumber,3);
                    model.setValueAt(phone,RowNumber,4);
                    model.setValueAt(sex,RowNumber,5);
                    model.setValueAt(dob,RowNumber,6);
                    model.setValueAt(address,RowNumber,7);
                    
                    try 
                    {
                    
                        Class.forName("com.mysql.jdbc.Driver");

                        String url,userName,password;
                        url="jdbc:mysql://localhost:3306/university";
                        userName="root";
                        password="";
                        
                        Connection connection = DriverManager.getConnection(url,userName,password);
                        Statement statement = connection.createStatement();
                        String query = "UPDATE student_baust SET ID='"+id+"',Name='"+name+"',Department='"+department+"',Email='"+email+"',Phone='"+phone+"',Sex='"+sex+"',DOB='"+dob+"',Address='"+address+"' WHERE ID='"+id+"'";
                        statement.executeUpdate(query);
                        
                        statement.close();
                        connection.close();
                        
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else if(ev.getSource()==deleteButton)
            {
                int [] Rows = table.getSelectedRows();
                int n=table.getSelectedRowCount();
                if(n>0)
                {
                    for(int i=n-1;i>=0;i--)
                    {
                        model.removeRow(Rows[i]); // The reverse order is used to avoid index shifting.
                    }
                    try 
                    {
                        
                        Class.forName("com.mysql.jdbc.Driver");
                        
                        String url,userName,password;
                        url="jdbc:mysql://127.0.0.1:3306/university?serverTimezone=UTC";
                        userName="root";
                        password="";
                        
                        Connection connection=DriverManager.getConnection(url,userName,password);
                        Statement statement=connection.createStatement();
                        
                        String id,query;
                        id=idField.getText();
                        query="DELETE FROM student_baust WHERE ID = '"+id+"'";
                        statement.executeUpdate(query);
                        statement.close();
                        connection.close();
                        
                    }catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Empty table or you did not select any row !");
                }
            }
            
            else if(ev.getSource()==displayButton)
            {
                try 
                {
                    
                    Class.forName("com.mysql.jdbc.Driver");

                    String url,userName,password;
                    url="jdbc:mysql://localhost:3306/university";
                    userName="root";
                    password="";

                    Statement statement;
                    Connection connection = DriverManager.getConnection(url,userName,password);
                    statement = connection.createStatement();
                    String query = "SELECT * FROM student_baust";
                    ResultSet result=statement.executeQuery(query);
                        
                    while(result.next())
                    {
                        row[0]=result.getString("ID");
                        row[1]=result.getString("Name");
                        row[2]=result.getString("Department");
                        row[3]=result.getString("Email");
                        row[4]=result.getString("Phone");
                        row[5]=result.getString("Sex");
                        row[6]=result.getString("DOB");
                        row[7]=result.getString("Address");
                            
                        model.addRow(row);
                    }
                    connection.close();
                    statement.close();   
                }catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(ev.getSource()==clearButton)
            {
                idField.setText("");
                nameField.setText("");
                departmentField.setText("");
                emailField.setText("");
                phoneField.setText("");
                dobField.setText("");
                addressArea.setText("");
                searchField.setText("");
            }
            
            else if(ev.getSource()==searchButton)
            {
                String option=searchOption.getSelectedItem().toString();
                searchField.setToolTipText("Enter The Student's "+option+".");
                
                try 
                {
                    
                    Class.forName("com.mysql.jdbc.Driver");

                    String url,userName,password;
                    url="jdbc:mysql://localhost:3306/university";
                    userName="root";
                    password="";

                    Connection connection = DriverManager.getConnection(url,userName,password);
                    Statement statement = connection.createStatement();
                    
                    String query="";
                    String searchingKey=searchField.getText();
                    
                    switch (option) {
                        case "ID":
                            query="SELECT * FROM student_baust WHERE ID='"+searchingKey+"'";
                            break;
                        case "Name":
                            query="SELECT * FROM student_baust WHERE Name='"+searchingKey+"'";
                            break;
                        case "Mobile Number":
                            query="SELECT * FROM student_baust WHERE Phone='"+searchingKey+"'";
                            break;
                        default:
                            query="SELECT * FROM student_baust WHERE Email='"+searchingKey+"'";
                            break;
                    }
                    
                    ResultSet result=statement.executeQuery(query);
                        
                    while(result.next())
                    {
                        row[0]=result.getString("ID");
                        row[1]=result.getString("Name");
                        row[2]=result.getString("Department");
                        row[3]=result.getString("Email");
                        row[4]=result.getString("Phone");
                        row[5]=result.getString("Sex");
                        row[6]=result.getString("DOB");
                        row[7]=result.getString("Address");
                            
                        model.addRow(row);
                    }
                    connection.close();
                    statement.close();  
                    
                }catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else if(ev.getSource()==searchOption)
            {
                String option=searchOption.getSelectedItem().toString();
                searchField.setToolTipText("Enter The Student's "+option+".");
            }
            
            else if(ev.getSource()==selectAll)
            {
                if(model.getRowCount()<=0)
                {
                    JOptionPane.showMessageDialog(null, "The Table Is Empty !");
                }
                else
                {
                    ListSelectionModel selectionModel = table.getSelectionModel();
                    selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    selectionModel.setSelectionInterval(0, table.getRowCount() - 1);
                }
            }
        }
    }  
    
    public static void main(String[] args) {
        
        StudentManagement obj = new StudentManagement();  
        
        obj.setVisible(true);
    } 
    
}
