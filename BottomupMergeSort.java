public class BottomupMergeSort {

    //this method merges two sorted subarrays into one sorted array
    // lo is the leftmost element of the left subarray
    // mid is the end of the left subarray
    // hi is the end of right subarray.
    public static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {

        //copy those two partitions into one unsorted partition.
        for (int k = lo; k <=hi; k++) {
            aux[k] = arr[k];
        }

        // i is the pointer for the left subarray while j is the pointer for the right.
        int i = lo;
        int j = mid + 1;


        for (int k = lo; k <=hi; k++) {

            if (j > hi) {
                arr[k] = aux[i];
                i++;
            } else if (i > mid) {
                arr[k] = aux[j];
                j++;
            } else if (aux[j] < aux[i]) {
                arr[k] = aux[j];
                //++: I put an element in, get to the next one.
                j++;
            } else {
                arr[k] = aux[i];
                i++;
            }

        }

    }

    public static int[] sort(int[] arr) {
        //len refers to the length of subarrays
        int[] aux = new int[arr.length];
        for (int len = 1; len < arr.length; len *= 2) {

            for (int lo = 0; lo < arr.length - len; lo += 2 * len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, arr.length - 1);
                merge(arr,aux,lo,mid,hi);
            }
            toString(arr);
        }
        return arr;
    }

    static String toString(int[] a){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <a.length ; i++) {
            s.append(a[i] + " ");
        }
        System.out.println(s.toString());
        return s.toString();
    }
    public static void main(String[] args) {
        int[] myarray = new int[]{ 3, 7, 1, 8, 20, 34, 5, 6 };
        sort(myarray);
        for (int i=0; i<myarray.length; i++) {
            System.out.format("%d, ", myarray[i]);
        }
    }

}
