package april;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    private static int VERTEX_COUNT = 6;
    private static int EDGED_COUNT = 8;

    private static int[][] matrix = new int[VERTEX_COUNT][VERTEX_COUNT];

    private static ArrayList<String> edges = new ArrayList<>();

    public static void main(String[] args) {

        initMatrix();

        fillMatrix();

        print();

        getMinTicketPrice(5, 6, 0);
        //System.out.println(minTicketPrice);

        getAnyRoadToVertex(1, 3);
        /*for (int value : anyPathToVertex) {
            System.out.print(value + " ");
        }*/

        dijkstraAlgorithm(4);


        //print();

    }

    private static int[] paths = new int[VERTEX_COUNT]; // минимальное расстояние
    private static boolean[] visitedVertexes = new boolean[VERTEX_COUNT];
    private static int temp, minindex, min;

    /**
     * https://prog-cpp.ru/deikstra/ об алгоритме Дейкстры
     */
    private static void dijkstraAlgorithm(int toVertex) {
        initPathsAndVisitedVertex();

        // Шаг алгоритма
        do {
            minindex = Integer.MAX_VALUE;
            min = Integer.MAX_VALUE;

            for (int i = 0; i < VERTEX_COUNT; i++) {
                // Если вершину ещё не обошли и вес меньше min
                if (!visitedVertexes[i] && (paths[i] < min)) {
                    // Переприсваиваем значения
                    min = paths[i];
                    minindex = i;
                }
            }
            // Добавляем найденный минимальный вес
            // к текущему весу вершины
            // и сравниваем с текущим минимальным весом вершины
            if (minindex != Integer.MAX_VALUE) {
                for (int i = 0; i < VERTEX_COUNT; i++) {
                    if (matrix[minindex][i] > 0) {

                        temp = min + matrix[minindex][i];

                        if (temp < paths[i]) {
                            paths[i] = temp;
                        }
                    }
                }
                visitedVertexes[minindex] = true;
            }
        } while (minindex < Integer.MAX_VALUE);


        /*for (int i = 0; i < VERTEX_COUNT; i++) {
            System.out.print(paths[i] + " ");
        }*/

        // Восстановление пути
        int[] visitedVertexes = new int[VERTEX_COUNT]; // массив посещенных вершин
        int end = toVertex - 1; // индекс конечной вершины = 5 - 1
        visitedVertexes[0] = end + 1; // начальный элемент - конечная вершина
        int k = 1; // индекс предыдущей вершины
        int weight = paths[end]; // вес конечной вершины

        while (end != 0) { // пока не дошли до начальной вершины
            for (int i = 0; i < VERTEX_COUNT; i++) // просматриваем все вершины
                if (matrix[i][end] != 0) {  // если связь есть
                    int temp = weight - matrix[i][end]; // определяем вес пути из предыдущей вершины
                    if (temp == paths[i]) {   // если вес совпал с рассчитанным
                        // значит из этой вершины и был переход
                        weight = temp; // сохраняем новый вес
                        end = i;       // сохраняем предыдущую вершину
                        visitedVertexes[k] = i + 1; // и записываем ее в массив
                        k++;
                    }
                }
        }

        for (int i = k - 1; i >= 0; i--) {
            System.out.print(visitedVertexes[i] + " ");
        }
    }

    private static void initPathsAndVisitedVertex() {
        //Инициализация вершин и расстояний
        for (int i = 0; i < VERTEX_COUNT; i++) {
            paths[i] = Integer.MAX_VALUE;
            visitedVertexes[i] = false;
        }
        paths[0] = 0;
    }


    private static ArrayList<Integer> anyPathToVertex = new ArrayList<>();
    private static boolean isPathFound = false;

    /**
     * Вывод любого пути к заданной вершине
     */
    private static void getAnyRoadToVertex(int fromVertex, int toVertex) {

        if (isPathFound) {
            return;
        }

        if (fromVertex == toVertex) {
            isPathFound = true;
            anyPathToVertex.add(fromVertex);
            return;
        }

        visitedVertexes[fromVertex - 1] = true;
        anyPathToVertex.add(fromVertex);

        for (int i = fromVertex; i < VERTEX_COUNT; i++) {

            int nextVertex = matrix[fromVertex - 1][i];

            if (!visitedVertexes[i] && nextVertex == 1) {
                getAnyRoadToVertex(i + 1, toVertex);
            }
        }
    }

    private static ArrayList<Integer> ticketPrices = new ArrayList<>();
    private static int minTicketPrice = Integer.MAX_VALUE;

    /**
     * Вывод минимальной стоимости билета в невзвешанном графе (вес ребра - 1)
     */
    private static void getMinTicketPrice(int fromVertex, int toVertex, int weight) {

        if (fromVertex == toVertex) {
            if (weight < minTicketPrice) {
                minTicketPrice = weight;
            }
        }

        for (int i = fromVertex; i < VERTEX_COUNT; i++) {

            int currentWeight = matrix[fromVertex - 1][i];

            if (currentWeight > 0) {
                getMinTicketPrice(i + 1, toVertex, weight + currentWeight);
            }
        }
    }

    /**
     * Заполняем матрицу смежности из консоли, вводя пары значений и вес ребра
     */
    private static void fillMatrix() {

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < EDGED_COUNT; i++) {

            int vertex1 = in.nextInt();
            int vertex2 = in.nextInt();
            int weight = in.nextInt();

            matrix[vertex1 - 1][vertex2 - 1] = weight;
            matrix[vertex2 - 1][vertex1 - 1] = weight;
        }
    }

    /**
     * Инициализация матрицы смежности графа
     */
    private static void initMatrix() {

        // fill 0 and -1
        for (int i = 0; i < VERTEX_COUNT; i++) {

            for (int j = 0; j < VERTEX_COUNT; j++) {

                if (i == j) {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = 0;
                }

            }
        }
    }

    /**
     * Список рёбер в графе
     */
    private static void getEdgesFromMatrix() {

        for (int i = 0; i < VERTEX_COUNT; i++) {

            for (int j = 0; j < i; j++) {

                if (matrix[i][j] == 1) {
                    edges.add((i + 1) + " - " + (j + 1));
                }

            }
        }

        for (String edge : edges) {
            System.out.println(edge);
        }
    }

    private static void print() {

        for (int i = 0; i < VERTEX_COUNT; i++) {

            for (int j = 0; j < VERTEX_COUNT; j++) {

                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}
