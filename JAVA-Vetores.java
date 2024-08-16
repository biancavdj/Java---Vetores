import java.util.Scanner;

public class exercicio1 {
    public static void main(String[] args) {

        Double[] valorConta = new Double[10];
        String[] nomeConta = new String[10];

        Double valorTotal = 0.0;
        int quantMaior250 = 0;
        int quantInvalidos = 0;

        int menorValor = 0;
        int maiorValor = 0;

        Scanner ler = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            try {
                System.out.print("Digite o nome da conta: ");
                nomeConta[i] = ler.nextLine();
                System.out.print("Digite o valor da conta: ");
                valorConta[i] = ler.nextDouble();

                
                ler.nextLine();

                if (valorConta[i] < 0 || valorConta[i] > 500) {
                    throw new Exception("A conta não pode possuir valor menor que 0 ou valor maior que 500!");
                }

                if (valorConta[i] > 250) {
                    quantMaior250++;
                }

                if (valorConta[i] < valorConta[menorValor]) {
                    menorValor = i;
                }

                if (valorConta[i] > valorConta[maiorValor]) {
                    maiorValor = i;
                }

                // += para somar todos os valores de valorConta em valorTotal.
                valorTotal += valorConta[i];

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                quantInvalidos++;
                i--; // Retorna 
                ler.nextLine(); 
            }
        }

        System.out.println("O montante geral de sua conta é: " + valorTotal);
        System.out.println("A média dos valores de sua conta é: " + (valorTotal / 10));
        System.out.println("A quantidade de valores maiores que 250 é: " + quantMaior250);
        System.out.println("A quantidade de valores inválidos digitados é: " + quantInvalidos);
        System.out.println("O maior valor digitado é: " + valorConta[maiorValor] + " e sua respectiva conta referida: " + nomeConta[maiorValor]);
        System.out.println("O menor valor digitado é: " + valorConta[menorValor] + " e sua respectiva conta referida: " + nomeConta[menorValor]);

        ler.close();
     }
}
