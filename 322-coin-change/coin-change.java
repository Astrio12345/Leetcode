class Solution {
	public int coinChange(int[] coins, int amount) {
        Map<Integer,Integer> map=new HashMap<>();
        return coinChange(coins,amount,map);
    }
    private int coinChange(int[] coins, int amount, Map<Integer,Integer> mem ){
        if(amount<0) return -1;
        if(amount==0) return 0;
        Integer c=mem.get(amount);
        if(c!=null) return c;
        int cc=-1;
        for(int i=0;i<coins.length;i++) {
            int coin=coinChange(coins, amount-coins[i],mem);
            if(coin>=0) cc=cc<0?coin+1:Math.min(cc,coin+1);
        }
        mem.put(amount,cc);
        return cc;
    }
}