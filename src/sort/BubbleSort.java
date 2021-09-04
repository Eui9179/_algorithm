package sort;

import java.util.ArrayList;
import java.util.Collections;
//Collections.swap(리스트, 바꿀인덱스1, 바꿀인덱스2)
//ArrayList: .get(인덱스) .add(값)
//버블 정렬 시간복잡도 O(n^2)
public class BubbleSort {
    public ArrayList<Integer> bubble_sort(ArrayList<Integer> dataList){
        for(int index = 0;index < dataList.size()-1;index++){
            boolean swap = false;
            for(int index2 = 0;index2 < dataList.size()-1-index;index2++){
                if(dataList.get(index2)>dataList.get(index2+1)){
                    Collections.swap(dataList, index2,index2+1);
                    swap = true;
                }
            }
            if(swap == false){
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {

        ArrayList<Integer> testData = new ArrayList<Integer>();
        for(int i = 0;i < 10; i++){
            testData.add((int)(Math.random()*100));
        }

        BubbleSort bs = new BubbleSort();

        System.out.println(bs.bubble_sort(testData));
    }
}