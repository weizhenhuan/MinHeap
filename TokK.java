import java.util.Scanner;

/**
 * File: TopK.java
 * Author: LittleLittleWei
 * Time: 2020/5/21 22:08
 **/
public class TopK {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,11,22,33,44,55,66};
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] topk = getTopK(data,k);
        for (int i = 0; i < k; i++) {
            System.out.print(topk[i] + " ");
        }
    }
    private static int[] getTopK(int[] data, int k) {
        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
            topk[i] = data[i];
        }
        MinHeap heap = new MinHeap(topk);
        for (int i = k; i < data.length; i++) {
            if(data[i] > heap.getBoot())
                heap.setBoot(data[i]);
        }
        return topk;
    }
}
