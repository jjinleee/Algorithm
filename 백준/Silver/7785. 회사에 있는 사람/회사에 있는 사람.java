import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());



        Set<String> have=new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name=st.nextToken();
            String log=st.nextToken();

            if(log.equals("enter")){
                have.add(name);
            } else if(log.equals("leave")){
                have.remove(name);
            }
        }   

        for(String s: have){
            System.out.println(s);
        }
        
    }
}