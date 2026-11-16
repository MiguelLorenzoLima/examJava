public class RoboEquilibrado extends Robo {
    public RoboEquilibrado(String nome, int codigo, int ataque, int defesa) {
        super(nome, codigo, ataque, defesa);
    }

    @Override
    public String getTipo() {
        return "Equilibrado";
    }
}