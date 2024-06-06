package A0Myself;

import java.util.Arrays;

public class cutRod {
    public static int cut(int[] p,int n){       //n is the length--p is the price
        int qMax=0;
        if(n==0){
            return 0;
        }
        else{
            //run the sub--all possible types to get the min
            //at least one
            for(int i=1;i<=n;i++){
                qMax = Math.max(qMax,p[i]+cut(p,n-i));
            }
        }
        return qMax;
    }

    //p is price of different length, n is the length
    //array r is used to store the optimal total price, each index is correspond the length
    //length of r is n+1, because we do not use zero
    public static int cutUseMemo(int[] p, int n, int[] r){
        int qMax=0;

        if(n==0){
            return 0;
        }
        //it stores the optimal value, its initial number is 0
        //when is positive, it means it has the optimal value
        if(r[n]>0){
            return r[n];
        }

        for(int i=1;i<=n;i++){
            //the number of index means the length of rod
            qMax = Math.max(qMax, p[i] + cutUseMemo(p, n-i, r));
        }
        //must after the loop, then we can give the qMax to r[n]
        //store the max of every procedure
        r[n]=qMax;
        return qMax;
    }
    public static int cutDirectly(int[] p,int n){
        //create the r for storing the optimal total price of rod
        int [] r = new int[n+1];
        Arrays.fill(r,0);

        //loop for all length that is less or equal than n
        for(int i=1; i<=n; i++){
            int qMax=0;
            //sub loop, inorder to calculate the optimal rest part of optimal value
            for (int j=1;j<=i;j++){
                //for each i,the sub loop of j, has use the all the r[]
                //that is less than i
                qMax = Math.max(qMax,p[i]+r[i-j]);
                //就是当前的最大值，要和之前的所有的最优的都比较一下。
            }
            r[i]=qMax;
        }

        return r[n];
    }
}
