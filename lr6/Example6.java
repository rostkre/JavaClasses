package lr6;

public class Example6 {

    public static long sumArrayMultiThreaded(int[] arr) throws InterruptedException {
        int threadCount = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[threadCount];
        long[] partialSums = new long[threadCount];

        // Рассчитываем размер «шага», чтобы разбить массив на блоки
        int chunkSize = (int) Math.ceil((double) arr.length / threadCount);

        for (int t = 0; t < threadCount; t++) {
            final int index = t;
            final int start = t * chunkSize;
            // Конечный индекс не должен выходить за границы массива
            final int end = Math.min(start + chunkSize, arr.length);

            threads[t] = new Thread(() -> {
                long localSum = 0;
                for (int i = start; i < end; i++) {
                    localSum += arr[i];
                }
                partialSums[index] = localSum;
            });
            threads[t].start();
        }

        // Дожидаемся завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Складываем частичные суммы для получения итогового результата
        long totalSum = 0;
        for (long sum : partialSums) {
            totalSum += sum;
        }

        return totalSum;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1, 2, 3, 10, 5, 6, 7, 8, 9, 100};
        long sum = sumArrayMultiThreaded(arr);
        System.out.println("Сумма элементов массива: " + sum);
    }
}
