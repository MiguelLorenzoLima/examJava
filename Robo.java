public class Robo {
    private String nome;
    private int codigo;
    private int ataque;
    private int defesa;
    private int energiaAtual = 100;
    private int vitorias = 0; 
    private int derrotas = 0;
    private int combatesRealizados = 0;
    private int pontos = 0;


    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public int getAtaque() {
        return ataque;
    }
    public int getDefesa() {
        return defesa;
    }
    public int getVitorias() {
        return vitorias;
    }
    public int getEnergiaAtual() {
        return energiaAtual;
    }
    public int getDerrotas() {
        return derrotas;
    }
    public int getCombatesRealizados() {
        return combatesRealizados;
    }
    public int getPontos() {
        return pontos;
    }

    private void perderEnegia (int dano){
        energiaAtual -= dano;
        if (energiaAtual < 0){
            energiaAtual = 0;
        }
    }

    private void registrarVitoria(){
        vitorias++;
        pontos = pontos + PONTOS_POR_VITORIA;
        combatesRealizados++;
    }
}
