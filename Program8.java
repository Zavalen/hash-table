/*
Zava
CS2050
04/29/2024
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program8 {
    public static void main(String[] args) {
        int size1 = 601;
        int size2 = 4001;

        HashTable table1 = new HashTable(size1);
        HashTable table2 = new HashTable(size2);

        String outputFile = "results.txt";
        String inputFile = "students.txt";

        readFile(inputFile,table1, table2);
        writeFile(outputFile, table1, table2);


    }

    public static void writeFile(String fileName, HashTable table1, HashTable table2) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write("Zava\nCS2050\n\n");
            fw.write("The algorithm applies the Caesar Cypher with an offset of 3 and then adds a random number " +
                    "between 0 and the hash table size. It then divides that by 2.\n\n");
            fw.write("Size of Hash Table 1: " + table1.getTableSize() + "\n");
            fw.write("Collisions in Hash Table 1: " + table1.getCollCnt() + "\n");
            fw.write("Load Factor of Hash Table 1: " + table1.loadFactor() + "\n\n");
            fw.write("Size of Hash Table 2: " + table2.getTableSize() + "\n");
            fw.write("Load Factor of Hash Table 2: " + table2.loadFactor() + "\n");
            fw.write("Collisions in Hash Table 2: " + table2.getCollCnt() + "\n");

            fw.close();
        }
        catch(IOException e) {
            System.out.println("Trouble trying to write to " + fileName);
            e.printStackTrace();
        }
    }
    public static void readFile(String fileName, HashTable table1, HashTable table2) {
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null) {
                String[] curr = line.split("\\s+");
                table1.insert(Integer.valueOf(curr[1]), curr[0]);
                table2.insert(Integer.valueOf(curr[1]), curr[0]);
            }
            br.close();

        }
        catch(IOException e) {
            e.printStackTrace();
            System.out.print("Unable to read/write files");
        }

    }
}
