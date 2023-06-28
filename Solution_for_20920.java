import java.io.*;
import java.util.*;

class VocaComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue() > e2.getValue()) return -1;
        else if (e1.getValue() < e2.getValue()) return 1;
        else {
            if (e1.getKey().length() > e2.getKey().length()) return -1;
            else if (e1.getKey().length() < e2.getKey().length()) return 1;
            else return e1.getKey().compareTo(e2.getKey());
        }
    }
}

public class Solution_for_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeMap<String,Integer> vocaNote = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String voca = br.readLine();
            if (voca.length() >= M) {
                if (vocaNote.containsKey(voca)) {
                    vocaNote.put(voca, vocaNote.get(voca) + 1);
                }
                else
                    vocaNote.put(voca,1);
            }
        }

        SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<Map.Entry<String, Integer>>(new VocaComparator());

        sortedset.addAll(vocaNote.entrySet());

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : sortedset)
            sb.append(entry.getKey() + "\n");
        
        System.out.println(sb);
    }
}