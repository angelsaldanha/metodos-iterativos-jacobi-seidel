package programaiterativos;

public class MainSeidel {

    public static void main(String[] args) {
        // carga de datos desde el módulo de definición
        double[][] A = DefMatriz.getMatrizA();
        double[] b = DefMatriz.getVectorB();
        double[] x0 = DefMatriz.getVectorX0();
        double tol = DefMatriz.getTolerancia();

        // ejecución de Gauss-Seidel
        double[] solucion = MetodosIterativos.gaussSeidel(A, b, x0, tol);

        // resultados finales
        System.out.println("\nSolución final aproximada (Gauss-Seidel):");
        System.out.printf("x = %.6f%n", solucion[0]);
        System.out.printf("y = %.6f%n", solucion[1]);
        System.out.printf("z = %.6f%n", solucion[2]);
    }
}
