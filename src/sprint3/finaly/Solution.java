public class Solution {
    //89222898

    /*
-- Принцип Работы --
так как мы работаем с кольцевым буфером, то нужно завести два указателя, левый и правый, указывающие на концы массива
Если массив не сломан и находится в правильной последовательности, то применяется фукнкция обычного бинарного поиска, в ином случае
вычисляется центральный элемент массива.
Если центральный элемент - это искомое значение, конец работы и возвращаем mid.
Если левая часть массива правильно отсортирована и наш элемент находится между крайними элементами этой части, то продолжаем поиск
в ней high = mid-1. Если элемента нет в этой части, то продолжаем поиск в правой части иского массива, сдвигая указатель low = mid +1.
Если левая часть неправильно отсортирована, то проверяем находится ли элемент в правой части, если нет, то ищем в левой части.

Если элемент не был найдет возвращаю -1.

--Сложность --
O(log n) - бинарный поиск

--Память --
O(1) * d(глубина рекурсии), так как на каждом уровне рекурсии хранятся только константы,
 а глубина рекурсии это (log n), то сложность равна O(1)
 */
    public static int brokenSearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        //проверка на то, что рассматриваемый фрагмент массива находится в неправильной последовательности
        boolean broken = arr[low] >= arr[high];
        if (!broken){
            return defaultBinarySearch(arr, k, low, high);
        } else {
            while (low <= high) {
                int mid = low + (high - low ) / 2;

                if (k == arr[mid]) {
                    return mid;
                }
                if (arr[low] <= arr[mid]){
                    if (k >= arr[low] && k < arr[mid]){
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (k <= arr[high] && k > arr[mid]){
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    private static int defaultBinarySearch(int [] arr, int k, int low, int high) {
        if (low == high){
            return (arr[low] == k) ? low : -1;
        }

        int mid = low + (high-low) / 2;
        if (k > arr[mid]){
            return defaultBinarySearch(arr, k, mid + 1, high);
        } else if (arr[mid] > k){
            return defaultBinarySearch(arr, k ,low, high - 1);
        }
        return mid;
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 4, 5, 7, 12};
        assert 6 == brokenSearch(arr, 5);
    }
}