import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;

        Stack<Integer> stack =new Stack<>();
       
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            String s= st.nextToken();
            if(s.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(s.equals("pop")){
                if(!stack.isEmpty()){
                    sb.append(stack.peek()+"\n");
                    stack.pop();
                } else sb.append(-1+"\n");

            }
            else if(s.equals("size")){
                sb.append(stack.size()+"\n");
            }
            else if(s.equals("empty")){
                if(stack.isEmpty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            }
            else if(s.equals("top")){
                if(!stack.isEmpty()) sb.append(stack.peek()+"\n");
                else sb.append(-1+"\n");
            }
        }

        
       System.out.println(sb.toString());
    }   
    
  
}