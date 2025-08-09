
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9,5,7,3,2,4,2,1,1,0,9};

        for(int i=0; i<arr.length-1; i++){
            for(int j=j=0; j<arr.length-i-1; j++){
                if(arr[j] >  arr[j+1]){
                    tools.swap(arr, j, (j+1));
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
