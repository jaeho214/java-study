package datastructure.sort;
/*
 * 리스트 가운데에서 pivot을 선정하고 pivot의 왼쪽에선 pivot보다 큰 값을 찾고 오른쪽에선 pivot보다 작은 값을 찾는다.
 * 둘다 찾으면 그 둘을 swap하고 찾는 두 인덱스가 엇갈리게 되면 즉 left > right 가 되면 정렬을 탐색을 끝낸 후 다시 pivot을 정하여 이 작업을 반복하여 정렬하는 방법
 * Worst : O(n^2)
 * Best  : O(n log n)
 * Avg   : O(n log n)
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {3,6,54,25,33,57,888,1};
        print(arr);
        sort(arr, 0, arr.length-1);
        print(arr);
    }


    private static void print(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void sort(int[] arr, int l, int r) {
        int left = l;
        int right = r;
        int pivot = arr[(l+r)/2];

        do{
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;
            if(left <= right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);

        if(l < right) sort(arr, l, right); // 피벗의 왼쪽을 다시 정렬하고
        if(r > left) sort(arr, left, r); // 피벗의 오른쪽을 다시 정렬
    }
}
