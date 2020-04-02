public class GameOfLife {
	private int[][] matrix, matrix2;

	public GameOfLife(int lin, int col) {
		matrix = new int[lin][col];
		matrix2 = new int[lin][col];
	}

	public int setCellAlive(int x, int y) {
		if(x > matrix.length - 1 || x < 0 || y < 0 || y > matrix.length - 1)
			return -1;

		return matrix[x][y] = 1;
	}

	public int setCellDead(int x, int y) {
		if(x > matrix.length - 1 || x < 0 || y < 0 || y > matrix.length - 1)
			return -1;

		return matrix[x][y] = 0;
	}

	public void execCycle() {
		int state;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				state = matrix[i][j];
				int viz = contaViz(matrix, i, j);
				if(state == 0 && viz == 3) {
					matrix2[i][j] = 1;
				} else if (viz < 2 || viz > 3 && state == 1) {
					matrix2[i][j] = 0;
				} else {
					matrix2[i][j] = state;
				}
			}
		}
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++)
				matrix[i][j] = matrix2[i][j];
		}
	}

	public int contaViz(int[][] m, int x, int y) {
		int viz = 0;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				int col = (x + i + m.length) % m.length;
				int lin = (y + j + m.length) % m.length;
				viz += m[col][lin];
			}
		}
		viz -= m[x][y];
		return viz;
	}

	public void show(){
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++)
				System.out.print(matrix[i][j] + " ");

			System.out.println();
		}
		System.out.println();
	}

	public void showComNumeros() {
		System.out.print("    ");
		for(int k = 0; k < matrix.length; k++)
			System.out.print(k + " ");

		System.out.println("\n");

		for(int i = 0; i < matrix.length; i++) {
			System.out.print(i + "   ");
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void clearScreen() {
		// ANSI CODE
		// System.out.println("\033[2J\033[;H"); // Funciona mas nao tanto
		final String ANSI_CLS = "\u001b[2J"; // Limpa tela.
		final String ANSI_HOME = "\u001b[H"; // Posiciona cursor.
		System.out.print(ANSI_CLS + ANSI_HOME);
		System.out.flush();
	}
}
