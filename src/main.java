public class main {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Sistema sistema = entrada.criarSistema();
        int op = -1;
        while (op != 0) {
            op = entrada.menu();
            if (op == 1) {
                entrada.menuCadastro(sistema);
            }
            if (op == 2) {
                entrada.menuReservas(sistema);
            }

        }
    }
}