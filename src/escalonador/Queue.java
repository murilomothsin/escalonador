package escalonador;

public class Queue {
    private Nodo start;
    private Nodo end;
    private int lenght = 0;
    
    public void Queue(){
    	start = null;
    	end = null;
    }
    
    public void print() {
    	Nodo aux = start;
    	if(empty()){
    		System.out.println( "Empty queue!" );
    	}
    	int i = 0;
    	while( i < lenght ) {
    		System.out.println( aux.getProcess().to_s() + "\n" );
    		i++;
    		aux = aux.next;
    	}
    }
    
    public void next(int time) {
    	System.out.println("Setuping process time: " + time);
    	start.getProcess().TimeElapsed(time);
    	end = start;
    	start = start.next;
    }
    
    public void add(Process p) {
        Nodo n = new Nodo(p);
        if(empty()){
            start = n;
            end = n;
            end.next = start;
        }else{
            n.next = start;
            end.next = n;
            end = n;
        }
        lenght++;
    }
    
    public Process remove(int quantum) {
        Process removed = null;
        if(empty())
            removed = null;
        else if(start == end){
        	start.getProcess().TimeElapsed(quantum);
        	removed = start.getProcess();
        	start = end = null;
        }else{
        	start.getProcess().TimeElapsed(quantum);
        	removed = start.getProcess();
        	start = start.next;
        	end.next = start;
        }
        if(removed != null)
        	lenght--;
        System.out.println("Removed: " + removed.to_s());
        return removed;
    }
    
    public Nodo getFirst() {
    	return start;
    }
    
    public boolean empty() {
        return start == null && end == null;
    }

	public int size() {
		return lenght;
	}
    
}
