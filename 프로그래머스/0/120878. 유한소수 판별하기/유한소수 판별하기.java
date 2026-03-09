class Solution {
    public int solution(int a, int b) {
        int gcd = gcd(a, b);
        b /= gcd;

        while (b % 2 == 0) {
            b /= 2;
        }

        while (b % 5 == 0) {
            b /= 5;
        }

        if (b == 1) {
            return 1;
        }

        return 2;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}