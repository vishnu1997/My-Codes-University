import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class frameDemo1 extends Frame implements ActionListener{
    String str;
    public frameDemo1(String s){
        super(s);
        Button b1 = new Button("Red");
        Label b2 = new Label("amafggi");
        add(b2);
        add(b1);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        str = ae.getActionCommand();
        if(str.equals("Red")){
            setBackground(Color.red);
        }
    }

    public static void main(String args[]){
        frameDemo1 f = new frameDemo1("HIiiiii");
        f.setSize(300,300);
        f.setVisible(true);
    }
}