import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        long[] arr={3,4,2,1,7,5,9};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(long[] array) {
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(array[j]<array[j-1]){
                    long temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
    }
}
