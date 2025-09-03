import java.util.PrimitiveIterator;
import java.util.Scanner;

/**
 * Classe principal do programa que simula o controle de um carro.
 * Permite ao usuário interagir com o carro através de um menu de opções.
 */
public class Main {
    // Scanner para entrada de dados do usuário
    private final static Scanner scanner = new Scanner(System.in);
    private final static Carro carro = new Carro();

    /**
     * Método principal que inicializa o programa e exibe o menu de opções.
     * O programa continua executando até que o usuário escolha a opção de sair.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Configura o scanner para usar nova linha como delimitador
        scanner.useDelimiter("\\n");
        var option = -1;
        do {
            // Exibe o menu de opções
            System.out.println("====Escolha uma das opções====");
            System.out.println("1---Ligar o carro");
            System.out.println("2---Desligar o carro");
            System.out.println("3---Acelerar o carro");
            System.out.println("4---Frear o carro");
            System.out.println("5---virar para esquerda/direita");
            System.out.println("6---verificar velocidade");
            System.out.println("7---trocar marcha");
            System.out.println("0---Sair");
            option = scanner.nextInt();

            // Executa a ação correspondente à opção escolhida
            switch (option) {
                case 1 -> carro.ligar();
                case 2 -> carro.desligar();
                case 3 -> carro.acelerar();
                case 4 -> carro.frear();
                case 5 -> virar();
                case 6 -> virifySpeed();
                case 7 -> Changemarch();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (option != 0);
    }

    /**
     * Método auxiliar para solicitar ao usuário a direção (esquerda ou direita)
     * e realizar a ação de virar o carro.
     */
    private static void virar() {
        var direcao = "";
        // Solicita a direção até que uma entrada válida seja fornecida
        while (direcao == null || direcao.isEmpty() || (!direcao.equalsIgnoreCase("esquerda") && !direcao.equalsIgnoreCase("direita"))) {
            System.out.println("Digite a direção (esquerda/direita): ");
            direcao = scanner.next();
        }
        carro.virar(direcao);
    }

    /**
     * Método auxiliar para verificar e exibir a velocidade atual do carro.
     */
    private static void virifySpeed() {
        var velocidade = carro.getVelocidade();
        System.out.println("A velocidade atual é: " + velocidade + " km/h");
    }

    /**
     * Método auxiliar para solicitar ao usuário a nova marcha e realizar a troca.
     * A marcha deve estar entre 0 e 6.
     */
    private static void Changemarch() {
        var novaMarcha = -1;
        // Solicita a nova marcha até que uma entrada válida seja fornecida
        while (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Digite a nova marcha (0 a 6): ");
            novaMarcha = scanner.nextInt();
        }
        carro.trocarMarcha(novaMarcha);
    }
}