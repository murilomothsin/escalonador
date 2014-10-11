package escalonador;

class Nodo {
    public Nodo proximo;
    private Process p;
    
    public Nodo (Process p) {
        this.proximo = null;
        this.p = p;
    }

	public Process getProcess() {
		return p;
	}
}
