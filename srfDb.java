import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class SRF extends Frame implements ActionListener{

	Label l1,l2,l3,l4,L5,L6,L7,l8,l9,l10,l11,l12;
	TextField t1,t2,t3;
	
	Choice c1,c2,c3,c4,c5,c6;
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox cb1,cb2,cb3,cb4;
	Button b1,b2,b3,b4;
		
	TextArea ta1,ta2;
	List li1;
	
	String s;
	
	Connection conn;
	Statement st,tr;
	ResultSet rs1,rs2;
	PreparedStatement ps;
	
	SRF(){
		super("Student Response Form");
		
			
	
		setLayout(new FlowLayout());
		b1 = new Button("SUBMIT");
		
		l1 = new Label("Register No.");
		t1 = new TextField(10);
		
		l2 = new Label("Name");
		t2 = new TextField(10);
		
		l3 = new Label("Gender ");
		cb1 = new Checkbox("Male",true,cbg);
		cb2 = new Checkbox("Female",false,cbg);
	
		l4 = new Label("Degree");	
		c1 = new Choice();	
		c1.add("B.Tech");
		c1.add("M.Tech");
	
		L5 = new Label("Branch");
		c2 = new Choice();
		c2.add("CSE");
		c2.add("ICT");
		c2.add("IT");
		
		L6 = new Label("YeaR OF STUDY");
		c3 = new Choice();
		c3.add("1");
		c3.add("2");
		c3.add("3");
	
		L7 = new Label("Date of birth");
		c4 = new Choice();
		c4.add("1");
		c4.add("2");
		c4.add("3");
		
		c5 = new Choice();
		c5.add("jan");
		c5.add("feb");
		c5.add("mar");
	
		c6 = new Choice();
		c6.add("1996");
		c6.add("1997");
		c6.add("1998");

		l8 = new Label("Address");
		ta1 = new TextArea(2,10);
		
		l9 = new Label("Email-id");
		t3 = new TextField(10);

		l10 = new Label("Hobby");	
		cb3 = new Checkbox("Stamp Collection");			
		cb4 = new Checkbox("Reading Novels");

		l11 = new Label("Extra Cirricular");
		li1 = new List(3,true);
		li1.add("cricket");
		li1.add("chess");
		li1.add("maggi");
	
		l12 = new Label("YOUR entries");
		ta2 = new TextArea(10,19);
				
	
		
		add(l1);
		add(t1);			
		
		add(l2);
		add(t2);
		
		add(l3);
		add(cb1);
		add(cb2);

		add(l4);
		add(c1);
	
		add(L5);
		add(c2);

		add(L6);
		add(c3);

		add(L7);
		add(c4);
		add(c5);
		add(c6);

		add(l8);		
		add(ta1);

		add(l9);
		add(t3);

		add(l10);
		add(cb3);
		add(cb4);

		add(l11);
		add(li1);
		
		add(l12);
		add(ta2);

				
	

		add(b1);
		b1.addActionListener(this);

		//t2.setEditable(false);
		  addWindowListener(new WindowAdapter()
		{ public void windowClosing(WindowEvent e)
  		   { setVisible(false);
		     //dispose();
			 System.exit(0);
		   }
		});
		  dbConn();
		  b2 = new Button("Display");
		  add(b2);
		  b2.addActionListener(this);
		 
		  b3 = new Button("first");
		  add(b3);
		  b3.addActionListener(this);
		  
		  b4 = new Button("last");
		  add(b4);
		  b4.addActionListener(this);
		}

	void dbConn(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dbtrial1?autoReconnect=true&useSSL=false","root","vishnu");
			st = conn.createStatement();
			tr = conn.createStatement();
			//st.execute("create table srf (regno int,name char(20),gender char(10))");
			ps = conn.prepareStatement("insert into srf values (?,?,?);");
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	

	public void actionPerformed(ActionEvent ae){
		ta2.setText(null);
		if(ae.getSource()==b1){
			try{
				String at;
				//ta2.append("register no is"+t1.getText()+"\n");
				ps.setInt(1,Integer.parseInt(t1.getText()));
				//ta2.append("Name is"+t2.getText()+"\n");
				ps.setString(2,t2.getText());
				if(cb1.getState()){
					//ta2.append("Gender is"+cb1.getLabel()+"\n");
					ps.setString(3,cb1.getLabel());
				}else{
					//ta2.append("Gender is"+cb2.getLabel()+"\n");
					ps.setString(3,cb2.getLabel());
				}
				ps.executeUpdate();
				
				/*ta2.append("\nDegree enrolled is "+c1.getSelectedItem());
				ta2.append("\nBranch is"+c2.getSelectedItem());
		
				ta2.append(ta1.getText());
				String[] nt = li1.getSelectedItems();
				for(int j = 0;j<nt.length;j++){
					ta2.append("\n    "+nt[j]);
				}
				if(cb3.getState()){
					ta2.append("\n hobbies are"+cb3.getLabel());
				}*/
				//t2.setEditable(true);
			}catch(Exception e){System.out.println(e);}
		}
		
		if(ae.getSource()==b2){
			try{
				rs2 = st.executeQuery("select * from srf where regno ="+Integer.parseInt(t1.getText()));
				if(rs2.next()){
					ta2.append("Reg no is "+rs2.getInt(1)+"\n");
					ta2.append("Name is "+rs2.getString(2)+"\n");
					ta2.append("Gender is "+rs2.getString(3)+"\n");
				}
			}catch(Exception e){
				System.out.println("Maggi  "+e);
			}
		}
		if(ae.getSource()==b3){
			try{
				rs1 = tr.executeQuery("select * from srf");
				rs1.first();
				ta2.append("Reg no is "+rs1.getInt(1)+"\n");
				ta2.append("Name is "+rs1.getString(2)+"\n");
				ta2.append("Gender is "+rs1.getString(3)+"\n");
				
			}catch(Exception e){
				System.out.println("first "+e);
			}
		}
		if(ae.getSource()==b4){
			try{
				rs1 = tr.executeQuery("select * from srf");
				rs1.last();
				ta2.append("Reg no is "+rs1.getInt(1)+"\n");
				ta2.append("Name is "+rs1.getString(2)+"\n");
				ta2.append("Gender is "+rs1.getString(3)+"\n");
				
			}catch(Exception e){
				System.out.println("last "+e);
			}
		}
	}
}


public class srfDb {
	
	public static void main(String ar[]){
		SRF d = new SRF();
		d.setVisible(true);
		d.setSize(600,600);
	
	
	}
 
}