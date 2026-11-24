import java.util.HashSet;
import java.util.Set;


public class TRAI_26_X5_prakigov implements TRAI_26_X5 {

    /**
     * SELF-EVALUATION HERE:
     * Writing the pseudocode in python helped deduce the logic of the problem and how to implement it in Java.
     * Understanding of the set operations especially difference was crucial to solving the problem.
     * Time complexity is O(n) where n is the total number of elements in all sets combined, as we iterate through each set independently to perform union and intersection operations.
     * Space complexity is O(m) where m is the number of unique elements across all sets, as we store them in HashSets.
     */ 

/**
 * PSEUDO CODE:
 * 
 * if inAll is empty, return empty set
 * if inSome is empty, return empty set
 * if null in inAll and inSome but NOT in inNone, return null set
 * 

commonAll, someUnion, noneUnion = {}

for i in range(inAll.length):
  commonAll.add(inAll[i])
for j in range(inSome.length):
  someUnion.union(inSome[j])
for k in range(inNone.length):
  noneUnion.union(inNone[j]

result = commonAll.intersect(someUnion).difference(noneUnion)
return result

 * 
 * EDGE CASES:
 * 
 * if {{k1}, {k2}, {k3}} in inAll, {{k1}, {k2}} in inSome, and {{k3}} in inNone, return empty set
 * if null in inAll and inSome and inNone, return empty set
 *
 * /

    /**
     * Find all those elements that are in all of the sets of inAll,
     * are in at least one of the sets of inSome,
     * and are in none of the sets of inNone.
     * @param inAll     Set of sets, the elements of the result must be in all of these sets.
     * @param inSome    Set of sets, the elements of the result must be in at least one of these sets.
     * @param inNone    Set of sets, the elements of the result may not be in any of these sets.
     * @return          The set containing the elements fulfilling the above requirements.
     * @param <E>       Element type.
     */
    public <E> Set<E> inAllSomeNone(Set<Set<E>> inAll, Set<Set<E>> inSome, Set<Set<E>> inNone) {
      Set<E> result = new HashSet<>();
      
      // validate input sets
      if (inAll.isEmpty() || inSome.isEmpty()) {
        return result;  // null set
      }

      // flatten inAll, inSome, and inNone into a single set each to remove duplicates and to reduce the memory allocation for the problem
      Set<E> commonAll = new HashSet<>(inAll.iterator().next());
      for (Set<E> s : inAll) {
        commonAll.retainAll(s); // union of all sets in inAll
      }
      
      Set<E> someUnion = new HashSet<>();
      for (Set<E> s : inSome) {
        someUnion.addAll(s);  // union of all sets in inSome
      }

      Set<E> noneUnion = new HashSet<>();
      for (Set<E> s : inNone) {
        noneUnion.addAll(s);  // union of all sets in inNone
      } 

      // find intersection of commonAll and someUnion, then remove difference elements that are in noneUnion
      commonAll.retainAll(someUnion); // intersection
      commonAll.removeAll(noneUnion); // difference
      result.addAll(commonAll);
                 
      return result;
    }
}