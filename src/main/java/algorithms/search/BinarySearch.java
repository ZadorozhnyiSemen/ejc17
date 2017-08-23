package algorithms.search;

/**
 * Binary search class <br>
 * Able to find value in sorted(!) array via binary search algorithm
 */
public class BinarySearch {
    private int[] arrayForSearch;
    private int elementNumber;

    public BinarySearch(int[] arrayForSearch) {
        this.arrayForSearch = arrayForSearch;
        this.elementNumber = arrayForSearch.length;
    }

    public int getElementNumber() {
        return elementNumber;
    }

    /**
     * Finds value of in array via binary search:
     * Divides array by half and first looks at 'middle' element
     * If this is a value we are looking for - returns it
     * Else compares it with searchValue:
     * if less - continues same logic in left half of the array
     * else - in right part
     * etc.
     * @param searchValue value we are looking for
     * @return index of searched value
     */
    public int find(int searchValue) {
        int lowerBound = 0;
        int upperBound = elementNumber - 1;
        int searchPosition;

        while(true) {
            searchPosition = (upperBound + lowerBound) / 2;
            if (arrayForSearch[searchPosition] == searchValue) {
                return searchPosition;
            } else if (lowerBound > upperBound) {
                return elementNumber;
            } else {
                if (arrayForSearch[searchPosition] < searchValue) {
                    lowerBound = searchPosition + 1;
                } else {
                    upperBound = searchPosition - 1;
                }
            }
        }
    }
}
