import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s=br.readLine();

        int result=0;
        String[] num= s.split("-");

        result+=calculate(num[0]);

        for(int i=1;i<num.length;i++){
            result-=calculate(num[i]);
        }

        System.out.println(result);
    }

    static int calculate(String group){
        String[] nums=group.split("\\+");
        int sum=0;

        for(String n:nums){
            sum+=Integer.parseInt(n);
        }

        return sum;
    }
}