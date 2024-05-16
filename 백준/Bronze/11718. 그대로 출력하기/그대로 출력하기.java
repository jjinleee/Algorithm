import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //byte 스트림->문자 스트림->버퍼 스트림
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str;
        while((str=br.readLine())!=null){
            System.out.println(str);
        }
        br.close();
    
    }
}