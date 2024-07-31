import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    
        List<Integer> arr=new ArrayList<>();
        int sum=0;

        for(int i=0;i<5;i++){
            arr.add(Integer.parseInt(br.readLine()));
            sum+=arr.get(i);
        }

        Collections.sort(arr);
       
        System.out.println(sum/5);
        System.out.println(arr.get(2));
    }
}