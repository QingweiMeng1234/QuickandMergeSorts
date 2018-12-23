public class QuickSort {
    //cannot do it this way because used extra spaces
//    int lp; // leftpointer
//    int rp; // rightpointer

//    public int[] getfirstarr (int[] a, int pivot){
//        System.out.println("f");
//        int index = 0;
//        for (int i = 0; i <a.length ; i++) {
//            if(a[i]==pivot){
//                index = i;
//            }
//        }
//        int[] arr = new int[index];
//        for (int i = 0; i <index ; i++) {
//            arr[i]=a[i];
//        }
//        return arr;
//    }
//
//    public int[] getsecondarr(int[]a, int pivot){
//        System.out.println("s");
//        if(a.length==pivot){
//            return new int[]{};
//        }
//        int index = 0;
//        for (int i = 0; i <a.length ; i++) {
//            if(a[i]==pivot){
//                index = i;
//            }
//        }
//        int[] arr = new int[a.length-index];
//        for (int i = index+1; i <a.length ; i++) {
//            arr[i]=a[i];
//        }
//        return arr;
//    }
//
//
//    public int[] quicksort(int[] a) {
//        if(a.length==1){
//            System.out.println("pass");
//            return a;
//        }
//        System.out.println("a");
//        lp = a[1];
//        rp = a[a.length - 1];
//        while (lp < a.length && rp > -1 && lp <= rp) {
//            while (a[lp] <= a[0]) {
//                lp++;
//            }
//
//            while (a[rp] >= a[0]) {
//                rp--;
//            }
//            int temp = a[lp];
//            a[lp] = a[rp];
//            a[rp] = temp;
//        }
//
//        int temp = a[0];
//        a[0] = a[rp];
//        a[rp] = temp;
//
//       toString(a);
//        quicksort(getfirstarr(a,a[rp]));
//        quicksort(getsecondarr(a,a[rp]));
//
//        return a;
//    }

    //this method returns the pivot's location
//    public int pivot(int[] arr, int left, int right) {
//        // i is the left pointer, j is the right pointer.
//        int i = left + 1;
//        int j = right;
//
//        //application of while true: break by inner conditions. You have to make it "while true" instead of put j>= i into the while condition because
//        // you want to j move an extra place after equal.
//        int pivot = arr[left];
//
//        while (true) {
//            while (arr[i] < pivot) {
//                System.out.println(arr[i]);
//                i++;
//                if (i==right) {
//                    break;
//                }
//            }
//
//            while (arr[j] > pivot) {
//                j--;
//                if (j==left) {
//                    break;
//                }
//            }
//            if(i>=j){
//                break;
//            }
//
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//
//        }
//
//        int temp = arr[left];
//        arr[left] = arr[j];
//        arr[j] = temp;
//
//        return j;
//
//    }
//
//    public int[] sort(int[] arr){
//         sort(arr,0, arr.length-1);
//         return arr;
//    }
//
//    public void sort(int[] arr, int left, int right) {
//        System.out.println(toString(arr));
//        if (right<=left)
//            return;
//
//            int j = pivot(arr, left, right);
//
//            sort(arr, left, j - 1);
//            sort(arr, j + 1, right);
//
//    }

    // Practice for previous code
    public int pivot (int[] a, int left, int right){
        int i = left+1;
        int j = right;

        int pivot = a[left];
        // conditions to break the loop
        while (true){
            while(pivot>=a[i]){
                i++;
                if(i==right){
                    break;
                }
            }

                while (pivot<=a[j]){
                    j--;
                    if(j==left){
                        break;
                    }
                }

                if(i>=j)
                    break;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

            }

            int temp = a[left];
            a[left] = a[j];
            a[j] = temp;

            return j;

        }

        public void sort(int[] arr, int left, int right){
        if(right<=left) return;
        int j = pivot(arr,left,right);
        sort(arr,left,j-1);
        sort(arr,j+1,right);

        }

        public int[] sort(int[] arr){
        sort(arr,0, arr.length-1);
        return arr;
        }


    public static String toString(int[] a) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            s.append(a[i] + " ");

        }
        return s.toString();
    }

    public static void main(String[] args) {
        int[] test = new int[]{6,1,23,12,512,1,3,4,9,6,56,88,554,32,23};
        QuickSort qs = new QuickSort();
        System.out.println(toString(qs.sort(test)));


    }

}
