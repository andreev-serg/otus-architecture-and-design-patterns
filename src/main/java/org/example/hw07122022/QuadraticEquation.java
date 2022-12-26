package org.example.hw07122022;

public class QuadraticEquation {
    public static final double eps = 0.0001;

    public static boolean isEquals(double valueFirst, double valueSecond) {
        return Math.abs(valueFirst - valueSecond) < eps;
    }

    public double[] solve(double a, double b, double c) {
        if (isEquals(a, 0)) {
            throw new RuntimeException("Корней нет");
        }
        validateDouble(a, b, c);
        double discriminant = b * b - 4 * a * c;
        if (isEquals(discriminant, 0)) {
            return new double[]{-b / (2 * a), -b / (2 * a)};
        } else if (discriminant >= 0) {
            return new double[]{(-b + Math.sqrt(discriminant)) / (2 * a), (-b - Math.sqrt(discriminant)) / (2 * a)};
        } else {
            throw new RuntimeException("решения нет");
        }
    }

    private void validateDouble(double... values) {
        for (double value : values) {
            if (Double.isInfinite(value)) {
                throw new RuntimeException("Указано бесконечное число");
            }
            if (Double.isNaN(value)) {
                throw new RuntimeException("Указано неопределенное число");
            }
        }
    }
}
