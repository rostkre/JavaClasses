package lr6;

public class Example5 {

    public static int findMaxMultiThreaded(int[] arr) throws InterruptedException {
        int threadCount = Runtime.getRuntime().availableProcessors();
        // Массив потоков
        Thread[] threads = new Thread[threadCount];
        // В этом массиве каждый поток сохранит локальный максимум
        int[] partialMax = new int[threadCount];

        // Вычисляем размер «шага», чтобы разбить массив на части
        int chunkSize = (int) Math.ceil((double) arr.length / threadCount);

        for (int t = 0; t < threadCount; t++) {
            final int index = t;
            final int start = t * chunkSize;
            // Конечный индекс не должен выходить за границы массива
            final int end = Math.min(start + chunkSize, arr.length);

            threads[t] = new Thread(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int i = start; i < end; i++) {
                    if (arr[i] > localMax) {
                        localMax = arr[i];
                    }
                }
                // Сохраняем локальный максимум в общий массив
                partialMax[index] = localMax;
            });
            threads[t].start();
        }

        // Дожидаемся завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Теперь находим глобальный максимум среди локальных
        int globalMax = partialMax[0];
        for (int i = 1; i < threadCount; i++) {
            if (partialMax[i] > globalMax) {
                globalMax = partialMax[i];
            }
        }
        return globalMax;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1, 7, 3, 10, 4, 22, 8, 5, 16, 42, 13};
        int maxVal = findMaxMultiThreaded(arr);
        System.out.println("Максимальное значение в массиве: " + maxVal);
    }
}
