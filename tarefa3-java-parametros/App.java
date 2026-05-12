public class App {
    public static void alterarNumero(int x) {
        System.out.println("Variável recebida pelo método: " + x);
        x = x * 2;
        System.out.println("Variável alterada pelo método dentro dele: " + x);
    }
    public static void main(String[] args) {
        int x = 5;
        System.out.println("Variável declarada: " + x);
        alterarNumero(x);
        System.out.println("Variável após chamada do método: " + x);
    }
}
