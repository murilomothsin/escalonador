package escalonador;

import java.util.Random;

public class Scheduler {
	private Queue queue;
	private int quantum;
	private int max_process;
	private Random randomic;
	private int time;
	
	public Scheduler (int quantum, int maxProcess) {
		max_process = maxProcess;
		this.quantum = quantum;
		this.randomic = new Random();
		queue = new Queue();
	}
	
	public void print_queue() {
		System.out.println("Printing...");
		queue.print();
		System.out.println("Printed!");
	}
	
	public void start() {
		System.out.println("Starting...");
		for(int i = 0; i < this.max_process; i++) {
			create_process_list();
		}
		System.out.println("Started with " + queue.size() + " Process!");
	}
	
	public void run() {
		System.out.println("Running...");
		Process p;
		while(!queue.empty()) {
			p = queue.getFirst().getProcess();
			System.out.println(p.to_s());
			if(p.getTime() > quantum) {
				queue.next(quantum);
			}else{
				queue.remove(p.getTime()).to_s();
			}
		}
		System.out.println("Finished!");
	}
	
	public void iteration() {
		Nodo n = queue.getFirst();
		Process p;
		int i = 0;
		System.out.println("Processing...");
		while (i < queue.size()){
			p = n.getProcess();
			if(p.getTime() >= quantum){
				p.TimeElapsed(quantum);
			}else{
				p.TimeElapsed(p.getTime());
				p.setStatus(Process.OK);
			}
			i++;
			n = n.proximo;
		}
		System.out.println("Processed!");
	}
	
	private void create_process_list() {
		if(queue.size() <= max_process){
			queue.add(new Process(randomic.nextInt(1000)));
		}
	}
    
}
