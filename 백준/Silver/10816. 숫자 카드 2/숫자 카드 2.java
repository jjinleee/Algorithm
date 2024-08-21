import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        int[] myCard=new int[N];
        HashMap<Integer, Integer> cardCount = new HashMap<>();
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            myCard[i]=num;
            cardCount.put(num, cardCount.getOrDefault(num, 0) + 1);
        }

        int M=Integer.parseInt(br.readLine());
        int[] result = new int[M];
        int[] query = new int[M];
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num=Integer.parseInt(st.nextToken());
            query[i] = num;
            result[i] = cardCount.getOrDefault(num, 0);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}