import java.io.*;
import java.util.*;


public class Main{
    public static class Member{
        int age;
        String name;
        int order;

        public Member(int age, String name, int order){
            this.age=age;
            this.name=name;
            this.order=order;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        List<Member> list= new ArrayList<>();

        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int age=Integer.parseInt(st.nextToken());
            String name=st.nextToken();
            list.add(new Member(age, name, i));
        }

        list.sort((a,b)-> (a.age==b.age ? a.order-b.order : a.age-b.age));

        StringBuilder sb= new StringBuilder();
        for(Member m: list){
            sb.append(m.age+" "+m.name+"\n");
        }

        System.out.println(sb);
    }
}