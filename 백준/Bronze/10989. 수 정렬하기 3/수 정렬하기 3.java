import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine());

        int[] num=new int[N];

        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        for(int value:num){
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}