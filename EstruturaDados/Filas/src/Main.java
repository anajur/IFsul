public class Main {
    public static void main(String[] args) {


        FilaDinamica filaAleatoria = new FilaDinamica();
        FilaDinamica filaPares = new FilaDinamica();
        FilaDinamica filaImpares = new FilaDinamica();

        filaAleatoria.inserir(1);
        filaAleatoria.inserir(2);
        filaAleatoria.inserir(3);
        filaAleatoria.inserir(4);
        filaAleatoria.inserir(5);
        filaAleatoria.inserir(6);


        do {
            int removido = filaAleatoria.remover();
            if (removido % 2 == 0) {
                filaPares.inserir(removido);
            } else {
                filaImpares.inserir(removido);
            }
        } while (!filaAleatoria.estaVazia());

        System.out.println("Fila Aleatória");
        filaAleatoria.imprimir();
        System.out.println("Fila de números Pares");
        filaPares.imprimir();
        System.out.println("Fila de números Ímpares");
        filaImpares.imprimir();


    }
}
