import java.nio.channels.Pipe;
import java.util.*;

/*
*  Quicksort Implementation with Five Pivot Choice techniques
*  and
*  Input Sequence Data Generator
* */


public class QuickSort

{
    int count, pivot_final;
    boolean Ins_Sort_Flag = false;

    //private int ;

    public int Partition(int[] A, int left, int right, int starting_pivot_index) {
        // int count = 0;
        //int pivot_index = p_index;
        int pivot_value = A[starting_pivot_index];

        int temp = A[starting_pivot_index];
        A[starting_pivot_index] = A[right];
        A[right] = temp;

        pivot_final = left;

        for (int i = left; i < right; i++) {
            if (A[i] <= pivot_value) {
                count++;
                temp = A[i];
                A[i] = A[pivot_final];
                A[pivot_final] = temp;
                pivot_final = pivot_final + 1;
            } else
                count++;

        }
        temp = A[pivot_final];
        A[pivot_final] = A[right];
        A[right] = temp;

        return pivot_final;

    }

    public void InsertionSort(int[] A, int left, int right) {
        // int count = 0;

        for (int i = left; i <= right; i++) {
            for (int j = i; j > left; j--) {

                if (A[j] < A[j - 1]) {
                    count++;
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                } else {
                    count++;
                    break;
                }
            }
        }

    }

    public void SortA(int[] A, int left, int right) {

        if (right - left < 5) {
            InsertionSort(A, left, right);
        } else {
            int Pivot_index = Partition(A, left, right, right);


            SortA(A, left, Pivot_index - 1);

            SortA(A, Pivot_index + 1, right);
        }

    }

    public void SortB(int[] A, int left, int right) {


        if (right - left < 5) {
            InsertionSort(A, left, right);
            return;
        } else {
            int Pivot_index = Partition(A, left, right, left);

            SortB(A, left, Pivot_index - 1);

            SortB(A, Pivot_index + 1, right);
        }

    }

    public void SortC(int[] A, int left, int right) {

        double middle = Math.floor(((right - left + 1) / 2));


        if (right - left < 5) {
            InsertionSort(A, left, right);
            return;
        } else {
            int Pivot_index = Partition(A, left, right, (int) middle + left);


            SortC(A, left, Pivot_index - 1);

            SortC(A, Pivot_index + 1, right);
        }

    }


    public void SortD(int[] A, int left, int right) {


        if (right - left < 5) {
            InsertionSort(A, left, right);
            return;

        } else {

            int dummy[] = new int[3];
            int dummy_index[] = new int[3];

            int temp, temp_index;
            dummy[0] = A[left];
            dummy[2] = A[right];
            dummy[1] = A[((int) Math.floor((right - left + 1) / 2)) + left];
            dummy_index[0] = left;
            dummy_index[1] = ((int) Math.floor((right - left + 1) / 2)) + left;
            dummy_index[2] = right;

            // InsertionSort(dummy,0,2);
            // Bubble Sort

            for (int i = 0; i < 3; i++) {
                for (int j = i; j > 0; j--) {

                    if (dummy[j] < dummy[j - 1]) {
                        count++;
                        temp = dummy[j];
                        temp_index = dummy_index[j];

                        dummy[j] = dummy[j - 1];
                        dummy_index[j] = dummy_index[j - 1];

                        dummy[j - 1] = temp;
                        dummy_index[j - 1] = temp_index;
                    } else {
                        count++;
                        break;
                    }
                }
            }

            int median_index = dummy_index[1];

            ////////////////////////

            int Pivot_index = Partition(A, left, right, median_index);

            SortD(A, left, Pivot_index - 1);

            SortD(A, Pivot_index + 1, right);
        }
    }


    public void SortE(int[] A, int left, int right) {

        if (right - left < 5) {
            InsertionSort(A, left, right);
            return;

        } else {

            int dummy[] = new int[5];
            int dummy_index[] = new int[5];

            int temp, temp_index;
            int size = right - left +1;
            dummy[0] = A[left + (int) Math.floor((1*(size)/10))];
            dummy[1] = A[left + (int) Math.floor((3*(size)/10))];
            dummy[2] = A[left + (int) Math.floor((5*(size)/10))];
            dummy[3] = A[left + (int) Math.floor((7*(size)/10))];
            dummy[4] = A[left + (int) Math.floor((9*(size)/10))];


            dummy_index[0] = left + (int) Math.floor((1*(size)/10));
            dummy_index[1] = left + (int) Math.floor((3*(size)/10));
            dummy_index[2] = left + (int) Math.floor((5*(size)/10));
            dummy_index[3] = left + (int) Math.floor((7*(size)/10));
            dummy_index[4] = left + (int) Math.floor((9*(size)/10));
          /*  dummy[0] = A[(int) (Math.floor((right - left + 1) * 0.1)) + left];
            dummy[1] = A[(int) (Math.floor((right - left + 1) * 0.3)) + left];
            dummy[2] = A[(int) (Math.floor((right - left + 1) * 0.5)) + left];
            dummy[3] = A[(int) (Math.floor((right - left + 1) * 0.7)) + left];
            dummy[4] = A[(int) (Math.floor((right - left + 1) * 0.9)) + left];


            dummy_index[0] = (int) (Math.floor((right - left + 1) * 0.1)) + left;
            dummy_index[1] = (int) (Math.floor((right - left + 1) * 0.3)) + left;
            dummy_index[2] = (int) (Math.floor((right - left + 1) * 0.5)) + left;
            dummy_index[3] = (int) (Math.floor((right - left + 1) * 0.7)) + left;
            dummy_index[4] = (int) (Math.floor((right - left + 1) * 0.9)) + left;*/


            // InsertionSort(dummy,0,2);

            for (int i = 0; i < 5; i++) {
                for (int j = i; j > 0; j--) {
                    count++;
                    if (dummy[j] < dummy[j - 1]) {


                        temp = dummy[j];
                        temp_index = dummy_index[j];

                        dummy[j] = dummy[j - 1];
                        dummy_index[j] = dummy_index[j - 1];

                        dummy[j - 1] = temp;
                        dummy_index[j - 1] = temp_index;

                    } else {

                        break;
                    }
                }
            }

            int median_index = dummy_index[2];

            ////////////////////////

            int Pivot_index = Partition(A, left, right, median_index);

            SortE(A, left, Pivot_index - 1);

            SortE(A, Pivot_index + 1, right);
        }

    }


    public int QuickSortPivotA(int[] array) {
        count = 0;

        if (array.length < 6)
            InsertionSort(array, 0, array.length - 1);

        else
            SortA(array, 0, array.length - 1);

        return count;
        /*
        Implement the quicksort with pivot as the last element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */


    }

    public int QuickSortPivotB(int[] array) {
        count = 0;
        if (array.length < 6)
            InsertionSort(array, 0, array.length - 1);

        else
            SortB(array, 0, array.length - 1);

        return count;



        /*
        Implement the quicksort with pivot as the first element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */

        //return 0;
    }

    public int QuickSortPivotC(int[] array) {

        count = 0;
        if (array.length < 6)
            InsertionSort(array, 0, array.length - 1);


            SortC(array, 0, array.length - 1);

        return count;

        /*
        Implement the quicksort with pivot as the middle element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */


    }

    public int QuickSortPivotD(int[] array) {

        count = 0;
        if (array.length < 6)
            InsertionSort(array, 0, array.length - 1);

        else
            SortD(array, 0, array.length - 1);

        return count;
        /*
        Implement the quicksort with pivot as the median of the first, middle and last elements of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        //return 0;
    }

    public int QuickSortPivotE(int[] array) {
        /*
        Implement the quicksort with pivot as the median of five elements of the sequence, chosen to be roughly 10%,
         30%, 50%, 70% and 90% of the way through the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        count = 0;
        if (array.length < 6)
            InsertionSort(array, 0, array.length - 1);

        else
            SortE(array, 0, array.length - 1);

        return count;

    }


    /*
    *
    * Implement the rest of the functions required to do the quicksort for every variation.
    * */


    public int[] GenerateInputSequence1(int N) {
        int array[] = new int[N];

        for (int i = 1; i <= N; i++)
            array[i - 1] = i;

        /*
        * return an array with the sequence 1, 2, 3, ..., N (in increasing order).
        * For example, if N = 1000, then the sequence would be: 1, 2, 3, 4, 5, ..., 1000
        * */
        return array;

    }

    public int[] GenerateInputSequence2(int N) {


        int array[] = new int[N];

        for (int i = N; i >= 1; i--)
            array[N - i] = i;
        /*
         * return an array with The sequence N, N-1, ..., 2, 1 (in decreasing order).
         * For example, if N = 1000, then the sequence would be: 1000, 999, ..., 2, 1
         * */

        return array;
    }

    public int[] GenerateInputSequence3(int N) {

        int array[] = new int[N];
        int ini_val = 1;
        int ini_val2 = 2;
        for (int index = 0; index <= N / 2 - 1; index++) {
            array[index] = ini_val;
            ini_val = ini_val + 2;
        }
        for (int index = N / 2; index < N; index++) {
            array[index] = ini_val2;
            ini_val2 = ini_val2 + 2;
        }


        /*
         * return an array with The sequence 1, 3, 5, ..., N-1, 2, 4, 6, ..., N.
         * For example,  if N = 1000, then the sequence would be: 1, 3, 5, ..., 999, 2, 4, 6, ..., 1000
         * */

        return array;
    }

    public int[] GenerateInputSequence4(int N) {

        int array[] = new int[N];
        int ini_val = 1;
        int ini_val2 = N;
        for (int index = 0; index <= N / 2 - 1; index++) {
            array[index] = ini_val;
            ini_val = ini_val + 2;
        }
        for (int index = N / 2; index < N; index++) {
            array[index] = ini_val2;
            ini_val2 = ini_val2 - 2;
        }

        /*
         * return an array with the sequence 1, 3, 5, ..., N-3, N-1, N, N-2, N-4, ..., 4, 2.
          * For example,  if N = 1000, then the sequence would be: 1,3,5 ...,997,999,1000,998,996, ..., 4,2
         * */

        return array;
    }

    public int[] GenerateInputSequence5(int N) {

        int array[] = new int[N];
        int ini_val = 1;
        int ini_val2 = N;
        for (int index = 0; index <= N - 2; index = index + 2) {
            array[index] = ini_val;
            ini_val = ini_val + 1;
        }
        for (int index = 1; index <= N - 1; index = index + 2) {
            array[index] = ini_val2;
            ini_val2 = ini_val2 - 1;
        }



        /*
         * return an array with sequence 1, N, 2, N-1, 3, N-2, 4, N-3, ..., N/2, (N/2)+1.
         * For example,  if N = 1000, then the sequence would be: 1, 1000, 2, 999, 3, 998, 4, 997, ..., 500, 501
         * */

        return array;
    }


    public int[] GenerateInputSequence6(int N) {

        int array[] = new int[N];
        array[0] = 0;

        for (int i = 1; i < N; i++) {

            array[i] = (7 + array[i - 1]) % N;
        }
        /*
         * return an array with the sequence: Each number is (7 + the previous number) mod N.
         * That is, a(i) = (7 + a(i-1)) mod N, a(0)=0
         * For example,  if N = 1000, then the sequence would be: 0, 7, 14, ..., 994, 1, 8, ..., 993
         */

        return array;

    }


    public int[] GenerateInputSequence7(int N) {
        int array[] = new int[N];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i < N; i++)

        {
            array[i] = (array[i - 1] + array[i - 2]) % N;
        }


        /*
         * return an array with The sequence: The first N Fibonacci numbers modulo N:
         * a(0) = 0; a(1) = 1; a(i) = (a(i-1) + a(i-2)) mod N for 1 < i < N.         *
         * */


        return array;
    }


    public int[] GenerateInputSequence8(int N) {
        int array[] = new int[N];
        array[0] = 1;

        for (int i = 1; i < N; i++)

        {
            array[i] = (2*array[i-1])%N;
        }

        /*
         * return an array with The sequence The first N powers of 2 modulo N:
         * a(0) = 1; a(i) = (2*a(i-1)) mod N for 0 < i < N.
         * */
        return array;
    }


    public int[] GenerateInputSequence9(int N) {

        int array[] = new int[N];
        //array[0] = 1;

        array[0] = 1;

        for (int i = 1; i < N; i++)

        {
            array[i] = (3*array[i-1])%N;
        }

        /*
         * return an array with The sequence: The first N powers of 3 modulo N:
         * a(0) = 1; a(i) = (3*a(i-1)) mod N for 0 < i < N.
         * */
        return array;
    }


    public int[] GenerateInputSequence10(int N, int RNG_Seed) {

        Random generator = new Random();
        generator.setSeed(RNG_Seed);

        int array[] = new int[N];

        for (int i = 0; i < N; i++)

        {
            array[i] = generator.nextInt() % 10000;
        }
        /*
         * return an array with The sequence N, N-1, ..., 2, 1 (in decreasing order).
         * A random sequence using the methods in java.util.Random: Use setSeed(long seed) to set the seed using
         * a nine-digit which will be an input to your method. Use nextInt()%10000 N times to get N random integers
          * between -9999 and 9999.  Use these in the order generated as the sequence.
          * Example:Random generator = new Random();
          * generator.setSeed(123456789);   // 123456789 is example, seed will be input
          * int num = generator.nextInt()%10000; // will be called N times to complete the sequence
          * */
        return array;
    }


    public static void main(String[] args) {

        int A[] = {1,1,1,1};
        int B[] = {1,2,3,4};

        QuickSort qs = new QuickSort();
        int example[]=qs.GenerateInputSequence10(1000,123456789);


        //System.out.println("A:"+qs.QuickSortPivotA(example));
        //System.out.println("B:"+qs.QuickSortPivotB(example));
      // System.out.println("C:"+qs.QuickSortPivotC(example));
        //System.out.println("D:"+qs.QuickSortPivotD(example));
      //  System.out.println("E:"+qs.QuickSortPivotE(example));

        System.out.println(qs.QuickSortPivotA(B));
        System.out.println(qs.QuickSortPivotB(A));


        //  int B[]= qs.GenerateInputSequence4(10);
        // int A[]= qs.GenerateInputSequence4(6);
        // int C[]= qs.GenerateInputSequence5(6);


        /*
        You can test you implementation of the quicksort here.
        Please do not change the function names as we will use them to
        grade your work.
        */
    }
}