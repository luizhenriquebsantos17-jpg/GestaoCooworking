import java.util.List;
import java.util.ArrayList;

public class Sistema {
    private List<Espaco> salas;
    private List<Espaco> estacoes;
    private List<Cliente> clientes;

    public Cliente getCliente(String cpf){
        for(Cliente c : clientes){
            if(c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }
    public void cadastrar(Cliente c) {
        if (!this.clientes.contains(c)) {
            this.clientes.add(c);
        }
    }
    public void cadastrar(Estacao est) {
        if (!this.estacoes.contains(est)){
            this.estacoes.add(est);
        }
    }
    public void cadastrar(Sala s) {
        if (!this.salas.contains(s)) {
            this.salas.add(s);
        }
    }

    public boolean reservar(String tipo, Data d, Horario inicio, Horario fim, Cliente c, boolean extra) {
        if (tipo.equals("e")) {
            for (Espaco est : estacoes) {
                if (est.disponivel(d, inicio, fim, extra)) {
                    Reserva r = new Reserva(d, inicio, fim, est, c);
                    est.adicionarReserva(r);
                    return true;
                }
            }
            return false;
        } else if (tipo.equals("s")) {
            for (Espaco s : salas) {
                if (s.disponivel(d, inicio, fim, extra)) {
                    Reserva r = new Reserva(d, inicio, fim, s, c);
                    s.adicionarReserva(r);
                    return true;
                }
            }
        }
            return false;

    }

    public boolean reservar (String tipo, Data d, Cliente c,boolean extra) {
        Horario inicio = new Horario(8, 0);
        Horario fim = new Horario(22, 0);

        if (tipo.equals("e")) {
            for (Espaco est : estacoes) {
                if (est.disponivel(d, inicio, fim, extra)) {
                    Reserva r = new Reserva(d, inicio, fim, est, c);
                    est.adicionarReserva(r);
                    return true;
                }
            }
            return false;
        } else if (tipo.equals("s")) {
            for (Espaco s : salas) {
                if (s.disponivel(d, inicio, fim, extra)) {
                    Reserva r = new Reserva(d, inicio, fim, s, c);
                    s.adicionarReserva(r);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean reservar(String tipo, Data d, String turno, Cliente c, boolean extra){
        Horario inicio;
        Horario fim;
        switch (turno){
            case "matutino":
                inicio = new Horario(8,0);
                fim = new Horario(12,0);
                break;
            case "vespertino":
                inicio = new Horario(13,0);
                fim = new Horario(17,0);
                break;
            case "noturno":
                inicio = new Horario(18,0);
                fim = new Horario(22,0);
                break;
            default:
                inicio = null;
                fim = null;

        }
        if (tipo.equals("e")) {
            for (Espaco est : estacoes) {
                if (est.disponivel(d, inicio, fim, extra)) {
                    Reserva r = new Reserva(d, inicio, fim, est, c);
                    est.adicionarReserva(r);
                    return true;
                }
            }
            return false;
        }
        else if (tipo.equals("s")) {
            for (Espaco s : salas) {
                if (s.disponivel(d, inicio, fim, extra)) {
                    Reserva r = new Reserva(d, inicio, fim, s, c);
                    s.adicionarReserva(r);
                    return true;
                }
            }
        }
        return false;
    }
    public List<Reserva> getReserva(){
        List<Reserva> auxl = new ArrayList<>();
        for (Espaco est : estacoes){
            auxl.addAll(est.getReservas());
        }
        for (Espaco s : salas){
            auxl.addAll(s.getReservas());
        }
        return auxl;
    }
    public List<Reserva> getReserva(Data d){
        List<Reserva> auxl = new ArrayList<>();
        for (Espaco est : estacoes){
            for(Reserva res : est.getReservas()){
                if(res.getD().equals(d)){
                    auxl.add(res);
                }
            }
        }
        for (Espaco s : salas){
            for(Reserva res : s.getReservas()){
                if (res.getD().equals(d)){
                    auxl.add(res);
                }
            }
        }
        return auxl;
    }

    public List<Reserva> getReserva(Cliente c){
        List<Reserva> auxl = new ArrayList<>();
        for (Espaco est : estacoes){
            for(Reserva res : est.getReservas()){
                if(res.getCli() == c){
                    auxl.add(res);
                }
            }
        }
        for (Espaco s : salas){
            for(Reserva res : s.getReservas()){
                if (res.getCli() == c){
                    auxl.add(res);
                }
            }
        }
        return auxl;
    }


    public Sistema(List<Espaco> salas, List<Espaco> estacoes, List<Cliente> clientes) {
        this.salas = salas;
        this.estacoes = estacoes;
        this.clientes = clientes;
    }

    public List<Espaco> getSalas() {
        return salas;
    }

    public void setSalas(List<Espaco> salas) {
        this.salas = salas;
    }

    public List<Espaco> getEstacoes() {
        return estacoes;
    }

    public void setEstacoes(List<Espaco> estacoes) {
        this.estacoes = estacoes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
