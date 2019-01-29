package heap;

public class HeapSort{
    public static void main(String[] args) {

    }

    private int count;
    private int capacity;
    private int[] heap;
    public HeapSort(int n){
        this.count = 0;
        this.heap = new int[n + 1];
        this.capacity = n;
    }

    public boolean insert(int value){
        if (count == capacity) {
            return false;
        }
        count++;
        heap[count] = value;
        int n = count;
        while (n / 2 > 0 ){
            if (heap[n / 2] < heap[n]){
                int tmp = heap[n];
                heap[n] = heap[n / 2];
                heap[n/2] = tmp;
            } else{
                break;
            }
        }
        return  true;
    }

    public int get(){
        if(count == 0) return -111;
        int value = heap[1];
        heap[1] = heap[count];
        count--;
        heapify(heap, count, 1);
        return value;
    }

    public void heapify(int[] heap, int count, int n){
        while(n * 2 <= count){
            int maxPos = n;
            if (heap[maxPos] < heap[n * 2]) maxPos = n *2;
            if (n * 2 + 1 <= count && heap[maxPos] < heap[n * 2 + 1]) maxPos = n * 2 + 1;
            if (maxPos == n) break;
            int tmp = heap[maxPos];
            heap[maxPos] = heap[n];
            heap[n] = tmp;
            n = maxPos;
        }
    }

}