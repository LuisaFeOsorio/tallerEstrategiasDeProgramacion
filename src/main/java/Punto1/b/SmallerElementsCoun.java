package Punto1.b;
import java.util.Arrays;
public class SmallerElementsCoun {

    public static void main(String[] args) {
        int[] array = {5, 2, 6, 1, 3};
        int[] counts = countSmaller(array);

        System.out.println("Arreglo original: " + Arrays.toString(array));
        System.out.println("Conteo de menores a la derecha: " + Arrays.toString(counts));
    }

    public static int[] countSmaller(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }
}

