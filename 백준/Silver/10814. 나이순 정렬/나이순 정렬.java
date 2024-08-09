import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] people=new String[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            people[i][0]=st.nextToken();
            people[i][1]=st.nextToken();
        }

        //정렬
        Arrays.sort(people,( s1,  s2)->(Integer.parseInt(s1[0])==Integer.parseInt(s2[0]) ? Arrays.asList(people).indexOf(s1[1])-Arrays.asList(people).indexOf(s2[1]) :Integer.parseInt(s1[0])-Integer.parseInt(s2[0])));

        
        for(int i=0;i<N;i++){
            System.out.println(people[i][0]+" "+people[i][1]);
        }

    }
}