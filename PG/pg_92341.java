import java.io.*;
import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Info {
    boolean inOrOut;
    String inTime;
    String outTime;
    long totalTime;
    int totalFees;
    
    // 첫 고객일때 생성자
    public Info(boolean inOrOut, String inTime) {
        this.inOrOut = inOrOut;
        this.inTime = inTime;
    }
}

class CarComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        return num1-num2;
    }
}

public class pg_92341 {


    // 시간차이 계산하는 메서드
    public static long findDiffTime(String inTime, String outTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
        
        Date in = sdf.parse(inTime);
        Date out = sdf.parse(outTime);
        
        return (out.getTime() - in.getTime()) / (1000*60);
    }

    public static void main(int[] fees, String[] records) throws ParseException {
        TreeMap<Integer, Info> data = new TreeMap<>(new CarComparator());
        StringTokenizer st;
        
        for (String record : records) {
            // 차량기록 분해해서 저장함.
            st = new StringTokenizer(record);
            String time = st.nextToken();
            Integer carNum = Integer.parseInt(st.nextToken());
            String status = st.nextToken();
            
            // 주차장 이용 첫 고객이라면 -> 입차 -> 등록
            if (!data.containsKey(carNum)) {
                data.put(carNum, new Info(true, time));
            }
            
            // 이미 한번 이용한 고객 -> 입차인지 출차인지 확인
            else {
                Info car = data.get(carNum);
                
                // 출차하는 차량일 경우 -> 시간계산
                if (car.inOrOut) {
                    car.inOrOut = false;
                    car.outTime = time;
                    car.totalTime += findDiffTime(car.inTime, car.outTime);
                }
                
                // 입차하는 차량일 경우
                else {
                    car.inOrOut = true;
                    car.inTime = time;
                }
            }
        }
        
        int index = 0;
        int[] answer = new int[data.size()];
        for (Map.Entry<Integer,Info> entry : data.entrySet()) {
            Info car = entry.getValue();
            
            // 23:59에 출차한 차량인경우
            if (car.inOrOut) car.totalTime += findDiffTime(car.inTime, "23:59");
            
            if (car.totalTime <= fees[0])
                car.totalFees = fees[1];
            else
                car.totalFees = fees[1] + (int)(Math.ceil((car.totalTime - fees[0])/fees[2])) * fees[3];
            
            answer[index] = car.totalFees;
            index++;
        }
        System.out.println(Arrays.toString(answer));
        //return answer;
    }
}