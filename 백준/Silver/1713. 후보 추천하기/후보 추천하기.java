import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       
       int n=Integer.parseInt(br.readLine());
       int s=Integer.parseInt(br.readLine());
       int[] suggest=new int[s];

       StringTokenizer st=new StringTokenizer(br.readLine());
       for(int i=0;i<s;i++){
        suggest[i]=Integer.parseInt(st.nextToken());
       }

       Map<Integer, Integer> pic=new LinkedHashMap<>();

       for(int sug : suggest){
            //후보가 이미 사진틀에 있음
            if(pic.containsKey(sug)){
                pic.put(sug, pic.get(sug)+1); //추천수 증가
            } else{ //후보가 사진틀에 없음
                if(pic.size()<n){ //사진틀 추가
                    pic.put(sug, 1);
                }
                //사진틀 다 참 -추천이 적은 순, 오래된 순으로 삭제
                else{
                    //사진틀 삭제
                    int min=Collections.min(pic.values());
                    for(int k : pic.keySet()){
                        if(pic.get(k)==min){
                            pic.remove(k);
                            break;
                        }
                    }
                    pic.put(sug, 1); //새로운 사진틀 
                }
            }
       }

       List<Integer> answer=new ArrayList<>(pic.keySet());
       Collections.sort(answer);
       for(int a : answer){
        System.out.print(a+" ");
       }
    }
}