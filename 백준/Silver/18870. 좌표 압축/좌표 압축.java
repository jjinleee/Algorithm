import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());

        int[] dot=new int[N];
        int[] sortDot=new int[N];

        for(int i=0;i<N;i++){
           dot[i]=Integer.parseInt(st.nextToken()); 
        }
        sortDot=dot.clone();

        HashMap<Integer, Integer> m=new HashMap<>();
        Arrays.sort(sortDot);

        int rank=0;
        for(int value: sortDot){
            if(!m.containsKey(value)){
                m.put(value, rank);
                rank++;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int value: dot){
            sb.append(m.get(value)).append(' ');
        }

        System.out.println(sb);
    }
}