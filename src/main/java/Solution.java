import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int n = power.length;
        if(n == 1) {
            return power[0];
        }

        List<long[]> list = new ArrayList<>();
        int prev = power[0];
        int c = 1;
        for(int i = 1; i <= n; i++) {
            if(i == n) {
                list.add(new long[]{prev, c});
            }else {
                if(power[i] == prev ){
                    c++;
                }else{
                    list.add(new long[]{prev, c});
                    prev = power[i];
                    c = 1;
                }
            }
        }
        if(list.size() == 1){
            return list.get(0)[0] * list.get(0)[1];
        }
        long[][] dp = new long[list.size()][3];
        dp[0][0] = (long) list.get(0)[0] * list.get(0)[1];
        dp[0][1] = 0L;
        dp[0][2] = 0L;
        long res = dp[0][0];
        for(int i = 1; i < list.size(); i++) {
            for(int j = 0; j < 3; j++){
                if(i - j - 1 >= 0 && list.get(i)[0] - list.get(i - j - 1)[0] > 2) {
                    dp[i][j] = Math.max((long) list.get(i)[0] * list.get(i)[1] +  Math.max(Math.max(dp[i - j - 1][0], dp[i - j - 1][1]), dp[i - j - 1][2]), dp[i - 1][j]);
                    res = Math.max(dp[i][j], res);
                }else {
                    dp[i][j] = Math.max((long) list.get(i)[0] * list.get(i)[1], dp[i - 1][j]) ;
                    res = Math.max(dp[i][j], res);
                }
            }

        }
       
        return res;
    }


}
