import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TesteAlgoritmo {
    public static void main(String[] args) throws IOException {
        Vetor v = new Vetor();
        ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
        ArvoreBinaria arvore = new ArvoreBinaria();

        for (int i = 0; i < v.tamanho(); i++) {
            int numero = v.get(i);

            lista.adicionaNoFim(numero);
            arvore.adiciona(numero);
        }

        System.out.println("Lista Duplamente Ligada:\n" + lista + "\n\n");
        System.out.println("Árvore Binária:\n" + arvore + "\n\n");

        FileWriter csvWriter = new FileWriter("resultados.csv");
        csvWriter.append("Teste,Tempo LDE,Tempo AB\n");

        List<List<String>> linhas = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            List<String> linha = new ArrayList<>();

            int chaveBusca = v.sorteiaIndice();
            System.out.println("\n================================================================");
            System.out.printf("\nTentativa %d\nNúmero Sorteado: %d\n", i, chaveBusca);
            linha.add(Integer.toString(i));

            System.out.println("\nMedindo tempo de busca na Lista Duplamente Ligada:\n");
            long inicio = System.nanoTime();
            lista.contem(chaveBusca);
            long fim = System.nanoTime() - inicio;
            System.out.println("Tempo: " + fim);
            linha.add(Long.toString(fim));

            System.out.println("\nMedind tempo de busca na Árvore Binária:\n");
            inicio = System.nanoTime();
            arvore.busca(chaveBusca);
            fim = System.nanoTime() - inicio;
            System.out.println("Tempo: " + fim);
            linha.add(Long.toString(fim));
            System.out.println("================================================================\n");

            linhas.add(linha);
        }

        for (List<String> linha : linhas) {
            csvWriter.append(String.join(",", linha));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

} 
