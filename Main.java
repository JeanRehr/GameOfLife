public class Main {
	public static void opcoes() {
		System.out.print("0: Mostrar celulas.\n" +
				"1: Set cell alive.\n" +
				"2: Set cell dead.\n" +
				"3: Executar ciclo.\n" +
				"4: Limpa o console.\n" +
				"5: Sair.\n");
	}

	public static void main(String[] args) {
		Teclado t = new Teclado();
		GameOfLife g = new GameOfLife(10, 10);

		int input;
		do {
			opcoes();
			input = t.leInt("Digite a acao desejada.");

			switch(input) {
				case 0:
					g.showComNumeros();
					break;
				case 1:
					char c;
					do {
						int x = t.leInt("Digite a linha.");
						int y = t.leInt("Digite a coluna.");
						g.setCellAlive(x, y);
						c = t.leChar("Gostaria de continuar? (s / n)");
					} while(c == 's' || c =='S');
					break;
				case 2:
					do {
						int x = t.leInt("Digite a linha.");
						int y = t.leInt("Digite a coluna.");
						g.setCellDead(x, y);
						c = t.leChar("Gostaria de continuar? (s / n)");
					} while(c == 's' || c =='S');
					break;
				case 3:
					int ciclos = 0;
					ciclos = t.leInt("Digite quantos ciclos deseja executar.");
					if(ciclos < 1) {
						System.out.println("Numero invalido.");
						break;
					} else {
						char mostrar = t.leChar("Mostrar as celulas a cada ciclo? (s / n)");
						if(mostrar == 'n' || mostrar == 'N') {
							for(int i = 0; i < ciclos; i++)
								g.execCycle();
						} else {
							for(int i = 0; i < ciclos; i++) {
								g.show();
								g.execCycle();
							}
						}
					}
					break;
				case 4:
					try {
						final String os = System.getProperty("os.name");
						if(os.contains("Windows")) {
							//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Nao funciona??
							g.clearScreen();
						} else {
							// Runtime.getRuntime().exec("clear"); // Nao funciona??
							g.clearScreen();
						}
					} catch(Exception e) {
						System.out.println("Nao foi possivel.");
					}
					break;
				case 5:
					break;
				default:
					System.out.println("Opcao invalida.");
			}

		} while(input != 5);

		//glider
		/*g.setCellAlive(0, 1);
		g.setCellAlive(1, 2);
		g.setCellAlive(2, 2);
		g.setCellAlive(2, 1);
		g.setCellAlive(2, 0);
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();*/

		//oscillator wrong?
		/*g.setCellAlive(0, 0);
		g.setCellAlive(1, 0);
		g.setCellAlive(2, 0);
		g.setCellAlive(2, 2);
		g.setCellAlive(3, 2);
		g.setCellAlive(4, 2);
		g.setCellAlive(4, 4);
		g.setCellAlive(5, 4);
		g.setCellAlive(6, 4);
		g.setCellAlive(6, 6);
		g.setCellAlive(7, 6);
		g.setCellAlive(8, 6);

		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();*/

		//oscillator
		/*g.setCellAlive(0, 1);
		g.setCellAlive(1, 1);
		g.setCellAlive(2, 1);

		g.show();
		g.execCycle();
		g.show();
		g.execCycle();
		g.show();
		g.execCycle();*/
	}
}
