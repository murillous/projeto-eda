package estruturas.grafo;

public class Vertice {
    private final String vertice;
    private final int indice;
    private boolean colorido = false;

    public Vertice(String vertice, int indice){
        this.vertice = vertice;
        this.indice = indice;
    }

    public String obterVertice(){
        return vertice;
    }

    public int obterIndice(){
        return indice;
    }

    public boolean ehColorido(){
        return colorido;
    }

    public void definirEhColorido(boolean colorido){
        this.colorido = colorido;
    }

}
