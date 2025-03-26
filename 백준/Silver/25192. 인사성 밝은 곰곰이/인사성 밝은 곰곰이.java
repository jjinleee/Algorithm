import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  
        int n=Integer.parseInt(br.readLine());
        int answer=0;

        Set<String> people=new HashSet<>();
        for(int i=0;i<n;i++){
            String s=br.readLine();
            if(s.equals("ENTER")){
                people.clear();
            } else if(!people.contains(s)) {
                people.add(s);
                answer++;
            }
        }
        

        System.out.println(answer);
    }
}