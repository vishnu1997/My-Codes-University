import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*<applet code = line width=300 height=300></applet>*/
public class line extends Applet implements MouseListener{
    int x,y,a,b;
    boolean first = true;
    boolean ft = true;
   public void init(){//super("line maker");
        addMouseListener(this);
    }
    public void mouseClicked(MouseEvent ae){
      if(first&&ft){
         x = ae.getX();
        y = ae.getY();
        
        first = false;
      }else{
          a = ae.getX();
          b = ae.getY();
          ft = false;
      }
      repaint();

    }
      public void mousePressed(MouseEvent ae){
    }
      public void mouseReleased(MouseEvent ae){
    }
  public void mouseEntered(MouseEvent ae){}
  public void mouseExited(MouseEvent ae){
    }
    public void paint(Graphics g){
        setBackground(Color.blue);
        setForeground(Color.red);
        if(first||ft){
            g.drawString("Select Minimum two points",50,50);
        }else{ft=false;
            //first=true;
            
            g.drawLine(x,y,a,b);
            x=a;
            y=b;
        }
    }
}
