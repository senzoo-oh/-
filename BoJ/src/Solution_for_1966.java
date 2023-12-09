import java.io.*;
import java.util.*;

class File {
    int fileName;
    int priority;

    File(int name, int priority) {
        this.fileName = name;
        this.priority = priority;
    }
}

public class Solution_for_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int N;
        int M;

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());  // 몇번째 파일인지

            st = new StringTokenizer(br.readLine());
            
            LinkedList<File> printer = new LinkedList<>();
            
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(st.nextToken());
                printer.add(new File(j, priority));
            }
            
            File myFile = printer.get(M);

            int count = 0;
            Loop1:
            while (printer.size() != 0) {
                File currentFile = printer.remove();

                count++;

                for (File file : printer) {
                    if (currentFile.priority >= file.priority) {
                        if(currentFile.fileName == myFile.fileName) {
                        sb.append(count + "\n");
                        break Loop1;
                        }
                        else continue;
                    }
                    else printer.add(currentFile);
                }
            }
        }
        System.out.println(sb);
    }
}
