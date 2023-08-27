import java.io.*;
import java.util.*;

public class Solution_for_2263 {
    static int[] inorder;
    static int[] postorder;
    static int[] location;
    static StringBuilder answer = new StringBuilder();

    public static void preorder(int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        if (inorderLeft > inorderRight || postorderLeft > postorderRight) {
            return;
        }
        int root = postorder[postorderRight];
        answer.append(root + " ");

        int inorderRootIndex = location[root];

        int leftSubtreeSize = inorderRootIndex - inorderLeft;
        
        preorder(inorderLeft, inorderRootIndex-1, postorderLeft, postorderLeft+leftSubtreeSize-1);
        preorder(inorderRootIndex+1, inorderRight, postorderLeft+leftSubtreeSize, postorderRight-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        inorder = new int[N+1];
        location = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            int node = Integer.parseInt(st.nextToken());
            inorder[i] = node;
            location[node] = i;
        }

        postorder = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        
        preorder(1, N, 1, N);
        System.out.println(answer);
    }
}