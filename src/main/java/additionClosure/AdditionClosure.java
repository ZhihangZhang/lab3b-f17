package additionClosure;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AdditionClosure {

	public static boolean isClosed(List<Integer> intList, Integer n) {
		// TODO: Implement this method
        int listLength = intList.size();
        int remainderByN;
        boolean isFound = false;

        // calculate all the remainders of (the sum of two distinct values / n ) in list
        for (int index = 0; index < listLength-1; index++) {
            for (int indexIncrement = 1; indexIncrement + index < listLength; indexIncrement++) {
                remainderByN = (intList.get(index) + intList.get(index+indexIncrement)) % n;

                // generate a new iterator when testing two elements
                ListIterator<Integer> itrIntList= intList.listIterator();

                // see if this remainder is in the list (or the of summation of it and k*n)
                while(itrIntList.hasNext()){
                    if( (remainderByN - itrIntList.next()) % n == 0){
                        isFound = true;
                        break; // found
                    }
                }

                // this remainder (+k*n) is not in the list
                if(!isFound){
                    return false;
                }

                // reset isFound to false and be ready for next two elements
                isFound = false;



            }
        }

        return true;



	}
	
}
