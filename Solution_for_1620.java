import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map.Entry;


public class Solution_for_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 포켓몬을 도감에 담음.
        HashMap<String,String> monster = new HashMap<String,String>();
        
        for(int i = 0; i < N; i++) {
            String name = br.readLine();
            monster.put(Integer.toString(i+1), name);
            monster.put(name, Integer.toString(i+1));
        }

        // M개의 포켓몬을 도감에서 찾음.
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(monster.get(br.readLine()) + "\n");
        }
        System.out.println(sb);
    }
}
