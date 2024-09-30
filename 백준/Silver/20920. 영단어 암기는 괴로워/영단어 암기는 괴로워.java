import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        Map<String, Integer> dict=new HashMap<>();

        for(int i=0;i<n;i++){
            String s=br.readLine();
            if(s.length()>=m) {
                dict.put(s, dict.getOrDefault(s, 0)+1);
            }
        }

        List<String> wordList=new ArrayList<>(dict.keySet());


        StringBuilder sb=new StringBuilder();
        
        wordList.sort((a,b)->{
            int freq=dict.get(b).compareTo(dict.get(a)); //1.빈도비교
            if(freq==0){
                int length=Integer.compare(b.length(),a.length());//2.길이비교
                if(length==0) return a.compareTo(b);            //3.알파벳순
                return length;
            } 
            return freq; 
        });

        for(String word :wordList){
            sb.append(word).append('\n');
        }
        
        System.out.println(sb.toString());

    }
}