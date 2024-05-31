package my;
public class GameOfLife {
        private static final int SIZE = 10; // 网格大小
        private static int[][] grid = new int[SIZE][SIZE]; // 存储细胞状态的二维数组

        // 初始化细胞状态
        private static void initialize() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    // 随机设置细胞的初始状态
                    grid[i][j] = Math.random() > 0.5 ? 1 : 0;
                }
            }
        }

        // 更新细胞状态
        private static void update() {
            int[][] newGrid = new int[SIZE][SIZE]; // 创建一个新的二维数组来存储更新后的状态

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    int neighbors = countNeighbors(i, j); // 计算邻居细胞的数量

                    // 根据规则更新细胞状态
                    if (grid[i][j] == 1) {
                        if (neighbors < 2 || neighbors > 3) {
                            newGrid[i][j] = 0; // 孤立或拥挤，细胞死亡
                        } else {
                            newGrid[i][j] = 1; // 适宜的生存环境，细胞存活
                        }
                    } else {
                        if (neighbors == 3) {
                            newGrid[i][j] = 1; // 正好三个邻居，细胞复活
                        } else {
                            newGrid[i][j] = 0; // 其他情况，细胞继续死亡
                        }
                    }
                }
            }

            // 更新网格状态
            grid = newGrid;
        }

        // 计算指定位置细胞的邻居数量
        private static int countNeighbors(int x, int y) {
            int count = 0;
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE) {
                    count += grid[nx][ny];
                }
            }

            return count;
        }

        // 打印当前细胞状态
        private static void printGrid() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(grid[i][j] == 1 ? "■ " : "□ ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public static void main(String[] args) {
            initialize(); // 初始化细胞状态

            // 模拟100个时间步骤
            for (int i = 0; i < 100; i++) {
                printGrid(); // 打印当前细胞状态
                update();    // 更新细胞状态
            }
        }
    }

