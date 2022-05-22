package gamersFun.com.example.gamersFun.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsConverter {

    public static <T> List<T>  getListFromIterator(Iterable<T> iterator)
    {
        // Create an empty list
        List<T> list = new ArrayList<>();

        // Add each element of iterator to the List
        iterator.forEach(list::add);

        // Return the List
        return list;
    }

}
