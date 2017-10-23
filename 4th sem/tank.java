import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*<APPLET code=tank width=500 height=500></APPLET>*/


public class tank extends Applet implements ActionListener,Runnable{
	
	
	int height;
	boolean suspendflag,stopflag;
	Button Start,Stop,Resume,Suspend;
	Thread t;

	public void init(){
		Start = new Button("Start");
		Stop = new Button("Stop");
		Resume = new Button("Resume");
		Suspend = new Button("Suspend");	
	
		Start.addActionListener(this);
		Stop.addActionListener(this);
		Resume.addActionListener(this);
		Suspend.addActionListener(this);
		
		setLayout(new BorderLayout());
		
		Panel p1 = new Panel();

		p1.add(Start);
		p1.add(Stop);
		p1.add(Suspend);
		p1.add(Resume);
	
		add(p1,BorderLayout.SOUTH);	
		
		height = 0;		
		
		}
	
	public void paint(Graphics g){
		g.drawLine(100,100,100,300);
		g.drawLine(100,300,300,300);
		g.drawLine(300,300,300,100);
	
		g.setColor(Color.BLUE);
		g.fillRect(100,300-height,200,height);	
		
		
	}
		
	
	synchronized public void reume(){
        suspendflag = false;
		notifyAll();
		
	}

	public void actionPerformed(ActionEvent ae){
		Object o = ae.getSource();
		
		if(o==Start){
			t = new Thread(this,"maggi");
			suspendflag = false;
			stopflag = false;
			t.start();
		}
		if(o==Stop){
			stopflag=true;
			height = 0;
		}
		if(o==Resume){
			reume();

		}
		if(o==Suspend){
			suspendflag=true;
		}

		
		
	}

	synchronized public void run(){
		setForeground(Color.red);
		try{		
			while(!stopflag){
				if(suspendflag){wait();}
				if(height>200){height=0;}
				height+=10;
				Thread.sleep(400);
				repaint();	
			}		
		}catch(Exception e){}	

	}
	
	

}