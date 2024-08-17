import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);

        int n=Integer.parseInt(st.nextToken());
       
        HashMap<String, String> map=new HashMap<String,String>();

        for(int i=0;i<n;i++){
            s=br.readLine();
            st=new StringTokenizer(s);

            String name=st.nextToken();
            String state=st.nextToken();

            if(map.containsKey(name)) {map.remove(name);}
            else  map.put(name,state);
        }
        List<String> enter_people=new ArrayList<>(map.keySet());

        Collections.sort(enter_people,Collections.reverseOrder());

        for(String t: enter_people){
            System.out.println(t);
        }
       
    }
}