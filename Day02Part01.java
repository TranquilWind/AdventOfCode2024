import java.util.*;

public class Day02Part01{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> reports = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                break; 
            }
            reports.add(line);
        }
        int safeCount = countSafeReports(reports);
        System.out.println(safeCount);
    }
    public static int countSafeReports(List<String> reports) {
        int safeCount = 0;
        for (String report : reports) {
            int[] levels = Arrays.stream(report.split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            if (isSafe(levels)) {
                safeCount++;
            }
        }
        return safeCount;
    }
    public static boolean isSafe(int[] levels) {
        if (levels.length < 2) return true;
        boolean shouldInc = levels[1] > levels[0];
        int prev = levels[0];
        for (int i = 1; i < levels.length; i++) {
            int diff = levels[i] - prev;
            if (shouldInc) {
                if (diff <= 0 || diff > 3) return false;
            } else {
                if (diff >= 0 || diff < -3) return false;
            }
            prev = levels[i];
        }
        return true;
    }

}