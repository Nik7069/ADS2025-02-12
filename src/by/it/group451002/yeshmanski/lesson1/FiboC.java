package by.it.group451002.yeshmanski.lesson1;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m
 * время расчета должно быть не более 2 секунд
 */

public class FiboC {

    private long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 55555;
        int m = 1000;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    long fasterC(long n, int m) {
        //Интуитивно найти решение не всегда просто и
        //возможно потребуется дополнительный поиск информации

        int prev = 0;
        int cur = 1;
        int temp = 0;
        int pezano = 1;
        for (int i = 0; i < m*m; i++)
        {
            temp = (prev + cur) % m;
            prev = cur;
            cur = temp;
            if ((cur == 1) && (prev == 0)){
               pezano = i + 1;
               break;
            }
        }
        n = n % pezano;

        prev = 0;
        cur = 1;
        temp = 0;

        for (int i = 2; i <= n ; i++)
        {
            temp = (prev + cur) % m;
            prev = cur;
            cur = temp;

        }

        return cur;
    }


}

