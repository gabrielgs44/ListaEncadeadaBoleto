package model;

public class ListBoleto {
    private Node head;

    private ListBoleto() {
        this.head = null;
    }

    public static ListBoleto Criar() {
        return new ListBoleto();
    }

    public ListBoleto Inserir(Node newNode) {

        if (this.head == null) {

            this.head = newNode;

        } else {
            Node aux = this.head;

            if (this.VerificarQualVencePrimeiro(aux, newNode)) {

                newNode.setNext(aux);
                this.head = newNode;

            } else {
                while (aux.getNext() != null) {
                    Node last = aux.getNext();
                    
                    if (this.VerificarQualVencePrimeiro(last, newNode)) {

                        newNode.setNext(last);
                        aux.setNext(newNode);
                        return this;
                    }
                    
                    aux = aux.getNext();
                }

                aux.setNext(newNode);
            }
        }

        return this;
    }

    public void imprimir(ListBoleto list) {
        Node currNode = list.head;

        while (currNode != null) {
            System.out.println();
            System.out.println("Id: " + currNode.getId());
            System.out.println("Valor: " + currNode.getValor());
            System.out.println("Valor: " + currNode.getDataVencimento());
            System.out.println();
            currNode = currNode.getNext();
        }

    }

    private boolean VerificarQualVencePrimeiro(Node last, Node newNode) {

        int diaLastNode = Integer.parseInt(last.getDataVencimento().substring(0, 2));
        int mesLastNode = Integer.parseInt(last.getDataVencimento().substring(3, 5));

        int diaNewNode = Integer.parseInt(newNode.getDataVencimento().substring(0, 2));
        int mesNewNode = Integer.parseInt(newNode.getDataVencimento().substring(3, 5));

        if (mesNewNode < mesLastNode) {
            return true;
        } else {

            if (mesNewNode == mesLastNode) {
                return diaNewNode <= diaLastNode;
            } else {
                return false;
            }
        }
    }
}
