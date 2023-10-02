import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String a=sc.next();
        String b=sc.next();

        int num1=change(a);
        int num2=change(b);

        if(num1>num2) System.out.println(num1);
        else System.out.println(num2);
    }
    public static int change(String a){
        String[] arr1=a.split("");
        String temp=arr1[0];
        arr1[0]=arr1[2];
        arr1[2]=temp;

        String s=String.join("",arr1);
        int num=Integer.parseInt(s);
        return num;
    }
}

