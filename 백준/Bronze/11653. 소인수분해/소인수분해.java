import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        
        int N=Integer.parseInt(br.readLine().trim());

        if(N==1) System.out.println();
    
        //루트N까지만 반복하도록 하여 시간줄임
        for(int i=2;i<=Math.sqrt(N);i++){
            while(N%i==0){
                System.out.println(i);
                N/=i;
            }
        }
        if(N!=1) System.out.println(N);
        
       
    }
}
