package datastructure.sort;
/*
 * 현재 값과 바로 다음 값을 비교하면서 정렬하는 방법
 * Worst : O(n^2)
 * Best  : O(n^2)
 * Avg   : O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,6,54,25,33,57,888,1};
        print(arr);
        sort(arr);
        print(arr);
    }

    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            //1회 정렬시 가장 큰 값이 맨 뒤로 감
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void print(int[] arr){
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}
