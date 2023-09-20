package sprint4.finaly;

import java.io.*;
import java.util.*;

// 89791374
/*
-- Условие --
Тимофей пишет свою поисковую систему. Имеется n документов, каждый из которых представляет собой текст из слов.
По этим документам требуется построить поисковый индекс. На вход системе будут подаваться запросы. Запрос —– некоторый набор слов.
По запросу надо вывести 5 самых релевантных документов.Релевантность документа оценивается следующим образом:
для каждого уникального слова из запроса берётся число его вхождений в документ, полученные числа для всех слов из запроса суммируются.
Итоговая сумма и является релевантностью документа. Чем больше сумма, тем больше документ подходит под запрос.
Сортировка документов на выдаче производится по убыванию релевантности. Если релевантности документов совпадают —–
то по возрастанию их порядковых номеров в базе (то есть во входных данных).

В первой строке дано натуральное число n —– количество документов в базе (1 ≤ n ≤ 10 ^ 4).
Далее в n строках даны документы по одному в строке. Каждый документ состоит из нескольких слов, слова отделяются друг
от друга одним пробелом и состоят из маленьких латинских букв. Длина одного текста не превосходит 1000 символов.
Текст не бывает пустым. В следующей строке дано число запросов —– натуральное число m (1 ≤ m ≤ 10 ^ 4). В следующих m строках даны запросы по одному в строке.
Каждый запрос состоит из одного или нескольких слов. Запрос не бывает пустым. Слова отделяются друг от друга одним пробелом и состоят из маленьких латинских букв.
Число символов в запросе не превосходит 100.

Для каждого запроса выведите на одной строке номера пяти самых релевантных документов.
Если нашлось менее пяти документов, то выведите столько, сколько нашлось. Документы с релевантностью 0 выдавать не нужно.

-- Принцип Работы --
Для дальнейшего быстрого поиска создается хеш-таблица, где ключ - слово, а значение это ещё одна хеш таблица (ключ -> номер документа, значение -> кол-во вхождение этого слова в него)
Далее идёт функция поиска, через stream я создаю массив из уникальных слов запроса, после чего для каждого работаю с запросами, где для каждого слова сливаю данные
о его вхождение в различные документы в хеш-таблицу results.
Так как я не знаю, как сортировать хеш-таблицу по значению, я создаю класс Docs, формирую лист с документами и сортирую при помощи созданного компаратора через лямбду.
Вывожу результат, так повторяю до каждого из запросов

--Сложность --
O(n + (m * (w + w*log(w)) -> так как максимум символов 100, т.е это даже не 100 слов, но пусть будет 100 для упрощение,
т.е можно сказать, что худший случий, это сортировка 100 документов)), где n - кол-во документов, а m - кол-во запросов, w - кол-во слов в каждом запросе :\

--Память --
O(n*кол-во слов + n (в функции поиска максимум потребляемой памяти равен максимуму документов) -> O(n)
*/
public class A {
    public static void main(String[] args) throws IOException {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out))) {
            /* ключ - слово
            значение - пара, где ключом является номер документа, а значением сумма вхождений слова для данного документа
            */
            Map<String, Map<Integer, Integer>> docs = new HashMap<>();
            int amountDoc = Integer.parseInt(rd.readLine());
            preparingDocs(rd, docs, amountDoc);
            int amountResponses = Integer.parseInt(rd.readLine());
            search(rd, wt, docs, amountDoc, amountResponses);
        }
    }

    private static void preparingDocs(BufferedReader rd, Map<String, Map<Integer, Integer>> documents, int amountDoc) throws IOException {
        for (int i = 1; i <= amountDoc; i++) {
            String[] words = rd.readLine().split(" ");
            for (String word : words) {
                if (documents.containsKey(word)) {
                    Map<Integer, Integer> currentDoc = documents.get(word);
                    currentDoc.put(i, documents.get(word).getOrDefault(i, 0) + 1);
                } else {
                    Map<Integer, Integer> newDoc = new HashMap<>();
                    newDoc.put(i, 1);
                    documents.put(word, newDoc);
                }
            }
        }
    }

    private static void search(BufferedReader rd, BufferedWriter wt, Map<String, Map<Integer, Integer>> docs, int amountDoc, int amountResponses) throws IOException {
        for (int i = 0; i < amountResponses; i++) {
            String[] words = Arrays.stream(rd.readLine().split(" ")).distinct().toArray(String[]::new);

            Map<Integer, Integer> results = new HashMap<>();
            List<Docs> prints = new ArrayList<>();
            for (String word : words) {
                if (docs.containsKey(word)) {
                    Map<Integer, Integer> currentWord = docs.get(word);
                    for (Map.Entry<Integer, Integer> entry : currentWord.entrySet()) {
                        int index = entry.getKey();
                        int sum = entry.getValue();

                        results.put(index, results.getOrDefault(index, 0) + sum);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
                prints.add(new Docs(entry.getKey(), entry.getValue()));
            }
            printSearchResults(wt, prints);
        }
    }

    private static void printSearchResults(BufferedWriter wt, List<Docs> results) throws IOException {
        results.sort((o1, o2) -> {
            if (o1.sum == o2.sum) return o1.index - o2.index;
            return o2.sum - o1.sum;
        });
        for (int j = 0; j < results.size() && j < 5; j++) {
            wt.write(results.get(j).index + " ");
        }
        wt.newLine();
    }

    static class Docs {
        int index;
        int sum;

        public Docs(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
}
