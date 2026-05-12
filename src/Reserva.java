public class Reserva {
    private Data d;
    private Horario inicio;
    private Horario fim;
    private Espaco esp;
    private Cliente cli;

    public double preco(){
        return esp.preco(this.inicio, this.fim);
    }

    public Reserva(Data d, Horario inicio, Horario fim, Espaco esp, Cliente cli) {
        this.d = d;
        this.inicio = inicio;
        this.fim = fim;
        this.esp = esp;
        this.cli = cli;
    }

    public Data getD() {
        return d;
    }

    public void setD(Data d) {
        this.d = d;
    }

    public Horario getFim() {
        return fim;
    }

    public void setFim(Horario fim) {
        this.fim = fim;
    }

    public Horario getInicio() {
        return inicio;
    }

    public void setInicio(Horario inicio) {
        this.inicio = inicio;
    }

    public Espaco getEsp() {
        return esp;
    }

    public void setEsp(Espaco esp) {
        this.esp = esp;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    @Override
    public String toString() {
        return "Reserva: \n" +
                "* Local: " + esp.toString() +"\n" +
                "* Data: " + d.toString() + "\n" +
                "* Horário: " + inicio.toString() + "\n" +
                "* Cliente: " + cli.toString() + "\n" +
                "* Valor: " + preco();
    }
}