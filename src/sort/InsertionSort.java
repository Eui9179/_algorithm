package sort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {

    public ArrayList<Integer> insertionSort(ArrayList<Integer> dataList){
        for (int stand = 0; stand < dataList.size(); stand++) {
            int lowest = stand;
            for (int index = stand; index >= 0; index--) {
                if (dataList.get(stand) < dataList.get(index)) {
                    lowest = index;
                }
            }
            Collections.swap(dataList,lowest,stand);
        }
        return dataList;
    }
    public static void main(String[] args) {

        ArrayList<Integer> testList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            testList.add((int) (Math.random() * 10));
        }

        InsertionSort is = new InsertionSort();
        System.out.println(is.insertionSort(testList));

    }
}
