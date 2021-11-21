package processamento;

import contas.Lancamento;

public class Controle {


    private Lancamento[] vetLancamento;
    private int pTopo;

    public Controle (int tam){
       vetLancamento = new Lancamento[tam];
        pTopo = -1;
    }
    public void Empilhar (Lancamento lan) {
        if ((pTopo + 1) >= vetLancamento.length) {
            System.out.print("Esta cheio");
        } else {
            pTopo = pTopo + 1;
            vetLancamento[pTopo] = lan;
        }
    }
    public void Desempilhar (){
        if ((pTopo + 1) >= vetLancamento.length){
            pTopo = pTopo -1;
        }else{
            System.out.print("Esta Vazio");
        }
    }
    public void ImprimirTodos (){
        int aux = pTopo;
        System.out.println("----------------------------------------------------");
        System.out.println("------------ LANÇAMENTOS          ------------------");
        System.out.println("----------------------------------------------------");
        while (aux !=-1){
            System.out.println("----------------------------------------------------");
            System.out.println("Descrição: "+vetLancamento[aux].descricao);
            System.out.println("Valor: "+vetLancamento[aux].valor);
            System.out.println("Tipo: "+ (vetLancamento[aux].tipo == 'C' ? "Crédito" : "Débito"));
            System.out.println("Emissão: "+vetLancamento[aux].emissao);
            System.out.println("----------------------------------------------------");
            aux = aux -1;

        }

    }
    public void pesquisarEspecifico(int idLancamento) {
        boolean achou = false;
        for (int i = pTopo; i == 0; i--) {
            if (vetLancamento[i] != null) {
                if (vetLancamento[i].id == idLancamento) {
                    achou = true;
                    System.out.println("Descrição: " + vetLancamento[i].descricao);
                    System.out.println("Valor: " + vetLancamento[i].valor);
                    System.out.println("Tipo: " + (vetLancamento[i].tipo == 'C' ? "Crédito" : "Débito"));

                    break;
                }
            }
        }
        if(achou == false){
            System.out.println("Lançamento não localizado");
        }
    }


        public void pesquisarVencimento(String vencimento){
            boolean achou = false;
            for (int i = pTopo; i == 0; i--) {
                if(vetLancamento[i] != null){
                    if(vetLancamento[i].vencimento.equals(vencimento.trim()) ){
                        achou = true;
                        System.out.println("Descrição: "+vetLancamento[i].descricao);
                        System.out.println("Valor: "+vetLancamento[i].valor);
                        System.out.println("Tipo: "+ (vetLancamento[i].tipo == 'C' ? "Crédito" : "Débito"));
                    }
                }
            }
        if(achou == false){
            System.out.println("Lançamento não localizado");
        }
    }

    public void Estacheio(){
        //int	cheio = 0;

        if ((pTopo + 1) >= vetLancamento.length){
            System.out.println("Esta cheio");
        }else{
            System.out.println("Esta vazio");
        }
    }
}
