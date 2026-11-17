public abstract class Robo {
    
    private static final int ENERGIA_INICIAL = 100;
    private static final int ENERGIA_MINIMA_PARA_LUTAR = 30;
    private static final int DANO_MINIMO = 5;
    private static final int BONUS_RODADA_PAR = 5;
    private static final int PONTOS_POR_VITORIA = 3;


    private String nome;
    private int codigo;
    private int ataque;
    private int defesa;
    private int energiaAtual = ENERGIA_INICIAL;
    private int vitorias = 0; 
    private int derrotas = 0;
    private int combatesRealizados = 0;
    private int pontos = 0;

    public Robo(String nome, int codigo, int ataque, int defesa) {
        this.nome = nome;
        this.codigo = codigo;
        this.ataque = ataque;
        this.defesa = defesa;
    }



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
    public boolean estaDisponivelParaLutar() {
        return energiaAtual > ENERGIA_MINIMA_PARA_LUTAR;
    }
    public boolean estaDerrotado() {
        return energiaAtual <= 0;
    }
    public void registrarDerrota() {
        derrotas++;
        combatesRealizados++;
    }   


    public abstract String getTipo();

    protected int calcularPoderDeAtaque() {
        return ataque;
    }
    protected int ajustarDanoRecebido(int dano) {
        return dano;
    }

    public final int atacar(Robo alvo, int rodada){
        int dano = this.calcularPoderDeAtaque();
        dano = dano - alvo.getDefesa();
        if (dano < DANO_MINIMO) {
            dano = DANO_MINIMO;
        }
        if (rodada % 2 == 0) {
            dano += BONUS_RODADA_PAR;
        }
        dano = alvo.ajustarDanoRecebido(dano);
        alvo.perderEnegia(dano);
        return dano;
    }

    private void perderEnegia (int dano){
        energiaAtual -= dano;
        if (energiaAtual < 0){
            energiaAtual = 0;
        }
    }

    public void registrarVitoria(){
        vitorias++;
        pontos = pontos + PONTOS_POR_VITORIA;
        combatesRealizados++;
    }

}
