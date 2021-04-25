package test5;

import java.util.Arrays;

/**
 * @author fangsheng
 * @date 2021/4/21 下午4:57
 */
public class T3 {
    public static void main(String[] args) {
        int[] scores = new int[]{88, 77, 51, 66};
        Score s = new Score(scores);
        s.printScores();
        scores[2] = 99;
        s.printScores();
    }
}

class Score {
    private int[] scores;

    public Score(int[] scores) {
        this.scores = new int[scores.length];
//        this.scores = scores;
        System.arraycopy(scores, 0, this.scores, 0, this.scores.length);
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }

}