import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        
        int[] w=new int[3];
        int[] h=new int[3];


        for(int i=0;i<3;i++){
            String s=br.readLine().trim();
            StringTokenizer st=new StringTokenizer(s);
            w[i]=(Integer.parseInt(st.nextToken()));
            h[i]=(Integer.parseInt(st.nextToken()));
        }

        int answerx;
        int answery;

        if(w[0]==w[1]){
            answerx=w[2];
        }else if(w[0]==w[2]){
            answerx=w[1];
        }else{
            answerx=w[0];
        }

        if (h[0] == h[1]) {
            answery = h[2];
        } else if (h[0] == h[2]) {
            answery = h[1];
        } else {
            answery = h[0];
        }
        
        System.out.println(answerx+" "+answery);
    }

}
