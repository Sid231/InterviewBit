import java.util.HashMap;
import java.util.Map;

public class TestColelctions {
    
    public static void main(String s[]){
      TestColelctions t = new TestColelctions();
      int[] arr = {-4,-2,-1,-1,0,1,2,4,4};
      twoSum(arr,0);
    }
    
    public static void twoSum(int[] arr,int target) {
      
      Map<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
      for(int i=0; i<arr.length; i++){
        if(sumMap.isEmpty() || !sumMap.containsKey(arr[i])){
          sumMap.put(arr[i], 1);
        }else{
          sumMap.put(arr[i], sumMap.get(arr[i])+1);
        }
      }
      for(int i=0; i<arr.length-2; i++){
        if(i>0 && arr[i] == arr[i-1]) continue;
        for(int j=i+1; j<arr.length-1; j++){
          if(j>i+1 && arr[j] == arr[j-1]) continue;
          int search = target - arr[i] - arr[j];
          if(sumMap.containsKey(arr[i]) && sumMap.get(arr[i])>0) sumMap.put(arr[i], sumMap.get(arr[i])-1);
          if(sumMap.containsKey(arr[j]) && sumMap.get(arr[j])>0) sumMap.put(arr[j], sumMap.get(arr[j])-1);
            if(arr[j]<=search && sumMap.containsKey(search) && sumMap.get(search)>0){
              System.out.println(arr[i]+" "+arr[j]+" "+search);
              sumMap.put(search, sumMap.get(search)-1);
            }
            if(sumMap.containsKey(arr[i])) sumMap.put(arr[i], sumMap.get(arr[i])+1);
          if(sumMap.containsKey(arr[j])) sumMap.put(arr[j], sumMap.get(arr[j])+1);
        }
      }
    }
}
