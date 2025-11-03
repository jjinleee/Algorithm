import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());


        
        int[] dir=new int[6];
        int[] len=new int[6];
        for(int i=0;i<6;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            dir[i]=Integer.parseInt(st.nextToken());
            len[i]=Integer.parseInt(st.nextToken());
        }

        int idxMaxW =-1, idxMaxH= -1;
        int maxW=-1, maxH=-1;

        for(int i=0;i<6;i++){
            if(dir[i]==1 || dir[i]==2){
                if(len[i]>maxW) {
                    maxW=len[i];
                    idxMaxW= i;
                }
            }
            else {
                if(len[i]>maxH){
                    maxH=len[i];
                    idxMaxH=i;
                }
            }
        }
        int leftW = len[(idxMaxW + 5) % 6];
        int rightW = len[(idxMaxW + 1) % 6];
        int smallW = Math.abs(leftW - rightW);

        int leftH = len[(idxMaxH + 5) % 6];
        int rightH = len[(idxMaxH + 1) % 6];
        int smallH = Math.abs(leftH - rightH);

        long bigArea = (long) maxW * maxH;
        long smallArea = (long) smallW * smallH;
        long result = (bigArea - smallArea) * k;

        System.out.println(result);
    }
}