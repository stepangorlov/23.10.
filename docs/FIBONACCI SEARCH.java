public class FibonacciSearch {
    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;
        
        int fibMM2 = 0;
        int fibMM1 = 1;
        int fibM = fibMM2 + fibMM1;
        
        while (fibM < n) {
            fibMM2 = fibMM1;
            fibMM1 = fibM;
            fibM = fibMM2 + fibMM1;
        }
        
        int offset = -1;
        
        while (fibM > 1) {
            int i = Math.min(offset + fibMM2, n - 1);
            
            if (arr[i] < target) {
                fibM = fibMM1;
                fibMM1 = fibMM2;
                fibMM2 = fibM - fibMM1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibMM2;
                fibMM1 = fibMM1 - fibMM2;
                fibMM2 = fibM - fibMM1;
            } else {
                return i;
            }
        }
        
        if (fibMM1 == 1 && offset + 1 < n && arr[offset + 1] == target) {
            return offset + 1;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
        int target = 85;
        
        int result = fibonacciSearch(arr, target);
        
        if (result != -1) {
            System.out.println("Элемент найден на позиции: " + result);
        } else {
            System.out.println("Элемент не найден");
        }
    }
}
