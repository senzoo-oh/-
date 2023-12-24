import java.io.*;
import java.util.*;

class Snake{
    int row;
    int col;

    public Snake(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Direction {
    int time;
    char direction;

    public Direction(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }
}

public class Solution_for_3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보드의 크기를 입력받고 2차원 배열을 생성함
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N+2][N+2];
        for (int i = 0; i < N+2; i++) {
            for (int j = 0; j < N+2; j++) {
                if (i == 0 || i == N+1 || j == 0 || j == N+1) {
                    board[i][j] = 'W';
                }
            }
        }
        // 사과의 개수를 입력받고 보드판에 사과를 표시함
        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 'A';
        }
        // 뱀의 이동을 나타내기 위해 Deque자료구조를 사용함
        Deque<Snake> deque = new ArrayDeque<>();
        
        // 보드의 맨 위 맨좌측(1,1)에 뱀을 표시하고 deque에 좌표를 넣음
        board[1][1] = 'S';
        deque.add(new Snake(1,1));

        // 뱀의 방향 변환 횟수(L)를 입력받고 큐에 넣음
        Queue<Direction> queue = new LinkedList<>();
        int L = Integer.parseInt(br.readLine());
        for (int l = 0; l < L; l++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            queue.add(new Direction(time, direction));
        }

        // 뱀의 방향 전환을 위한 좌표 표시
        int[][] moveDir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int moveCnt = 0;

        // 뱀의 머리 초기 위치
        int currentSnakeRow = 1;
        int currentSnakeCol = 1;
        // 시작지점에서 뱀은 처음에 오른쪽으로 이동
        int currentSnakeDirection = 1;  

        // 반복문을 돌면서 moveCnt를 1씩 증가시키고 뱀의 머리를 진행방향의 한칸 앞으로 이동
        while (true) {
            // 현재 cnt의 값과 queue에 들어있는 time과 비교해서 일치하면 queue에서 꺼내고 이동방향을 바꿈
            if (!queue.isEmpty() && (moveCnt == queue.peek().time)) {
                Direction d = queue.poll();
                if (d.direction == 'D')
                    currentSnakeDirection = (currentSnakeDirection == 3) ? 0 : currentSnakeDirection+1;
                if (d.direction == 'L')
                    currentSnakeDirection = (currentSnakeDirection == 0) ? 3 : currentSnakeDirection-1;
            }
            moveCnt++;

            currentSnakeRow = currentSnakeRow + moveDir[currentSnakeDirection][0];
            currentSnakeCol = currentSnakeCol + moveDir[currentSnakeDirection][1];
            // 뱀의 머리가 위치해 있는 곳의 알파벳이 'W'라면
            if (board[currentSnakeRow][currentSnakeCol] == 'W') {
                // cnt를 출력하고 종료
                System.out.println(moveCnt);
                return;
            }
            // 뱀의 머리가 위치해 있는 곳의 알파벳이 'A'라면
            else if (board[currentSnakeRow][currentSnakeCol] == 'A') {
                // deque의 앞에 현재 좌표를 추가
                board[currentSnakeRow][currentSnakeCol] = 'S';
                deque.addFirst(new Snake(currentSnakeRow, currentSnakeCol));
            }
            // 뱀의 머리가 위치해 있는 곳의 알파벳이 'S'라면
            else if (board[currentSnakeRow][currentSnakeCol] == 'S') {
                System.out.println(moveCnt);
                return;
            }
            // 뱀의 머리가 위치해 있는 곳이 빈칸이라면 뱀 전체를 이동시킴
            else {
                // deque의 앞에 현재 좌표를 추가하고 뱀의 꼬리를 제거함
                deque.addFirst(new Snake(currentSnakeRow, currentSnakeCol));
                board[currentSnakeRow][currentSnakeCol] = 'S';

                Snake snakeTail = deque.pollLast();
                board[snakeTail.row][snakeTail.col] = ' ';
            }
        }
    }
}
