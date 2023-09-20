package sprint2.finaly;

import java.io.*;
import java.util.StringTokenizer;

/*
--Принцип работы --
Реализацию кольцевого буффера реализовал через массив Integer с размером, указанным при вводе
В классе main идёт стандартная логика обработки ввода, заключенная в try with resources, через regexp я проверяю
как в данным момент подана команда (currentCommand) и запускаю соответствующую логику. Для обработки случаев, когда
дек пустой или заполненный завел переменную currentSize.

В самом классе дека через конструктор инициализируется сам дек, максимальный размер дека, указатели для головы и хвоста дека,
отвечающие за добавление и удаление.

Методы push_front и pop_back не отличаются от стандартной логики очереди, хвост указывает всегда на null элемент, в который
будет добавлен новый элемент и перещелкивает указатель вперед. Голова указывает всегда на самый старый элемент дека, при удалении указатель
перещелкивает так же вперед.

Метод push_back - так как при пуше требуется указатель, указывающий на свободную ячейку, а добавляем в этот раз мы в начало, то
при используется указатель head. head-1 >= 0 - даёт понимание о том, есть ли пустая свободная ячейка до текущего указателя, если нет и мы выходим
за граниуц дека, значит пора заходить с другой стороны и присвается значение maxSize-1, иначе просто отнимаем единицу и добавляем туда элемент.

Метод pop_front использует указатель tail для работы с передней частью очереди, я проверяю аналогично не находимся ли мы сейчас в самом начале, чтобы
не выйти за границу дека, если мы на 0 элемент, то значит есть элемент с обратной стороны и просто переключаемся на maxSize-1.

--Временная сложность
Переписывание (добавление) и затираение (извлечение) элемента в массиве стоит O(1), так как у нас зараннее заданный размер, расширять его не надо.

--Пространственная сложность --
Зависит от подаваемого на вход максимального размера, так что O(n)
 */
//87133818
public class A {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int commandCount = Integer.parseInt(reader.readLine());
            int maxDequeSize = Integer.parseInt(reader.readLine());

            Deque myDeque = new Deque(maxDequeSize);
            String[] currentCommand;


            for (int i = 0; i < commandCount; i++) {
                currentCommand = reader.readLine().split(" ");
                try {
                    switch (currentCommand[0]) {
                        case "push_back":
                            myDeque.push_back(Integer.parseInt(currentCommand[1]));
                            break;
                        case "push_front":
                            myDeque.push_front(Integer.parseInt(currentCommand[1]));
                            break;
                        case "pop_back":
                            writer.write(String.valueOf(myDeque.pop_back()));
                            writer.newLine();
                            break;
                        case "pop_front":
                            writer.write(String.valueOf(myDeque.pop_front()));
                            writer.newLine();
                            break;
                    }
                } catch (IndexOutOfBoundsException e) {
                    writer.write("error");
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Deque {
    private int maxSize;
    private int[] myQueueSized;
    private int tail;
    private int head;

    private int currentSize;

    public Deque(int maxSize) {
        this.maxSize = maxSize;
        this.myQueueSized = new int[maxSize];
        this.tail = 0;
        this.head = 0;
        this.currentSize = 0;
    }

    public void push_front(int x) {
        if (currentSize == maxSize) {
            throw new IndexOutOfBoundsException();
        } else {
            myQueueSized[tail] = x;
            tail = (tail + 1) % maxSize;
            currentSize++;
        }
    }

    public int pop_back() {
        if (currentSize == 0) {
            throw new IndexOutOfBoundsException();
        } else {
            int output;
            output = myQueueSized[head];
            myQueueSized[head] = Integer.MIN_VALUE;
            head = (head + 1) % maxSize;
            currentSize--;
            return output;
        }
    }

    public void push_back(int x) {
        if (currentSize == maxSize) {
            throw new IndexOutOfBoundsException();
        } else {
            head = head - 1 >= 0 ? (head - 1) : (maxSize - 1);
            myQueueSized[head] = x;
            currentSize++;
        }
    }

    public int pop_front() {
        if (currentSize == 0) {
            throw new IndexOutOfBoundsException();
        } else {
            int output;
            tail = tail - 1 >= 0 ? (tail - 1) : (maxSize - 1);
            output = myQueueSized[tail];
            myQueueSized[tail] = Integer.MIN_VALUE;
            currentSize--;
            return output;
        }
    }
}
