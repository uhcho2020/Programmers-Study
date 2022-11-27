
import java.util.*;
import java.io.*;

public class Main_17245 { // 서버실
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long sum = 0;
        int high=0;
        // int n = 5;
        // int[] computers = { 1,4,0,2,1, 0,0,5,6,3, 8,4,7,2,0, 7,1,0,5,3, 4,5,7,9,1 };
        int n = Integer.parseInt(br.readLine());
  
        int[] computers = new int[n * n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                computers[j+n*i] = Integer.parseInt(st.nextToken());
                sum += computers[j+n*i];
                if(high<computers[j+n*i]){
                    high=computers[j+n*i];
                }
            }
        }
        // Arrays.sort(computers);
        // long[] floor = new long[computers[n * n - 1]]; // 층마다 누적
        // for (int j = 0; j < computers.length; j++) {
        //     if (computers[j] > 0) {
        //         floor[0]++;
        //         computers[j]--;
        //     }
        // }
        // for (int i = 1; i < floor.length; i++) {
        //     floor[i] = floor[i - 1];
        //     for (int j = 0; j < computers.length; j++) {
        //         if (computers[j] > 0) {
        //             floor[i]++;
        //             computers[j]--;
        //         }
        //     }
        // }
        // long target;
        // if (sum % 2 == 0)
        //     target = sum / 2;
        // else
        //     target = sum / 2 + 1;
        // System.out.println("sum: " + sum + " / target: " + target);
        // for (int i = 0; i < floor.length; i++) {
        //     System.out.print(i + 1 + "층(" + i + ")까지 누적: " + floor[i] + " / ");
        // }
        // System.out.println();
        int low = 0;
        // int high = floor.length - 1;
        int mid;
        // int answer = 0;
        while (low +1< high) {
            mid = (low + high) / 2;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (computers[j+n*i] > mid) {
                        cnt += mid;
                    } else {
                        cnt += computers[j+n*i];
                    }
                }
            }

            if (((double) cnt / sum) >= 0.5) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(high);
    }
}