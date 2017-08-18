import java.io.*;
import java.awt.*;
import java.awt.event.*;

class exe extends Frame implements ActionListener,ItemListener{
    Button b1;
    Choice c1;
    TextField t1;
    String s;
    exe(){super("excerixe");

        c1 = new Choice();
        c1.add("153");
        c1.add("7");
        c1.add("21");
        c1.add("5");
        c1.add("3");

        t1 = new TextField();
        b1 = new Button("CLEAR");
        add(c1);
        add(t1);
        add(b1);
        c1.addItemListener(this);
        b1.addActionListener(this);
         addWindowListener(new WindowAdapter(){
             public void windowClosing(WindowEvent ae){
        setVisible(false);
        System.exit(0);
    }});
    }
    public void ActionPerformed(ActionEvent ae){
        t1.setText("");
    }
    public void ItemStateChanged(ItemEvent ae){
         s = ae.getSelectedItem();
         int n = s.length();
         int i = Integer.parseInt(s);
         if(armstrong(i,n)){
             t1.setText("armstrong ");
         }
         else if(prime(i)){
             t1.setText("prime ");
         } 
    }

    boolean armstrong(int n,int i){

    }
    boolean prime(int n){

    }

   
}

public class ex1 {
    public static void main(String arg[]){
        exe f1 = new exe();
        exe.setVisible(true);
        exe.setSize(300,300);
    }
}