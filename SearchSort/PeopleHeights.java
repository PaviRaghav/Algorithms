/*
You are given the following :

1. A positive number N
2. Heights : A list of heights of N persons standing in a queue
3. Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P

You need to return list of actual order of persons’s height
*/

import java.util.*;

public class PeopleHeights {
    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>(A);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.size(); i++)
            map.put(A.get(i), B.get(i));
        Collections.sort(result);
        int ptr = result.size() - 1;
        int high = result.size() - 1;
        while (ptr >= 0) {
            int element = result.get(ptr);
            int taller = map.get(element);
            result.remove(ptr);
            if (ptr + taller >= result.size())
                result.add(element);
            else
                result.add(ptr + taller, element);
            high = ptr;
            ptr--;
        }
        return result;
    }
}
