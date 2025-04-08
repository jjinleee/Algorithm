import java.io.*;
import java.util.*;

public class Main { 
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int k=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        long[] len=new long[k];

        for(int i=0;i<k;i++){
            len[i]=Long.parseLong(br.readLine());
        }
        Arrays.sort(len);
        
        long left=1;
        long right=len[k-1];
        long result=0;

        while(left<=right){
            long mid=(left+right)/2;

            long cnt=0;
            for(long l:len){
                cnt+=l/mid;
            }

            if(cnt>=n){
                result=mid;
                left=mid+1;
            } else{
                right=mid-1;
            }
        }

        System.out.println(result);
    }
}