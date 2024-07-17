import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < 2; i++) {
            list.add(Integer.parseInt(br.readLine().trim()));
        }

        int a1 = list.get(0);
        int a0 = list.get(1);
        int c = list.get(2);
        int n = list.get(3);
        

        if(a1*n + a0 <= c*n  && c>=a1) {
            System.out.println(1);
        } else System.out.println(0);
    }

}
