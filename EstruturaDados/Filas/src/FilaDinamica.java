public class FilaDinamica {
    private Celula inicio;

    public FilaDinamica() {
        this.inicio = null;
    }

    public boolean estaVazia() {
        return this.inicio == null;
    }

    public void inserir(int elemento) {
        Celula celula = inicio;
        if (estaVazia()) {
            inicio = new Celula(null, elemento);
        } else {
            while (celula != null) {
                if (celula.getProxima() == null) {
                    celula.setProxima(new Celula(null, elemento));
                    break;
                }
                celula = celula.getProxima();
            }}
    }

    public int remover() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        } else {
            Celula antiga = inicio;
            inicio = antiga.getProxima();
            return antiga.getElemento();
        }
    }

    public void imprimir() {
        if (estaVazia()) {
            System.out.println("A fila está vazia!");
        } else {
            Celula proxima = inicio;
            do {
                System.out.println(proxima.getElemento());
                proxima = proxima.getProxima();
            } while (proxima != null);
        }
    }

}
