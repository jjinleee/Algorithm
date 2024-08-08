import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] str=new String[N];

        for(int i=0;i<N;i++){
            str[i]=br.readLine();
        }

        //중복제거-1
        String[] finalStr=Arrays.stream(str).distinct().toArray(String[]::new);
        //정렬
        Arrays.sort(finalStr,( s1,  s2)->(s1.length()==s2.length()? s1.compareTo(s2) :s1.length()-s2.length()));

        
        for(int i=0;i<finalStr.length;i++){
            System.out.println(finalStr[i]);
        }

    }
}