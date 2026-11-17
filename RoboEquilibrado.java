//herança
public class RoboEquilibrado extends Robo {
    //herança
    public RoboEquilibrado(String nome, int codigo, int ataque, int defesa) {
        super(nome, codigo, ataque, defesa);
    }
    //polimorfismo
    @Override
    public String getTipo() {
        return "Equilibrado";
    }
}