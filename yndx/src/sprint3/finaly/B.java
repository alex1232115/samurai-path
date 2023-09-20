package sprint3.finaly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//89502676

/*
-- Принцип Работы --
Была создана структура данных InternFinal для удобного доступа и хранения полей: логин, таски и штрафы каждого из стажеров.
Был создан компаратор для сравнения их между собой по требуемому условию задачи
Базовый случай выхода из рекурссии это когда левый указатель совпадает с правым. Сначала вычисляется центральный
элемент массива, после чего в цикле while идёт переставление левого и правого указателей, сравнивая их с опорным
Одинаковые элементы по выполненным задачам будут соответсвенно  проверяться на штрафы и лексиграфический порядок
Если элементы, на которых остановилась работа проходят по условию компаратора, то происходит свап и переставление указателей
Либо же указатели просто переставляются без какой-либо замены

В конце рекурсивного вызова идёт проверка указателей, не дошли ли мы до конца массива, где уже нет элементов

--Сложность --
O(n*log(n))

--Память --
O(1) (входные данные) * O(log n) - глубина рекурсии, что дает O(log n), затраты по памяти - никакая структура данных не копируется в реализации in place
*/
class InternFinal implements Comparable<InternFinal> {
    public final String login;
    public final int doneTasks;
    public final int penalties;

    InternFinal(String login, int doneTasks, int penalties) {
        this.login = login;
        this.doneTasks = doneTasks;
        this.penalties = penalties;
    }

    @Override
    public int compareTo(InternFinal o) {
        if (doneTasks > o.doneTasks) {
            return -1;
        } else if (doneTasks < o.doneTasks) {
            return 1;
        } else {
            if (penalties < o.penalties) {
                return -1;
            } else if (penalties > o.penalties) {
                return 1;
            } else {
                return login.compareTo(o.login);
            }
        }
    }
}

public class B {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            List<InternFinal> arrayList = new ArrayList<>();
            StringTokenizer stringTokenizer;

            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                arrayList.add(new InternFinal(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
            }
            effectiveQuickSort(arrayList, 0, arrayList.size() - 1);
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                System.out.println(arrayList.get(i).login);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void effectiveQuickSort(List<InternFinal> interns, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        InternFinal pivot = interns.get(mid);

        int i = left, j = right;

        while (i <= j) {
            while (interns.get(i).compareTo(pivot) > 0) {
                i++;
            }
            while (pivot.compareTo(interns.get(j)) > 0) {
                j--;
            }

            if (interns.get(i).compareTo(interns.get(j)) < 0 && i <= j) {
                Collections.swap(interns, i, j);
                i++;
                j--;
            } else if (i <= j) {
                i++;
                j--;
            }
        }
        effectiveQuickSort(interns, left, j);
        effectiveQuickSort(interns, i, right);
    }
}
