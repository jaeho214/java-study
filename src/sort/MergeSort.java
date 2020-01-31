package sort;
/*
 * 재귀함수 호출을 통해서 더이상 쪼갤 수 없을 때까지 쪼개고 병합을 하는 과정에서 정렬을 하는 방법
 * Worst : O(nlogn)
 * Best  : O(nlogn)
 * Avg   : O(nlogn)
 */
public class MergeSort {
    private static int[] sorted; // 임시 배열 필요
    public static void main(String[] args) {
        int arr[] = {3,6,54,25,33,57,888,1};
        sorted = new int[arr.length];
        print(arr);
        sort(arr, 0, arr.length-1);
        print(arr);
    }


    private static void print(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    //병합 정렬
    private static void sort(int[] arr, int left, int right) {
        int mid;

        if(left < right){
            mid = (left + right) / 2;
            //recursion 으로 계속 분할
            sort(arr, left, mid);
            sort(arr, mid+1, right);
            //분할하여 정렬한 것을 합침
            merge(arr, left, mid, right);
        }

    }

    //병합
    private static void merge(int[] arr, int left, int mid, int right){
        int i = left; //첫번째 부분 집합의 시작위치 설정
        int j = mid+1; //두번째 부분 집합의 시작위치 설정
        int k = left; // 배열 sorted 에 정렬된 원소를 저장할 인덱스

        //두개의 배열을 sorted 에 이어 붙여서 저장
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j])
                sorted[k++] = arr[i++];
            else
                sorted[k++] = arr[j++];
        }

        //홀수인 경우 하나가 남으니까 나머지 이어주는 작업
        if(i > mid){
            for(int l=j; l<=right; l++)
                sorted[k++] = arr[l];
        }else{
            for(int l=i; l<=mid; l++)
                sorted[k++] = arr[l];
        }

        //정렬이 된 sorted 배열을 arr 로 copy
        for(int l=left;l<=right;l++)
            arr[l] = sorted[l];
    }
}
