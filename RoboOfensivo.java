//Herança
public class RoboOfensivo extends Robo {
    private static final int BONUS_DE_ATAQUE = 5;
    //herança
    public RoboOfensivo(String nome, int codigo, int ataque, int defesa) {
        super(nome, codigo, ataque, defesa);
    }
    //polimorfismo
    @Override
    public String getTipo() {
        return "Ofensivo";
    }
    
    //polimorfismo
    @Override
    protected int calcularPoderDeAtaque() {
        return getAtaque() + BONUS_DE_ATAQUE;
    }
}
