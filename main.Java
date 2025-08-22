main.Java :import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            EstudanteService service = new EstudanteService();

            while (true) {
                System.out.println("\n=== Sistema de Cadastro de Estudantes ===");
                System.out.println("1. Cadastrar Estudante");
                System.out.println("2. Listar Estudantes");
                System.out.println("3. Calcular Média das Notas");
                System.out.println("4. Atualizar Estudante");
                System.out.println("5. Remover Estudante");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = -1;
                try {
                    opcao = sc.nextInt();
                    sc.nextLine(); // limpar buffer
                } catch (InputMismatchException e) {
                    System.out.println("❌ Entrada inválida! Digite um número.");
                    sc.nextLine(); // limpar buffer
                    continue;
                }

                switch (opcao) {
                    case 1:
                        cadastrarEstudante(sc, service);
                        break;
                    case 2:
                        service.listarEstudantes();
                        break;
                    case 3:
                        service.calcularMediaNotas();
                        break;
                    case 4:
                        atualizarEstudante(sc, service);
                        break;
                    case 5:
                        removerEstudante(sc, service);
                        break;
                    case 0:
                        System.out.println("👋 Encerrando o sistema...");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("❌ Opção inválida.");
                }
            }
        }

        private static void cadastrarEstudante(Scanner sc, EstudanteService service) {
            try {
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Idade: ");
                int idade = sc.nextInt();

                System.out.print("Nota: ");
                double nota = sc.nextDouble();
                sc.nextLine(); // limpar buffer

                service.adicionarEstudante(nome, idade, nota);
            } catch (InputMismatchException | IOException e) {
                System.out.println("❌ Erro ao cadastrar: entrada inválida ou problema ao salvar.");
                sc.nextLine(); // limpar buffer
            }
        }

        private static void atualizarEstudante(Scanner sc, EstudanteService service) {
            try {
                service.listarEstudantes();
                System.out.print("ID do estudante: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Novo nome: ");
                String nome = sc.nextLine();

                System.out.print("Nova idade: ");
                int idade = sc.nextInt();

                System.out.print("Nova nota: ");
                double nota = sc.nextDouble();
                sc.nextLine();

                service.atualizarEstudante(id, nome, idade, nota);
            } catch (InputMismatchException | IOException e) {
                System.out.println("❌ Erro ao atualizar: entrada inválida ou problema ao salvar.");
                sc.nextLine(); // limpar buffer
            }
        }

        private static void removerEstudante(Scanner sc, EstudanteService service) {
            try {
                service.listarEstudantes();
                System.out.print("ID do estudante a remover: ");
                int id = sc.nextInt();
                sc.nextLine();
                service.removerEstudante(id);
            } catch (InputMismatchException | IOException e) {
                System.out.println("❌ Erro ao remover: entrada inválida ou problema ao salvar.");
                sc.nextLine(); // limpar buffer
            }
        }
    }
