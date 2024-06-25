import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
    
        List<String> results=new ArrayList<>();

        while(true){
            String s=br.readLine();
            StringTokenizer st=new StringTokenizer(s);
            
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            if((a==0)&(b==0)) break;

            if(a%b==0){
                results.add("multiple");
            } else if(b%a==0){
                results.add("factor");
            } else  results.add("neither");
           
        }

        for(String result:results){
            System.out.println(result);
        }
       
    }
}
