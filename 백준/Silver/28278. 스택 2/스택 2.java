import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        StringBuilder sb= new StringBuilder();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            String[] s=br.readLine().split(" ");
            if(s[0].equals("1")){
                stack.push(Integer.parseInt(s[1]));
            } else if(s[0].equals("2")){
                if(!stack.isEmpty()){
                    sb.append(stack.pop()).append('\n');
                } else sb.append(-1).append('\n');
            } else if(s[0].equals("3")){
                sb.append(stack.size()).append('\n');
            } else if(s[0].equals("4")){
                if(!stack.isEmpty()) sb.append(0).append('\n');
                else sb.append(1).append('\n');
            } else{
                if(!stack.isEmpty()) sb.append(stack.peek()).append('\n');
                else sb.append(-1).append('\n');
            }
        }

        System.out.println(sb.toString());

    }
}