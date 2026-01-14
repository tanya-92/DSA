import java.util.Arrays;
import java.util.*;

class ArrayADT{
    int totalSize;
    int usedSize;
    int[] arr;  

    void createArray(int tSize, int uSize) {
        totalSize = tSize;
        usedSize = uSize;
        arr = new int[totalSize];   // dynamic allocation
    }
}

public class ArrayADTclass{
    public static void main(String[] args) {
        obj arr = new obj();
        arr.createArray(10, 5);  // total size = 10, used size = 5
    }
}
