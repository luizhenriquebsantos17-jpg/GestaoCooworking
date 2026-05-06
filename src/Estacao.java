import java.util.List;

public class Estacao extends Espaco{
    private boolean monitorExtra;
    private static double precoMonitor;



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
}
