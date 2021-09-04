package common;

public class RecursiveCall {
    // 시간 복잡도 n-1번만큼 호출 O(n)
    /*
     * 일반적인 형태 1
     * function (입력){
     *   if(입력 > 일정값){
     *       return function(입력 -1);
     *   }else{
     *       return 특정값
     *   }
     * }
     *
     * 일반적인 형태 2
     * function(입력){
     *   if(입력 <= 일정값){
     *       return 특정값;
     *   }
     *   return function(입력 - 1);
     * }
     * */
    public int factorial1(int number){
        if(number > 1){
            return number * this.factorial1(number - 1);
        }else{
            return 1;
        }
    }
    public int factorial2(int number){
        if(number <= 1){
            return 1;
        }
        return number * this.factorial2((number - 1));
    }
    // ex) 값이 4라고 주어질 때
    // 4는 1 1 1 1, 1 2 1, 2 2 ... 이렇게 표현할 수 있다 경우의 수는?
    public int practice(int num){
        if(num == 1){
            return 1;
        }
        else if(num == 2) {
            return 2;
        }
        else if(num == 3) {
            return 4;
        }else{
            return this.practice(num - 1)
                    + this.practice(num - 2)
                    + this.practice(num - 3);
        }
    }

    public static void main(String[] args) {
        RecursiveCall rc = new RecursiveCall();
        System.out.println(rc.practice(5));
    }
}