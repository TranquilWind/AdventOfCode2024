import java.util.*;

public class Day02Part02 {
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
            if (isSafeWithDampener(levels)) {
                safeCount++;
            }
        }
        return safeCount;
    }
    public static boolean isSafeWithDampener(int[] levels) {
        if (isSafe(levels)) return true;
        for (int i = 0; i < levels.length; i++) {
            int[] modifiedLevels = new int[levels.length - 1];
            int index = 0;
            for (int j = 0; j < levels.length; j++) {
                if (j != i) {
                    modifiedLevels[index++] = levels[j];
                }
            }
            if (isSafe(modifiedLevels)) {
                return true;
            }
        }
        
        return false;
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
