import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class frameDemo1 extends Frame implements ActionListener,ItemListener,TextListener{
    String str;
    Checkbox c1,c2;
    int  v = 1;
    TextField fd = new TextField(10);
    TextField t1,t2,t3;
    CheckboxGroup cbg = new CheckboxGroup();
    public frameDemo1(String s){
        super(s);
        //setLayout(new FlowLayout());
        //FlowLayout f1  = new FlowLayout();
        Panel p1 = new Panel(new FlowLayout());
        //Panel p2 = new Panel();
        Panel p2 = new Panel(new BorderLayout());
         t1 = new TextField(20);
        p2.add(t1);
        add(p2,BorderLayout.NORTH);
        Button b1 = new Button("Red");
        Label b2 = new Label("amafggi");
         t2 = new TextField(20);
        p1.add(b2);
        p1.add(b1);
        p1.add(t2);
         c1 = new Checkbox("hiii",false,cbg);
         c2 = new Checkbox("Maggi",true,cbg);
          t3 = new TextField(20);
        p1.add(c1);
        p1.add(c2);
        p1.add(fd);
        p1.add(t3);
        t2.addTextListener(this);
        t3.addTextListener(this);
        b1.addActionListener(this);
        c1.addItemListener(this);
        c2.addItemListener(this);
        add(p1,BorderLayout.CENTER);
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ae){
                setVisible(false);
                System.exit(0);
            }
        });
        t1.addTextListener(this);
        addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent ae){
                t2.setText("Key Pressed");
            }
        });
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent ae){
                setBackground(Color.pink);
            }
        });

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
        }else if(ob==c2){
            fd.setText("Second choice ");            
        }else{setBackground(Color.red);}
    }  
    public void textValueChanged(TextEvent ae){
        TextField ft =(TextField) ae.getSource();
        if(ft==t1){
        setBackground(new Color(v*8,v*1,v*13));
        v +=1;}else if(ft==t2){
            setBackground(Color.blue);}
            else{setBackground(Color.red);}
    }
    

    public static void main(String args[]){
        frameDemo1 f = new frameDemo1("HIiiiii");
        f.setSize(400,400);
        f.setVisible(true);
    }
}