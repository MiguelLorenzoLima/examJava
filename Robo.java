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

}
