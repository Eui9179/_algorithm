package dataStructure.hash;

public class HashFunction {
    public int simpleFunction(String key, int size) {
        return (int)(key.charAt(0)) % size;
    }

    public int improvedFunction(String key, int size) {
        int address = 0;
        for (int i = 0; i < key.length(); i++) {
            address += key.charAt(i);
        }
        return address % size;
    }
}
