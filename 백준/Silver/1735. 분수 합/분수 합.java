import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int a1=Integer.parseInt(st.nextToken());
        int b1=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int a2=Integer.parseInt(st.nextToken());
        int b2=Integer.parseInt(st.nextToken());
        
        int deno= b1*b2/gcd(b1,b2);
        int mul1=deno/b1;
        int mul2=deno/b2;

        int mole=a1*mul1+a2*mul2;

        int check=gcd(mole,deno);
        if(check>1){
            mole/=check;
            deno/=check;
        }
        System.out.println(mole+" "+deno);
        
    }

    public static int gcd(int a,int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
}