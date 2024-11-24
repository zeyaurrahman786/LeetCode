class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // get the minPos, maxNeg value to later get the min of them to deduct
        int minPos=Integer.MAX_VALUE, maxNeg=Integer.MIN_VALUE, negatives=0;
        // maintain sum of positives and elements that can be converted to positive
        long sum=0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                // if current element is negative, count it, sum it as positive and update maxNeg
                if(matrix[i][j]<0) {
                    negatives+=1;
                    sum-=(matrix[i][j]);
                    maxNeg = Math.max(maxNeg, matrix[i][j]);
                // if current element is positive, sum it and update minPos
                } else {
                    sum+=matrix[i][j];
                    minPos = Math.min(minPos, matrix[i][j]);
                }
            }
        }
        // return sum if total number of negative elements are even
        if((negatives&1)==0) return sum;
        // deduct 2*(Min of maxNeg and minPos from the answer)
        return sum-2*Math.min(-maxNeg, minPos);
    }
}