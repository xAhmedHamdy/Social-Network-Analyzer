import DataStructures.TopK;

public class App {
    public static void main(String[] args) throws Exception {
        Integer[] nums = {5, 9, 2, 7, 4};
        Integer[] out = new Integer[3];
        TopK.topK(nums, out, 3);
        for (Integer x : out) System.out.println(x);   // 9, 7, 5

    }
}
