import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int m=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());

        ArrayList<Integer> primes=new ArrayList<>();

    
        //m이상 n이하
        for(int i=m;i<=n;i++){
            if(isPrime(i)){
                    primes.add(i);
            }
        }
        

        //소수 출력
        for(long p:primes){
            System.out.println(p);
        }

    }

    //소수 판별 함수->런타임에러발생 
    public static boolean isPrime(long n){
        if(n<=1) return false;
        if (n == 2) return true; // 2는 소수
        if (n % 2 == 0) return false; // 2를 제외한 짝수는 소수가 아님
        for (long i = 3; i * i <= n; i += 2) { // 홀수만 검사
            if (n % i == 0) return false;
        }
        return true;
    }
}