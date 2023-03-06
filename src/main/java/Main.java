import java.util.Scanner;

public class Main {   // Задача 3

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================================");
        System.out.println("========== Введите целое число n >= 2 ===================");
        System.out.println("=========================================================");
        int n = scanner.nextInt();
        int i = 0;
        int a = n - 1;
        int b = n - a;
        int minNok = a * b;
        int winnerA = a;  // создаем переменные для обработки  чисел  a  b
        int winnerB = b;
        while (b < n) {
            int nok = lcm(a, b);
            if (nok < minNok) {
                minNok = nok;
                winnerA = a;
                winnerB = b;
                System.out.println(minNok + " наименьшее общее кратное для чисел  " + winnerA + " и " + winnerB);
            }
            a = a - 1;
            b = b + 1;
            i = i + 1;
        }

        System.out.println("================================================================");
        System.out.println("          РЕЗУЛЬТАТ - найдена выигрышнаяч комбинация            ");
        System.out.println(minNok + " - наименьшее общее кратное для чисел a & b ---> " + winnerA + " & " + winnerB);
        System.out.println(gcdGenius(a, b) + " - наибольший общий делитель для чисел a & b --> " + winnerA + " & " + winnerB);
        System.out.println("================================================================");

    }
    // НОД (Наибольший общий делитель) или gcd (Greatest Common Divisor)
    // НОД - наибольшее число, которое является делителем одновременно для чисел a и b.
    // Реализация (Алгоритм Евклида - гениальный):

    public static int gcdGenius(int a, int b) {
        return b == 0 ? a : gcdGenius(b, a % b);
    }

    // Реализация (Алгоритм Евклида - обычный):
    public static int gcdEuklid(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            int gcdConst = a % b;
            a = b;
            b = gcdConst;
        }
        return a;
    }

    // НОК (Наименьшее общее кратное) или lcm (Least Common Multiple)
    // НОК - наименьшее число, которое делится на a и b без остатка.
    // НОК можно найти через НОД по следующей формуле:
    // НОК (a, b) = a * b / НОД (a, b)
    // Реализация:
    public static int lcm(int a, int b) {
        return a / gcdEuklid(a, b) * b;
        // Примечание: a / gcdEuklid(a, b) * b более предпочтительно,
        // чем a * b / gcdEuklid(a, b), т.к. во втором случае при больших числах - long
        // переполнение может случиться намного раньше.
    }

}