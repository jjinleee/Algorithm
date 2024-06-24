import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int V=Integer.parseInt(st.nextToken());


        int day=(V-A)/(A-B);
        if((V-A)%(A-B)!=0) day++;

        System.out.println(day+1);
    }
}
