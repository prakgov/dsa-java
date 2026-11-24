import java.util.HashSet;
import java.util.Set;

public class Week5 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        TRAI_26_X5_prakigov testSet = new TRAI_26_X5_prakigov();
        Set<Set<Integer>> inAll = new HashSet<>();
        Set<Set<Integer>> inSome = new HashSet<>();
        Set<Set<Integer>> inNone = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        set1.add(19);
        set1.add(20);
        set1.add(21);
        Set<Integer> set2 = new HashSet<>();
        set2.add(20);
        set2.add(21);
        Set<Integer> set3 = new HashSet<>();
        set3.add(22);
        inAll.add(set1);
        inAll.add(set2);
        inAll.add(set3);
        inSome.add(set2);
        inNone.add(set3);
        Set<Integer> result = testSet.inAllSomeNone(inAll, inSome, inNone);
        System.out.println("Result = " + result);
    }
}
