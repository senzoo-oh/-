import java.io.*;
import java.util.*;

class Shark {
    int r;
    int c;
    int speed;
    int direction;
    int size;

    public Shark(int r, int c, int speed, int direction, int size) {
        this.r = r;
        this.c = c;
        this.speed = speed;
        this.direction = direction;
        this.size = size;
    }
}

public class Solution_for_17143 {
    static int R, C, M;
    static Shark[][] sea;
    static Shark[][] afterMove;
    
    static int totalSharkSize;      // 정답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sea = new Shark[R+1][C+1];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            sea[r][c] = new Shark(r, c, s, d, z);
        }

        startFishing();
        System.out.println(totalSharkSize);
    }

    public static void startFishing() {
        // 낚시왕이 가장 오른쪽에 도달할 때까지 반복
        for (int c = 1; c < C+1; c++) {
            fishing(c);
            moveShark();
        }
    }

    public static void fishing(int fisherPosition) {
        for (int depth = 1; depth < R+1; depth++) {
            // 상어가 없다면
            if (sea[depth][fisherPosition] == null) continue;
            
            // 상어가 있다면
            Shark catchedShark = sea[depth][fisherPosition];
            
            totalSharkSize += catchedShark.size;
            // 상어 제거
            sea[depth][fisherPosition] = null;
            return;
        }
    }

    public static void moveShark() {
        afterMove = new Shark[R+1][C+1];
		
		for (int r = 1; r < R+1; r++) {
            for (int c = 1; c < C+1; c++) {
                // 상어가 없다면
                if (sea[r][c] == null) continue;
                
                // 상어가 있다면 상어를 이동시켜줌
                Shark s = sea[r][c];

                int count = s.speed;

                while (count != 0) {
                    switch(s.direction) {
                        case 1: // 위
                            if (s.r-count < 1) {
                                count -= (s.r-1);
                                s.r = 1;
                                s.direction = 2;
                            }
                            else {
                                s.r -= count;
                                count = 0;
                            }
                            break;

                        case 2: // 아래
                            if (R < s.r+count) {
                                count -= (R-s.r);
                                s.r = R;
                                s.direction = 1;
                            }
                            else {
                                s.r += count;
                                count = 0;
                            }
                            break;

                        case 3: // 오른쪽
                            if (C < s.c+count) {
                                count -= (C-s.c);
                                s.c = C;
                                s.direction = 4;
                            }
                            else {
                                s.c += count;
                                count = 0;
                            }
                            break;

                        case 4: // 왼쪽
                            if (s.c-count < 1) {
                                count -= (s.c-1);
                                s.c = 1;
                                s.direction = 3;
                            }
                            else {
                                s.c -= count;
                                count = 0;
                            }
                            break;
                    }
                }
                
                // 한 칸에 두마리 이상의 상어가 존재한다면
                if (afterMove[s.r][s.c] != null) {
                    // 먼저 도착한 상어의 크기가 새로 도착한 상어의 크기보다 작다면
                    if (afterMove[s.r][s.c].size < s.size) {
                        // 먼저 도착한 상어가 잡아먹힘
                        afterMove[s.r][s.c] = s;
                    }
                }
                else {
                    afterMove[s.r][s.c] = s;
                }
            }
		}
        sea = afterMove;
    }
}
