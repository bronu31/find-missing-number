package org;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        LostNumber lostNumber= new LostNumber();
        long[] arr=new long[]{ 7,9,10, 11, 12};
        System.out.println(lostNumber.lostInteger(arr));
        // массив может быть длинны от 0, но начиная с длинны 2 гарантировано будет пропущенный элемент
        //последовательность не содержит отрицательных чисел
        
        
    }
    
}
