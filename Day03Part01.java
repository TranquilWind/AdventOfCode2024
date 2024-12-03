import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Day03Part01 {
    public static void main(String args[]){
        int total = 0;
        String reg = "mul\\(([0-9]{1,3}),([0-9]{1,3})\\)";
        Pattern p = Pattern.compile(reg);
        String ip = "Your test case";
        Matcher m = p.matcher(ip);
        while(m.find()){
            int firstNumber = Integer.parseInt(m.group(1));  
            int secondNumber = Integer.parseInt(m.group(2));
            tot = tot + firstNumber*secondNumber;
        }
        System.out.println(tot);
        
    }
}
