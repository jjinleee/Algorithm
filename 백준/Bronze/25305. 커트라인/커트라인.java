import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        List<Integer> students=new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            students.add(Integer.parseInt(st.nextToken()));
        }

        students.sort(Comparator.reverseOrder());
        System.out.println(students.get(k-1));
    }
}