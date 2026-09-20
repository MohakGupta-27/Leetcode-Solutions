class Solution {

    static final long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        long even = solve(5, (n + 1) / 2);
        long odd = solve(4, n / 2);

        return (int) ((even * odd) % MOD);
    }

    public long solve(long a, long b) {

        if (b == 0) {
            return 1;
        }

        long half = solve(a, b / 2);

        long result = (half * half) % MOD;

        if (b % 2 == 1) {
            result = (result * a) % MOD;
        }

        return result;
    }
}