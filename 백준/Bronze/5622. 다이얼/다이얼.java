import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String words=sc.nextLine();

        int time=0;

        for(char s: words.toCharArray()){
            if(s=='A'||s=='B'||s=='C'){
                time+=3;
            }
            else if(s=='D'||s=='E'||s=='F'){
                time+=4;
            }
            else if(s=='G'||s=='H'||s=='I'){
                time+=5;
            }
            else if(s=='J'||s=='K'||s=='L'){
                time+=6;
            }
            else if(s=='M'||s=='N'||s=='O'){
                time+=7;
            }
            else if(s=='P'||s=='Q'||s=='R'||s=='S'){
                time+=8;
            }
            else if(s=='T'||s=='U'||s=='V'){
                time+=9;
            }
            else if(s=='W'||s=='X'||s=='Y'||s=='Z'){
                time+=10;
            }
            else time+=11;
        }
        System.out.println(time);

    }
}
