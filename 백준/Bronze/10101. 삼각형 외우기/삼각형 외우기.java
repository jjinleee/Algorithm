import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        int angle[]=new int[3];

        int sum=0;

        for(int i=0;i<3;i++){
            angle[i]=Integer.parseInt(br.readLine());
            sum+=angle[i];
        }

        if(sum==180){
            if(angle[0]==angle[1]||angle[1]==angle[2]||angle[0]==angle[2]){
                if(angle[1]==60) System.out.println("Equilateral");
                else System.out.println("Isosceles");
            } else System.out.println("Scalene");
        } else System.out.println("Error");
    }

}
