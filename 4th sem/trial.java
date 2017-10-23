import java.io.*;
import java.util.Scanner;

class maggi{

}

interface inter extends maggi
{
static int a = 10;
}

class input implements inter{
	public static void main(String a[]){
		Scanner sc = new Scanner(System.in);
		int i;
		double d;
		String c;
		System.out.println("sioasas"+a);
		c = sc.nextLine();
		i = sc.nextInt();
		d = sc.nextDouble();
		System.out.println("hiii");

		System.out.println(i);
		System.out.println(d);
		System.out.println(c);

	}

};
