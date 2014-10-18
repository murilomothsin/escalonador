package escalonador;

class Nodo {
    public Nodo next;
    private Process p;
    
    public Nodo (Process p) {
        this.next = null;
        this.p = p;
    }

	public Process getProcess() {
		return p;
	}
}
