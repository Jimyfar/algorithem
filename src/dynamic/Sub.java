package dynamic;
/*
* 找出数列中最长的递增子数列
* */

public class Sub{
     public static void main(String[] args) {
         int[] items = {3,5,8,9,1,7};
//         findByBackTracking(0, 0, 7, items);
//         System.out.println(maxValue);
         findByDynamic(6, items);
     }
     private  static int maxValue = Integer.MIN_VALUE;
     public static void findByBackTracking(int num, int i, int n, int[] items){
         if (i == n - 1){
             if (num > maxValue) maxValue = num;
             return;
         }
         for (int j = i + 1; j < n; j++) {
             if(items[j] > items[i]) {
                 findByBackTracking(num + 1, j, n, items );
             }
         }
     }

    /**
     * 利用一维数组，记录以每个下标为最后一个数字的最大递增数列。
     * @param n
     * @param items
     */
     public static void findByDynamic(int n, int[] items){
         int[] states = new int[n];
         states[0] = 1;
         for(int i = 1; i < n; i++){
             int maxLength = Integer.MIN_VALUE;
             for(int k = i - 1; k >= 0; k--){
                 if (items[k] < items[i]){
                     if (states[k] > maxLength){
                         maxLength = states[k];
                     }
                 }
                 states[i] = maxLength + 1;
             }
         }
         int maxLength = Integer.MIN_VALUE;
         for(int i = 0; i < n; i++){
             if (states[i] > maxLength){
                 maxLength = states[i];
             }
         }
         System.out.print(maxLength);
     }

}