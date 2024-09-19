import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //입력받기 
        int n=Integer.parseInt(br.readLine());
        int[] A= new int[n]; //자료 구조 종류

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }

        int[] B= new int[n];  //자료구조원소
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            B[i]=Integer.parseInt(st.nextToken());
        }

        int m=Integer.parseInt(br.readLine());
        int[] C= new int[m];    //삽입할 원소
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            C[i]=Integer.parseInt(st.nextToken());
        }

        Deque<Integer> q= new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(A[i]==0){        //큐면 원소변경
                q.add(B[i]);
            }
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<m;i++){
            q.offerFirst(C[i]);
            sb.append(q.pollLast()+" ");
        }

        System.out.println(sb.toString());
    }
}