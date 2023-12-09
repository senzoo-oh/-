import java.io.*;
import java.util.*;

class Zero{
    public int indexX;
    public int indexY;

    public Zero(int x, int y) {
        indexX = x;
        indexY = y;
    }
}

public class Solution_for_2580 {
    public static ArrayList<Zero> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    public static int flag = 0;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] answer = new int[9][9];
        StringTokenizer st;
        int num;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    list.add(new Zero(i, j));
                    count++;
                }
                answer[i][j] = num;
            }
        }
        sudoku(0, answer);
    }

    public static void sudoku(int c, int[][] arr) {
        if (flag == 1) return;
        int[][] nums = new int[9][9];
        for (int i = 0; i < 9; i++) {
            nums[i] = arr[i].clone();
        }

        if (c == count) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(nums[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            flag = 1;
            return;
        }
        
        Zero next = list.get(c);
        int x = next.indexX;
        int y = next.indexY;

        for (int n = 1; n < 10; n++) {
            if(promising(x, y, n, nums)) {
                nums[x][y] = n;
                sudoku(c+1, nums);
            }
        }
    }

    public static boolean promising(int x, int y, int value, int[][] arr) {
        // 가로줄에 중복되는 수가 있을때 -> 유망x
        for (int j = 0; j < 9; j++) {
            if (arr[x][j] == value) {
                return false;
            }
        }
        // 세로줄에 중복되는 수가 있을때 -> 유망x
        for (int i = 0; i < 9; i++) {
            if (arr[i][y] == value)
                return false;
        }
        // 3*3 정사각형에 중복되는 수가 있을때 -> 유망x
        int startX = (x/3)*3;
        int startY = (y/3)*3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (arr[i][j] == value)
                    return false;
            }
        }
        return true;
    }
}