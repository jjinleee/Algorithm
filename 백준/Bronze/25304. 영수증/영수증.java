import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int X=sc.nextInt();     //총금액
        int N= sc.nextInt();    //물건종류
        int sum=0;              //계산결과

        for(int i=0;i<N;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            sum+=(a*b);
        }
        if(X==sum)
            System.out.println("Yes");
        else System.out.println("No");
    }
}
