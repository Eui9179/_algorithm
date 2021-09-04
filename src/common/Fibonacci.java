package common;

public class Fibonacci {
    //피보나치 수열 재귀함수
    public int calFibo(int num){
        if (num <= 1) {
            return num;
        } else {
            return this.calFibo(num - 1) + this.calFibo(num - 2);
        }
    }

    //동적 계획법
    public int dynamicFunc(int num) {
        int[] cache = new int[num + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int index = 2; index < num + 1; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[num];
    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        System.out.println(fibo.calFibo(9));
    }

}
