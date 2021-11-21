package apresentacao;

import java.util.Scanner;
import processamento.Controle;
import contas.Lancamento;

public class Menu {
    public static void main(String[] args) {
        // TODO Auto-generated method stub


        Scanner entradaDados = new Scanner(System.in);
        Scanner opcaoMenu = new Scanner(System.in);
        int opc ;

        String varVencimento ;

        Controle pilha;

        System.out.println("Digite a quantidade de lançamentos que serão armazenados");
        int t = entradaDados.nextInt();
        pilha = new Controle(t);
        do {

            System.out.println("|---------------------");
            System.out.println("|    CONTROLE FINANCEIRO         ");
            System.out.println("|1  - GUARDAR                           ");
            System.out.println("|2  - REMOVER                           ");
            System.out.println("|3  - IMPRIMIR TITULO ESPECIFICO   ");
            System.out.println("|4  - ESTA CHEIA      ");
            System.out.println("|5  - PESQUISAR VENCIMENTO MAIS PROXIMO ");
            System.out.println("|6  - IMPRIMIR TODOS  ");
            System.out.println("|99 - SAIR            ");
            System.out.println("|---------------------");
            System.out.println(" ");
            System.out.println("|  DIGITE UMA OPÇÃO:  ");
            opc = opcaoMenu.nextInt();

            if ((opc > 0) || (opc > 99 )||(opc < 5 ) ){
                switch (opc) {
                    case 1://  EMPILHAR
                        System.out.println("OPÇÃO EMPILHAR SELECIONADA");
                        Lancamento lanc = new Lancamento();
                        System.out.println("----------------------------------");
                        System.out.println("Digite por favor os dados abaixo:");
                        System.out.println("----------------------------------");

                        System.out.print("Insira um código para identificação do Lançamento:");
                        lanc.id = entradaDados.nextInt();
                        System.out.println("----------------------------------");

                        System.out.print("Descrição do Lançamento:");
                        lanc.descricao = entradaDados.next();
                        System.out.println("----------------------------------");

                        System.out.print("Informe o tipo do lançamento C para 'Credito' e D para 'Débito':");
                        lanc.tipo = entradaDados.next().charAt(0);
                        System.out.println("----------------------------------");

                        System.out.print("Informe o valor para o lançamento:");
                        lanc.valor = entradaDados.nextDouble();
                        System.out.println("----------------------------------");

                        System.out.print("Informe o vencimento:");
                        lanc.vencimento = entradaDados.next();
                        System.out.println("----------------------------------");

                        System.out.print("Informe a emissao:");
                        lanc.emissao = entradaDados.next();
                        System.out.println("----------------------------------");

                        pilha.Empilhar(lanc);
                        break;

                    case 2://DESEMPILHAR
                        System.out.println("OPÇÃO DESEMPILHAR SELECIONADA");
                        pilha.Desempilhar();
                        break;

                    case 3://IMPRIMIR
                        System.out.println("OPÇÃO IMPRIMIR SELECIONADA");
                        System.out.print(" Por favor entre com codigo desejado");
                        pilha.pesquisarEspecifico(entradaDados.nextInt());
                        break;

                    case 4:// ESTA CHEIA
                        System.out.println("OPÇÃO VERIFICAR CHEIO SELECIONADA");
                        pilha.Estacheio();
                        break;

                    case 5:// PESQUISA POR VENCIMENTO
                        System.out.println("OPÇÃO PESQUISA POR DATA DE VENCIMENTO");
                        System.out.println("Digite a data de vencimento no padrão (DD/MM/AAAA)");
                        pilha.pesquisarVencimento(entradaDados.next());
                        break;
                    case 6:// IMPRESSAO DOS DADOS ARMAZENADOS
                        pilha.ImprimirTodos();
                        break;
                }
            }else if (opc != 99) {
                System.out.println("Opçaõ Invalida!");
            }

        } while (opc != 99);


    }
}
