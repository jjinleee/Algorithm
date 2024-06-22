import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
       Scanner sc=new Scanner(System.in);

       int n=sc.nextInt();
       int answer=1;
       int range=2;

     if(n==1) {
        answer=1;
    }else{
            while(range<=n){
                range+=answer*6;
                answer++;
            }
       }
       System.out.println(answer);
    }
}
