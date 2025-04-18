import java.io.*;
import java.util.*;


public class Main { 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        int[] result=new int[n];
        Stack<Integer> stack=new Stack<>();

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                result[stack.pop()]=arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()]=-1;
        }
        

        StringBuilder sb= new StringBuilder();
        for(int r : result){
            sb.append(r).append(' ');
        }

        System.out.println(sb);
    }
}