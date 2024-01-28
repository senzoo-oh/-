import java.io.*;
import java.util.*;

class CCTV {
    int num;
    int r;
    int c;
    int[][] dir;

    public CCTV (int num, int r, int c) {
        this.num = num;
        this.r = r;
        this.c = c;
    }
}

public class Solution_for_15683 {
    static int N, M;
    static int[][] map;

    static ArrayList<CCTV> cctvs = new ArrayList<>();

    static int answer = 65;
    static int wallCount = 0;

    // CCTV 종류별로 탐지할 수 있는 방법의 개수
    static int[][][] CCTV1 = { {{-1, 0}}, {{1, 0}}, {{0, -1}}, {{0, 1}} };
    static int[][][] CCTV2 = { {{-1, 0}, {1, 0}}, {{0, -1}, {0, 1}} };
    static int[][][] CCTV3 = { {{-1, 0}, {0, 1}}, {{0, 1}, {1, 0}}, {{1, 0}, {0, -1}}, {{0, -1}, {-1, 0}} };
    static int[][][] CCTV4 = { {{0, -1}, {-1, 0}, {0, 1}}, {{-1, 0}, {0, 1}, {1, 0}}, {{0, 1}, {1, 0}, {0, -1}}, {{1, 0}, {0, -1}, {-1, 0}} };
    static int[][][] CCTV5 = { {{-1, 0}, {1, 0}, {0, -1}, {0, 1}} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                int num = Integer.parseInt(st.nextToken());
                
                // CCTV 저장
                if (num != 0 && num != 6) {
                    cctvs.add(new CCTV(num, r, c));
                }

                // 벽의 개수
                if (num==6) wallCount++;

                map[r][c] = num;
            }
        }

        comb(0);

        System.out.println(answer);
    }

    // CCTV의 방향을 다르게 설정하는 조합 구하는 메서드
    public static void comb(int nthCCTV) {

        // 모든 CCTV를 선택한 경우
        if (nthCCTV == cctvs.size()) {
            // System.out.printf("%d개의 CCTV를 모두 찾음\n", nthCCTV);
            findBlindSpot();
            return;
        }

        // 모든 CCTV를 선택하지 않은 경우
        CCTV selection = cctvs.get(nthCCTV);

        switch(selection.num) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    selection.dir=CCTV1[i];
                    comb(nthCCTV+1);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    selection.dir = CCTV2[i];
                    comb(nthCCTV+1);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    selection.dir=CCTV3[i];
                    comb(nthCCTV+1);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    selection.dir=CCTV4[i];
                    comb(nthCCTV+1);
                }
                break;
            case 5:
                selection.dir=CCTV5[0];
                comb(nthCCTV+1);
                break;
        }
    }

    // 사각지대의 개수를 구하는 메서드
    public static void findBlindSpot() {
        // CCTV가 감시 가능한 곳 체크
        boolean[][] detected = new boolean[N][M];

        int detectedAreaCount = 0;
        for (CCTV cctv : cctvs) {
            for (int n = 0; n < cctv.dir.length; n++) {

                int dr = cctv.r;
                int dc = cctv.c;

                while (true) {
                    dr += cctv.dir[n][0];
                    dc += cctv.dir[n][1];

                    //범위를 벗어나거나 벽인 경우 -> 감시 종료
                    if (dr < 0 || dc < 0 || N-1 < dr || M-1 < dc || map[dr][dc]==6) break;

                    //CCTV를 접한 경우 또는 이미 다른 CCTV가 탐지하는 경우 -> 카운트 하지 않음
                    if (map[dr][dc] != 0 || detected[dr][dc]) continue;

                    detected[dr][dc] = true;
                    detectedAreaCount++;
                }
            }
        }
        answer = Math.min(answer, ((N*M)-detectedAreaCount-cctvs.size()-wallCount));
    }
}