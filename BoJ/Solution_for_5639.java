import java.io.*;
import java.util.*;

public class Solution_for_5639 {
    static ArrayList<Integer> preorder = new ArrayList<>();
    static StringBuilder answer = new StringBuilder();

    static void getPostorder(int L, int R) {
        if (L > R) return;

        int root = preorder.get(L);
        int leftSubtreeL = L+1;

        int rightSubtreeL = R+1;
        for (int i = L+1; i < R+1; i++) {
            if (root < preorder.get(i)) {
                rightSubtreeL = i;
                break;
            }
        }

        int leftSubtreeR = rightSubtreeL-1;

        int rightSubtreeSize = R - leftSubtreeR;
        int rightSubtreeR = rightSubtreeL + rightSubtreeSize-1;

        getPostorder(leftSubtreeL, leftSubtreeR);
        getPostorder(rightSubtreeL, rightSubtreeR);
        answer.append(root+"\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key;
        while((key = br.readLine()) != null) {
            preorder.add(Integer.parseInt(key));
        }
        getPostorder(0, preorder.size()-1);
        System.out.println(answer);
    }
}