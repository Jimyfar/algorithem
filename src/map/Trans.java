package map;
public class Trans {

    private static int[] resultstop3 = {0, 0, 0};

    public static void main(String[] args) {
        int[][] words = new int[3][3];
        int[] a = {8, 6, 3};
        int[] b = {6, 5, 4};
        int[] c = {9, 6, 4};
        for (int i = 0; i < 3; i++) {
            words[0][i] = a[i];
            words[1][i] = b[i];
            words[2][i] = c[i];
        }
        System.out.print(trans(0, 3, 3, words, 0));
        System.out.println(resultstop3[0]);
        System.out.println(resultstop3[1]);
        System.out.println(resultstop3[2]);
    }

    //    public static void trans(int i, int wordNum, int valueNum, int[][] words, int results){
//        if (i == wordNum) {
//            for(int k = 0; k < 3; k++){
//                if (results > resultstop3[k]){
//                    resultstop3[k] = results;
//                    break;
//                }
//            }
//            return;
//        }
//        for(int j = 0; j < valueNum; j++){
//            trans(i + 1, wordNum, valueNum, words, results + words[i][j]);
//        }
//
//    }
//
    public static int trans(int i, int wordNum, int valueNum, int[][] words, int result) {
        if (i == wordNum) {

            return 0;
        }
        for (int j = 0; j < valueNum; j++) {
            result += trans(i + 1, wordNum, valueNum, words, result + words[i][j]);
        }
        return result;
    }
}