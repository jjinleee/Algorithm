import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        boolean[] primes=new boolean[1000001];
        primes[0]=primes[1]=true;

        //수 입력받기
        for(int i=2;i*i<=1000000;i++){
            if(!primes[i]){
                for(int j=i+i;j<=1000000;j+=i){
                    primes[j]=true;
                }
            }
        }

        for(int i=0;i<n;i++){
            int temp=Integer.parseInt(br.readLine());
            int ans=0;
            for(int j=2;j<=temp/2;j++){
                if(!primes[j] && !primes[temp-j]) ans++;
            }
            System.out.println(ans);
        }


    }

   
}