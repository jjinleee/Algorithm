import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        HashMap<String, Integer> pocketmon=new HashMap<>();
        String[] names = new String[N + 1]; // 이름을 인덱스로 저장할 배열

        for(int i=0;i<N;i++){
            s=br.readLine();
            pocketmon.put(s,i+1);
            names[i+1] = s; // 인덱스에 해당하는 이름 저장
        }

        String[] answer=new String[M];

        for(int i=0;i<M;i++){
            s=br.readLine();
            if(s.chars().allMatch(Character::isDigit)){ // 숫자일 때
                int num = Integer.parseInt(s);
                answer[i]=names[num];
            } else {   // 문자열일 때
                answer[i]=Integer.toString(pocketmon.get(s));
            }
        }

        for(String pocket : answer){
            System.out.println(pocket);
        }
    }
}