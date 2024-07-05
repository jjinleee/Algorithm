import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);

        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int h=Integer.parseInt(st.nextToken());
       
        List<Integer> length=new ArrayList<>();

        length.add(w-x);
        length.add(x);
        length.add(h-y);
        length.add(y);

        System.out.println(Collections.min(length));

    }
}
