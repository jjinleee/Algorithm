import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        Set<String> users=new HashSet<>();
        int sum=0;
        

        for(int i=0;i<N;i++){
            String s=br.readLine();
            if(s.equals("ENTER")) users.clear();
            else {
                if(!users.contains(s)) {
                    users.add(s);
                    sum++;
                }
            }
        }
        System.out.println(sum);
        
    }
}