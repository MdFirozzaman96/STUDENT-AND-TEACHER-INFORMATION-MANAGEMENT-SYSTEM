
package STUDENT_TEACHER_INFORMATION_MANAGEMENT;

import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;


public class Common{
    
    
    public Font getPlainFont(int size)
    {
        Font f=new Font("Arial",Font.PLAIN,size);
        return f;
    }
    public Font getBoldFont(int size)
    {
        Font f=new Font("Arial",Font.BOLD,size);
        return f;
    }
    public Font getBoldTimesNewRoman(int size)
    {
        Font f=new Font("Times New Roman",Font.BOLD,size);
        return f;
    }
    public Font getBoldItalicFont(int size)
    {
        Font f=new Font("Times New Roman",Font.BOLD+Font.ITALIC,size);
        return f;
    }
    public Font getItalicFont(int size)
    {
        Font f=new Font("Arial",Font.ITALIC,size);
        return f;
    }
    public ImageIcon frameIcon(String path)
    {
        ImageIcon icon=new ImageIcon(getClass().getResource(path));
        return icon;
    }
    
    public ImageIcon getIcon(String path)
    {
        ImageIcon icon=new ImageIcon(getClass().getResource(path));
        return icon;
    }
    public Cursor getCursor()
    {
        Cursor c=new Cursor(Cursor.HAND_CURSOR);
        return c;
    }
    
}
