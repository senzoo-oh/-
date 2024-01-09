import java.io.*;
import java.util.*;

class Soil {
    int water = 5;
    PriorityQueue<Tree> aliveTrees;
    Queue<Tree> deadTrees;

    public Soil() {
        aliveTrees = new PriorityQueue<>(new TreeComparator());
        deadTrees = new ArrayDeque<>();
    }
}

class Tree {
    int age;

    public Tree(int age) {
        this.age = age;
    }
}

class TreeComparator implements Comparator<Tree>{
    @Override
    public int compare(Tree t1, Tree t2) {
        return t1.age - t2.age;
    }
}

public class Solution_for_16235 {
    static int N, M, K;
    static int[][] addedWater;
    static Soil[][] soil;
    
    static int[] dirRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dirCol = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 각 칸에 추가되는 양분의 양 A입력받기
        addedWater = new int[N+1][N+1];
        for (int r = 1; r < N+1; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c < N+1; c++) {
                addedWater[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        soil = new Soil[N+1][N+1];
        for (int r = 1; r < N+1; r++) {
            for (int c = 1; c < N+1; c++) {
                soil[r][c] = new Soil();
            }
        }

        // 나무의 정보 입력받기
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());   // 나무 행(위치)
            int y = Integer.parseInt(st.nextToken());   // 나무 열(위치)
            int z = Integer.parseInt(st.nextToken());   // 나무 나이

            soil[x][y].aliveTrees.add(new Tree(z));
        }

        for (int k = 0; k < K; k++) {
            spring();
            summer();
            fall();
            winter();
        }
        
        System.out.println(getTreeCount());
    }

    public static void spring() {
        for (int r = 1; r < N+1; r++) {
            for (int c = 1; c < N+1; c++) {

                // 심어진 나무가 없다면 -> 다음 칸 탐색
                if (soil[r][c].aliveTrees.isEmpty()) continue;

                PriorityQueue<Tree> currAliveTrees = new PriorityQueue<>(new TreeComparator());
                // 각각의 나무는 자신의 나이만큼 양분을 먹음
                while(!soil[r][c].aliveTrees.isEmpty() && soil[r][c].aliveTrees.peek().age <= soil[r][c].water) {

                    Tree t = soil[r][c].aliveTrees.poll();

                    soil[r][c].water -= t.age;
                    t.age++;
                    currAliveTrees.add(new Tree(t.age));
                }

                soil[r][c].deadTrees.addAll(soil[r][c].aliveTrees);
                soil[r][c].aliveTrees = currAliveTrees;
            }
        }
    }
    public static void summer() {
        for (int r = 1; r < N+1; r++) {
            for (int c = 1; c < N+1; c++) {
                if (soil[r][c].deadTrees.isEmpty()) continue;
                
                // 땅에 죽은 나무들이 존재한다면 큐에서 죽은 나무들을 하나씩 꺼내 나이/2 의 값을 양분에 추가해줌
                for (Tree t : soil[r][c].deadTrees) {
                    soil[r][c].water += (t.age/2);
                }
                soil[r][c].deadTrees.clear();
            }
        }
    }
    public static void fall() {
        int[][] newTree = new int[N+1][N+1];

        for (int r = 1; r < N+1; r++) {
            for (int c = 1; c < N+1; c++) {
                if (soil[r][c].aliveTrees.isEmpty()) continue;
                
                Iterator<Tree> iter = soil[r][c].aliveTrees.iterator();

                while (iter.hasNext()) {
                    // 땅에 살아있는 나무의 나이가 5의 배수이면
                    if (iter.next().age % 5 == 0) {
                        for (int i = 0; i < 8; i++) {
                            int nr = r + dirRow[i];
                            int nc = c + dirCol[i];

                            if (nr < 1 || N < nr || nc < 1 || N < nc) continue;
                            newTree[nr][nc]++;
                        }
                    }
                }
            }
        }

        for (int r = 1; r < N+1; r++) {
            for (int c = 1; c < N+1; c++) {
                if (newTree[r][c]==0) continue;

                int newTreeCount = newTree[r][c];
                for (int i = 0; i < newTreeCount; i++) {
                    soil[r][c].aliveTrees.add(new Tree(1));
                }
            }
        }
    }

    public static void winter() {
        for (int r = 1; r < N+1; r++) {
            for (int c = 1; c < N+1; c++) {
                // 양분을 더해줌
                soil[r][c].water += addedWater[r][c];
            }
        }
    }

    public static int getTreeCount() {
        int treeCount = 0;

        for (int r = 1; r < N+1; r++) {
            for (int c = 1; c < N+1; c++) {
                treeCount += soil[r][c].aliveTrees.size();
            }
        }
        return treeCount;
    }
}