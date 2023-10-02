import java.io.*;
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();


        for(int i=0;i<T;i++){
            int R=sc.nextInt();
            String S=sc.next();
            
            String P="";
            String[] arr=S.split("");
            for(int j=0;j<arr.length;j++){
                P+=arr[j].repeat(R);
            }
            System.out.println(P);
        }
    }
}

