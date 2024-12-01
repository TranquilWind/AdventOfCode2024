import java.util.*;
public class Day01Part01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        while(sc.hasNext()){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            arr1.add(n1);
            arr2.add(n2);
        }
        Collections.sort(arr1);
        Collections.sort(arr2);
        int n = 0;
        for(int i=0; i<arr1.size(); i++){
            n = n+ Math.abs(arr1.get(i)-arr2.get(i));
        }
        System.out.println(n);
    }
}
