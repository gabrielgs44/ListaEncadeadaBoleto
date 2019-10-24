package control;

import model.Node;

public class ControlNode {
    private Node node;
    
    public void CreateNode(int id, String dueDate, double value) {
        
        node = new Node(id, dueDate, value);
    }
    
    public Node getNode() {
        return node;
    }
}
