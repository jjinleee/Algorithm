import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //창문이 열려있다=바뀐 횟수가 홀수다=배수가 홀수다=완전제곱수다
        //즉 N이하의 완전제곱수 개수를 세면 된다

        long N=Long.parseLong(br.readLine());
        long result=(long)Math.sqrt(N);

        
        System.out.println(result);
    }
}