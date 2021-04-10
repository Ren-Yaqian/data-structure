import java.util.Arrays;

public class Solution {
    public int[] BinaryTree1(int[] nums) {
        int len=nums.length;
        int n=0;
        int sum=0;
        while(sum<=len){
            for(int i=1;i<len;i++){
                sum +=i*i;
            }
            int d=len-sum;
        }
        nums = Arrays.copyOfRange(nums, 0, sum);
        for(int i=0;i<sum;i++){
            System.out.println(nums[i]);
        }
        return nums;
    }

//    public static void Arrayprint(int[]nums){
//        for(int i = 0;i<nums.length;i++){
//            System.out.print(nums[i]+",");
//        }
//
//    }
//
//    public static void main(String[] args) {
//        int arr[]={1,2,3,4,5,6,7,8};
//        BinaryTree1(arr);
//    }
}
