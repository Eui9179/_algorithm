package sort;

import java.util.ArrayList;
import java.util.Collections;
//Selection Sort: 인덱스 기준으로 가장 작은 값을 찾아서
//                그 값을 현재 인덱스 위치에 놓는다
//시간 복잡도: O(n^2)
public class SelectionSort {

    public ArrayList<Integer> selectionSort(ArrayList<Integer> dataList){

        for(int stand=0; stand < dataList.size()-1; stand++){
            int lowest = stand;
            for(int index = stand+1; index < dataList.size(); index++){
                if(dataList.get(lowest) > dataList.get(index)){
                    lowest=index;
                }
            }
            Collections.swap(dataList,lowest,stand);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            testList.add((int)(Math.random()*100));
        }

        SelectionSort ss = new SelectionSort();

        System.out.println(ss.selectionSort(testList));
    }
}
