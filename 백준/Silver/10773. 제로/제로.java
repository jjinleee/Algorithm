import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<n;i++){
            int a=Integer.parseInt(br.readLine());
            if(a==0) stack.pop();
            else stack.push(a);
        }

        int sum=0;
        for(int i=0;i<stack.size();i++){
            sum+=stack.get(i);

        }

        System.out.println(sum);
    }
}