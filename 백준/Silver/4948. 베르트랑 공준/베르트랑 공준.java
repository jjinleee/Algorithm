import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        while(true){
            int cnt=0;

            int n=Integer.parseInt(br.readLine());
            if(n==0) break;
            for(int i=n+1;i<=2*n;i++){
                if(isPrime(i)) cnt++;
            }

            sb.append(cnt).append('\n');
        }
        
        
        System.out.print(sb);
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }
}