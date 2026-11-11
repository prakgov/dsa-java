import java.util.LinkedList;
import java.util.ListIterator;

public class TRAI_26_X3_prakigov implements TRAI_26_X3 {

    /**
     * SELF-EVALUATION HERE:
     * Key lesson was that pseudo code and coding syntax always do not match and the logic of the solution sometimes gets twisted during implementation.
     * aCurrent had to move backward to follow the pseudocode logic (if/else-if) for comparison == 0, to skip the duplicates between A and B.
     * Understanding how the ListIterator and its methods next() and previous() can be used was key to implementing the solution correctly since I failed multiple times to understand the implementation logic in handling duplicates.
     * 'hasBcurrent' flag was added during implementation and was not part of the pseudocode, but was necessary to handle the case when A is empty or when A runs out of elements before B.
     * Overall, pseudocode is only half the solution, and the implementation logic is equally important to build a working algorithm.
     */


    /**
     * Add new elements to a sorted list.
     * Adds to list A such elements of B that are not in A originally.
     * Boths lists are sorted and the list A also remains sorted.
     * @param A sorted list to which elements are added
     * @param B sorted list whose elements are added if they are not originally in list A
     * @param <E> element type
     */
    @Override
    public <E extends Comparable<? super E>> void addNew(LinkedList<E> A, LinkedList<E> B) {
      // hints: adding to A is fast using an iterator, A and B are sorted
      
      /* 
      // PSEUDOCODE:
      aCurrent, bCurrent = ListIterators for A and B
        while bCurrent.hasNext:
          b = bCurrent.next();
          hasBcurrent = false;
          while aCurrent.hasNext:
            a = aCurrent.next();
            if a == b:
              aCurrent.previous();
              hasBcurrent = true;
              break;
            else if a > b:
              aCurrent.previous();
              insert b at aCurrent;
              hasBcurrent = true;
              break;
            else if a < b:
              continue;
          if !hasBcurrent:
            insert b at aCurrent;
        return A;
    
     // EDGE CASES:
      * if A, B have same elements	     -->	return A as is
    * if A is empty				               -->	insert all elements from B to A
      * if B is empty				             --> return A as is
      * if b is smaller than all of A    --> insert b at the front of A
      * if b is larger than all of A     --> A runs out, insert b at the end
      * if B has duplicates of an A element   --> skipped (step back on match)
      * if B has duplicates not in A     --> all copies are added
      
     // COMPLEXITY:
      * TIME - O(n+m) where n = size of A,  m = size of B, since all elements of B are traversed and each element of A is traversed at most once. Also since both lists are sorted and we use only A.add(x) instead of A.add(index, x), the time complexity is linear.
      * SPACE - O(1) since no additional data structures are used, only iterators and a flag variable.
     
     */

      // intialize iterators for both lists
      ListIterator<E> aIter = A.listIterator();
      ListIterator<E> bIter = B.listIterator();
      while(bIter.hasNext()) {
        E bCurrent = bIter.next();
        boolean hasBcurrent = false;  // flag to handle remaining elements in B
        while(aIter.hasNext()) {
          E aCurrent = aIter.next();
          int comparison = aCurrent.compareTo(bCurrent);
          if(comparison == 0) {
            // handles duplicates by skipping all bCurrent values that match aCurrent
            aIter.previous(); 
            hasBcurrent = true;
            break;
          } else if(comparison > 0) {
            // step backward to insert bCurrent before aCurrent
            aIter.previous();
            aIter.add(bCurrent);
            hasBcurrent = true;
            break;
          } // if aCurrent < bCurrent, inner loop continues to next aCurrent
        }
        // If reached end of A and all duplicates are handled, Or A is empty,add remaining elements from B to A
        if(!hasBcurrent) {
          aIter.add(bCurrent);
        }
      }
    }
}