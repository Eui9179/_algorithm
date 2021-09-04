package dataStructure.hash;
/*
 * 개방
 * */
public class HashChaining {
    public Slot[] hashTable;
    public HashFunction hashFunction;

    public HashChaining(int size) {
        this.hashTable = new Slot[size];
        hashFunction = new HashFunction();
    }

    public static class Slot{
        String key;
        String value;
        Slot next;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /*
     * 데이터 저장
     * hashTable 안에 주소가 충돌 된다면 linked list 를 이용해 데이터를 추가함
     *
     * */
    public void saveData(String key, String value) {
        Integer address = hashFunction.improvedFunction(key, this.hashTable.length);

        if (this.hashTable[address] != null) { //key 값이 이미 존재
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];

            while (findSlot != null) { // 링크드 리스트 끝으로 감
                if (findSlot.key == key) { // 값 업데이트
                    findSlot.value = value;
                } else { // 충돌
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value); // 링크드 리스트 끝에 값 추가
        }else{
            this.hashTable[address] = new Slot(key, value);
        }
    }

    public String getData(String key) {
        Integer address = hashFunction.improvedFunction(key,hashTable.length);

        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];

            while (findSlot != null) {
                if (findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashChaining hc = new HashChaining(20);
        hc.saveData("eui", "2665");
        hc.saveData("eeee", "3356");
        hc.saveData("jiwon", "7129");
        hc.saveData("jou", "5363");

        System.out.println(hc.getData("eui"));
        System.out.println(hc.getData("eeee"));
        System.out.println(hc.getData("jiwon"));
        System.out.println(hc.getData("jou"));

    }
}
