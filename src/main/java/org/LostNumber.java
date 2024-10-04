package org;

import java.util.Arrays;
import java.util.LongSummaryStatistics;

public class LostNumber <T>{

//ну раз мне отказали можно и повеселится :D
//Вместо того чтобы делать класс для одной какой-то штуки будем делать его и для целых чисел и для дробей
//в таком случае формула не сработает, но я оставлю закоментированной так как красивое решение
    /*public long lostInteger(long[] array){
        if (array.length==0) return -1;
        if (array.length==1) return array[0];

        LongSummaryStatistics stats= Arrays.stream(array).summaryStatistics();
        return (stats.getMin()+stats.getMax())*(stats.getMax()-stats.getMin()+1)/2-stats.getSum();
    }*/

    // и так с чего начать? Ну хотя бы с того что решение в таком случае будем делать глупо и просто
    // а именно сортировкой и проверкой, для целый чисел разницу установим не больше чем 1 целая единица
    // а для дробей установим не более чем 1 или 0.1 ибо тут тогда можно долго сидеть и плакать над нашими ограничениями

    //провреку будем проводить более детальную и гарантий в этот раз никаких не будет, только слёзы

    public Object lostInteger(Object[] array){
        // первые крайние случаи это ясно понятно длинна 1 или 0 всё просто
        //а что делаем когда длинна больше? Обсусловимся что у нас всегда есть отсутсвующий элемент который нахоидтся
        // между min и max
        Object retValue=-1;
        if (array.length==0) return retValue;
        if (array.length==1) return array[0];
        boolean gate=true;

        //так как у нас два гланых класса
        //я тут понял что в идеале это надо бы делать сканером, но блин так занудно получится
        //из-за чего будет провеять только на long и double
        //тип а какая разница то? Может потом придумаю как это сделать правильней конечно а пока хз
        //так как массив объектов в нём может быть что угодно, но мы обуславниваемся что там могут быть только числа
        //иначе опять же куча головной боли
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Integer) {
                continue;
            }
            else {
                gate = false;
                break;
            }
            //если есть хоть один элемент другого типа то начинаем проверять дробный формат
            //потенциально так же возникает вопрос о числах которые
        }
        if (gate){// Ух ну и ересь же с таким я ещё не работал хехе
            int[] arr=new int[array.length];
            for (int i = 0; i < array.length; i++) {
                arr[i]= (int) array[i];
            }
            return lost(arr);
        } else {
            double[] arr=new double[array.length];
            for (int i = 0; i < array.length; i++) {
                arr[i]= (double) array[i];
            }
            return lost(arr);
        }
        //вопрос можно ли оптимизировать конечно сразу встаёт но я хз
    }
    //разница между числами если есть пропуск должна соаставлять максимум удвоенное значение то есть 0.2 или 2
    public double lost(double[] arr){
        Arrays.sort(arr);
        for (int i=1;i<arr.length;i++){
            if (arr[i]-arr[i-1]>1||arr[i]-arr[i-1]>0.1){
                return arr[i]-(arr[i]-arr[i-1])/2;//как то так вроде
            }
        }
        return 0;
    }

    public int lost(int[] arr){
        Arrays.sort(arr);
        for (int i=1;i<arr.length;i++){
            if (arr[i]-arr[i-1]>1){
                return arr[i]-1;//а здесь проще так как точно должно быть минус 1 и мне лень делать проверку на переполнение
            }
        }
        return 0;
    }
}
