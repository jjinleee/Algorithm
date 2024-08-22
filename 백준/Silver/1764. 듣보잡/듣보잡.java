import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nolisten = new HashMap<>();
        
        for(int i=0;i<N;i++){
            String s=br.readLine();
            nolisten.put(s, 0);
        }

        ArrayList<String> result=new ArrayList<>();
        
        for(int i=0;i<M;i++){
            String s=br.readLine();
            if(nolisten.containsKey(s)) result.add(s);
        }

        Collections.sort(result);

      
        System.out.println(result.size());
        for(String n:result){
            System.out.println(n);
        }
    }
}