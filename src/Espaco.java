import java.util.List;
import java.util.ArrayList;


public class Espaco {
    protected String descricao;
    protected static double valorHora;
    protected static double taxaLimpeza;
    protected List<Reserva> reservas;

    public Espaco(String descricao, List<Reserva> reservas) {
        this.descricao = descricao;
        this.reservas = reservas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static double getTaxaLimpeza() {
        return taxaLimpeza;
    }

    public static void setTaxaLimpeza(double taxaLimpeza) {
        Espaco.taxaLimpeza = taxaLimpeza;
    }

    public static double getValorHora() {
        return valorHora;
    }

    public static void setValorHora(double valorHora) {
        Espaco.valorHora = valorHora;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
