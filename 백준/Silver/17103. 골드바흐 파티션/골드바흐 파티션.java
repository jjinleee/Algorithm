import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int n= Integer.parseInt(br.readLine());

        sieve(1000000);

        for(int i=0;i<n;i++){
            int num=Integer.parseInt(br.readLine());

            sb.append(count(num)).append('\n');
        }
        
        
        System.out.print(sb);
    }
    public static void sieve(int max){
        isPrime=new boolean[max+1];
        for(int i=2;i<=max;i++){
            isPrime[i]=true;
        }
        for(int i=2;i*i<=max;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=max;j+=i){
                    isPrime[j]=false;
                }
            }
        }
    }

    public static int count(int n) {
        int cnt=0;
        for(int a=2;a<=n/2;a++){
            int b=n-a;
            if(isPrime[a] && isPrime[b]) cnt++;
        }
        return cnt;
    }
}