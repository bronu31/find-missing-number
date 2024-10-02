package org;

import java.util.Arrays;
import java.util.LongSummaryStatistics;

public class LostNumber {


    public long lostInteger(long[] array){
        if (array.length==0) return -1;
        if (array.length==1) return array[0];

        LongSummaryStatistics stats= Arrays.stream(array).summaryStatistics();
        return (stats.getMin()+stats.getMax())*(stats.getMax()-stats.getMin()+1)/2-stats.getSum();
    }
}
