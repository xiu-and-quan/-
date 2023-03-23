package 动态规划;

public class 石子游戏 {
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5,3,4,5}));
    }
    public static boolean stoneGame(int[] piles) {
        int size = piles.length;
        int oneScore = 0;
        int twoScore = 0;
        if (piles[0]>piles[size-1]){
            oneScore = piles[0]+dp(piles,1,size-1);
            twoScore = piles[size-1]+dp(piles,0,size-2);
        }else {
            oneScore = piles[size-1]+dp(piles,0,size-2);
            twoScore = piles[0]+dp(piles,1,size-1);
        }
        return oneScore > twoScore;
    }

    static int dp(int[] piles, int i, int j) {
        if ( i == j){
            return piles[i];
        }if (i>j){
            return 0;
        }
        if (piles[i] > piles[j]){
            return piles[i];
        }else {
            return piles[j];
        }
    }
}
