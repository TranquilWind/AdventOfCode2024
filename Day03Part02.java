import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03Part02 {
    public static void main(String[] args) {
        try {
            String line = Files.readString(Paths.get("./day_03.in")).trim();
            Pattern p = Pattern.compile("(?:mul\\((\\d+),(\\d+)\\))|(do\\(\\)|don't\\(\\))");
            Matcher m = p.matcher(line);
            
            boolean enabled = true;
            int ans = 0;
            while (m.find()) {
                String controlGroup = m.group(3);
                
                if (controlGroup == null && enabled) {
                    int num1 = Integer.parseInt(m.group(1));
                    int num2 = Integer.parseInt(m.group(2));
                    ans += num1 * num2;
                } else if (controlGroup != null) {
                    enabled = controlGroup.equals("do()");
                }
            }
            
            System.out.println(ans);
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
