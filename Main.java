
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

                    Robo robo = new Robo(
                            nome,
                            codigo,
                            ataque,
                            defesa);
                    robosLista.add(robo);
                    break;

                case 2:
                    System.out.println("\n \n \n" + "-------------" + "\n" + "Digite o código do robô: ");
                    int codigoBusca = s.nextInt();
                    buscarRoboPeloCodigo(robosLista, codigoBusca);
                    break;

                case 3:
                    System.out.println("==== Listagem dos competidores ====");
                    for (Robo r : robosLista) {
                        System.out.println(
                                "\n" + "-------------" + "\n" +
                                        " Nome: " + r.nome + "\n" +
                                        " Código: " + r.codigo + "\n" +
                                        " ataque: " + r.ataque + "\n" +
                                        " defesa: " + r.defesa + "\n \n");
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

                    break;

                default:
                    break;
            }
        } while (opc != 0);
        s.close();
    }

    public static Robo buscarRoboPeloCodigo(ArrayList<Robo> robosLista, int codigos) {
        for (Robo roboBuscar : robosLista) {
            if (roboBuscar.codigo == codigos) {
                System.out.println("\n\nRobô encontrado!\n");
                System.out.println("Código: " + roboBuscar.codigo);
                System.out.println("Nome: " + roboBuscar.nome);
                System.out.println("Ataque: " + roboBuscar.ataque);
                System.out.println("Defesa: " + roboBuscar.defesa);
                System.out.println("Energia: " + roboBuscar.energiaAtual);
                System.out.println("Vitorias: " + roboBuscar.vitorias);
                System.out.println("Derrotas: " + roboBuscar.derrotas);
                System.out.println("Combates Realizados: " + roboBuscar.combatesRealizados);
                if (roboBuscar.energiaAtual > 30) {
                    System.out.println("Pronto para lutar: Disponível!");
                } else {
                    System.out.println("Pronto para lutar: Em recuperação!");
                }
                System.out.println("Pontuação Total: " + roboBuscar.pontos);
                System.out.println("\n\n\n");
            }
        }
        return null;
    }

    public static Robo buscarRobo(ArrayList<Robo> robosLista, int codigos) {
        for (Robo r : robosLista) {
            if (r.codigo == codigos) {
                return r;
            }
        }
        return null;
    }

    public static void combate(Robo robo1, Robo robo2) {
        Robo primeiro = null;
        Robo segundo = null;
        if (primeiro == null){
            System.out.println("Combate recusado: robô " + primeiro + " não encontrado.");
        }
        if (segundo == null){
            System.out.println("Combate recusado: robô " + segundo + " não encontrado.");
        }
        if (robo2.pontos < robo1.pontos ) {
            primeiro = robo2;
            segundo = robo1;
        }else{
            primeiro = robo1;
            segundo = robo2;
        }
        
        int ataquePrimeiro = primeiro.ataque;
        int defesaPrimeiro = primeiro.defesa;

        int ataqueSegundo = segundo.ataque;
        int defesaSegundo = segundo.defesa;
        
        System.out.println("\n==== COMBATE: " + primeiro.nome + " x " + segundo.nome + " ====");
        System.out.println(primeiro.nome + " ataca primeiro em todas as rodadas.");

       for (int i = 1; i <= 5; i++) {
            System.out.println("-- Rodada " + i + " --");

            int totalDano1 = ataquePrimeiro - defesaSegundo;
            int totalDano2 = ataqueSegundo - defesaPrimeiro;

            if (totalDano1 < 5) {
                totalDano1 = 5;
            }
            if (totalDano2 < 5) {
                totalDano2 = 5;
            }

            if (i % 2 == 0) {
                totalDano1 = totalDano1 + 5;
                totalDano2 = totalDano2 + 5;
            }
            segundo.receberDano(totalDano1);
            int vidaSegundo = segundo.energiaAtual;
            System.out.println(primeiro.nome + " causou " + totalDano1 + " de dano. "
                    + segundo.nome + " tem: " + vidaSegundo + " de vida");

            if (vidaSegundo == 0) {
                System.out.println(segundo.nome + " ficou sem energia!");
                break;
            }
            primeiro.receberDano(totalDano2);
            int vidaPrimeiro = primeiro.energiaAtual;
            System.out.println(segundo.nome + " causou " + totalDano2 + " de dano. "
                    + primeiro.nome + " tem: " + vidaPrimeiro + " de vida");

            if (vidaPrimeiro == 0) {
                System.out.println(primeiro.nome + " ficou sem energia!");
                break;
            }
        }

        if (primeiro.energiaAtual > segundo.energiaAtual) {
            primeiro.registrarVitoria();
            segundo.registrarDerrota();
            System.out.println("Vencedor: " + primeiro.nome + "! (+3 pontos)");
        } else if (segundo.energiaAtual > primeiro.energiaAtual) {
            segundo.registrarVitoria();
            primeiro.registrarDerrota();
            System.out.println("Vencedor: " + segundo.nome + "! (+3 pontos)");
        } else {
            primeiro.registrarEmpate();
            segundo.registrarEmpate();
            System.out.println("Empate! (+1 ponto para cada)");
        }
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
