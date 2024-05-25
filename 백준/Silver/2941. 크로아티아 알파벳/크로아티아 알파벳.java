import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();

        List<String> croatia=new ArrayList<>();
        croatia.add("c=");
        croatia.add("c-");
        croatia.add("dz=");
        croatia.add("d-");
        croatia.add("lj");
        croatia.add("nj");
        croatia.add("s=");
        croatia.add("z=");

        int count=0;

        //replace후에 연결된단어에서도 count가 되는걸 막아야함
        for(String str:croatia){
            if(s.contains(str)){
                count+=(s.length()-s.replace(str,"").length())/str.length();
                s=s.replace(str," "); //빈칸을넣어줌
            }
        }

        //공백제거 문자개수 세기
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!= ' '){
                count++;
            }
        }
        System.out.println(count);

    }
}
