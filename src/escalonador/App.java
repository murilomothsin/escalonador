package escalonador;

import java.util.Scanner;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Scheduler.");
		System.out.print("Quamtum: ");
		int quantum = in.nextInt();
		System.out.println("Process max: ");
		int max = in.nextInt();
		System.out.println("Creating Scheduler");
		Scheduler schedule = new Scheduler(quantum, max);
		schedule.start();
//		schedule.print_queue();
		schedule.iteration();
		schedule.print_queue();
//		schedule.run();
	}

}
