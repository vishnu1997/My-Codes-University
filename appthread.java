import java.io.*;
import java.util.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*<applet code=appthread width=300 height=300></applet>*/
public class appthread extends Applet implements ActionListener,Runnable{
    TextField t1,t2;
    Button b1,b2,b3;
    Thread t;
    boolean rt;
    int a,b;

    public void init(){
        t1 = new TextField(10);
        t2 = new TextField(10);
        b1 = new Button("start");
        b2 = new Button("stop");
       // b3 = new Button("create");
        add(t1);
        add(b1);
        add(t2);
        add(b2);
        a=0;
        b=0;
        rt=true;
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
          //  add(b3);
            //remove(b2);
             t = new Thread(this,"start");
            t.start();
            //validate();
        }
        if(ae.getSource()==b2){
            t.stop();
        }

    }
    public void paint(Graphics g){

    }
    public void run(){
        while(true){
            try{
        if(rt){
            a++;
            rt=false;
            t1.setText(""+a);
            Thread.sleep(600);
        }else{
            a++;
            t2.setText(""+a);
            rt=true;
            Thread.sleep(600);
        }}catch(Exception e){
            System.out.println(" error "+e);
        }
    }
  }
}