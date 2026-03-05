import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        //상하좌우 1,2칸 대각선
        int[] dx1={1,-1,0,0};
        int[] dy1={0,0,-1,1};
        
        int[] dx2={-2,2,0,0};
        int[] dy2={0,0,-2,2};
        
        int[] dx3={1,1,-1,-1};
        int[] dy3={1,-1,-1,1};
        
        for(int i=0;i<5;i++){
            String[] room=places[i];
            boolean ok=true;
            
            for(int r=0;r<5 &&ok ;r++){
                for(int c=0;c<5 && ok;c++){
                    if(room[r].charAt(c)!='P') continue;
                    
                    //상하좌우1칸 
                    for(int k=0;k<4;k++){
                        int nr=r+dx1[k];
                        int nc=c+dy1[k];
                        if(nr<0 || nr>=5 || nc<0 || nc>=5) continue;
                        if(room[nr].charAt(nc)=='P'){
                            ok=false;
                            break;
                        }
                    }
                    if(!ok) break;
                    
                    //상하좌우2칸 
                    for(int k=0;k<4;k++){
                        int nr=r+dx2[k];
                        int nc=c+dy2[k];
                        if(nr<0 || nr>=5 || nc<0 || nc>=5) continue;
                        if(room[nr].charAt(nc)=='P'){
                            int mr=r+dx2[k]/2;
                            int mc=c+dy2[k]/2;
                            if(room[mr].charAt(mc)=='O'){
                                ok=false;
                                break;
                            }
                            
                        }
                    }
                   if(!ok) break;
                    
                    //대각선
                    for(int k=0;k<4;k++){
                        int nr=r+dx3[k];
                        int nc=c+dy3[k];
                        if(nr<0 || nr>=5 || nc<0 || nc>=5) continue;
                        if(room[nr].charAt(nc)=='P'){
                            if(room[r].charAt(nc)=='O' || room[nr].charAt(c)=='O'){
                                ok=false;
                                break;
                            }
                        }
                    }
                }
            }
           answer[i]=ok ? 1 : 0;
            
        }
        return answer;
    }
}