import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private LocalDateTime horario;
    private List<ItemPedido> itens;


    public Pedido(int numeroPedido, LocalDateTime horario, List<ItemPedido> itens) {
        this.numeroPedido = numeroPedido;
        this.horario = horario;
        this.itens = itens;
    }

    public Pedido() {
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public LocalDateTime getHorario() {
        return horario;
    }
    public double custoTotal() {
        double valor = 0.0;
        for (ItemPedido ip : itens) {

            valor += ip.custoItemPedido();
        }
        return valor;
    }
    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido: " + numeroPedido + " Total: " +
                this.custoTotal() +
                '}';
    }
}
