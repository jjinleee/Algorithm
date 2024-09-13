import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int[] people=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            people[i]=Integer.parseInt(st.nextToken());
        }

        Stack<Integer> student=new Stack<>();

        int cnt=1;
        for(int i=0;i<n;i++){
            if(people[i]==cnt){
                cnt++;
                while(!student.isEmpty()){
                    if(student.peek()==cnt){
                        student.pop();
                        cnt++;
                    } else break;
                }
            } else student.push(people[i]);
        }

       System.out.println(student.isEmpty() ? "Nice" : "Sad");
    }
}