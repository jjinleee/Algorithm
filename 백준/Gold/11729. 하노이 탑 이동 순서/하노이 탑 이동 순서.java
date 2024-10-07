import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static  int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        hanoi(n, 1, 3, 2);

        System.out.println(cnt);
        System.out.println(sb.toString());

    }

    public static void hanoi(int n,int start, int dest,int aid){
        if(n==1) {
            sb.append(start).append(" ").append(dest).append("\n");
            cnt++;
            return;
        }
        hanoi(n-1,start,aid,dest);
        sb.append(start).append(" ").append(dest).append("\n");
        cnt++;

        hanoi(n-1, aid, dest, start);

    }
}