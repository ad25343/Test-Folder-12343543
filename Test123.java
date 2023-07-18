import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PercentileDisc {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int n = 1; n <= 10; n++) {
            numbers.add(n);
        }
        Collections.sort(numbers);

        double percentile = calculatePercentile(numbers, 0.5);
        System.out.println("50th percentile: " + percentile);
    }

    private static double calculatePercentile(List<Integer> numbers, double percentile) {
        int n = numbers.size();
        double rank = percentile * (n - 1) + 1;

        int k = (int) Math.floor(rank);
        double d = rank - k;

        int index = k - 1;
        int value = numbers.get(index);

        if (d == 0) {
            return value;
        } else {
            int nextValue = numbers.get(index + 1);
            return value + d * (nextValue - value);
        }
    }
}
