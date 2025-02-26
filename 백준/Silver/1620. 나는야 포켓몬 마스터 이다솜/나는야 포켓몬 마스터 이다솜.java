import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        
        Map<String,Integer> book=new HashMap<>();
        String[] names=new String[n+1];
        for(int i=0;i<n;i++){
            String s= br.readLine();
            book.put(s, i+1);
            names[i+1]=s;
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<m;i++){
            String s=br.readLine();
            if(s.matches("\\d+")){
                sb.append(names[Integer.parseInt(s)]+"\n");
            } else{
                sb.append(book.get(s)+"\n");
            }
        }

        System.out.println(sb.toString());
    }
}