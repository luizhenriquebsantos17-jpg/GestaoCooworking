import java.util.List;
import java.util.ArrayList;


public class Espaco {
    protected String descricao;
    protected static double valorHora;
    protected static double taxaLimpeza;
    protected List<Reserva> reservas;

    public double preco(Horario inicio,Horario fim ){
        int quantHoras = fim.getHora() - inicio.getHora();
        if ((fim.getMin() - inicio.getMin()) > 0){
            quantHoras++;
        }
        return ((getValorHora() * quantHoras) + getTaxaLimpeza());
    }
    public void adicionarReserva(Reserva r){
        this.reservas.add(r);
    }
    public boolean possuiAdicionalExtra(){
        return true;
    }
    public boolean disponivel(Data d, Horario inicio, Horario fim, boolean extra){
        if(extra && !possuiAdicionalExtra()){
            return false;
        }
        for (Reserva r : reservas){
            if (r.getD().equals(d)){
                if((inicio.compara(r.getInicio()) == -1) && (fim.compara(r.getInicio()) == 1)){
                    return false;
                }
                if((inicio.compara(r.getInicio()) == 1) && (inicio.compara(r.getFim()) == -1)){
                    return false;
                }
            }
        }
        return true;
    }

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

    @Override
    public String toString() {
        return descricao;
    }
}