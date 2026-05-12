import java.util.Scanner;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) {
        
        class Aluno {
            String nome;
            ArrayList<Double> notas = new ArrayList<>();
            double media; 
            String situacao; 
        }
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        Scanner input = new Scanner(System.in); // abre o scanner
        for (int i = 0; i < 5; i++) {
            Aluno a = new Aluno(); // cria um novo objeto aluno
            
            System.out.print("Nome do aluno: ");
            a.nome = input.nextLine();
            
            System.out.println("Notas do aluno: ");
            double somaNotas = 0;
            for (int j = 0; j < 3; j++) {
                String entrada = input.nextLine();
                double nota = Double.parseDouble(entrada);
                somaNotas += nota;
                a.notas.add(nota);
            }
            a.media = somaNotas / 3;
            if (a.media >= 7) {
                a.situacao = "APROVADO";
            }
            else if (a.media < 5) {
                a.situacao = "REPROVADO";
            }
            else {
                a.situacao = "RECUPERACAO";
            }
        
            alunos.add(a); // adiciona esse objeto aluno na lista alunos
        }
        
        // relatorio final
        System.out.println("RELATORIO FINAL");
        System.out.println("ALUNO               NOTAS               MEDIA               SITUACAO");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.printf("%-20s%-20s%-20.2f%s%n",
            alunos.get(i).nome, alunos.get(i).notas, alunos.get(i).media, alunos.get(i).situacao);
        }
        input.close(); // fecha o scanner
    }
}
