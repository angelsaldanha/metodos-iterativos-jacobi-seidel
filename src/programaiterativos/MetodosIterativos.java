package programaiterativos;

public class MetodosIterativos {

    // -------------------------------------------------------------
    // Metodo de Jacobi
    // utiliza un vector auxiliar para almacenar los nuevos valores
    // sin sobreescribir los valores de la iteración previa
    // -------------------------------------------------------------
    public static double[] jacobi(double[][] A, double[] b, double[] x0, double tol) {
        int n = b.length;
        double[] xActual = x0.clone();
        double[] xNuevo = new double[n]; // Vector auxiliar obligatorio en Jacobi
        int iteracion = 0;
        double error;

        System.out.println("--- Iteraciones: Método de Jacobi ---");

        do {
            iteracion++;

            // cálculo de cada variable xi usando exclusivamente valores de xActual (iteración k-1)
            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * xActual[j];
                    }
                }
                // despeje: xi^(k) = (bi - sum(aij * xj^(k-1))) / aii
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            // cálculo del error absoluto máximo entre la iteración actual y la previa
            error = 0.0;
            for (int i = 0; i < n; i++) {
                double dif = Math.abs(xNuevo[i] - xActual[i]);
                if (dif > error) {
                    error = dif;
                }
            }

            // muestra progreso de la iteración
            System.out.printf("Iteración %2d: x = %.6f, y = %.6f, z = %.6f | Error = %.6f%n",
                    iteracion, xNuevo[0], xNuevo[1], xNuevo[2], error);

            // ya calculadas todas las variables, se actualiza el vector para la siguiente ronda
            xActual = xNuevo.clone();

        } while (error > tol && iteracion < 100);

        return xActual;
    }

    // -------------------------------------------------------------
    // Metodo de Gauss-Seidel
    // Emplea actualización inmediata: en cuanto una variable se calcula,
    // se utiliza ese valor fresco en las ecuaciones siguientes del mismo ciclo.
    // -------------------------------------------------------------
    public static double[] gaussSeidel(double[][] A, double[] b, double[] x0, double tol) {
        int n = b.length;
        double[] x = x0.clone(); // se modifica en tiempo real (actualización inmediata)
        int iteracion = 0;
        double error;

        System.out.println("--- Iteraciones: Método de Gauss-Seidel ---");

        do {
            iteracion++;
            double[] xAnterior = x.clone(); // respaldo temporal solo para medir el error

            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        // x[j] ya contiene valores nuevos si j < i, o valores previos si j > i
                        suma += A[i][j] * x[j];
                    }
                }
                // actualización inmediata sobre el mismo arreglo
                x[i] = (b[i] - suma) / A[i][i];
            }

            // cálculo del error absoluto máximo
            error = 0.0;
            for (int i = 0; i < n; i++) {
                double dif = Math.abs(x[i] - xAnterior[i]);
                if (dif > error) {
                    error = dif;
                }
            }

            // mostrar progreso de la iteración
            System.out.printf("Iteración %2d: x = %.6f, y = %.6f, z = %.6f | Error = %.6f%n",
                    iteracion, x[0], x[1], x[2], error);

        } while (error > tol && iteracion < 100);

        return x;
    }
}
