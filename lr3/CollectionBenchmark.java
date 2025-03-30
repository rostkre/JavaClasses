package lr3;

import java.util.*;

public class CollectionBenchmark {
    public static void main(String[] args) {
        // Количество элементов
        int size = 18 * 1_000_000;

        // Создание коллекций
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> treeSet = new TreeSet<>();

        // Заполнение коллекций
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
            treeSet.add(i);
        }

        // Добавление элемента в начало
        long start = System.nanoTime();
        arrayList.add(0, 100);  // Добавление в начало ArrayList
        long end = System.nanoTime();
        System.out.println("ArrayList добавление в начало: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedList.add(0, 100);  // Добавление в начало LinkedList
        end = System.nanoTime();
        System.out.println("LinkedList добавление в начало: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.add(100);  // Добавление в TreeSet (нет концепции "в начало", но вставка)
        end = System.nanoTime();
        System.out.println("TreeSet добавление в начало: " + (end - start) + " ns");

        // Добавление элемента в конец
        start = System.nanoTime();
        arrayList.add(100);  // Добавление в конец ArrayList
        end = System.nanoTime();
        System.out.println("ArrayList добавление в конец: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedList.add(100);  // Добавление в конец LinkedList
        end = System.nanoTime();
        System.out.println("LinkedList добавление в конец: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.add(100);  // Добавление в TreeSet (это тоже добавление, но с сортировкой)
        end = System.nanoTime();
        System.out.println("TreeSet добавление в конец: " + (end - start) + " ns");

        // Добавление элемента в середину
        start = System.nanoTime();
        arrayList.add(size / 2, 100);  // Добавление в середину ArrayList
        end = System.nanoTime();
        System.out.println("ArrayList добавление в середину: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedList.add(size / 2, 100);  // Добавление в середину LinkedList
        end = System.nanoTime();
        System.out.println("LinkedList добавление в середину: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.add(100);  // Для TreeSet середина не существует, добавление всё равно происходит
        end = System.nanoTime();
        System.out.println("TreeSet добавление в середину: " + (end - start) + " ns");

        // Удаление элемента в начале
        start = System.nanoTime();
        arrayList.remove(0);  // Удаление из начала ArrayList
        end = System.nanoTime();
        System.out.println("ArrayList удаление из начала: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedList.remove(0);  // Удаление из начала LinkedList
        end = System.nanoTime();
        System.out.println("LinkedList удаление из начала: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.remove(100);  // Удаление из TreeSet
        end = System.nanoTime();
        System.out.println("TreeSet удаление из начала: " + (end - start) + " ns");

        // Удаление элемента в конце
        start = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);  // Удаление из конца ArrayList
        end = System.nanoTime();
        System.out.println("ArrayList удаление с конца: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedList.remove(linkedList.size() - 1);  // Удаление из конца LinkedList
        end = System.nanoTime();
        System.out.println("LinkedList удаление с конца: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.remove(100);  // Удаление из TreeSet
        end = System.nanoTime();
        System.out.println("TreeSet удаление с конца: " + (end - start) + " ns");

        // Удаление элемента в середине
        start = System.nanoTime();
        arrayList.remove(size / 2);  // Удаление из середины ArrayList
        end = System.nanoTime();
        System.out.println("ArrayList удаление из середины: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedList.remove(size / 2);  // Удаление из середины LinkedList
        end = System.nanoTime();
        System.out.println("LinkedList удаление из середины: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.remove(100);  // Удаление из TreeSet
        end = System.nanoTime();
        System.out.println("TreeSet удаление из середины: " + (end - start) + " ns");

        // Получение элемента по индексу
        start = System.nanoTime();
        arrayList.get(size / 2);  // Получение по индексу для ArrayList
        end = System.nanoTime();
        System.out.println("ArrayList получение по индексу: " + (end - start) + " ns");

        start = System.nanoTime();
        // Для LinkedList получение по индексу медленное, так как требуется обход списка
        linkedList.get(size / 2);
        end = System.nanoTime();
        System.out.println("LinkedList получение по индексу: " + (end - start) + " ns");

        start = System.nanoTime();
        // Для TreeSet нельзя просто получить элемент по индексу, так как это дерево.
        Iterator<Integer> iterator = treeSet.iterator();
        for (int i = 0; i < size / 2; i++) {
            iterator.next();
        }
        iterator.next();  // Получаем элемент
        end = System.nanoTime();
        System.out.println("TreeSet получение по индексу: " + (end - start) + " ns");
    }
}
