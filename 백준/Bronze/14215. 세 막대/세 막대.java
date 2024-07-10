import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);
    
        int[] tmp=new int[3];
        for(int i=0;i<3;i++){
            tmp[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(tmp);
        if(tmp[0]+tmp[1]<=tmp[2]){
            tmp[2]=tmp[0]+tmp[1]-1;
        }
        System.out.println(tmp[0]+tmp[1]+tmp[2]);
    

    }

}
