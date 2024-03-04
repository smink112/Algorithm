import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Float> scoreBoard = new HashMap<>();

    public static void main(String[] args) throws IOException {
        scoreBoard.put("A+", 4.5f);
        scoreBoard.put("A0", 4.0f);
        scoreBoard.put("B+", 3.5f);
        scoreBoard.put("B0", 3.0f);
        scoreBoard.put("C+", 2.5f);
        scoreBoard.put("C0", 2.0f);
        scoreBoard.put("D+", 1.5f);
        scoreBoard.put("D0", 1.0f);
        scoreBoard.put("F", 0.0f);
        float totalTime = 0.0f;
        float totalScore = 0.0f;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String subjectName = st.nextToken();
            float lectureTime = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();
            Subject subject = new Subject(subjectName, lectureTime, grade);

            if (!subject.grade.equals("P")) {
                for (Entry<String, Float> entry : scoreBoard.entrySet()) {
                    if(entry.getKey().equals(subject.grade)){
                        totalScore += (entry.getValue() * subject.lectureTime);
                        totalTime += subject.lectureTime;
                    }
                }
            }

        }
        System.out.println(totalScore/totalTime);


    }

}

class Subject {

    String subject;
    float lectureTime;
    String grade;

    public Subject(String subject, float lectureTime, String grade) {
        this.subject = subject;
        this.lectureTime = lectureTime;
        this.grade = grade;
    }
}