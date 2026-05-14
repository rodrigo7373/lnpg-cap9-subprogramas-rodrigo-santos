import java.util.*;

class Item {
    int codigo;
    String nome;
    int quantidade;
    double precoUnitario = 2 * quantidade;
}

public class App {
    public static void limparTerminal() {
            System.out.println("\n".repeat(50));
        }
    public static void mostrarMenu(ArrayList<Item> lista, Scanner scanner) {
        System.out.println("\n[1] VER ESTOQUE\n[2] ADICIONAR ITEM\n[0] SAIR");
        String opcao = scanner.nextLine();
        int entrada = 0;
        try {
            entrada = Integer.parseInt(opcao);
            validarMenu(lista, entrada, scanner);
        }
        catch(NumberFormatException as) {
            System.out.println("Opçao invalida!");
            mostrarMenu(lista, scanner);
        }
    }
    public static void validarMenu(ArrayList<Item> lista, int entrada, Scanner scanner) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if (entrada == 1) {
            if (lista.size() == 0) {
                System.out.println("Estoque vazio! Adicione um item.");
                mostrarMenu(lista, scanner);
            }
            else {
                mostrarEstoque(lista, scanner);
            }
        }
        else if (entrada == 2

        ) {
            adicionarItem(lista, scanner);
            mostrarEstoque(lista, scanner);
        }
        else if (entrada == 0) {    
            System.out.println("Volte sempre!");
        }
        else {
            System.out.println("Opçao invalida!");
            mostrarMenu(lista, scanner);
        }
    }

    public static void mostrarEstoque(ArrayList<Item> lista, Scanner scanner) {
        limparTerminal();
        Collections.sort(lista, Comparator.comparing(l -> l.nome));
        System.out.printf("CODIGO" + " ".repeat(2) + "ITEM" + " ".repeat(16) + "QUANTIDADE" + " ".repeat(5) + "PRECO" + " ".repeat(5) + "SUBTOTAL" + "%n");
        for (Item l : lista) {
            System.out.printf("%-8d%-20s%-15d%-10.2f%8.2f%n",
            l.codigo, l.nome, l.quantidade, l.precoUnitario, l.precoUnitario * l.quantidade);
        }
        mostrarMenuEstoque(lista, scanner);
    }

    public static void mostrarMenuEstoque(ArrayList<Item> lista, Scanner scanner) {

        System.out.println("\n[1] ADICIONAR ITEM\n[0] VOLTAR AO MENU PRINCIPAL");
        String entrada = scanner.nextLine();
        int opcao = 0;
         try {
            opcao = Integer.parseInt(entrada);
        }
        catch(NumberFormatException as) {
            System.out.println("Opçao invalida!");
            mostrarMenuEstoque(lista, scanner);
        }
        if (opcao == 1) {
            adicionarItem(lista, scanner);
            mostrarEstoque(lista, scanner);
        }
        else if (opcao == 0) {
            limparTerminal();
            mostrarMenu(lista, scanner);
        }
        else {
            System.out.println("Opção invalida!");
            mostrarMenuEstoque(lista, scanner);
        }
    }
    
    public static void adicionarItem(ArrayList<Item> lista, Scanner scanner) {
        Item item = new Item();
        
        Random random = new Random();
        item.codigo = random.nextInt(900000) + 100000;
        
        System.out.println("Nome do item: ");
        item.nome = scanner.nextLine();
        
        System.out.println("Quantidade: ");
        String quantidade = scanner.nextLine();
        item.quantidade = Integer.parseInt(quantidade);
        
        System.out.println("Preco unitario: ");
        String preco = scanner.nextLine();
        item.precoUnitario = Integer.parseInt(preco);
        lista.add(item);
        limparTerminal();
        System.out.println("Item adicionado com sucesso!");
        mostrarEstoque(lista, scanner);
    }
    
    public static void main(String[] args) {
        System.out.println("Bem vindo(a) ao meu sistema de estoque! Digite o número de uma opção e clique Enter.");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> itens = new ArrayList<>(); // lista onde os itens ficarao
        
        mostrarMenu(itens, scanner);
    }
}