/*
Zava
CS2050
04/29/2024
 */
import java.util.Random;
class HashTable {

    class LinkedHash {
        private int key;
        private String id;
        LinkedHash next;

        // constructor of linked hash 
        LinkedHash(int key, String value)
        {
            this.key = key;
            this.id = value;
            this.next = null;
        }

        public int getKey() {
            return key;
        }

    }

    private int tableSize;
    private int size;
    private LinkedHash[] table;
    private int collCnt = 0;
    Random rand = new Random();

    public HashTable(int ts)
    {
        size = 0;
        tableSize = ts;
        table = new LinkedHash[tableSize];

        for (int i = 0; i < tableSize; i++)
            table[i] = null;
    }

    public int getSize() { return size; }
    public int getCollCnt() {
        return collCnt;
    }
    public int getTableSize() {
        return tableSize;
    }

    public double loadFactor() {
        return (double) size/tableSize;
    }
    public int hashAlg(int rando, int key) { // Caesar Cipher
        if(key - 3 >= 0) {
            return ((((key-3) + rando) / 2) % tableSize);
        }
        else {
            return(((key+597 + rando) / 2) % tableSize);
        }
    }

    public void insert(int key, String value)
    {
        int randomNum = rand.nextInt(tableSize-1);
        int hash = hashAlg(randomNum, key); // Hash Algorithm
        if (table[hash] == null) {
            table[hash] = new LinkedHash(key, value);
        }
        else {
            collCnt++;
            LinkedHash entry = table[hash];
            while (entry.next != null
                    && entry.key != key) {
                entry = entry.next;

            }
            if (entry.key == key) {
                entry.id = value;
            }
            else {
                entry.next = new LinkedHash(key, value);
            }
        }
        size++;

    }

}