import java.io.*;
import java.util.*;

public class Solution_for_18111 {
    static int N;
    static int M;
    static int B;

    static int[][] ground;
    static int lowest = 256;
    static int highest = 0;

    static int minTime = Integer.MAX_VALUE;
    static int groundHeight = -1;

    public static void find() {
        for (int h = lowest; h < highest+1; h++) {
            int neededBlock = 0;
            int deletedBlock = 0;
            int time = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    int height = ground[r][c];
                    if (height < h) {
                        neededBlock += (h-height);
                    }
                    else if (h < height) {
                        deletedBlock += (height-h);
                    }
                }
            }
            //쌓을 필요가 없는경우 삭제만 하면 됨.
            if (h == lowest) {
                time += (2*deletedBlock);
            }
            //쌓을 필요가 있고 충분한 블록을 가지고 있을때
            else if (neededBlock <= B+deletedBlock) {
                time += (neededBlock + 2*deletedBlock);
            }
            // 쌓을 필요가 있고 충분한 블록을 가지고 있지 않을때 -> 만들지 못함.
            else if (B+deletedBlock < neededBlock) {
                continue;
            }
            if (time <= minTime) {
                minTime = time;
                groundHeight = h;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        ground = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int height = Integer.parseInt(st.nextToken());
                lowest = Math.min(lowest, height);
                highest = Math.max(highest, height);
                ground[n][m] = height;
            }
        }
        find();
        System.out.println(minTime + " " + groundHeight);
    }
}