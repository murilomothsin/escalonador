package escalonador;

import java.util.Random;

class Process {
	
	private int time;
	private int time_elapsed;
	private int id;

	public Process(int time) {
		this.time = time;
		time_elapsed = 0;
		this.id = new Random().nextInt(100);
	}
	
	public int getTime(){
		return time - time_elapsed;
	}
	
	public void TimeElapsed(int time) {
		time_elapsed = time_elapsed + time;
	}

	public String to_s() {
		return "Processo: " + id + "\nTime: " + time;
	}
    
}
