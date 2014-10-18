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
		System.out.println("\nPrinting internal queue...");
		queue.print();
		System.out.println("\nDone!");
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
		int size_of_queue = queue.size();
		Process p;
		int i = 0;
		System.out.println("Processing...");
		while (i < size_of_queue){
			p = queue.getFirst().getProcess();
//			System.out.println(p.to_s());
			if(p.getTime() >= quantum){
				queue.next(quantum);
			}else{
				queue.remove(p.getTime());
			}
			i++;
		}
		System.out.println("Processed!");
	}
	
	private void create_process_list() {
		if(queue.size() <= max_process){
			queue.add(new Process(randomic.nextInt(1000)));
		}
	}
    
}
