public class RoboDefensivo extends Robo {
    private static final int REDUCAO_DE_DANO = 5;

    public RoboDefensivo(String nome, int codigo, int ataque, int defesa) {
        super(nome, codigo, ataque, defesa);
    }

    @Override
    public String getTipo() {
        return "Defensivo";
    }

    @Override
    protected int ajustarDanoRecebido(int dano) {
        int reduzido = dano - REDUCAO_DE_DANO;
        if (reduzido < DANO_FINAL_MINIMO) {
            reduzido = DANO_FINAL_MINIMO;
        }
        return reduzido;
    }
    
}
