import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
    
        //5킬로 3킬로 하나씩 늘려가면서 N이 되는것 구하기
        int result=-1;

        for(int i=0;i<=1000;i++){
            for(int j=0;j<1700;j++){
                if(5*i+3*j==N) {
                    result=i+j;
                } 
            }
        }

        System.out.println(result);
       
    }
}