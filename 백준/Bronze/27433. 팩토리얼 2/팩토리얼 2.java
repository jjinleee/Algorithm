import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());

        long answer=fact(n);
        System.out.println(answer);
        
    }
    public static long fact(int n){
        if(n==0 || n==1) return 1;
        else{
            return n*fact(n-1);
        }

    }
}