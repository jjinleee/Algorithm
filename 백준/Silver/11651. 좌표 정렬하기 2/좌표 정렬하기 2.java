import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] dot=new int[n][2];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            dot[i][0]=Integer.parseInt(st.nextToken());
            dot[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dot, (a,b)->(a[1]==b[1]? a[0]-b[0]:a[1]-b[1]));

        StringBuilder sb= new StringBuilder();
        for(int[] p:dot){
            sb.append(p[0]+" "+p[1]+"\n");
        }

        System.out.println(sb.toString());
    }
}