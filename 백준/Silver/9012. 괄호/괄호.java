import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        StringBuilder sb= new StringBuilder();

        for(int i=0;i<n;i++){
            Stack<Character> stack= new Stack<>();
            String s=br.readLine();
            boolean isValid=true;

            for(char c: s.toCharArray()){
                if(c=='(') stack.push('(');
                else{
                    if(stack.isEmpty()){
                        isValid=false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(isValid && stack.isEmpty()) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }

        System.out.println(sb);
    }
}