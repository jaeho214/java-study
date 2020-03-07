package datastructure.sort;
/*
 * 힙 자료구조를 기반으로 한 정렬 방식.
 * 최대 힙을 구성하고, 현재 힙의 루트는 가장 큰 값이 존재하고 루트의 값을 마지막 요소와 바꾼 후 힙의 사이즈를 하나 줄인다.
 * 힙의 사이즈가 1보다 크면 위 과정을 반복하여 정렬하는 방법
 * Worst : O(n log n)
 * Best  : O(n log n)
 * Avg   : O(n log n)
 */
public class HeapSort {
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
        int n = arr.length;
        for(int i=n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }

        for(int i=n-1;i>0;i--){
            //루트 노드를 삭제하고 마지막 노드를 루트로 올림
            swap(arr, 0, i);
            //다시 힙으로 구성
            heapify(arr, i, 0);
        }
    }

    //힙을 구성하는 메소드
    private static void heapify(int[] arr, int n, int i) {
        int root = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if(left < n && arr[root] < arr[left])
            root = left;

        if(right < n && arr[root] < arr[right])
            root = right;

        if(i != root){
            swap(arr, root, i);
            heapify(arr, n, root);
        }

    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
