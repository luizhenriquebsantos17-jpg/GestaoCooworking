import java.util.List;

public class Estacao extends Espaco{
    private boolean monitorExtra;
    private static double precoMonitor;

    @Override
    public double preco(Horario inicio, Horario fim){
        double total = super.preco(inicio, fim);
        if (possuiAdicionalExtra()){
            total += precoMonitor;
        }
        return total;
    }
    @Override
    public boolean possuiAdicionalExtra(){
        return monitorExtra;
    }

    public Estacao(String descricao, List<Reserva> reservas, boolean monitorExtra) {
        super(descricao, reservas);
        this.monitorExtra = monitorExtra;
    }

    public boolean isMonitorExtra() {
        return monitorExtra;
    }

    public void setMonitorExtra(boolean monitorExtra) {
        this.monitorExtra = monitorExtra;
    }

    public static double getPrecoMonitor() {
        return precoMonitor;
    }

    public static void setPrecoMonitor(double precoMonitor) {
        Estacao.precoMonitor = precoMonitor;
    }

    @Override
    public String toString() {
        String text = " sem";
        if (possuiAdicionalExtra()){
            text = " com";
        }

        return super.toString() + " (Estação de Trabalho " + text + " Monitor Extra)";
    }
}
