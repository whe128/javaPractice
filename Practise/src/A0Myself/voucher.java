package A0Myself;

import java.util.Arrays;

public class voucher {
    public static int minWaste(int[] p,int n){
        //can not buy the cheapest
        if(n< Arrays.stream(p).min().getAsInt()){
            return n;
        }
        int qmin =n;
        //for different price
        for(int i=0;i<p.length;i++)
        {
            //the max mum that can buy by each good
            for(int j=1;j<=n/p[i];j++){
                qmin = Math.min(qmin,minWaste(p,n-p[i]*j));
            }
        }
        return qmin;
    }

    public static int minWasteDirect(int[] p,int n){
       int[] res = new int[n+1];
       Arrays.fill(res,n);
       res[0]=0;
       //loop all voucher
       for(int i=0; i<=n;i++){
           int qMin = i;
           //for different good,see who can make it become smallest
           for(int j=0;j<p.length;j++){
               for(int k=1;k<=i/p[j];k++){
                   //why can use res, because i-p[j]/k <i,we will have the value
                   //res 的值肯定不会超过最小的
                   qMin = Math.min(qMin,res[i-p[j]*k]);
               }
           }
           res[i] = qMin;
       }
       return res[n];
     }

    public static void main(String[] args) {
        int[] p = {243,245,297,401,1004};
        int n = 2007;
        int waste = n;
        waste = minWasteDirect(p,n);
        System.out.println(waste);
    }
}
