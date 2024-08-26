import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] result=new int[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            //b가 더큰경우
            if(a<=b){
                for(int j=1;j<=a;j++){
                    if(b*j%a==0) {
                        result[i]=b*j;
                        break;
                    }
                }
            } else {
                for(int j=1;j<=a;j++){
                    if(a*j%b==0) {
                        result[i]=a*j;
                        break;
                    }
                }
            }
        }


        for(int num: result){
            System.out.println(num);
        }        
        
    }
}