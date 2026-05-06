import java.util.List;

public class Sala extends Espaco{
    private boolean projetor;
    private static double precoProjetor;



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
}
