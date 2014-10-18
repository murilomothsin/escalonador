package escalonador;

class Process {
	
	private int time;
	private int time_elapsed;
	private int id;
	private static int generate = 1;

	public Process(int time) {
		System.out.println(generate);
		this.time = time;
		time_elapsed = 0;
		this.id = generate++;
	}
	
	public int getTime(){
		return time - time_elapsed;
	}
	
	public void TimeElapsed(int time) {
		time_elapsed = time_elapsed + time;
	}

	public String to_s() {
		return "Process: " + id + "\nTime: " + time + "\nTime elapsed: " + time_elapsed;
	}
    
}
