import java.util.*;
public class ZeroSumSubarrays{
    static void findSubarrays(int[] arr){
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        int sum = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        for(int i=0; i< arr.length; i++){
            sum += arr[i];
        if(map.containsKey(sum)){
            for( int startIndex : map.get(sum)){
                result.add(new int[] {startIndex + 1,1});
            }
        }
        map.computeIfAbsent(sum, k-> new ArrayList<>()).add(i);
        }
        if(result.isEmpty()){
            System.out.println("No subarrays with zero sum found.");
        }else{
            System.out.println("Subarrays with zero sum:");
            for(int[] pair : result){
                System.out.println("From index " + pair[0] + " to " + pair[1]);
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {3,4,-2,1,3,-4};
        findSubarrays(arr);
    }
}