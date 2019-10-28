package control;

import java.util.Scanner;

import model.ListBoleto;

public class Program {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int id = 0;
        ControlNode contNode = new ControlNode();

        ControlListBoleto contList = new ControlListBoleto();
        contList.CreateListBoleto();
        ListBoleto list = contList.getListBoleto();

        boolean continuar = true;

        do {

            System.out.print("Digite o valor do boleto: ");
            double value = read.nextDouble();

            System.out.print("Digite a data de vencimento (dd/MM/yyyy): ");
            String dueDate = read.next();

            contNode.CreateNode(id, dueDate, value);
            list.Inserir(contNode.getNode());

            id++;
            System.out.print("Deseja continuar? (S ou N): ");
            char opcao = read.next().toUpperCase().charAt(0);
            continuar = opcao == 'S' ? true : false;

        } while (continuar == true);

        list.imprimir();
        
        System.out.print("Digite o saldo disponível para realizar os pagamentos: ");
        double saldo = read.nextDouble();
        
        saldo = list.realizarPagamentos(saldo);
        
        System.out.println("Contas que falta pagar: ");
        list.imprimir();
        System.out.println("Valor total a pagar: " + list.calcularValorTotal());
        System.out.println("Saldo restante: " + saldo);
        read.close();
    }

}
