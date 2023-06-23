import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;


public class Solution_for_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집합A, 집합 B 원소의 개수를 입력받음
        int numberOfA = Integer.parseInt(st.nextToken());
        int numberOfB = Integer.parseInt(st.nextToken());

        // 대칭차집합에 집합 A의 원소를 넣음
        HashSet<String> symDif = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numberOfA; i++) {
            symDif.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numberOfB; i++) {
            String eOfB = st.nextToken();
            
            if(symDif.contains(eOfB)) symDif.remove(eOfB);
            else symDif.add(eOfB);
        }

        System.out.println(symDif.size());
    }
}