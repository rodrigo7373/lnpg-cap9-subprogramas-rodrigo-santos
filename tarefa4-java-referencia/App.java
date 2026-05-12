class Produto {
    String nome;
    double preco;
}
public class App {
    public static void aplicarDesconto(Produto p) {
        System.out.println("Preço antes: " + p.preco);
        p.preco = p.preco * 0.85;
        System.out.println("Preço depois: " + p.preco);
    }
    public static void main(String[] args) {
        Produto p = new Produto();
        p.preco = 100;
        aplicarDesconto(p);
        System.out.println("Preço após chamada do método: " + p);
    }

}