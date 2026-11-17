
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Robo> robosLista = new ArrayList<>();
        int opc = -1;

        do {
            System.out.println("==== Batalha dos Robôs ====");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Robô");
            System.out.println("2. Buscar Robô pelo código");
            System.out.println("3. Lista dos competidores");
            System.out.println("4. Combate individual");
            System.out.println("5. Rodada geral");
            System.out.println("6. Classificação");
            System.out.println("7. Estatísticas");
            System.out.println("8. Recuperar energia");
            System.out.println("9. Excluir Participante");
            System.out.println("Digite a operação: ");
            opc = buscarOperacao(s);

            switch (opc) {
                case 0:
                    System.out.println("Adeus!");
                    break;

                case 1:
                    System.out.println("Digite o nome do Robô: ");
                    String nome = s.next();

                    System.out.println("Digite o código do robô (somente números): ");
                    int codigo = s.nextInt();

                    System.out.println("Digite o dano de ataque do robô (somente números): ");
                    int ataque = s.nextInt();

                    System.out.println("Digite o valor de defesa do robô (somente números): ");
                    int defesa = s.nextInt();

                    int tipo;
                    do {
                        System.out.println("Digite o tipo do robô: ");
                        System.out.println("1. Ofensivo");
                        System.out.println("2. Defensivo");
                        System.out.println("3. Equilibrado");
                        tipo = s.nextInt();
                    } while (tipo < 1 || tipo > 3);

                    Robo robo = criarRobo(tipo, nome, codigo, ataque, defesa);
                    robosLista.add(robo);
                    System.out.println("Robô " + robo.getTipo() + " cadastrado!!!!!!");
                    break;

                case 2:
                    System.out.println("\n \n \n" + "-------------" + "\n" + "Digite o código do robô: ");
                    int codigoBusca = s.nextInt();
                    Robo roboBuscar = buscarRobo(robosLista, codigoBusca);
                    if (roboBuscar == null) {
                        System.out.println("Robô não encontrado!");
                        break;
                    }
                    System.out.println("\n\n\n\n\nRobô encontrado!\n");
                    System.out.println("Código: " + roboBuscar.getCodigo());
                    System.out.println("Nome: " + roboBuscar.getNome());
                    System.out.println("Tipo: " + roboBuscar.getTipo());
                    System.out.println("Ataque: " + roboBuscar.getAtaque());
                    System.out.println("Defesa: " + roboBuscar.getDefesa());
                    System.out.println("Energia: " + roboBuscar.getEnergiaAtual());
                    System.out.println("Vitorias: " + roboBuscar.getVitorias());
                    System.out.println("Derrotas: " + roboBuscar.getDerrotas());
                    System.out.println("Combates Realizados: " + roboBuscar.getCombatesRealizados());
                    if (roboBuscar.estaDisponivelParaLutar()) {
                        System.out.println("Pronto para lutar: Disponível!");
                    } else {
                        System.out.println("Pronto para lutar: Em recuperação!");
                    }
                    System.out.println("Pontuação Total: " + roboBuscar.getPontos());
                    break;

                case 3:
                    System.out.println("==== Listagem dos competidores ====");
                    for (Robo r : robosLista) {
                        System.out.println(
                                "\n" + "-------------" + "\n" +
                                        " Nome: " + r.getNome() + "\n" +
                                        " Código: " + r.getCodigo() + "\n" +
                                        " Tipo: " + r.getTipo() + "\n" +
                                        " ataque: " + r.getAtaque() + "\n" +
                                        " defesa: " + r.getDefesa() + "\n \n\n\n\n");
                    }
                    break;
                case 4:
                    System.out.println("\n \n \n" + "-------------" + "\n" + "Digite o código primeiro do robô: ");
                    int codigo1 = s.nextInt();

                    System.out.println("\n \n \n" + "-------------" + "\n" + "Digite o código do segundo robô: ");
                    int codigo2 = s.nextInt();

                    Robo robo1 = buscarRobo(robosLista, codigo1);
                    Robo robo2 = buscarRobo(robosLista, codigo2);

                    combate(robo1, robo2);
                    break;
                case 5:
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("Digite o código do robô que será excluído: ");
                    int codigoExcluir = s.nextInt();
                    if(codigoExcluir == 0){
                        System.out.println("Não há robôs cadastrados para exclusão.");
                        break;
                    }
                    excluirParticipante(robosLista, codigoExcluir);
                    break;

                default:
                    break;
            }
        } while (opc != 0);
        s.close();
    }

    public static Robo criarRobo(int tipo, String nome, int codigo, int ataque, int defesa) {
        switch (tipo) {
            case 1:
                return new RoboOfensivo(nome, codigo, ataque, defesa);
            case 2:
                return new RoboDefensivo(nome, codigo, ataque, defesa);
            case 3:
                return new RoboEquilibrado(nome, codigo, ataque, defesa);
            default:
                return null;
        }
    }

    public static Robo buscarRobo(ArrayList<Robo> robosLista, int codigos) {
        for (Robo roboBuscar : robosLista) {
            if (roboBuscar.getCodigo() == codigos) {
                return roboBuscar;
            }
        }
        return null;
    }

    public static void combate(Robo robo1, Robo robo2) {
        if (robo1 == null || robo2 == null || robo1 == robo2) {
            System.out.println("Combate Inválido, robôs ");
            return;
        }
        if (!robo1.estaDisponivelParaLutar() || !robo2.estaDisponivelParaLutar()) {
            System.out.println("Não é possível realizar o combate, algum robô não está dispoível para lutar!");
            return;
        }
        Robo primeiro = robo1;
        Robo segundo = robo2;
        if (robo2.getPontos() < robo1.getPontos()) {
            primeiro = robo2;
            segundo = robo1;
        }

        if (robo1.getPontos() == robo2.getPontos() && robo2.getCodigo() < robo1.getCodigo()) {
            primeiro = robo2;
            segundo = robo1;
        }
        System.out.println("\n==== " + primeiro.getNome() + " (" + primeiro.getTipo() + ") x " + segundo.getNome()
                + " (" + segundo.getTipo() + ") ====");

        int rodada = 1;
        while (!primeiro.estaDerrotado() && !segundo.estaDerrotado()) {
            golpe(primeiro, segundo, rodada);
            if (!segundo.estaDerrotado()) {
                golpe(segundo, primeiro, rodada);
            }
            rodada++;
        }
        Robo vencedor = primeiro;
        Robo perdedor = segundo;
        if (primeiro.estaDerrotado()) {
            vencedor = segundo;
            perdedor = primeiro;
        }
        vencedor.registrarVitoria();
        perdedor.registrarDerrota();
        System.out.println("Vencedor: " + vencedor.getNome() + " (" + vencedor.getTipo() + ")\n");
    }

    public static void golpe(Robo agressor, Robo alvo, int rodada) {
        int dano = agressor.atacar(alvo, rodada);
        System.out.println("Rodada " + rodada + ": " + agressor.getNome() + " causou " + dano + " de dano em "
                + alvo.getNome() + " (energia: " + alvo.getEnergiaAtual() + ")");
    }

    public static void excluirParticipante(ArrayList<Robo> robosLista, int codigo) {
        Robo r = buscarRobo(robosLista, codigo);
        if (r.getCombatesRealizados() > 0) {
            System.out.println("Exclusão recusada: " + r.getNome() + " já realizou combates.");
            return;
        }
        robosLista.remove(r);
        System.out.println("Robô " + r.getNome() + " excluído.");
    }

    public static int buscarOperacao(Scanner s) {
        int opt = -1;
        do {
            try {
                opt = s.nextInt();
            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Operação inválida");
                System.out.println("Digite novamente a informação!");
                opt = -1;
            }
        } while (opt < 0);

        return opt;
    }
}
