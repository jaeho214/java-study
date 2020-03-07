package datastructure.sort;
/*
 * 일정한 간격으로 떨어져있는 자료들끼리 집합을 만들어 각각의 집합 내에서 삽입정렬을 수행하는 작업을 반복하여 정렬하는 방식
 * 이때 간격은 원소 개수의 1/2 로 시작을 해서 계속 반으로 줄여감
 * Worst : O(n^2)
 * Best  : O(n)
 * Avg   : O(n^1.5)

 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = {3,6,54,25,33,57,888,1};
        print(arr);
        sort(arr, arr.length);
        print(arr);
    }


    private static void print(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void sort(int[] arr, int length) {
        int interval = length/2;
        while(interval >= 1){
            for(int i=0;i<interval;i++){
                intervalSort(arr, i, length-1, interval);
            }
            interval /= 2;
        }
    }

    private static void intervalSort(int[] arr, int begin, int end, int interval) {
        int j;
        //interval 간격마다 비교
        for(int i=begin+interval; i<=end;i += interval){
            //값을 item에 넣어놓고
            int item = arr[i];
            //interval 간격만큼 떨어진 데이터들을 비교하다가 item 보다 크면
            for(j = i-interval; j>=begin && item<arr[j]; j -= interval){
                //item 자리에 그 값을 넣고
                arr[j+interval] = arr[j];
            }
            //그 값이 있던 자리에 item 을 넣어준다 즉, swap 해준거
            arr[j+interval] = item;
        }
    }
}
