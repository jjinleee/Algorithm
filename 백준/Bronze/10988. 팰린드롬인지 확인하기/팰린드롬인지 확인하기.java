import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st=br.readLine();
        br.close();

        char[] str=st.toCharArray();
        
        int n=st.length();
        for(int i=0;i<=n/2;i++){
            if((i!=n/2)&(str[i]==str[n-i-1])) {
                continue;
            }else if((i==n/2)&(str[i]==str[n-i-1])){
                System.out.println("1");
            }else{
                System.out.println("0");
                break;
            }
 
        }
    }
}
