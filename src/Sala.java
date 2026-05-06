import java.util.List;

public class Sala extends Espaco{
    private boolean projetor;
    private static double precoProjetor;

    @Override
    public double preco(Horario inicio, Horario fim){
        double total = super.preco(inicio, fim) * 4;
        if (possuiAdicionalExtra()){
            total += precoProjetor;
        }
        return total;
    }

    @Override
    public boolean possuiAdicionalExtra(){
        return projetor;
    }

    public Sala(String descricao, List<Reserva> reservas, boolean projetor) {
        super(descricao, reservas);
        this.projetor = projetor;
    }

    public boolean isProjetor() {
        return projetor;
    }

    public void setProjetor(boolean projetor) {
        this.projetor = projetor;
    }

    public static double getPrecoProjetor() {
        return precoProjetor;
    }

    public static void setPrecoProjetor(double precoProjetor) {
        Sala.precoProjetor = precoProjetor;
    }

    @Override
    public String toString() {
        String text = " sem";
        if (possuiAdicionalExtra()){
            text = " com";
        }

        return super.toString() + " (Sala " + text + " Projetor)";
    }
}
