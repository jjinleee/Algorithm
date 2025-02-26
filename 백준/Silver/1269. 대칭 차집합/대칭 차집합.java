import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        Set<Integer> a=new HashSet<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            a.add(num);
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int num=Integer.parseInt(st.nextToken());
            if(a.contains(num)) a.remove(num);
            else a.add(num);
        }


        System.out.println(a.size());
    }
}