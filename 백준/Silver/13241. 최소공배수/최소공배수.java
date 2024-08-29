import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        long A=Integer.parseInt(st.nextToken());
        long B=Integer.parseInt(st.nextToken());
        long result=0;

            //b가 더큰경우
            if(A<=B){
                for(int j=1;j<=A;j++){
                    if(B*j%A==0) {
                        result=B*j;
                        break;
                    }
                }
            } else {    //a가 더큰경우
                for(int j=1;j<=A;j++){
                    if(A*j%B==0) {
                        result=A*j;
                        break;
                    }
                }
            }
        

        System.out.println(result);        
        
    }
}