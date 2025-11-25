import java.util.*;
public class TwoSum {
    static int[] findTwoSum(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(arr[i],1);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args){
        int[] arr = {2,7,11,15};
        int target = 9;

        int[] result = findTwoSum(arr, target);
        if(result[0] != -1){
             System.out.println("Pair found at indices: " + result[0] + " and " + result[1]);
        }else{
            System.out.println("No pair found with the given sum.");
        }
    }
}
