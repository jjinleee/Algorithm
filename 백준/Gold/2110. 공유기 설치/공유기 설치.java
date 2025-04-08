import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());

        int[] home=new int[n];
        for(int i=0;i<n;i++){
            home[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int left=1;
        int right=home[n-1]-home[0];
        int result=0;

        while(left<=right){
            int mid=(left+right)/2;

            if(install(home,mid,c)){
                result=mid;
                left=mid+1;
            } else right=mid-1;
        }

        System.out.println(result);
    }
    static boolean install(int[] home, int distance, int c){
        int cnt=1;
        int last=home[0];

        for(int i=1;i<home.length;i++){
            if(home[i]-last>=distance){
                cnt++;
                last=home[i];
            }
        }
        return cnt>=c;
    }
}