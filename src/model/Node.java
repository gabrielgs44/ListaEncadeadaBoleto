package model;

public class Node {
    private int id;
    private String dataVencimento;
    private double valor;
    private Node next;
    
    public Node(int id, String dataVencimento, double valor) {
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.next = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}
