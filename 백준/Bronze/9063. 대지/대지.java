import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        

        int n=Integer.parseInt(br.readLine());

        List<Long> x=new ArrayList<>();
        List<Long> y=new ArrayList<>();

        for(int i=0;i<n;i++){
            String s=br.readLine();
            StringTokenizer st=new StringTokenizer(s);

            x.add(Long.parseLong(st.nextToken()));
            y.add(Long.parseLong(st.nextToken()));
        }

        long width=Collections.max(x)-Collections.min(x);
        long height=Collections.max(y)-Collections.min(y);


        System.out.println(width*height);
    }

}
