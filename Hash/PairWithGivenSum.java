import java.util.*;
public class PairWithGivenSum {
    static void checkPair(int[] arr, int target){
        Set<Integer> seen = new HashSet<>();
        boolean found = false;

        for(int num : arr){
            int complement = target - num;

            if(seen.contains(complement)){
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                found = true;
            }
            seen.add(num);
        }
        if(!found){
            System.out.println("No pair found with sum "+target);
        }
    }
    public static void main(String[] args){
        int[] arr = {8,7,2,5,4,1};
        int target = 20;

        checkPair(arr, target);
    }
}
