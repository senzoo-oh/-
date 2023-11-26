import java.io.*;
import java.util.*;

public class Solution_for_1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    static int numOfBuilding;
    static int numOfRule;
    static int[] takenTime;
    static int[] dp;

    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static Queue<Integer> queue = new LinkedList<>();

    public static void findMinTime(int target) {
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                dp[i] = takenTime[i];
            }
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.add(next);
                }
                dp[next] = Math.max(dp[next], dp[current] + takenTime[next]);
            }
        }
        answer.append(dp[target]+"\n");
    }

    public static void makeGraph() throws IOException {

        indegree = new int[numOfBuilding+1];
        graph = new ArrayList[numOfBuilding+1];
        for (int i = 1; i < numOfBuilding+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int nthRule = 0; nthRule < numOfRule; nthRule++) {
            st = new StringTokenizer(br.readLine());

            int preBuilding = Integer.parseInt(st.nextToken());
            int nextBuilding = Integer.parseInt(st.nextToken());

            indegree[nextBuilding]++;
            graph[preBuilding].add(nextBuilding);
        }
    }
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            numOfBuilding = Integer.parseInt(st.nextToken());
            numOfRule = Integer.parseInt(st.nextToken());

            takenTime = new int[numOfBuilding+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < numOfBuilding+1; i++) {
                takenTime[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[numOfBuilding+1];

            makeGraph();
            findMinTime(Integer.parseInt(br.readLine()));
        }
        System.out.println(answer);
    }
}