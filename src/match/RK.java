package match;
public class RK{
    public static void main(String[] args) {

    }

    public int match(char[] a, char[] b){
        int[] k = new int[a.length];
        for(int i = 0; i < k.length; i++){
            k[i] = 26 ^ i;
        }
        int aNum = 0, bNum = 0;
        for(int i = 0; i < a.length; i++){
            aNum = aNum + ((int) a[i]) * i;
        }

    }

}