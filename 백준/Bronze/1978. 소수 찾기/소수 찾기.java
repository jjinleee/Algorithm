import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        int N=Integer.parseInt(br.readLine().trim());
        
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);

        List<Integer> list=new ArrayList<>();

        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int count=0;

        for(int num:list){
            int cnt=0;
           for(int i=1;i<=num;i++){
                if(num%i==0) cnt++;
           } 
           if(cnt==2) count++;
        }
        System.out.println(count);
        
    }
}
