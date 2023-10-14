import java.io.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x=0, y=0 ;
        char[][] park2 = new char[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++){
            park2[i] = park[i].toCharArray();
            
            if(park[i].contains("S")){
                x = park[i].indexOf("S");
                y = i;
            }
        }
    
        for(String route : routes){
            String[] tmp = route.split(" ");
            String dir = tmp[0];
            int moving = Integer.parseInt(tmp[1]);
            
            int tmpX = x;
            int tmpY = y;
            
            for(int i = 0; i < moving; i++){
                if(dir.equals("E")){
                    tmpX++;
                }
                if(dir.equals("W")){
                    tmpX--;
                }
                if(dir.equals("S")){
                    tmpY++;
                }
                if(dir.equals("N")){
                    tmpY--;
                }
                if(tmpX >=0 && tmpY >=0 && tmpX < park2[0].length && tmpY < park2.length){
                    if(park2[tmpY][tmpX] == 'X') break;
                    if(i == moving-1){
                        x = tmpX;
                        y = tmpY;
                    }
                }
            }
        }       
        
        int[] answer = {y, x};
        return answer;
    }
}