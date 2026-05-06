public class Horario {
    private int hora;
    private int min;

    public int compara(Horario h2){
        if (this.hora < h2.hora) {
            return -1;
        }
        else if(this.hora > h2.hora){
            return 1;
        }
        if (this.min < h2.min){
            return -1;
        }
        else if(this.min > h2.min){
            return 1;
        }
        return 0;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public Horario(int hora, int min) {
        this.hora = hora;
        this.min = min;
    }

    @Override
    public String toString() {
        return String.format("%02d", this.hora) + ":" + String.format("%02d", this.min);
    }
}
