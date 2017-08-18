import java.io.*;
import java.awt.*;
import java.applet.*;


public class exe7_pre extends Applet{
	
	public void paint(Graphics g){
		int x[] = {360,340,400,440,480};
		int y[] = {330,380,400,460,370};
	
		g.drawRect(5,5,30,30);
		g.drawRect(45,45,50,40);
		g.drawOval(130,130,30,30);
		g.drawOval(210,210,50,30);
		g.drawPolygon(x,y,5);
		
		int y1[] = {250,280,310,340,380};
		setForeground(Color.red);
		g.fillRect(5,40,30,30);
		g.fillRect(45,85,50,40);
		g.fillOval(130,170,30,30);
		g.fillOval(210,250,50,30);
		g.fillPolygon(x,y1,5);
			

	}
}