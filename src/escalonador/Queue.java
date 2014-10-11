package escalonador;

public class Queue {
    private Nodo inicio;
    private Nodo fim;
    private int lenght = 0;
    
    public void print() {
    	Nodo aux = inicio;
    	if(empty()){
    		System.out.println( "Lista vazia!" );
    	}
    	int i = 0;
    	while( aux != fim.proximo ) {
    		System.out.println( "Processo "+ i + ": \n\t" + aux.getProcess().to_s() + "\n" );
    		i++;
    		aux = aux.proximo;
    	}
    }
    
    public void next(int time) {
    	inicio.getProcess().TimeElapsed(time);
    	fim.proximo = inicio;
    	inicio = inicio.proximo;
    }
    
    public void add(Process p) {
        Nodo n = new Nodo(p);
        if(empty()){
            inicio = n;
            fim = n;
            fim.proximo = inicio;
        }else{
            n.proximo = inicio;
            fim.proximo = n;
            fim = n;
        }
        lenght++;
    }
    
    public Process remove(int quantum) {
        Process removido = null;
        if(empty())
            removido = null;
        else if(inicio == fim){
        	inicio.getProcess().TimeElapsed(quantum);
        	removido = inicio.getProcess();
        	inicio = fim = null;
        }else{
        	inicio.getProcess().TimeElapsed(quantum);
        	removido = inicio.getProcess();
        	fim = inicio;
        	inicio = inicio.proximo;
        	fim.proximo = inicio;
        }
        if(removido != null)
        	lenght--;
        return removido;
    }
    
    public Nodo getFirst() {
    	return inicio;
    }
    
    public boolean empty() {
        return inicio == null && fim == null;
    }

	public int size() {
		return lenght;
	}
    
}
