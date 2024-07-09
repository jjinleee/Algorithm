import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        
        int[] tmp=new int[3];
        List<String> result=new ArrayList<>();
        
        while(true){
            String s=br.readLine();
            StringTokenizer st=new StringTokenizer(s);

            tmp[0]=Integer.parseInt(st.nextToken());

            if(tmp[0]==0) break;

            tmp[1]=Integer.parseInt(st.nextToken());
            tmp[2]=Integer.parseInt(st.nextToken());

            Arrays.sort(tmp);

            if(tmp[0]+tmp[1]<=tmp[2]) result.add("Invalid");
            else if(tmp[0]==tmp[1]&&tmp[1]==tmp[2]){
                result.add("Equilateral");
            } else if(tmp[0]==tmp[1]||tmp[0]==tmp[2]||tmp[1]==tmp[2]){
                result.add("Isosceles");
            } else result.add("Scalene");
        }
        

        for(String s:result){
            System.out.println(s);
        }

    }

}
