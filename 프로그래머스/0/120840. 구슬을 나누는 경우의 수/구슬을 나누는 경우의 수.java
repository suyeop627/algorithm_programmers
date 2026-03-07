import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        return factorial(balls)
                .divide(factorial(balls - share).multiply(factorial(share)))
                .intValue();
    }

    private BigInteger factorial(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}