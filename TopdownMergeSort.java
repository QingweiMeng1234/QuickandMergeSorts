public class TopdownMergeSort {
    // has the same merge as the BottomupMergeSort
    public static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
        //first, copy all the elements from the original two subarrays into one.
        //lo-mid is the first subarray, mid+1-hi is the second subarray.
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        // then do the pointers, i is the beginning of the left subarray, j is the beginning of the right subarray.
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j];
                j++;
            }else if(j>hi){
                arr[k] = aux[i];
                i++;
            }else if(aux[i]<aux[j]){
                arr[k] = aux[i];
                i++;
            }else{
                arr[k] = aux[j];
                j++;
            }
        }
    }

    public static void sort(int[] arr, int []aux, int lo, int hi){
        if(hi<=lo) return;

        int mid = lo + (hi-lo)/2;

        sort(arr,aux,lo,mid);

        sort(arr,aux,mid+1,hi);

        merge(arr,aux,lo,mid,hi);
    }

    public static int[] sort(int[] arr){
        int[] aux = new int[arr.length];
        sort(arr,aux,0,arr.length-1);
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

