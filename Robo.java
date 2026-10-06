public class Robo {
    public String nome;
    public int codigo;
    public int ataque;
    public int defesa;
    public int energiaAtual = 100;
    public int vitorias = 0; 
    public int derrotas = 0;
    public int combatesRealizados = 0;
    public int pontos = 0;


    Robo(String nome, int codigo, int ataque, int defesa) {
        this.nome = nome;
        this.codigo = codigo;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public boolean estaDisponivel() {
        return energiaAtual >= 30;
    }

    public String situacao() {
        if (energiaAtual >= 30) {
            return "Disponível";
        }
        return "Em recuperação";
    }
     public void receberDano(int dano) {
        energiaAtual = energiaAtual - dano;
        if (energiaAtual < 0) {
            energiaAtual = 0;
        }
    }
    public void registrarVitoria() {
        vitorias++;
        pontos = pontos + 3;
        combatesRealizados++;
    }

    public void registrarDerrota() {
        derrotas++;
        combatesRealizados++;
    }

    public void registrarEmpate() {
        pontos = pontos + 1;
        combatesRealizados++;
    }
}
