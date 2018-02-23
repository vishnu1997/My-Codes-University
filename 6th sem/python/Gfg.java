import javclass Gfg
    {
    // constructor
    Gfg()
    {
        System.out.println("ictas");
    }
     
    static Gfg a = new Gfg(); //line 1
 
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int i=s.nextInt();
        String s1=s.next();
        System.out.println(s1+" "+i);
     }
   }