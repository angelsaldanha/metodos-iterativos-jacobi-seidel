package programaiterativos;

public class DefMatriz {

    // matriz de coeficientes A (diagonal estrictamente dominante: |aii| > suma|aij|)
    public static double[][] getMatrizA() {
        return new double[][] {
                { 5.0, 1.0, 1.0 },
                { 1.0, 4.0, 1.0 },
                { 1.0, 2.0, 5.0 }
        };
    }

    // vector de términos independientes b
    public static double[] getVectorB() {
        return new double[] { 7.0, 6.0, 8.0 };
    }

    // vector de aproximación inicial X^(0) = [0, 0, 0]^T
    public static double[] getVectorX0() {
        return new double[] { 0.0, 0.0, 0.0 };
    }

    // tolerancia establecida: epsilon = 0.0001
    public static double getTolerancia() {
        return 0.0001;
    }
}
