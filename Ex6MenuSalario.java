import java.util.Scanner;

public class Ex6MenuSalario {

    public static int menu(Scanner scanner) {
        // menu com opções de escolha
        System.out.println("1) informe quanto você ganha por hora");
        System.out.println("2) informe o número de horas trabalhadas no mês");
        System.out.println("3) salário bruto");
        System.out.println("4) quanto pagou ao INSS");
        System.out.println("5) quanto pagou ao sindicato");
        System.out.println("6) salário líquido");
        System.out.println("7) sair");

        System.out.print("escolha uma opção utilizando os números: ");
        int item = scanner.nextInt();
        scanner.nextLine();
        return item;
    }

    // funções para cada opção
    public static double SalHora(Scanner scanner) { // opção1
        System.out.println("quanto você ganha por hora: ");
        double salarioHora = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("salário por hora: RS%.2f".formatted(salarioHora));
        return salarioHora;
    }

    public static int horasTrabalhadas(Scanner scanner) { // opção2
        System.out.println("quantas horas você trabalhou esse mês: ");
        int horasTrab = scanner.nextInt();
        scanner.nextLine();
        System.out.println("horas trabalhadas no mês: %d".formatted(horasTrab));
        return horasTrab;
    }

    public static double SalarioBruto(double SalHora, double horasTrabalhadas) { // opção3
        double salBruto = SalHora * horasTrabalhadas;
        System.out.println("salário bruto: R$%.2f".formatted(salBruto));
        return salBruto;
    }

    public static double INSS(double salBruto) { // opção4
        double pagoINSS = (salBruto * 11) / 100;
        System.out.println("valor pago ao INSS: R$%.2f".formatted(pagoINSS));
        return pagoINSS;
    }

    public static double sindicato(double salBruto) { // opção5
        double pagoSindicato = (salBruto * 4) / 100;
        System.out.println("valor pago ao sindicato: R$%.2f".formatted(pagoSindicato));
        return pagoSindicato;
    }

    public static double salarioLiquido(double salBruto, double pagoINSS, double pagoSindicato) { // opção6
        double salLiquido = salBruto - pagoINSS - pagoSindicato;
        System.out.println("salário líquido: R$%.2f".formatted(salLiquido));
        return salLiquido;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //variaveis que vão ser recebidas pelas funções
        double salarioHora = 0;
        int horasTrab = 0;
        double salBruto = 0;
        double pagoINSS = 0;
        double pagoSindicato = 0;
        int escolha = 0;

        //sistema de escolhas de opções e loop
        while (escolha != 7) {
            escolha = menu(scanner);
            switch (escolha) {
                case 1:
                    salarioHora = SalHora(scanner);
                    break;
                case 2:
                    if (salarioHora != 0) {
                         horasTrab = horasTrabalhadas(scanner);
                    } else{
                        System.out.println("informe quanto você ganha por hora.");
                    }
                    break;
                case 3:
                    if (salarioHora != 0 && horasTrab != 0) {
                        salBruto = SalarioBruto(salarioHora, horasTrab);
                    } else {
                        System.out.println("informe quanto você ganhar por hora e quantas horas foram trabalhadas");
                    }
                    break;
                case 4:
                    if (salBruto != 0) {
                        pagoINSS = INSS(salBruto);
                    } else {
                        System.out.println("informe quanto você ganhar por hora e quantas horas foram trabalhadas");
                    }
                    break;
                case 5:
                    if (salBruto != 0) {
                        pagoSindicato = sindicato(salBruto);
                    } else {
                        System.out.println("informe quanto você ganhar por hora e quantas horas foram trabalhadas");
                    }
                    break;
                case 6:
                    if (pagoINSS != 0 && pagoSindicato != 0) {
                        salarioLiquido(salBruto, pagoINSS, pagoSindicato);
                    } else {
                        System.out.println("primeiro calcule quanto você pagou ao INSS e ao SINDICATO");
                    }
                    break;
                case 7:
                    System.out.println("saindo do programa.");
                    break;
                default:
                    System.out.println("opção desconhecida.");
                    break;
            }
             if (escolha != 7) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
        }
        }
        scanner.close();
    }
}