import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        int[] div=new int[N];

        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            div[i]=Integer.parseInt(st.nextToken());
        }

        if(N==1) System.out.println(div[0]*div[0]);
        else{
            Arrays.sort(div);
    
            System.out.println(div[0]*div[N-1]);
        }
        
    }
}