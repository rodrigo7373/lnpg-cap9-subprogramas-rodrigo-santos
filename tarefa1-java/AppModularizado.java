import java.util.Scanner;
import java.util.ArrayList;

class Aluno {
    String nome;
    ArrayList<Double> notas = new ArrayList<>();
    double media; 
    String situacao; 
}

public class AppModularizado {
    public static final int NUMERO_NOTAS = 3;

    public static double calcularMedia(ArrayList<Double> notas, int NUMERO_NOTAS) {
        double somaNotas = 0;
        for (int i = 0; i < NUMERO_NOTAS; i++) {
            somaNotas = somaNotas + notas.get(i);
        }
        return somaNotas / 3;
    }
    
    /** Lê o nome do aluno e retorna em forma de String*/
    public static String lerAluno(Scanner scanner) {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        return nome;
    }
    
    public static ArrayList<Double> lerNotas(Scanner scanner, int NUMERO_NOTAS) {
        ArrayList<Double> notas = new ArrayList<> ();
        System.out.println("Notas do aluno: ");
        for (int j = 0; j < NUMERO_NOTAS; j++) {
            String entrada = scanner.nextLine();
            notas.add(Double.parseDouble(entrada));
        }
        return notas;
    }
    
    public static String determinarSituacao(double media) {
        String situacao;
        if (media >= 7) {
            situacao = "APROVADO";
        }
        else if (media < 5) {
            situacao = "REPROVADO";
        }
        else {
            situacao = "RECUPERACAO";
        }
        return situacao;
    }
    
    public static void imprimirRelatorio(ArrayList<Aluno> alunos, int quantidade) {
        System.out.printf("%43s%n%n", "RELATORIO FINAL");
        System.out.println("ALUNO               NOTAS               MEDIA               SITUACAO");
        for (int i = 0; i < quantidade; i++) {
            System.out.printf("%-20s%-20s%-20.2f%s%n",
            alunos.get(i).nome, alunos.get(i).notas, alunos.get(i).media, alunos.get(i).situacao);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // abre o scanner
        ArrayList<Aluno> alunos = new ArrayList<Aluno>(); // cria um ArrayList chamado alunos que receberá objetos do tipo Aluno
        final int NUMERO_ALUNOS = 5;
        for (int i = 0; i < NUMERO_ALUNOS; i++) {
            Aluno aluno = new Aluno(); // cria um novo objeto aluno do tipo Aluno    
            aluno.nome = lerAluno(scanner); 
            aluno.notas = lerNotas(scanner, NUMERO_NOTAS);
            aluno.media = calcularMedia(aluno.notas, NUMERO_NOTAS);
            aluno.situacao = determinarSituacao(aluno.media);
            alunos.add(aluno);
        }
        imprimirRelatorio(alunos, NUMERO_ALUNOS);
        scanner.close(); // fecha o scanner
    }
}
