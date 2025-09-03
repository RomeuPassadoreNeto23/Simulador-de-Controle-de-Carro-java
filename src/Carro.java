/**
 * Classe que representa um carro com funcionalidades básicas como ligar, desligar,
 * acelerar, frear, virar e trocar marchas.
 */
public class Carro {
    // Indica se o carro está ligado ou desligado
    private boolean ligado;

    // Velocidade atual do carro
    private int velocidade;

    // Marcha atual do carro
    private int marcha;

    /**
     * Construtor da classe Carro.
     * Inicializa o carro desligado, com velocidade 0 e em ponto morto (marcha 0).
     */
    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0; // ponto morto
    }

    /**
     * Liga o carro, caso ele esteja desligado.
     * Exibe uma mensagem informando o estado do carro.
     */
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado.");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    /**
     * Desliga o carro, caso ele esteja parado e em ponto morto.
     * Exibe uma mensagem informando o estado do carro.
     */
    public void desligar() {
        if (velocidade == 0 && marcha == 0) {
            ligado = false;
            System.out.println("Carro desligado.");
        } else {
            System.out.println("Não é possível desligar o carro em movimento ou fora do ponto morto.");
        }
    }

    /**
     * Acelera o carro, caso ele esteja ligado e não esteja em ponto morto.
     * A velocidade máxima é limitada a 120 km/h.
     * Exibe a velocidade atual após a aceleração.
     */
    public void acelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (marcha == 0) {
            System.out.println("Não é possível acelerar em ponto morto.");
            return;
        }
        if (velocidade < 120) {
            velocidade++;
            System.out.println("Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("Velocidade máxima atingida.");
        }
    }

    /**
     * Reduz a velocidade do carro, caso ele esteja ligado.
     * A velocidade não pode ser menor que 0.
     * Exibe a velocidade atual após a frenagem.
     */
    public void frear() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (velocidade > 0) {
            velocidade--;
            System.out.println("Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("O carro já está parado.");
        }
    }

    /**
     * Vira o carro para a direção especificada (esquerda ou direita),
     * caso ele esteja ligado e em uma velocidade adequada (entre 1 e 40 km/h).
     *
     * @param direcao Direção para a qual o carro deve virar ("esquerda" ou "direita").
     */
    public void virar(String direcao) {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (velocidade >= 1 && velocidade <= 40) {
            System.out.println("Virando para " + direcao);
        } else {
            System.out.println("Velocidade inadequada para virar.");
        }
    }

    /**
     * Exibe a velocidade atual do carro.
     */
    public void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h");
    }

    /**
     * Troca a marcha do carro, caso ele esteja ligado e a nova marcha seja válida.
     * A troca de marchas deve ser sequencial e compatível com a velocidade atual.
     *
     * @param novaMarcha Nova marcha desejada (entre 0 e 6).
     */
    public void trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida.");
            return;
        }
        if (Math.abs(novaMarcha - marcha) != 1) {
            System.out.println("Não é permitido pular marchas.");
            return;
        }

        boolean marchaValida = switch (novaMarcha) {
            case 0 -> velocidade == 0;
            case 1 -> velocidade >= 0 && velocidade <= 20;
            case 2 -> velocidade >= 21 && velocidade <= 40;
            case 3 -> velocidade >= 41 && velocidade <= 60;
            case 4 -> velocidade >= 61 && velocidade <= 80;
            case 5 -> velocidade >= 81 && velocidade <= 100;
            case 6 -> velocidade >= 101 && velocidade <= 120;
            default -> false;
        };

        if (marchaValida) {
            marcha = novaMarcha;
            System.out.println("Marcha trocada para: " + (marcha == 0 ? "ponto morto" : marcha + "ª"));
        } else {
            System.out.println("Velocidade incompatível com a marcha desejada.");
        }
    }

    /**
     * Retorna a velocidade atual do carro.
     *
     * @return Velocidade atual em km/h.
     */
    public int getVelocidade() {
        return velocidade;
    }
}