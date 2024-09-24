import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //입력받기 
        int N=Integer.parseInt(br.readLine());
        int answer=1;
        
        for(int i=1;i<=N;i++){
            if(N==1 || N==0) answer=1;
            answer*=i;
        }

        System.out.println(answer);

    }
}