/*
    There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?
*/

// The naive solution is to traverse each element. 
// [1] If the current rating is higher than previous rating, add one more candy to current one; 
// [2] if current rating is lower than previous rating, and current candy is more than previous candy,
// we have to increase previous candy, and then maybe the previous previous one. In a word, an 
// increment in previous one may cause a chain of increments
// time: O(n^2); space: O(1)


// In fact, we can do all the [1] check in one traversal, and all the [2] check in another tarversal
// time: O(n); space: O(1)
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
            if (ratings[i] > ratings[i+1] && candy[i]<=candy[i+1]) // Remember &&candy[i]<=[i+1]
                candy[i] = candy[i+1]+1;
        }
        for (int i=0; i<N; i++){
            sum += candy[i];
        }
        return sum;
    }
}