package sprint2.finaly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
-- Принцип Работы --
Сначал читаем строку входных данных, забрасываем в метод calculate, далее создаем стэк, в который последовательно
будут добавляться и извлекаться числа. Строку входных данных превращаю в массив, по которому можно удобно проходиться.
Запускаю последовательную проверку (можно было через switch) на вычислительную операци, выдергиваю 2 последних элемента,
произвощу соответствующую операцию и результат добавляю обратно.

ВАЖНО! double val = ((double) (second / (double) first)) и digits.push((int) Math.floor(val)); - нужны для сведения результата
к нижней границе.

В конце логики возращаю самый верхний элемент и вывожу его в консоль

--Доказательство корректности --
Из стека вынимается первый последний добавленный элемент LIFO
Так как в польской аннотации операция выполняется на элементами слева, а добавление идёт при прохождение по массиву
[5 6 + 3 2 * +] --- > [5 6] -(операция +)-> [11] --> [11 3 2] -(операция *)-> [11 6] -(операция +)- > [17]
Array 👆             Stack 👆

--Сложность --
O(n) - нужно пройтись по всем элементам, поданным на вход

--Память --
O(n) - зависит от входных данных, может быть ситуация, когда будет просто n числовых значений, которые все придется заносить
в стек
 */

//87134561
public class B {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            System.out.println(calculate(input));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculate(String input) {
        Stack<Integer> digits = new Stack<>();

        String[] array = input.split(" ");

        int value;
        int first;
        int second;

        for (String c : array) {

            if (c.matches(".*\\d")){
                digits.push(Integer.parseInt(c));
            } else {
                first = digits.pop();
                second = digits.pop();
                switch (c) {
                    case "+":
                        value = second + first;
                        digits.push(value);
                        break;
                    case "-":
                        value = second - first;
                        digits.push(value);
                        break;
                    case "*":
                        value = second * first;
                        digits.push(value);
                        break;
                    case "/":
                        digits.push(Math.floorDiv(second, first));
                        break;
                }
            }
        }
        return digits.pop();
    }
}
