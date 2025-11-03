import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int[] rope=new int[n];

        for(int i=0;i<n;i++){
            rope[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        long max=0;

        for(int i=0;i<n;i++){
            long capacity=(long)rope[i] * (n-i);
            if(capacity>max) max=capacity;
        }
        System.out.println(max);
    }
}