import java.io.*;
import java.awt.*;
import java.awt.event.*;

class nu extends Frame implements ActionListener{
    Button b1,b2;
    nu(){
        super("here");
        setLayout(null);
        b1 = new Button("no");
        b2 = new Button("yes");
        b1.setVisible(false);
        b1.setBounds(30,30,80,40);
        b2.setBounds(40,40,50,50);
        add(b1);
        add(b2);
        b2.addActionListener(this);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ae){
                setVisible(false);
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent ae){
        b1.setVisible(true);
    }
}
public class nut 
{
    public static void main(String ar[]){
        nu n = new nu();
        n.setVisible(true);
        n.setSize(300,300);
    }
}