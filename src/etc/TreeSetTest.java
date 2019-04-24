package etc;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {

        TreeSet<Integer> ts = new TreeSet<Integer>();

        ts.add(3);
        ts.add(1);
        ts.add(5);
        ts.add(3);
        ts.add(7);
        ts.add(6);
        ts.add(3);
        ts.add(2);
        
        //TreeSet<Integer> desc = (TreeSet<Integer>) ts.descendingSet();

        Iterator<Integer> it = ts.iterator();
        Iterator<Integer> itd = ts.descendingIterator();

        System.out.println(ts);
        System.out.println(ts.descendingSet());

        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("----------------");
        while(itd.hasNext()){
            System.out.println(itd.next());
        }
        System.out.println("----------------");

        NavigableSet<Integer> test = ts.headSet(5, true);
        NavigableSet<Integer> test2 = ts.descendingSet().headSet(5, true);

        System.out.println(test);
        System.out.println(test2);
    }

}
