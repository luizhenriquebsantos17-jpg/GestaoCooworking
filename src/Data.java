public class Data {
    private int dia;
    private int mes;
    private int ano;

    public boolean equals(Data d2){
        return ((this.dia == d2.dia) && (this.mes == d2.mes) && (this.ano == d2.ano));
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString(){
        return String.format("%02d", this.dia) + "/" + String.format("%02d", this.mes) + "/" + String.format("%02d", this.ano);
    }
}
