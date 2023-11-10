import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RoboDeLimpeza {
	
    private static class Coord {
        int x;
        int y;

        Coord (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Quarto {
        char[][] estQuarto;
        char[][] ambiente;
        Coord posicaoRobo;
        int bolsaDeSujeira;
        int energia = 10;
    

        Quarto(char[][] ambiente, char[] pontosSujos, int energia) {
            this.ambiente = ambiente;
            this.estQuarto = new char[ambiente.length][ambiente[0].length];
            inicializarEstQuarto(pontosSujos);
            this.posicaoRobo = new Coord (0, 0);
             this.bolsaDeSujeira = 0;
            this.energia = energia;
            
        }

        private void inicializarEstQuarto(char[] pontosSujos) {
            for (int i = 0; i < estQuarto.length; i++) {
                for (int j = 0; j < estQuarto[i].length; j++) {
                    if (temPontoSujos(pontosSujos, ambiente[i][j])) {
                        estQuarto[i][j] = 'S';
                    } else {
                        estQuarto[i][j] = 'L';
                    }
                }
            }
        }
	    private boolean temSujeira() {
            int x = posicaoRobo.x;
            int y = posicaoRobo.y;
            return x >= 0 && x < estQuarto[0].length && y >= 0 && y < estQuarto.length && estQuarto[y][x] == 'S';
        }

        private void limparSujeira() {
            int x = posicaoRobo.x;
            int y = posicaoRobo.y;
            estQuarto[y][x] = 'L';
        }

        private boolean todasAsCelulasEstaoLimpa() {
            for (char[] linha : estQuarto) {
                for (char celula : linha) {
                    if (celula == 'S') {
                        return false;
                    }
                }
            }
            return true;
        }

     
