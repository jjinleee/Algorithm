import java.io.*;
import java.util.*;

public class Main {
    static int cnt1=0;
    static int cnt2=0;
    static int[] f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        f=new int[n+1];

        fib(n);
        fibonacci(n);

    
        System.out.println(cnt1+" "+cnt2);
       
    }
    static int fib(int n){
        if(n==1 || n==2) {
            cnt1++;
            return 1;
        }
        else return (fib(n-1)+fib(n-2));
    }

    static int fibonacci(int n){
        f[1]=f[2]=1;
        for(int i=3;i<=n;i++){
            f[i]=f[i-1]+f[i-2];
            cnt2++;
        }
        return f[n];
    }
}