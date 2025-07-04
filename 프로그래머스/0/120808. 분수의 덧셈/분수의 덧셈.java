class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numerator = numer1 * denom2 + numer2 * denom1;
        int denominator = denom1 * denom2;

        int gcd = getGCD(numerator, denominator);  // 최대공약수

        return new int[]{numerator / gcd, denominator / gcd};
    }

    // 유클리드 호제법
    private int getGCD(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}