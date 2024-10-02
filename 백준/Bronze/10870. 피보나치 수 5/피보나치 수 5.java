import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        

        int answer=fibo(n);
        System.out.println(answer);
        
    }
    public static int fibo(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fibo(n-1)+fibo(n-2);

    }
}