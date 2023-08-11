class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        long temp = n;
        if(temp<0) temp = -1*temp;
        while(temp > 0){
            if(temp%2 == 1){
                res = res*x;
                temp = temp - 1;
            }else{
                x = x * x;
                temp = temp/2;
            }
        }
        if(n<0) res = (1.0)/res;
        return res;
    }
}
// double ans=1.0;
//         long nn=n;
//         if(nn<0) nn= -1 * nn;
//         while(nn>0){
//             if(nn%2==1){
//                 ans=ans*x;
//                 nn=nn-1;
//             }
//             else{
//                 x=x*x;
//                 nn=nn/2;
//             }
//         }
//         if(n<0) ans=(double)(1.0)/(double)(ans);    //if it is negetive
//         return ans;