class Solution {
    public double myPow(double x, int n) {

        long N = n;

        // negative n for 2^-3 = 1 / 2^3
        if( N < 0){
            x = 1 / x;
            N = -N;
        }
        if( N == 0){
            return 1;
        }

        double halfPower = myPow( x ,(int)(N / 2));

        // if power is even
        double halfPowerSquare = halfPower * halfPower;

        // if power is odd
        if( N % 2 != 0){
            halfPowerSquare = x * halfPowerSquare;
        }

        return halfPowerSquare;
    }
}