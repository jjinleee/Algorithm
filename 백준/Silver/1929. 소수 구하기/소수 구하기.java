import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int m=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        
        StringBuilder sb= new StringBuilder();

        for(int i=m;i<=n;i++){
            if(isPrime(i)) sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean isPrime(int i){
        if(i<2) return false;
        if(i==2) return true;
        if(i%2==0) return false;
        
        for(int j=3;j<=Math.sqrt(i);j++){
            if(i%j==0) return false;
        }
        
        return true;
    }
}