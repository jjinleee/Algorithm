import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        Set<Integer> cards= new HashSet<>();
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cards.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb= new StringBuilder();

        int m=Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int check=Integer.parseInt(st.nextToken());
            if(cards.contains(check))  sb.append("1"+" ");
            else sb.append("0"+" ");
        }

        System.out.println(sb.toString());
    }
}