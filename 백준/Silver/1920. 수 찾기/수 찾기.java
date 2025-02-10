import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
       
        int[] nums= new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        StringBuilder sb= new StringBuilder();

        int m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        
        for(int i=0;i<m;i++){
            int num=Integer.parseInt(st.nextToken());
            if(binarySearch(nums, num)>=0) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb.toString());
    }   
    private static int binarySearch(int[] arr, int target){
        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target) return 0;
            else if(target<arr[mid]) right=mid-1;
            else left=mid+1;
        }
        return -1;
    }
}