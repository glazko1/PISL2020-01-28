package by.it.group773602.chekun.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.ArrayList;
import java.util.List;

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        List<Long> s = getSequencePeriod(m);
        long period = s.size() - 2;
        int val = (int) (n % period);
        return s.get(val);
    }

    private List<Long> getSequencePeriod(long m) {
        List<Long> s = new ArrayList<>();
        s.add(0L);
        s.add(1L);
        for (int i = START_POSITION; i < calculateMaxPizanoPeriod(m); i++) {
            s.add((s.get(i - 1) + s.get(i - 2)) % m);
            if (s.get(i) == 1 && s.get(i - 1) == 0) {
                break;
            }
        }
        return s;
    }

    private static final int START_POSITION = 2;

    private long calculateMaxPizanoPeriod(long value) {
        return value * 6;
    }
}

