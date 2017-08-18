import java.awt.*;
import java.awt.event.*;

public class menusDemo extends Frame implements ActionListener{
    String str;
    menusDemo(String s){
        super(s);
        MenuBar mb = new MenuBar();
        
        setMenuBar(mb);
        str = "r";
        Menu m1 = new Menu("colors");
        Menu m2 = new Menu("submenu");
        mb.add(m1);
        
        MenuItem mi1 = new MenuItem("red");
        MenuItem mi2 = new MenuItem("yellow");
        MenuItem mi3 = new MenuItem("blue");

        m1.add(mi1);
        m2.add(mi2);
        m2.add(mi3);
        m1.addSeparator();
        m1.add(m2);
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent ae){
        str = ae.getActionCommand();
        repaint();
        
    }
    
    public void windowClosing(){
        System.exit(0);
    }

    public void paint(Graphics g){
        if(str.equals("red"))
            setBackground(Color.red);
            else{
            setBackground(Color.red);
            setForeground(Color.blue);
            g.drawString(str,50,50);
            }
        if(str.equals("yellow"))
            setBackground(Color.yellow);
             else{
                
            }
        if(str.equals("blue"))
            setBackground(Color.blue);   
             else{
                
            } 

    }

    public static void main(String ar[]){
        menusDemo m = new menusDemo("MENU");
        m.setVisible(true);
        m.setSize(400,400);
    }
}