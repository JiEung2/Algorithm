import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Piece{
        int x, y, direction;

        public Piece(int x, int y, int direction){
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    static int n, m;
    static int[][] board;
    static ArrayList<Integer>[] copy_board;
    static Piece[] pieces;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        copy_board = new ArrayList[n*n];
        for(int i = 0; i < n * n; i++){
            copy_board[i] = new ArrayList<>();
        }

        pieces = new Piece[m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken()) - 1;

            pieces[i] = new Piece(x, y, direction);
            copy_board[x * n + y].add(i);
        }

        int cnt = 0;
        while(cnt < 1000){
            cnt++;
            if (solution()) {
                result = cnt;
                break;
            }
        }

        if (cnt == 1000) {
            result = -1;
        }
        System.out.println(result);

    }

    public static boolean solution(){
        for(int i = 0; i < m; i++){
            int direction = pieces[i].direction;
            int nx = pieces[i].x + dx[direction];
            int ny = pieces[i].y + dy[direction];
            int boardNumber = pieces[i].x * n + pieces[i].y;

            int floor = 0;

            //흰색일때
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0){
                //일단 내 말의 위치 파악이 필요
                for(int j = 0; j < copy_board[boardNumber].size(); j++){
                    if (copy_board[boardNumber].get(j) == i) {
                        floor = j;
                        break;
                    }
                }
                //말 이동
                for(int j = floor; j < copy_board[boardNumber].size(); j++) {
                    pieces[copy_board[boardNumber].get(j)].x = nx;
                    pieces[copy_board[boardNumber].get(j)].y = ny;
                    copy_board[nx * n + ny].add(copy_board[boardNumber].get(j));
                }

                for(int j = copy_board[boardNumber].size() - 1; j >= floor ; j--) {
                    copy_board[boardNumber].remove(j);
                }
            } // 빨간색일 때
            else if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                for(int j = 0; j < copy_board[boardNumber].size(); j++){
                    if (copy_board[boardNumber].get(j) == i) {
                        floor = j;
                        break;
                    }
                }

                //말 이동
                for(int j = copy_board[boardNumber].size() - 1; j >= floor; j--) {
                    pieces[copy_board[boardNumber].get(j)].x = nx;
                    pieces[copy_board[boardNumber].get(j)].y = ny;

                    copy_board[nx * n + ny].add(copy_board[boardNumber].remove(j));
                }
            } // 파란색일 때
            else {
                if(direction == 0) direction = 1;
                else if(direction == 1) direction = 0;
                else if(direction == 2) direction = 3;
                else if(direction == 3) direction = 2;

                pieces[i].direction = direction;

                nx = pieces[i].x + dx[direction];
                ny = pieces[i].y + dy[direction];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 2) continue;

                for(int j = 0; j < copy_board[boardNumber].size(); j++){
                    if (copy_board[boardNumber].get(j) == i) {
                        floor = j;
                        break;
                    }
                }

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0){
                    //일단 내 말의 위치 파악이 필요
                    for(int j = 0; j < copy_board[boardNumber].size(); j++){
                        if (copy_board[boardNumber].get(j) == i) {
                            floor = j;
                            break;
                        }
                    }
                    //말 이동
                    for(int j = floor; j < copy_board[boardNumber].size(); j++) {
                        pieces[copy_board[boardNumber].get(j)].x = nx;
                        pieces[copy_board[boardNumber].get(j)].y = ny;
                        copy_board[nx * n + ny].add(copy_board[boardNumber].get(j));
                    }

                    for(int j = copy_board[boardNumber].size() - 1; j >= floor ; j--) {
                        copy_board[boardNumber].remove(j);
                    }
                } // 빨간색일 때
                else if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    for(int j = 0; j < copy_board[boardNumber].size(); j++){
                        if (copy_board[boardNumber].get(j) == i) {
                            floor = j;
                            break;
                        }
                    }

                    //말 이동
                    for(int j = copy_board[boardNumber].size() - 1; j >= floor; j--) {
                        pieces[copy_board[boardNumber].get(j)].x = nx;
                        pieces[copy_board[boardNumber].get(j)].y = ny;

                        copy_board[nx * n + ny].add(copy_board[boardNumber].remove(j));
                    }
                }
            }

            if (copy_board[nx * n + ny].size() >= 4) {
                return true;
            }
        }
        return false;
    }
}
