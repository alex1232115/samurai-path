package sprint4.finaly;

/*
Основные задачи:
* 1. Организация хранения элементов через ноды для метода цепочек, класс Node
* 2. Написание быстрой хеш функции для хранения в пределах массива (пробирование методом умножения)
* 3. Хранения одинаковых ключей в связанном списке
* 4. Реализация метода put, get, delete
* 5. Рехеширование, делать или нет? Сразу создавать огромный массив? Bad practice

Количество ключей в хеш-таблице не может превышать 1_000_00.
Методы:
put key value —– добавление пары ключ-значение. Если заданный ключ уже есть в таблице, то соответствующее ему значение
обновляется.
get key –— получение значения по ключу. Если ключа нет в таблице, то вывести «None». Иначе вывести найденное значение.
delete key –— удаление ключа из таблицы. Если такого ключа нет, то вывести «None», иначе вывести хранимое по данному
ключу значение и удалить ключ.
*/

// 89791442
/*
-- Принцип Работы --
С входными данными я думаю, что всё понятно. Для своей хеш-таблицы было создано три метода, get, put и delete. В качестве
хеш функции я брал от каждого ключа его строковое представление и выражал через встроенную хеш-функцию. Если честон, не совсем уверен, что так
оно и предполагалось, но придумывать свою хеш-функцию не хватило времени, а вообще можно подумать. В качестве принципа
хранения коллизий я использовал метод цепочек. Если проходиться по каждому из методов, то там обычное просчёт хеша, потом
выбор номера корзины и далее логика добавление в связанный список. В качестве размера массива я выбрал простое число, так как выбор корзины
реализован за счёт метода деления, при чем использовал я не mod выражение,а побитовый сдвиг, прочитал на stackoverflow, что так быстрее.

--Сложность --
O(n * n), где n - кол-во запросов и скорость выполения в худшем случае, а в среднем должно быть O(n)

--Память --
O(10 ^ 5, худший случай, когда кол-во всех ячеек занято, а дальше алгоритм не даст запихнуть большее кол-во)
*/

import java.io.*;

public class B {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int amountResponses = Integer.parseInt(rd.readLine());
            CustomHashMap hashMap = new CustomHashMap();
            String[] currentCommand;
            for (int i = 0; i < amountResponses; i++) {
                currentCommand = rd.readLine().split(" ");
                try {
                    switch (currentCommand[0]) {
                        case "get":
                            wt.write(String.valueOf(hashMap.get(Integer.parseInt(currentCommand[1]))));
                            wt.newLine();
                            break;
                        case "put":
                            hashMap.put(Integer.parseInt(currentCommand[1]), Integer.parseInt(currentCommand[2]));
                            break;
                        case "delete":
                            wt.write(String.valueOf(hashMap.delete(Integer.parseInt(currentCommand[1]))));
                            wt.newLine();
                            break;
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                    wt.write("None");
                    wt.newLine();
                } catch (IndexOutOfBoundsException ignored){

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

class CustomHashMap {
    int amount;
    final int MAX_AMOUNT = 100_000;
    int capacity = 89898;
    Node[] buckets;

    public CustomHashMap() {
        buckets = new Node[capacity];
        amount = 0;
    }

    public void put(int key, int value) {
        if (amount == MAX_AMOUNT) {
            throw new IndexOutOfBoundsException(); //Too many keys in hashMap
        }
        Node node = new Node(key, value);
        int hash = customHashCode(node.key);
        int bucketNum = hash & (capacity-1);
        if (buckets[bucketNum] == null) {
            buckets[bucketNum] = node;
            amount++;
        } else {
            Node head = buckets[bucketNum];
            Node currentNode = buckets[bucketNum];
            while (currentNode.next != null) {
                if (currentNode.key == key) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key != key) {
                node.next = head;
                buckets[bucketNum] = node;
                amount++;
            } else {
                currentNode.value = value;
            }
        }
    }

    public int get(int key) {
        int hash = customHashCode(key);
        int bucketNum = hash & (capacity - 1);
        if (buckets[bucketNum] == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node currentNode = buckets[bucketNum];
            while (currentNode.next != null) {
                if (currentNode.key == key) {
                    return currentNode.value;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key != key) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                return currentNode.value;
            }
        }
    }

    public int delete(int key) {
        int hash = customHashCode(key);
        int bucketNum = hash & (capacity- 1);
        Node currentNode = buckets[bucketNum];
        if (currentNode == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (currentNode.key == key) {
            int answer = currentNode.value;
            buckets[bucketNum] = currentNode.next;
            return answer;
        } else {
            while (currentNode.next != null) {
                if (currentNode.next.key == key) {
                    amount--;
                    int answer = currentNode.next.value;
                    currentNode.next = currentNode.next.next;
                    return answer;
                }
                currentNode = currentNode.next;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int customHashCode(int key) {
        return String.valueOf(key).hashCode();
    }
}

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
