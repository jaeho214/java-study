package sort;
/*
 * 임의로 하나의 Key 를 정해놓고 Key 보다 큰 값들을 뒤로 밀고 key 보다 작은 값 바로 뒤에 key 를 삽입하는 방법을 반복하며 정렬하는 방법
 * Worst : O(n^2)
 * Best  : O(n)
 * Avg   : O(n^2)
 */
public class InsertionSort {
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
        int j;
        for(int i=0;i<arr.length;i++){
            //현재 값을 key 로 지정해놓고
            int key = arr[i];
            //키의 바로 앞에서부터 왼쪽으로 가면서 key 값보다 큰 값이 있다면
            for(j=i-1;j>=0 && key < arr[j];j--){
                //key 값 자리에 작은 값들을 넣고
                arr[j+1] = arr[j];
            }
            //최종적으로 앞에다가 key 값을 넣어줌
            arr[j+1] = key;
        }
    }

}
