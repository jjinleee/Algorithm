import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        long a=Integer.parseInt(st.nextToken());
        long b=Integer.parseInt(st.nextToken());
        long c=Integer.parseInt(st.nextToken());

        System.out.println(pow(a,b,c));
    }
    public static long pow(long base, long exp, long mod){
        if(exp==0) return 1;
        long half=pow(base, exp/2, mod)%mod;

        if(exp%2==0) return (half*half) % mod;
        else return ((half*half)%mod* (base%mod))%mod;
    }
}