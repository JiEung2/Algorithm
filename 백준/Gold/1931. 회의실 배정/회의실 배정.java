import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Meeting implements Comparable<Meeting>{
        int start, finish;

        public Meeting(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.finish == o.finish) {
                return this.start - o.start; // 시작 시간 기준 오름차순
            }
            return this.finish - o.finish;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings);

        int result = 0;
        int lastFinishTime = 0;

        for (Meeting meeting : meetings) {
            if (meeting.start >= lastFinishTime) {
                result++;
                lastFinishTime = meeting.finish;
            }
        }

        System.out.println(result);
    }
}
