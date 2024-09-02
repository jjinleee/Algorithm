import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums=new ArrayList<>();
        ArrayList<Integer> primes=new ArrayList<>();


        //수 입력받기
        while(true){
            String s=br.readLine();
            if(s.equals("0")) break;
            nums.add(Integer.parseInt(s));
        }


        for(int i=0;i<nums.size();i++){
            int count=0;
            for(int j=nums.get(i)+1;j<=2*nums.get(i);j++){
                if(isPrime(j)) count++;
            }
            primes.add(count);
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