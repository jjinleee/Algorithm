import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //10개 입력받을 배열생성
        int[] num = new int[10];
        //입력받기
        int i = 0;
        while (i < 10) {
            num[i] = sc.nextInt();
            i++;
        }

        //나머지를 담을 배열생성 후 나머지담기
        int[] remainder = new int[10];
        for (int j = 0; j < 10; j++) {
            remainder[j] = num[j] % 42;
        }

        //반복문을 통해 중복아닌것만 리스트에 담기

        int difRemainder = 0;  //서로다른나머지개수
        for (int j = 0; j < 10; j++) {
            int count = 0;     //중복하는지 세는 변수
            for (int k = j+1; k < 10; k++) {
                if (remainder[j] == remainder[k]) count++;
            }
            //중복하지않으면 difRemainder 증가
            if (count == 0) difRemainder++;
        }

        System.out.println(difRemainder);

    }
}
