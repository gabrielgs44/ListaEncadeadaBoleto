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

            if (this.verificarQualVencePrimeiro(aux, newNode)) {

                newNode.setNext(aux);
                this.head = newNode;

            } else {

                while (aux.getNext() != null) {

                    if (this.verificarQualVencePrimeiro(aux.getNext(), newNode)) {

                        newNode.setNext(aux.getNext());
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

    public ListBoleto remover(int id) {

        Node aux = this.head;

        if (aux.getId() == id) {

            this.head = aux.getNext();

        } else {

            while (aux.getNext() != null) {

                if (aux.getNext().getId() == id && aux.getNext().getNext() == null) {

                    aux.setNext(null);
                    return this;

                } else if (aux.getNext().getId() == id) {

                    aux.setNext(aux.getNext().getNext());
                    return this;
                }

                aux = aux.getNext();
            }
        }

        return this;
    }

    public void imprimir() {
        Node currNode = this.head;

        while (currNode != null) {
            System.out.println();
            System.out.println("Id: " + currNode.getId());
            System.out.println("Valor: " + currNode.getValor());
            System.out.println("Data de Vencimento: " + currNode.getDataVencimento());
            System.out.println();
            currNode = currNode.getNext();
        }

    }

    public double calcularValorTotal() {

        Node aux = this.head;
        double valorTotal = 0;

        while (aux != null) {

            valorTotal += aux.getValor();
            aux = aux.getNext();

        }

        return valorTotal;
    }

    public double realizarPagamentos(double saldo) {

        Node aux = this.head;
        do {

            if (saldo >= aux.getValor()) {

                saldo -= aux.getValor();
                int id = aux.getId();
                aux = aux.getNext();
                this.remover(id);

            } else {

                aux = aux.getNext();

            }

        } while (aux != null);

        return saldo;
    }

    private boolean verificarQualVencePrimeiro(Node last, Node newNode) {

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
