public class TRAI_26_X1_prakigov implements TRAI_26_X1 {
    /**
     *  SELF-EVALUATION HERE:
     * The logic involves searching within the same array using a nested-for loop.
     * The outer loop verifies its iterator variable against entire array using the inner loop iterator variable.
     * Based on the logic, the process identifies any duplicates and returns true, else false.
     * If array length is one or zero, there is no possibility for duplicates hence false is returned which is
     * validated in the entry point.
     **/

    /**
     * Does an array have duplicate(s) or not?
     *
     * If all integers of the array are distinct
     * (or there are only 0 or 1 elements), return false.
     * If some integer(s) occurs two or more times, return true.
     * You may assume all elements to be proper values (not nulls).
     *
     * @param A Input array
     * @return true if some element occurs at least two times, otherwise false
     */
    @Override
    public boolean haveDuplicates(Integer[] A) {
        if (A.length > 1) {
            for  (int i = 0; i < A.length; i++) {
                for (int j = i+1; j < A.length; j++) {
                    if (A[i] == A[j]) {
                        return true;
                    }
                }
            }
        }
        // If no duplicates are found and if the array length <= 1
        return false;
    }
}
