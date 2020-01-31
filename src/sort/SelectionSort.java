package sort;

/*
 * 정렬하고자 하는 배열의 최소값을 찾아 swap 하는 방식을 반복하여 정렬하는 방법
 * 최소값을 찾는데에만 n^2 만큼 걸림
 * Worst : O(n^2)
 * Best  : O(n^2)
 * Avg   : O(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {3,6,54,25,33,57,888,1};
        print(arr);
        sort(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void sort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for(int j=i;j<arr.length;j++){
                if(min > arr[j]){
                    min = arr[j];
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }
}
