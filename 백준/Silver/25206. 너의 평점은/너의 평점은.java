import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        double Score=0.0; //학점x과목퍙점
        double sum=0.0;//학점총합


        for(int i=0;i<20;i++){
            String[] s=br.readLine().split(" ");
            String grade=s[2];
            if(grade.equals("P")){
                continue;
            } else{
                Score+=Double.parseDouble(s[1])*convertScore(grade);
                sum+=Double.parseDouble(s[1]);
            }
        }
        double totalScore=Score/sum;
        System.out.printf("%.6f",totalScore);

    }

    //등급에 따른 과목평점변환
    static double convertScore(String sub){
        double score=0.0;
        switch (sub) {
            case "A+":
                score=4.5;
                break;
            case "A0":
                score=4.0;
                break; 
            case "B+":
                score=3.5;
                break;    
            case "B0":
                score=3.0;
                break;   
            case "C+":
                score=2.5;
                break;
            case "C0":
                score=2.0;
                break;
            case "D+":
                score=1.5;
                break;
            case "D0":
                score=1.0;
                break;
            case "F":
                score=0.0;
                break;
        }
        return score;
    }
}
