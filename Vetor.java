import java.util.Arrays;
import java.util.Random;

public class Vetor {

    private int[] vetor;
    private int tamanho;

    public Vetor() {
        this.tamanho = 1000;
        vetor = preencheVetor();
    }

    public int[] preencheVetor() {
        int[] vet = new int[tamanho];

        Random r = new Random();

        for (int i = 0; i < vet.length; i++) {
            int num = r.nextInt(1000) + 1;
            if (!existe(num, i, vet))
                vet[i] = num;
            else
                i--;
        }

        return vet;
    }

    private boolean existe(int num, int ate, int[] vet) {
        for (int i = 0; i < ate; i++) {
            if (vet[i] == num) {
                return true;
            } 
        }
        return false;
    }

    public int[] getVetor() {
        return vetor;
    }

    public int get(int posicao) {
        return vetor[posicao];
    }

    public int tamanho() {
        return tamanho;
    }

    public int sorteiaIndice() {
        Random r = new Random();
        return r.nextInt(1000) + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(vetor);
    }

} 
