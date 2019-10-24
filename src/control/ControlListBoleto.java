package control;

import model.ListBoleto;

public class ControlListBoleto {
    ListBoleto list;
    
    public void CreateListBoleto() {
        list = ListBoleto.Criar();
    }
    
    public ListBoleto getListBoleto() {
        return list;
    }
}
