import java.util.*;

class player{
    private int id;
    private double score;

    int getId(){ 
        return id;
    }
    void setId(int i){
        id = i;
    }

}


public class MyClass {
    public static void main(String args[]) {
        HashMap<String,Integer> hmap = new HashMap();
        hmap.put("v",2);
        hmap.put("vi",3);
        hmap.put("ui",4);
        hmap.put("it",3);
        hmap.put("aa",8);
        hmap.put("ab",9);
        hmap.put("ac",3);
        hmap.put("aa",3);
        hmap.put("ab",3);
        hmap.put("ac",4);
        hmap.put("a",4);
        hmap.put("b",4);
        hmap.put("c",3);
        
        TreeMap<String,Integer> tmap = new TreeMap();
        Integer c = hmap.get("Ui");
        for(Map.Entry<String,Integer> m:hmap.entrySet()){
            String s = m.getKey();
            int u = m.getValue();
            u++;
            System.out.println("Sum of x+y = " + s+"   "+u);
            tmap.put(s,u);
            
        }
        List<String> al = new ArrayList<String>();
        for(Map.Entry<String,Integer> m: tmap.entrySet()){
            String s = m.getKey();
            int u = m.getValue();
            u++;
            System.out.println(" = " + s+" ''''''  "+u);
            if(u==4||u==5){
                al.add(s);
            }
            
        }
        System.out.println("Sum of x+ = " + tmap.containsKey("ab"));
        System.out.println("Sum of +y = " + tmap.containsKey("abc"));
        //arrayList<String> al = new arrayList<String>();
        
        
        String a[] = new String[al.size()];
        int i = 0;
        for(String temp: al){
            String er = temp;
            System.out.println("Su   " + er);
            a[i] = er;
            i++;
        }
        for(int j =0;j<al.size();j++){
            System.out.println(a[j]);
        }
        al.remove(1);
        for(int j =0;j<al.size();j++){
            System.out.println("===="+a[j]);
        }
        
        System.out.println("Sum of +y = ");
    }
}
