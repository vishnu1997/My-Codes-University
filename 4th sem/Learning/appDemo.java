import java.io.*;
import java.applet.*;
import java.awt.*;

public class appDemo extends Applet{
  String msg=" ";
  //---------------------------------------init class
  public void init(){
    msg +="intiliasze";
    setBackground(Color.red);
    setForeground(Color.white);
  }

  //---------------------------------------start class
  public void start(){
    msg += "Started....";
  }

  //---------------------------------------paint class
  public void paint(Graphics g){
    g.drawString(msg,90,90);
  }
}
