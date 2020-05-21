package test;

/**
 * File: MinHeap.java
 * Author: LittleLittleWei
 * Time: 2020/5/21 22:08
 **/
public class MinHeap {
    private int[] data;
    public MinHeap(int[] data) {
        this.data = data;
        buildHeap();
    }
    private void buildHeap() {
        for(int i = data.length / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }
    private void heapify(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);
        if(l < data.length && data[l] < data[smallest])    { smallest = l; }
        if(r < data.length && data[r] < data[smallest])    { smallest = r; }
        if(smallest == i)   return;
        else { swap(smallest,i); heapify(smallest); }
    }
    private int left(int i) { return (i + 1) << 1 - 1; }
    private int right(int i) { return (i + 1) << 1; }
    private void swap(int smallest, int i) {
        data[smallest] = data[i] + data[smallest] - (data[i] = data[smallest]);
    }
    public int getBoot() { return data[0]; }
    public void setBoot(int boot) {
        data[0] = boot;
        heapify(0);
    }
}
