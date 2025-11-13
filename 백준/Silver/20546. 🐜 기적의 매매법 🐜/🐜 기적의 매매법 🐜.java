import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       int amoney=Integer.parseInt(br.readLine());
        int bmoney=amoney;
        int ahave=0; //보유주식수
        int bhave=0; 

        int[] price=new int[14];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<14;i++){
            price[i]=Integer.parseInt(st.nextToken());

        }

        for(int p : price){
            //준현이 매수가능
            if(amoney/p>0){
                int cnt=amoney/p; //매수개수
                ahave+=amoney/p;  //보유주식수
                amoney-=p*cnt;    //남은 현금
            }
        }

        //성민주식
        int high=0;
        int low=0;
        for(int i=0;i<13;i++){
            //3일 연속 상승-전량매도
            if(bhave>0 && high>=3){
                bmoney+=bhave*price[i];
                bhave=0;
                //System.out.println(i+"날 팔았습니다");
            }
            //3일연속 하락-전량매수
            if(low>=3){
                int cnt=bmoney/price[i];
                bmoney-=cnt*price[i];
                bhave+=cnt;
                //System.out.println(i+"날 "+cnt+"만큼 샀어요");
            }
            if(price[i]<price[i+1]) { //전일대비상승
                high++;
                low=0;
            }
            else if(price[i]>price[i+1]) { //전일대비하락
                low++;
                high=0;
            }
        }

        amoney+=ahave*price[13];
        bmoney+=bhave*price[13];

        // System.out.println("준현"+amoney);
        // System.out.println("성민"+bmoney);

        if(amoney>bmoney) System.out.println("BNP");
        else if(amoney<bmoney) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}