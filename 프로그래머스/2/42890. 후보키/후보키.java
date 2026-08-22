import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int row=relation.length;
        int col=relation[0].length;
        
        List<Integer> candidates=new ArrayList<>();
        
        for(int bit=1;bit<(1<<col) ; bit++){
            boolean minimal=true;
            
            for(int key : candidates){
                if((key&bit)==key){
                    minimal=false;
                    break;
                }
            }
            
            if(!minimal) continue;
            Set<String> set = new HashSet<>();

            for (int i = 0; i < row; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < col; j++) {

                    // 현재 조합 bit에 j번 컬럼이 포함되어 있는지 확인
                    if ((bit & (1 << j)) != 0) {
                        sb.append(relation[i][j])
                          .append("/");
                    }
                }

                set.add(sb.toString());
            }

            
            if(set.size()==row) candidates.add(bit);
        }
        return candidates.size();
    }
}