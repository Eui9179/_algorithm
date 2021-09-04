package dataStructure.hash;
/*
 * 폐쇠
 * */
public class HashLinearProbing {
    public Slot[] hashTable;
    public HashFunction hashFunction;

    public HashLinearProbing(Integer size) {
        this.hashTable = new Slot[size];
        hashFunction = new HashFunction();
    }

    public static class Slot{
        String key;
        String value;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public boolean saveData(String key, String value) {
        int address = hashFunction.improvedFunction(key,this.hashTable.length);

        if (hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;

                return true;
            } else {
                int currAddress = address + 1;
                while (hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;

                        return true;
                    } else {
                        currAddress += 1;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                hashTable[currAddress] = new Slot(key, value);
            }
        } else {
            hashTable[address] = new Slot(key, value);
            return true;
        }
        return true;
    }

    public String getData(String key) {
        int address = hashFunction.improvedFunction(key,this.hashTable.length);

        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return hashTable[address].value;
            } else {
                int currAddress = address + 1;
                while (this.hashTable[currAddress] != null) {
                    if (hashTable[currAddress].key == key) {
                        return hashTable[currAddress].value;
                    } else {
                        currAddress += 1;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashLinearProbing hlp = new HashLinearProbing(20);
        hlp.saveData("eui", "1");
        hlp.saveData("eee", "2");
        hlp.saveData("jiwon", "3");
        hlp.saveData("jjj", "4");

        System.out.println(hlp.getData("eui"));
        System.out.println(hlp.getData("eee"));
        System.out.println(hlp.getData("jiwon"));
        System.out.println(hlp.getData("jjj"));

    }
}
