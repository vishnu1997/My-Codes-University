import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;

public class appletDemo extends Applet implements ActionListener,TextListener{
    
    //new button source created.
    Button b1 = new Button("click me");
    //
    TextArea textarea1 = new TextArea("vishnu",10,10,1);
    String s = "new";
    public void init(){
        //text area added to the layout
        add(textarea1);
        //button added to the layout
        add(b1);
        //Listener added to the source
        b1.addActionListener(this);
        //Listener added to the textarea
        textarea1.addTextListener(this);
    }

  //paint method 
    public void paint(Graphics g){
        g.drawString(s,200,200);
        if(!s.equals("Text value changed")){
            setForeground(Color.cyan);
        }
        g.fillRoundRect(300, 300, 70, 70, 10, 10);
    }


    //implemented class with respect to action event
    public void actionPerformed(ActionEvent ae){
        s = ae.getActionCommand();  //gets the text associated with the button
        if(s.equals("click me")){
            repaint();
            showStatus("Action Performed");
        }
    }

    //implemented class with respect to text listener
    public void textValueChanged(TextEvent te){
        //s = textarea1.getText();
        s = "Text value changed";
        showStatus("Text value changed");
       setForeground(Color.green);
        repaint();
    }
}
