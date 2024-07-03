import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        
        int M=Integer.parseInt(br.readLine().trim());
        int N=Integer.parseInt(br.readLine().trim());
        int sum=0;
    
        List<Integer> list=new ArrayList<>();

        for(int i=M;i<=N;i++){
            int cnt=0;
            for(int j=1;j<=i;j++){
                if(i%j==0) cnt++;
            }
            if(cnt==2) {
                list.add(i);
                sum+=i;
            }
        }

        if(list.size()==0) {
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(list.get(0));
        }
        
    }
}
