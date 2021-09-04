package dataStructure.hash;
/*
 * Hash: 키(key)에 데이터(value)를 매핑할 수 있는 데이터 구조
 * 장점: 데이터 저장, 읽기 속도가 빠르다.
 * 단점: 여러키에 대한 충돌이 발생한다.
 * */
public class Hash {
    public Slot[] hashTable;

    public Hash(int size){
        this.hashTable = new Slot[size];
    }

    public static class Slot{
        String value;

        Slot(String value){
            this.value = value;
        }
    }

    public int hashFunc(String key){
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public void saveData(String key, String value) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
    }

    public String getData(String key) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        Hash hash = new Hash(20);
        hash.saveData("의찬", "2664");
        hash.saveData("의원", "7129");

        System.out.println(hash.getData("의찬"));
    }
}
