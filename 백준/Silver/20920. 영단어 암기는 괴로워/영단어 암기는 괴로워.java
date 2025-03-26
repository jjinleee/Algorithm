import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        
        Map<String,Integer> words= new HashMap<>();
        for(int i=0;i<n;i++){
            String word=br.readLine();
            if(word.length()>=m){
                words.put(word, words.getOrDefault(word, 0)+1);
            }
        }

        //자주나올수록 앞에, 단어의 길이 내림차순, 사전순
        List<String> many=new ArrayList<>(words.keySet());
        many.sort((a,b)->words.get(b)==words.get(a) ? (b.length()==a.length() ? a.compareTo(b) :b.length()-a.length()) : words.get(b)-words.get(a) );


        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        for(String k:many){
            bw.write(k);
            bw.write('\n');
        }

        bw.flush();
    }
}