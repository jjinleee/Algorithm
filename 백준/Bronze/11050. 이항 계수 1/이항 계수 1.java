import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        //입력받기 
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int mul=1;
        int div=1;
        int answer=1;

        for(int i=0;i<M;i++){
            if(M==0) break;
            mul*=(N-i);
            div*=(M-i);
        }

        answer=mul/div;

        System.out.println(answer);
    }
}