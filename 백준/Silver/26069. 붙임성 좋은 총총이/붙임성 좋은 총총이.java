import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        Set<String> dancePeople=new HashSet<>();
        int cnt=0;

    
        while(true){
            if(cnt>=N) break;
            StringTokenizer st= new StringTokenizer(br.readLine());
            String a=st.nextToken();
            String b=st.nextToken();
            cnt++;

            if(a.equals("ChongChong") || b.equals("ChongChong")){
                dancePeople.add(a); 
                dancePeople.add(b);

                for(int i=cnt;i<N;i++){
                    st= new StringTokenizer(br.readLine());
                    String a2=st.nextToken();
                    String b2=st.nextToken();
                    cnt++;

                    if(dancePeople.contains(a2) & !dancePeople.contains(b2)) dancePeople.add(b2);
                    if(dancePeople.contains(b2) & !dancePeople.contains(a2))dancePeople.add(a2);
                } 
            }
        }
        System.out.println(dancePeople.size());
        
    }
}