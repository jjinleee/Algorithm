import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); 

        int[] coin=new int[n];
        for(int i=0;i<n;i++){
            coin[i]=Integer.parseInt(br.readLine());
        }

        int cnt=0;
        for(int i=n-1;i>=0;i--){
            if(k==0) break;

            int current=coin[i];
            if(k>=current){
                cnt+=k/current;
                k%=current;
            }
        }

        System.out.println(cnt);
    }
}