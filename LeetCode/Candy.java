public class Solution {
    public int candy(int[] ratings) {
        int N = ratings.length, sum = 0;
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i=1; i<N; i++){
            if (ratings[i] > ratings[i-1])
                candy[i] = candy[i-1]+1;
        }
        for (int i=N-2; i>=0; i--){
            if (ratings[i] > ratings[i+1] && candy[i]<=candy[i+1])
                candy[i] = candy[i+1]+1;
        }
        for (int i=0; i<N; i++){
            sum += candy[i];
        }
        return sum;
    }
}