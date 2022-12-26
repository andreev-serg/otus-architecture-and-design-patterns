package org.example.hw07122022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuadraticEquationTest {

    /**
     * 3 Написать тест, который проверяет, что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)
     */
    @Test
    void solveEmpty() {
        QuadraticEquation main = new QuadraticEquation();
        Assertions.assertThrowsExactly(RuntimeException.class, () -> main.solve(1, 0, 1));
    }

    /**
     * 5 Написать тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1 (x1=1, x2=-1)
     */
    @Test
    void solveTwoResult() {
        QuadraticEquation main = new QuadraticEquation();
        double[] solve = main.solve(1, 0, -1);
        Assertions.assertEquals(solve.length, 2);
        Assertions.assertTrue(QuadraticEquation.isEquals(solve[0], 1));
        Assertions.assertTrue(QuadraticEquation.isEquals(solve[1], -1));
    }

    /**
     * 7 Написать тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1).
     */
    @Test
    void solveTwoEqualsResult() {
        QuadraticEquation main = new QuadraticEquation();
        double[] solve = main.solve(1, 2, 1);
        Assertions.assertEquals(solve.length, 2);
        Assertions.assertTrue(QuadraticEquation.isEquals(solve[0], -1));
        Assertions.assertTrue(QuadraticEquation.isEquals(solve[1], -1));
    }

    /**
     * 9 Написать тест, который проверяет, что коэффициент a не может быть равен 0. В этом случае solve выбрасывает исключение.
     */
    @Test
    void solveZeroA() {
        QuadraticEquation main = new QuadraticEquation();
        Assertions.assertThrowsExactly(RuntimeException.class, () -> main.solve(10e-9, 2, 1));
    }

    /**
     * 7 Написать тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1).
     */
    @Test
    void solveSmallDiscriminant() {
        QuadraticEquation main = new QuadraticEquation();
        double[] solve = main.solve(1, 2, 0.999999999);
        Assertions.assertEquals(solve.length, 2);
        Assertions.assertTrue(QuadraticEquation.isEquals(solve[0], -1));
        Assertions.assertTrue(QuadraticEquation.isEquals(solve[1], -1));
    }

    /**
     * 13 Посмотреть какие еще значения могут принимать числа типа double,
     * кроме числовых и написать тест с их использованием на все коэффициенты. solve должен выбрасывать исключение.
     */
    @Test
    void solveCustom() {
        QuadraticEquation main = new QuadraticEquation();
        Assertions.assertThrowsExactly(RuntimeException.class, () -> main.solve(Double.POSITIVE_INFINITY, 2, 1));
        Assertions.assertThrowsExactly(RuntimeException.class, () -> main.solve(0, Double.POSITIVE_INFINITY, 1));
        Assertions.assertThrowsExactly(RuntimeException.class, () -> main.solve(0, 2, Double.POSITIVE_INFINITY));
        Assertions.assertThrowsExactly(RuntimeException.class, () -> main.solve(Double.NaN, 2, 1));
        Assertions.assertThrowsExactly(RuntimeException.class, () -> main.solve(0, Double.NaN, 1));
        Assertions.assertThrowsExactly(RuntimeException.class, () -> main.solve(0, 2, Double.NaN));
    }

    @Test
    void isEquals() {
        Assertions.assertTrue(QuadraticEquation.isEquals(0, 0));
        Assertions.assertTrue(QuadraticEquation.isEquals(0, 0 + QuadraticEquation.eps / 2));
        Assertions.assertFalse(QuadraticEquation.isEquals(1, 2));

    }
}