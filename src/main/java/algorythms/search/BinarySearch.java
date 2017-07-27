package algorythms.search;

public class BinarySearch {
    private int[] arrayForSearch;
    private int elementNumber;

    public BinarySearch(int maxNumberOfElements) {
        arrayForSearch = new int[maxNumberOfElements];
        elementNumber = 0;
    }

    public BinarySearch(int[] arrayForSearch) {
        this.arrayForSearch = arrayForSearch;
        this.elementNumber = arrayForSearch.length;
    }

    public int getElementNumber() {
        return elementNumber;
    }

    public int find(int searchKey) {
        int lowerBound = 0;
        int upperBound = elementNumber - 1;
        int searchPosition;

        while(true) {
            searchPosition = (upperBound + lowerBound) / 2;
            if (arrayForSearch[searchPosition] == searchKey) {
                return searchPosition;
            } else if (lowerBound > upperBound) {
                return elementNumber;
            } else {
                if (arrayForSearch[searchPosition] < searchKey) {
                    lowerBound = searchPosition + 1;
                } else {
                    upperBound = searchPosition - 1;
                }
            }
        }
    }
}
