import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        StringBuilder sb= new StringBuilder();
        sb.append("<");

        ArrayDeque<Integer> list=new ArrayDeque<>();
        for(int i=1;i<=n;i++ ){
            list.add(i);
        }
        while(list.size()>1){
            for(int i=0;i<k-1;i++){
                list.addLast(list.pollFirst());
            }
            sb.append(list.pollFirst()).append(", ");
        }
        sb.append(list.peek());
        sb.append(">");

        System.out.println(sb);

    }
}