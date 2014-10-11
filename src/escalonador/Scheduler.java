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
	}
	
	public void start() {
		for(int i = 0; i <= max_process; i++) {
			create_process_list();
		}
	}
	
	public void run() {
		Process p;
		while(!queue.empty()) {
			p = queue.getFirst().getProcess();
			if(p.getTime() > quantum) {
				queue.next(quantum);
			}else{
				queue.remove(p.getTime()).to_s();
			}
		}
	}
	
	private void create_process_list() {
		if(queue.size() <= max_process){
			queue.add(new Process(randomic.nextInt(1000)));
		}
	}
    
}
