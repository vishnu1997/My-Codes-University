import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class frameDemo1 extends Frame implements ActionListener,ItemListener{
    String str;
    Checkbox c1,c2;
    TextField fd = new TextField(10);
    CheckboxGroup cbg = new CheckboxGroup();
    public frameDemo1(String s){
        super(s);
        setLayout(new FlowLayout());
        Button b1 = new Button("Red");
        Label b2 = new Label("amafggi");
        add(b2);
        add(b1);
         c1 = new Checkbox("hiii",false,cbg);
         c2 = new Checkbox("Maggi",false,cbg);
        add(c1);
        add(c2);
        add(fd);
        b1.addActionListener(this);
        c1.addItemListener(this);
        c2.addItemListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        str = ae.getActionCommand();
        if(str.equals("Red")){
            setBackground(Color.red);
        }}

    public void itemStateChanged(ItemEvent aa){
        Object ob = aa.getSource();
        if(ob==c1){
            fd.setText("First choice ");
        }else{
            fd.setText("Second choice ");            
        }
    }  
    

    public static void main(String args[]){
        frameDemo1 f = new frameDemo1("HIiiiii");
        f.setSize(300,300);
        f.setVisible(true);
    }
}