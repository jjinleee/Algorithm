import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);
            
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        List<Integer> list=new ArrayList<>();

        for(int i=1;i<=N;i++){
            if(N%i==0) list.add(i);
        }
        if(list.size()<K) System.out.println(0);
        else{
            System.out.println(list.get(K-1));
        }
    }
}
