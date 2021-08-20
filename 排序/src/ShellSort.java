public class ShellSort {
    public static void main(String[] args) {
        int[] arr={3,4,2,1,7,5,9};
        shellSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    public static void shellSort(int[] array) {
        int group=array.length;
        while(true){
            group=group/2;
            for(int k=0;k<group;k++){
                for(int i=k+group;i<array.length;i+=group){
                    for(int j=i;j>k;j-=group){
                        if(array[j]<array[j-group]){
                            int temp=array[j];
                            array[j]=array[j-group];
                            array[j-group]=temp;
                        }
                    }
                }
            }
            if(group==1){
                break;
            }
        }
    }
}
