import java.util.*;

public class FCFS1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        
        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        
        // Input the arrival time and burst time for each process
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter arrival time and burst time for process %d: ", i + 1);
            arrivalTime[i] = sc.nextInt();
            burstTime[i] = sc.nextInt();
        }
        
        // Calculate waiting time and turnaround time for each process
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            if (currentTime < arrivalTime[i]) {
                currentTime = arrivalTime[i];
            }
            waitingTime[i] = currentTime - arrivalTime[i];
            turnaroundTime[i] = waitingTime[i] + burstTime[i];
            currentTime += burstTime[i];
        }
        
        // Calculate average waiting time and average turnaround time
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }
        avgWaitingTime /= n;
        avgTurnaroundTime /= n;
        
        // Print the results
        System.out.printf("Average waiting time = %.2f\n", avgWaitingTime);
        System.out.printf("Average turnaround time = %.2f\n", avgTurnaroundTime);
    }
}
