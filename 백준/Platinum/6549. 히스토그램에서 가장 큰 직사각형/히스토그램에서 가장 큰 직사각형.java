import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        while(true){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n= Integer.parseInt(st.nextToken());

            if(n==0) break;

            int[] hist=new int[n];
            for(int i=0;i<n;i++){
                hist[i]=Integer.parseInt(st.nextToken());
            }

            sb.append(getMaxArea(hist)+"\n");
        }
        System.out.println(sb);
    } 

    public static long getMaxArea(int[] hist){
        Stack<Integer> stack=new Stack<>();
        long maxArea=0;
        int n=hist.length;

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && hist[stack.peek()]> hist[i]){
                int h=hist[stack.pop()];
                int width=stack.isEmpty() ? i: (i-stack.peek()-1);
                maxArea=Math.max(maxArea, (long) h*width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int h=hist[stack.pop()];
            int width=stack.isEmpty() ? n: (n-stack.peek()-1);
            maxArea=Math.max(maxArea, (long) h*width);
        }
        return maxArea;
    }
    
}