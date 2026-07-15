import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        //행열개수
        int rowCount = relation.length;
        int colCount = relation[0].length;
        
        //후보키-비트마스킹
        List<Integer> candidateKeys = new ArrayList<>();

        //모든 열조합 만듦
        for (int combination = 1; combination < (1 << colCount); combination++) {
            boolean isMinimal = true; //최소성 검사

            //후보키와 현재조합 최소성 검사
            for (int candidateKey : candidateKeys) {
                if ((candidateKey & combination) == candidateKey) { //현재조합에 후보키가 포함되면 최소성 탈락
                    isMinimal = false;
                    break;
                }
            }

            if (!isMinimal) continue;

            //유일성 검사
            Set<String> tuples = new HashSet<>(); //행별 조합 저장

            for (int row = 0; row < rowCount; row++) {
                StringBuilder key = new StringBuilder();

                //현재조합이 각 열에 포함되는지 확인
                for (int col = 0; col < colCount; col++) {
                    if ((combination & (1 << col)) != 0) {
                        //선택된 열의 값 이어붙이기
                        key.append(relation[row][col]).append("|");
                    }
                }

                //현재 행 조합값 추가
                tuples.add(key.toString());
            }

            //모든 행이 현재 열조합으로 구분된다는 뜻 즉 유일성, 최소성 만족
            if (tuples.size() == rowCount) {
                candidateKeys.add(combination);
            }
        }

        return candidateKeys.size();
    }
}