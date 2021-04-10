import java.util.Stack;

public class Solution2 {
    public int[] xiaoxiaole(int[] array){
        for(int i=0;i<array.length-1;i++){
            if(array[i]+array[i+1]==10){
                delAnyPosition(array,i);
                delAnyPosition(array,i+1);
            }
        }
        return array;
    }
    public static int[] delAnyPosition(int[] arr,int position){
        if(position >= arr.length || position < 0){
            return null;
        }
        int[] res = new int[arr.length - 1];
        for(int i = 0;i<res.length;i++){
            if(i < position){
                res[i] = arr[i];
            }else{
                res[i] = arr[i + 1];
            }
        }
        return res;
    }
}
