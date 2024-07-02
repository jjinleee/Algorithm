import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));

        List<Integer> list=new ArrayList<>();

        while(true){
            String s=br.readLine();
            if(s.equals("-1")) break;
            list.add(Integer.parseInt(s));
        }
                    
       
        for(int num:list){
            int result=0;
            List<Integer> divisor=new ArrayList<>();
           for(int i=1;i<num;i++){
                if(num%i==0) {
                    divisor.add(i);
                    result+=i;
                }
           }
           if(num==result){
                System.out.print(num+" = ");
                for(int i=0;i<divisor.size();i++){
                    System.out.print(divisor.get(i));
                    if(i<divisor.size()-1){
                        System.out.print(" + ");
                    }
                }
                System.out.println();
           }else{
                System.out.println(num+" is NOT perfect.");
           }
        }
        
    }
}
