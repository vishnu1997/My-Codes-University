import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class layout extends Frame implements ActionListener{

    String str="yooooo";
    Button b1 = new Button("Maggi");
    Button b2 = new Button("Samosa");
    Button b3 = new Button("Nestley");   
    GridLayout g1 = new GridLayout(2,2);    
    layout(String s) {
        super(s);
        add(b1,BorderLayout.EAST);
        add(b2,BorderLayout.NORTH);
        add(b3,BorderLayout.WEST);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        MenuBar mb = new MenuBar();
        setMenuBar(mb);

        Menu m1 = new Menu("Colors");
        mb.add(m1);

        MenuItem mi1 = new MenuItem("Red");
        MenuItem mi2 = new MenuItem("Blue");
        MenuItem mi3 = new MenuItem("Yellow");
        m1.add(mi1);
        m1.addSeparator();   
        m1.add(mi2);
        m1.addSeparator();
        m1.add(mi3);
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);  

        setForeground(Color.orange); 

        setLayout(g1); 
    }

    public static void main(String arg[]){
        layout l1 = new layout("Layouts");
        l1.setSize(300,300);
        l1.setVisible(true);
    }

    public void paint(Graphics g){
        if(str.equals("Red")){
            setBackground(Color.red);
        }else if(str.equals("Blue")){
            setBackground(Color.blue);
        }else if(str.equals("Yellow")){
            setBackground(Color.yellow);
            
        }else{
        g.drawString(str,150,150);}
    }
    public void actionPerformed(ActionEvent ae){
        str = ae.getActionCommand();
        setBackground(Color.green);
        repaint();
    }
}