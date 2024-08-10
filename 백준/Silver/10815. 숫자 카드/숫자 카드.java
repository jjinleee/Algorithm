import java.io.*;
import java.util.*;


public class Main{
    public static int[] card,num;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());

        //갖고있는 카드
        card=new int[N];

        for(int i=0;i<N;i++){
            card[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        //확인해야할 카드
        int M = Integer.parseInt(br.readLine());

        num=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            num[i]=Integer.parseInt(st.nextToken());   
        }

        //있는지 체크-이분탐색
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<M;i++){
            sb.append(binarySearch(0,N-1,num[i])==true?1:0).append(" ");
        }
        
        System.out.println(sb);

    }

    //이진탐색 함수
    public static boolean binarySearch(int left,int right, int target){
        int start=0;
        int end=right;

        while(start<=end){
            int middle=(start+end)/2;
            if(target==card[middle]){
                return true;
            }
            if(card[middle]<target){
                start=middle+1;
            } else if(card[middle]>target){
                end=middle-1;
            }
        }
        return false;
    }
}