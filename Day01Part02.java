import java.util.*;
public class Day01Part02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        while(sc.hasNext()){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            arr.add(n1);
            hm.put(n2, hm.getOrDefault(n2, 0)+1);
        }
        
        int sim_score = 0;
        for(Integer n : arr){
            sim_score = sim_score + n*hm.getOrDefault(n, 0);
            
        }
        System.out.println(sim_score);
    }
}
