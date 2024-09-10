import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        

        int k=Integer.parseInt(br.readLine());
        Stack<Integer> moneybook = new Stack<>();

        for(int i=0;i<k;i++){
            int n=Integer.parseInt(br.readLine());
            if(n==0) moneybook.pop();
            else moneybook.push(n);
        }

        int sum=0;

        for(int i=0;i<moneybook.size();i++){
            sum+=moneybook.get(i);
        }
        System.out.println(sum);
    }
}