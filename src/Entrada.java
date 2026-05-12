import java.util.Scanner;

public class Entrada {
    Scanner input = new Scanner(System.in);

    public Entrada() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input2.txt")).useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            // Locale.US para que o Java sempre leia double com "pontos" ao invés de "vírgulas"
            this.input = new Scanner(System.in).useLocale(Locale.US);
        }
    }

    public String lerLinha(String msg) {
        System.out.println(msg);
        String s = this.input.nextLine();
        while (s.charAt(0) == '#') s = this.input.nextLine();
        return s;
    }

    public int lerInteiro(String msg) {
        System.out.println(msg);
        int s = this.input.nextInt();
        return s;
    }

    public double lerDouble(String msg) {
        System.out.println(msg);
        double s = this.input.nextDouble();
        return s;
    }

    public Cliente LerCliente(Sistema s) {
        String nome = lerLinha("Nome: ");
        String email = lerLinha("CPF: ");
        String cpf = lerLinha("CPF: ");
        String senha = lerLinha("Senha: ");
        return new Cliente(nome, email, cpf, senha);
    }

    public Data LerData(Sistema s) {

        int d = this.lerInteiro("Dia: ");
        int m = this.lerInteiro("Mês: ");
        int a = this.lerInteiro("Ano: ");
        return new Data(d, m, a);
    }

    public Horario lerHorario(Sistema s) {
        int min = lerInteiro("Minuto: ");
        int hora = lerInteiro("Hora: ");
        return new Horario(min, hora);
    }

    public String lerTIpo(Sistema s) {
        String tipo = lerLinha("Deseja reservar uma sala ou estação de trabalho? (s/e): ").toLowerCase();
        while (!tipo.equals("e") && !tipo.equals("s")) {
            tipo = lerLinha("Resposta inválida, insira (s/e): ");
        }
        return tipo;
    }

    public boolean lerExtra(Sistema s) {

    }

    public void listarSalas(Sistema s) {
        for (Sala i : s.getSalas()) {
            System.out.println();
        }
    }

    public void listarEstacoes(Sistema s) {
        for (Cliente i : s.getEstacoes()) {
            System.out.println(i.toString());
        }

    }

    public void listarClientes(Sistema s) {
        for (Cliente i : s.geTclientes()) {
            System.out.println(i.getNome() + "(" + i.getEmail() + " - CPF: " + i.getCpf() + ")");
        }

    }

    public void listarReservas(Sistema s) {

    }

    public void listarReservasDatas(Sistema s) {

    }

    public void listReservasClientes(Sistema s) {

    }


    public int menu() {
        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastros\n" +
                "2) Reservas\n" +
                "0) Sair\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 2) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    public void menuCadastro(Sistema s) {
        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Ver clientes\n" +
                "2) Ver salas\n" +
                "3) Ver estações de trabalho\n" +
                "4) Cadastrar cliente\n" +
                "5) Cadastrar sala\n" +
                "6) Cadastrar estação de trabalho\n" +
                "0) Voltar\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 6) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        switch (op) {
            case 1:
                this.listarClientes(s);
                break;
            case 2:
                this.listarSalas(s);
                break;
            case 3:
                this.listarEstacoes(s);
                break;
            case 4:
                this.cadastrarCliente(s);
                break;
            case 5:
                // chamar metodo para cadastrar sala
                break;
            case 6:
                // chamar metodo para cadastrar estacao
                break;
        }
    }

    public void cadastrarSala(s) {

    }
}