import java.io.*;
import java.util.*;

public class Solution_for_4195 {
    static Map<String, Integer> personInfo;
    static int[] groupInfo;
    static int[] numInGroup;

    static int groupCount = 1;

    public static int find(int num) {
        if (num == groupInfo[num])
            return num;
        else return groupInfo[num] = find(groupInfo[num]);
    }

    public static void union(String name1, String name2) {
        
        int group1Root = find(personInfo.get(name1));
        int group2Root = find(personInfo.get(name2));

        if (group1Root != group2Root) {
            groupInfo[group2Root] = group1Root;
            numInGroup[group1Root] += numInGroup[group2Root];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {

            personInfo = new HashMap<>();

            groupInfo = new int[200_001];
            for (int i = 1; i < 200_001; i++) {
                groupInfo[i] = i;
            }

            numInGroup = new int[200_001];
            Arrays.fill(numInGroup, 1);

            int F = Integer.parseInt(br.readLine());
            for (int f = 0; f < F; f++) {
                st = new StringTokenizer(br.readLine());

                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!personInfo.containsKey(name1)) personInfo.put(name1, groupCount++);
                if (!personInfo.containsKey(name2)) personInfo.put(name2, groupCount++);

                union(name1, name2);
                answer.append(numInGroup[find(personInfo.get(name1))]+"\n");
            }
        }
        System.out.println(answer);
    }
}