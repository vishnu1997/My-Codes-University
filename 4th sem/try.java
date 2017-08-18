
import java.io.*;
import java.util.*;

class student{
	int rno;
	String name;
	student(String n,int r){
		rno = r;
		name = n;
	}
	public String toString(){
		return name;
	}
}

class trr implements Comparator<student>{
	public int compare(student s1,student s2){
		if(s1.rno>s2.rno){return 1;}else if(s1.rno<s2.rno){return -1;}else{return 0;}
	}
	public static void main(String args[]){
		student s1 = new student("maggi",12);
		student s2 = new student("wegi",14);
		student s3 = new student("ioni",10);

		ArrayList plist = new ArrayList<student>();
		plist.add(s1);
		plist.add(s2);
		plist.add(s3);
		System.out.println(plist);
		trr q = new trr();
		Collections.sort(plist,q);
		System.out.println(plist);

		ListIterator<student> it = plist.listIterator();
		while(it.hasNext()){
			student s = it.next();
			System.out.println(s);
		}
	}
}