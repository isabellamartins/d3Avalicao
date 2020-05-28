public class ListaDuplamenteLigada {

    private No primeiro = null;
    private No ultimo = null;
    private int tamanho = 0;

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.tamanho;
    }

    private No pegaNo(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição Inexistente!");
        }

        No atual = primeiro;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getLinkd();
        }

        return atual;
    }

    public void adicionaNoComeco(int numero) {
        if (this.tamanho == 0) {
            No novo = new No(numero);
            this.primeiro = this.ultimo = novo;
        } else {
            No novo = new No(numero, this.primeiro);
            this.primeiro.setLinke(novo);
            this.primeiro = novo;
        }
        this.tamanho++;
    }

    public void adicionaNoFim(int numero) {
        if (this.tamanho == 0) {
            this.adicionaNoComeco(numero);
        } else {
            No novo = new No(numero);
            this.ultimo.setLinkd(novo);
            novo.setLinke(this.ultimo);
            this.ultimo = novo;

            this.tamanho++;
        }
    }

    public void adiciona(int posicao, int numero) {
        if (posicao == 0) {
            this.adicionaNoComeco(numero);
        } else if (posicao == this.tamanho) {
            this.adicionaNoFim(numero);
        } else {
            No anterior = this.pegaNo(posicao - 1);
            No proximo = anterior.getLinkd();

            No novo = new No(numero, proximo);
            novo.setLinke(anterior);
            anterior.setLinkd(novo);
            proximo.setLinke(novo);

            this.tamanho++;
        }
    }

    public int pega(int posicao) {
        return this.pegaNo(posicao).getNumero();
    }

    public int removeDoComeco() {
        if (this.tamanho == 0) {
            throw new IllegalArgumentException("Lista vazia!");
        }

        int numero = this.primeiro.getNumero();

        this.primeiro = primeiro.getLinkd();
        this.tamanho--;

        if(this.tamanho == 0) {
            this.ultimo = null;
        }

        return numero;
    }

    public void removeDoFim() {
        if (this.tamanho <= 1) {
            this.removeDoComeco();
        } else {
            No penultimo = this.ultimo.getLinke();

            penultimo.setLinkd(null);
            this.ultimo = penultimo;
            this.tamanho--;
        }
    }

    public void remove(int posicao) {
        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.tamanho - 1) {
            this.removeDoFim();
        } else {
            No anterior = this.pegaNo(posicao - 1);
            No atual = anterior.getLinkd();
            No proximo = atual.getLinkd();

            anterior.setLinkd(proximo);
            proximo.setLinke(anterior);

            this.tamanho--;
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean contem(int numero) {
        No atual = this.primeiro;

        while (atual != null) {
            if(atual.getNumero() == numero) {
                return true;
            }
            atual = atual.getLinkd();
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        No atual = this.primeiro;

        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getNumero());
            builder.append(", ");

            atual = atual.getLinkd();
        }

        builder.append(atual.getNumero());
        builder.append("]");

        return builder.toString();
    }

} 
