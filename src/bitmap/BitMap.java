package bitmap;

public class BitMap {
    private char[] bytes;
    private int nbits;

    public static void main(String[] args){
        BitMap map = new BitMap(10);
        map.set(4);
        System.out.println(map.get(2));
    }
    public BitMap(int nbits){
        this.nbits = nbits;
        this.bytes = new char[nbits/8+1];
    }

    public void set(int k){
        if(k > nbits) return;
        int byteIndex = k / 8;
        int bitIndex = k % 8;

        bytes[byteIndex] |= (1 << bitIndex);
        System.out.println(byteIndex);
    }

    public boolean get(int k){
        if(k > nbits) return false;
        int byteIndex  = k / 8;
        int bitIndex = k % 8;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }
}
