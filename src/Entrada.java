import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
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


    public Sistema criarSistema() {
        System.out.println("Iniciando o sistema...");
        double valorHora = this.lerDouble("Digite o valor por hora para usar um espaço: R$ ");
        double taxaLimpeza = this.lerDouble("Digite a taxa de limpeza: R$ ");
        double precoProjetor = this.lerDouble("Digite o valor extra para usar o projetor: R$ ");
        double precoMonitor = this.lerDouble("Digite o valor para usar o monitor extra: R$ ");

        return new Sistema(valorHora, taxaLimpeza, precoProjetor, precoMonitor);
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

    public Cliente lerCliente(Sistema s) {
        String nome = lerLinha("Digite o nome do cliente: ");
        String email = lerLinha("Digite o CPF do cliente: ");
        String cpf = lerLinha("Digite o email do cliente: ");
        String senha = lerLinha("Digite a senha do cliente: ");
        return new Cliente(nome, email, cpf, senha);
    }

    public Data lerData(Sistema s) {

        int d = this.lerInteiro("Dia: ");
        int m = this.lerInteiro("Mês: ");
        int a = this.lerInteiro("Ano: ");
        return new Data(d, m, a);
    }

    public Horario lerHorario(Sistema s) {
        int hora = lerInteiro("Hora: ");
        int min = lerInteiro("Minuto: ");
        return new Horario(hora, min);
    }

    public String lerTIpo(Sistema s) {
        String tipo = lerLinha("Deseja reservar uma sala ou estação de trabalho? (s/e): ").toLowerCase();
        while (!tipo.equals("e") && !tipo.equals("s")) tipo = lerLinha("Resposta inválida, insira (s/e): ");
        return tipo;
    }



    public void listarSalas(Sistema s) {
        String msg = "";
        System.out.println("Salas cadastradas:");
        int j = 0;
        for (Espaco i : s.getSalas()) {
            j = j + 1;
            if (i.possuiAdicionalExtra()) {
                msg = " (Sala com Projetor)";
            } else {
                msg = " (Sala sem Projetor)";
            }
            System.out.println(i.descricao + msg);
        }
    }

    public void listarEstacoes(Sistema s) {
        String msg = "";
        System.out.println("Estações de Trabalho cadastradas:");
        int j = 0;
        for (Espaco i : s.getEstacoes()) {
            j = j + 1;
            if (i.possuiAdicionalExtra()) {
                msg = " (Estacao de Trabalho com Monitor Extra)";
            } else {
                msg = " (Estacao de Trabalho sem Monitor Extra)";
            }
            System.out.println("Estacao " + String.format("%02d", j) + msg);
        }

    }

    public void listarClientes(Sistema s) {
        for (Cliente i : s.getClientes()) {
            System.out.println(i.toString());
        }

    }

    public void listarReservas(Sistema s) {
        System.out.println("Reservas cadastradas:");
        for (Reserva i : s.getReserva()) {
            System.out.println(i.toString());
        }
    }

    public void listarReservasData(Sistema s) {
        System.out.println("Escolha uma data (dd/mm/aaaa):");
        Data data = this.lerData(s);
        for (Reserva i :s.getReserva(data)) {
            System.out.println(i.toString());
        }

    }



    public void listarReservasClientes(Sistema s) {
        System.out.println("Clientes cadastrados:");
        this.listarClientes(s);
        String cpf = this.lerLinha("Digite o CPF do Cliente: ");
        Cliente cliente = s.getCliente(cpf);
        for (Reserva i :s.getReserva(cliente)) {
            System.out.println(i.toString());
        }
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
                this.cadastrarSala(s);
                break;
            case 6:
                this.cadastrarEstacao(s);
                break;
        }
    }

    public void menuReservas(Sistema s) {
        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Ver reservas\n" +
                "2) Ver reservas por data\n" +
                "3) Ver reservas por cliente\n" +
                "4) Fazer Reserva (dia inteiro)\n" +
                "5) Fazer Reserva (turno inteiro)\n" +
                "6) Fazer reserva (horário específico)\n" +
                "0) Voltar\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 6) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        switch (op) {
            case 1:
                this.listarReservas(s);
                break;
            case 2:
                this.listarReservasData(s);
                break;
            case 3:
                this.listarReservasClientes(s);
                break;
            case 4:
                this.reservarData(s);
                break;
            case 5:
                this.reservarTurno(s);
                break;
            case 6:
                this.reservarHorario(s);
                break;
        }
    }

    public void cadastrarSala(Sistema s) {
        String descricao = this.lerLinha("Digite o nome da sala: ");
        String p = this.lerLinha("Possui Projetor? (s/n): ").toLowerCase();
        while (!p.equals("s") && !p.equals("n")) {
            p = this.lerLinha("Valor inválido, possui projetor? (s/n): ").toLowerCase();
        }
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        boolean projetor = p.equals("s");
        Sala sala = new Sala(descricao, reservas, projetor);


        s.cadastrar(sala);
    }

    public void cadastrarEstacao(Sistema s) {
        String descricao = this.lerLinha("Digite o nome da estação de trabalho: ");
        String p = this.lerLinha("Possui monitor extra? (s/n): ").toLowerCase();
        while (!p.equals("s") && !p.equals("n")) {
            p = this.lerLinha("Valor inválido, possui monitor extra? (s/n): ").toLowerCase();
        }
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        boolean projetor = p.equals("s");
        Estacao estacao = new Estacao(descricao, reservas, projetor);

        s.cadastrar(estacao);

    }

    public void cadastrarCliente(Sistema s) {
        Cliente cliente = this.lerCliente(s);
        s.cadastrar(cliente);
    }

    public void reservarData(Sistema s) {
        String tipo = this.lerLinha("Deseja reservar uma sala ou estação de trabalho? (s/e): ");
        while (!tipo.equals("e") && !tipo.equals("s"))
            tipo = this.lerLinha("Valor inválido, Deseja reservar uma sala ou estação de trabalho? (s/e): ");
        String extra = this.lerLinha("Deseja reservar sala com projetor? (s/n): ");
        while (!extra.equals("s") && !extra.equals("n"))
            tipo = this.lerLinha("Valor inválido: Deseja reservar sala com projetor? (s/n): ");
        System.out.println("Escolha uma data (dd/mm/aaaa):" );
        Data data = this.lerData(s);
        System.out.println("********************************");
        System.out.println("Clientes cadastrados:");
        this.listarClientes(s);
        String cpf = this.lerLinha("Digite o CPF do cliente: ");
        Cliente cliente = s.getCliente(cpf);
        boolean s1 = s.reservar(tipo, data, cliente, extra.equals("s"));



    }

    public void reservarTurno(Sistema s) {
        String tipo = this.lerLinha("Deseja reservar uma sala ou estação de trabalho? (s/e): ");
        while (!tipo.equals("e") && !tipo.equals("s"))
            tipo = this.lerLinha("Valor inválido, Deseja reservar uma sala ou estação de trabalho? (s/e): ");
        String extra = this.lerLinha("Deseja reservar sala com projetor? (s/n): ");
        while (!extra.equals("s") && !extra.equals("n"))
            tipo = this.lerLinha("Valor inválido: Deseja reservar sala com projetor? (s/n): ");
        System.out.println("Escolha uma data (dd/mm/aaaa):" );
        Data data = this.lerData(s);
        String turno = this.lerLinha("Escolha um turno: matutino, vespertino ou noturno (m/v/n): ");
        System.out.println("********************************");
        System.out.println("Clientes cadastrados:");
        this.listarClientes(s);
        String cpf = this.lerLinha("Digite o CPF do cliente: ");
        Cliente cliente = s.getCliente(cpf);
        boolean s1 = s.reservar(tipo, data, turno, cliente, extra.equals("s"));
        if (s1) {
            System.out.println("Reserva Realizada com sucesso!");
        } else {
            System.out.println("Reserva não Realizada com sucesso!");
        }
    }

    public void reservarHorario(Sistema s) {
        String tipo = this.lerLinha("Deseja reservar uma sala ou estação de trabalho? (s/e): ");
        while (!tipo.equals("e") && !tipo.equals("s"))
            tipo = this.lerLinha("Valor inválido, Deseja reservar uma sala ou estação de trabalho? (s/e): ");
        String extra = this.lerLinha("Deseja reservar sala com projetor? (s/n): ");
        while (!extra.equals("s") && !extra.equals("n"))
            tipo = this.lerLinha("Valor inválido: Deseja reservar sala com projetor? (s/n): ");
        System.out.println("Escolha uma data (dd/mm/aaaa):" );
        Data data = this.lerData(s);
        System.out.println("Escolha um horário (hh:mm): ");
        Horario h1 = this.lerHorario(s);
        System.out.println("Escolha um horário (hh:mm): ");
        Horario h2 = this.lerHorario(s);
        System.out.println("********************************");
        System.out.println("Clientes cadastrados:");
        this.listarClientes(s);
        String cpf = this.lerLinha("Digite o CPF do cliente: ");
        Cliente cliente = s.getCliente(cpf);
        boolean s1 = s.reservar(tipo, data, h1, h2, cliente, extra.equals("s"));
        if (s1) {
            System.out.println("Reserva Realizada com sucesso!");
        } else {
            System.out.println("Reserva não Realizada com sucesso!");
        }
    }


}