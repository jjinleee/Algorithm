import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
       Scanner sc=new Scanner(System.in);

       int step=1;
       int n=1;
        
       int num=sc.nextInt();

       while(n<num){
            step++;
            n+=step;
       }
    
       n-=step;
       int order=num-n;
       if(step%2==0){
        System.out.println(order+"/"+(step-order+1));
       } else{
        System.out.println(step-order+1+"/"+order);
       }
    }
}
