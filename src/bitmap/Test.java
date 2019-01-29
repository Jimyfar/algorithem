package bitmap;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        int[] data = {1,2,2,2,3,4,5,6,7,8,9,10};
        System.out.println(search(3, data));

        System.out.println(powerRoot(1023));

        System.out.println(findFirstEqual(3, data));

        System.out.println(findLastEqual(3, data));

        System.out.println(findFirstBiggerEqual(3, data));

        System.out.println(findLastSmallerEqual(3, data));

    }

    public static int search(int target, int[] data) {
        if (data.length == 1) return 0;
        int low = 0;
        int high = data.length - 1;
        int mid = (high + low) / 2;
        while (low != high) {
            if (target == data[mid]) {
                return mid;
            }
            if (target < data[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (high + low) / 2;

        }
        return 0;
    }

    /**
     * *��һ������ƽ���� ��ȷ��С�����6λ
     */
    public static double powerRoot(double num) {
        double low = 0;
        double high = num;
        double presion = 1;
        double mid = low + (high - low) / 2;
        while(presion > 0.000001) {

            if (mid * mid == num) {
                return mid;
            }
            if (num < mid * mid) {
                presion = mid * mid - num;
                high = mid;
            }
            if (num > mid * mid) {
                presion = num - mid * mid;
                low = mid;
            }
            mid = low + (high - low) / 2;
        }
        return mid;
    }

    /**
     *  *���ҵ�һ��ֵ���ڸ���ֵ��Ԫ�ء�
     */
    public static int findFirstEqual(int target, int[] data) {
        int low = 0;
        int high = data.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data[mid] == target) {
                result = mid;
                high = mid - 1;
            }
            if (target > data[mid]) {
                low = mid + 1;
            }

            if (target < data[mid]) {
                high = mid - 1;
            }
        }
        return result;
    }

    /**
     * *�������һ�����ڸ���ֵ��Ԫ�ء�
     */
    public static int findLastEqual(int target, int[] data) {
        int low = 0;
        int high = data.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data[mid] == target) {
                result = mid;
                low = mid + 1;
            }
            if (target > data[mid]) {
                low = mid + 1;
            }

            if (target < data[mid]) {
                high = mid - 1;
            }
        }
        return result;
    }

    /**
     *  * ���ҵ�һ�����ڵ��ڸ���ֵ��Ԫ��
     */
    public static int findFirstBiggerEqual(int target, int[] data) {
        int low = 0;
        int high = data.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data[mid] == target) {
                result = mid;
                low = mid + 1;
            }
            if (target > data[mid]) {

                low = mid + 1;
            }

            if (target < data[mid]) {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }

    /**
     *  *�������һ��С���ڸ���ֵ��Ԫ��
     */
    public static int findLastSmallerEqual(int target, int[] data) {
        int low = 0;
        int high = data.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data[mid] == target) {
                result = mid;
                low = mid + 1;
            }
            if (target > data[mid]) {
                result = mid;
                low = mid + 1;
            }

            if (target < data[mid]) {

                high = mid - 1;
            }
        }
        return result;
    }
}