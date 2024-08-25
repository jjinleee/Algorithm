import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();
        int cnt=0;

        //중복이 없도록 set에 넣는다
        Set<String> partString=new HashSet<>();


        //부분문자열넣기
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                partString.add(s.substring(i, j));
            }
        }

    

        System.out.println(partString.size());
        
        
    }
}