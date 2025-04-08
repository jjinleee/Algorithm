import java.io.*;
import java.util.*;

public class Main { 
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[] tree=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            tree[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int left=1;
        int right=tree[n-1];
        long result=0;

        while(left<=right){
            int mid=(left+right)/2;

            long sum=0;
            for(int t:tree){
                if(t>mid)  sum+=t-mid;
            }

            if(sum>=m){
                result=mid; //조건을 만족하는 자를수있는 최대높이
                left=mid+1; //더 높은 높이도 가능한지 확인
            } else right=mid-1; //너무 많이 자름
        
        }

        System.out.println(result);
    }
}