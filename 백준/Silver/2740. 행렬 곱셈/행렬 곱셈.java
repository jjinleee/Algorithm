import java.io.*;
import java.util.*;


public class Main { 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] a=new int[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                a[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[][] b=new int[m][k];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<k;j++){
                b[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int[][] result=new int[n][k];

        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                int sum=0;
                for(int t=0;t<m;t++){
                    sum+=a[i][t]*b[t][j];
                }
                result[i][j]=sum;
            }
        }
    
        StringBuilder sb= new StringBuilder();
        for(int[] r: result){
            for(int num:r){
                sb.append(num).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
        
    }
}