public class No {

    private int numero;
    private No linkd;
    private No linke;

    public No(int numero) {
        this.numero = numero;
        this.linkd = null;
        this.linke = null;
    }

    public No(int numero, No linkd) {
        this.numero = numero;
        this.linkd = linkd;
        this.linke = null; 
    }

    public No(int numero, No linkd, No linke) {
        this.numero = numero;
        this.linkd = linkd;
        this.linke = linke;
    }

    public No getLinkd() {
        return linkd;
    }

    public void setLinkd(No linkd) {
        this.linkd = linkd;
    }

    public No getLinke() {
        return linke;
    }

    public void setLinke(No linke) {
        this.linke = linke;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
} 
