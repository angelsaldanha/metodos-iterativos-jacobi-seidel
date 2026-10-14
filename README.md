# Métodos Numéricos: Métodos Iterativos (Jacobi y Gauss-Seidel)

Implementación modular en Java de los algoritmos iterativos de **Jacobi** y **Gauss-Seidel** para la resolución de sistemas de ecuaciones lineales algebraicas con matrices diagonalmente dominantes.

---

## 1. Lenguaje y entorno
* **Lenguaje:** Java (compatible con Java SE 17, 21 o superior).
* **Paradigma:** Modular / Programación estructurada basada en métodos estáticos.
* **Control de versiones:** Git y GitHub.

---

## 2. Arquitectura modular del proyecto

El paquete `programaiterativos` se organiza bajo una estricta separación de responsabilidades a través de tres componentes principales:

* **Módulo 1: Definición del sistema (`DefMatriz.java`)**  
  Centraliza y provee la matriz de coeficientes $A$, el vector de términos independientes $b$, el vector de aproximación inicial $X^{(0)} = [0, 0, 0]^T$ y la tolerancia de error ($\varepsilon = 0.0001$).
* **Módulo 2: Motor de procesamiento iterativo (`MetodosIterativos.java`)**  
  Contiene la lógica matemática de ambos algoritmos:
    * *Método de Jacobi:* Emplea un vector auxiliar obligatorio para almacenar los valores calculados de la iteración actual sin sobrescribir los valores de la iteración anterior.
    * *Método de Gauss-Seidel:* Implementa la actualización inmediata, utilizando el valor recién calculado de cada variable en las ecuaciones subsecuentes del mismo ciclo iterativo.
* **Módulo 3: Ejecución independiente (`MainJacobi.java` y `MainSeidel.java`)**  
  Clases ejecutables independientes que gestionan la carga de parámetros, invocan el método correspondiente y despliegan el progreso de iteraciones y la solución final en consola.

---

## 3. Compilación y ejecución

### Opción A: Desde la terminal (Línea de comandos)

1. Abrir la terminal y situarse en el directorio raíz del proyecto:
   ```bash
   cd MetodosIterativos
   ```

2. Compilar todos los archivos fuente dentro del paquete:
   ```bash
   javac -d out/production/MetodosIterativos src/programaiterativos/*.java
   ```

3. Ejecutar el método de Jacobi:
   ```bash
   java -cp out/production/MetodosIterativos programaiterativos.MainJacobi
   ```

4. Ejecutar el método de Gauss-Seidel:
   ```bash
   java -cp out/production/MetodosIterativos programaiterativos.MainSeidel
   ```

### Opción B: Desde IntelliJ IDEA

1. Abrir el proyecto `MetodosIterativos` en el entorno.
2. Navegar en el panel lateral a `src` $\rightarrow$ `programaiterativos`.
3. Hacer clic derecho sobre `MainJacobi.java` y seleccionar **Run 'MainJacobi.main()'**.
4. Hacer clic derecho sobre `MainSeidel.java` y seleccionar **Run 'MainSeidel.main()'**.

---

## 4. Sistema evaluado y corridas de prueba

### Sistema de ecuaciones lineales
$$\begin{aligned} 5x + y + z &= 7 \\ x + 4y + z &= 6 \\ x + 2y + 5z &= 8 \end{aligned}$$

* **Aproximación inicial:** $X^{(0)} = [0, 0, 0]^T$
* **Criterio de paro:** Error absoluto máximo $\leq 0.0001$ ($\varepsilon$)
* **Solución analítica exacta:** $x = 1.0$, $y = 1.0$, $z = 1.0$

---

### Salida de consola: Método de Jacobi

```text
--- Iteraciones: Método de Jacobi ---
Iteración  1: x = 1.400000, y = 1.500000, z = 1.600000 | Error = 1.600000
Iteración  2: x = 0.780000, y = 0.750000, z = 0.720000 | Error = 0.880000
Iteración  3: x = 1.106000, y = 1.125000, z = 1.144000 | Error = 0.424000
Iteración  4: x = 0.946200, y = 0.937500, z = 0.928800 | Error = 0.215200
Iteración  5: x = 1.026740, y = 1.031250, z = 1.035760 | Error = 0.106960
Iteración  6: x = 0.986598, y = 0.984375, z = 0.982152 | Error = 0.053608
Iteración  7: x = 1.006695, y = 1.007812, z = 1.008930 | Error = 0.026778
Iteración  8: x = 0.996651, y = 0.996094, z = 0.995536 | Error = 0.013394
Iteración  9: x = 1.001674, y = 1.001953, z = 1.002232 | Error = 0.006696
Iteración 10: x = 0.999163, y = 0.999023, z = 0.998884 | Error = 0.003348
Iteración 11: x = 1.000419, y = 1.000488, z = 1.000558 | Error = 0.001674
Iteración 12: x = 0.999791, y = 0.999756, z = 0.999721 | Error = 0.000837
Iteración 13: x = 1.000105, y = 1.000122, z = 1.000140 | Error = 0.000419
Iteración 14: x = 0.999948, y = 0.999939, z = 0.999930 | Error = 0.000209
Iteración 15: x = 1.000026, y = 1.000031, z = 1.000035 | Error = 0.000105
Iteración 16: x = 0.999987, y = 0.999985, z = 0.999983 | Error = 0.000052

Solución final aproximada (Jacobi):
x = 0.999987
y = 0.999985
z = 0.999983
```

---

### Salida de consola: Método de Gauss-Seidel

```text
--- Iteraciones: Método de Gauss-Seidel ---
Iteración  1: x = 1.400000, y = 1.150000, z = 0.860000 | Error = 1.400000
Iteración  2: x = 0.998000, y = 1.035500, z = 0.986200 | Error = 0.402000
Iteración  3: x = 0.995660, y = 1.004535, z = 0.999054 | Error = 0.030965
Iteración  4: x = 0.999282, y = 1.000416, z = 0.999977 | Error = 0.004119
Iteración  5: x = 0.999921, y = 1.000025, z = 1.000006 | Error = 0.000639
Iteración  6: x = 0.999994, y = 1.000000, z = 1.000001 | Error = 0.000072

Solución final aproximada (Gauss-Seidel):
x = 0.999994
y = 1.000000
z = 1.000001
```

> **Conclusión comparativa:** Ambos métodos convergen a la solución analítica $X = [1, 1, 1]^T$. Gauss-Seidel alcanza el criterio de paro en 6 iteraciones frente a las 16 requeridas por Jacobi, evidenciando una velocidad de convergencia aproximadamente 2.6 veces superior debido a la actualización inmediata de variables.