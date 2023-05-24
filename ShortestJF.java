import java.util.*;
 
public class ShortestJF {
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.println ("enter no of process:");
int n = sc.nextInt();
int processid[] = new int[n];
int arrivaltime[] = new int[n]; 
int bursttime[] = new int[n]; 
int completetime[] = new int[n]; 
int turnaroundtime[] = new int[n]; 
int waitingtime[] = new int[n];  
int f[] = new int[n];  // f means it is flag it checks process is completed or not
int st=0, tot=0;
float avgwt=0, avgta=0;
 
for(int i=0;i<n;i++)
{
System.out.println ("enter process " + (i+1) + " arrival time:");
arrivaltime[i] = sc.nextInt();
System.out.println ("enter process " + (i+1) + " brust time:");
bursttime[i] = sc.nextInt();
processid[i] = i+1;
f[i] = 0;
}
//boolean a = true;
while(true)
{
int c=n, min=999;
if (tot == n) // total no of process = completed process loop will be terminated
break;
for (int i=0; i<n; i++)
{
/*
* If i'th process arrival time <= system time and its flag=0 and burst<min
* That process will be executed first
*/
if ((arrivaltime[i] <= st) && (f[i] == 0) && (bursttime[i]<min))
{
min=bursttime[i];
c=i;
}
}
/* If c==n means c value can not updated because no process arrival time< system time so we increase the system time */
if (c==n)
st++;
else
{
completetime[c]=st+bursttime[c];
st+=bursttime[c];
turnaroundtime[c]=completetime[c]-arrivaltime[c];
waitingtime[c]=turnaroundtime[c]-bursttime[c];
f[c]=1;
tot++;
}
}
System.out.println("\npid  arrival burst  complete turn waiting");
for(int i=0;i<n;i++)
{
avgwt+= waitingtime[i];
avgta+= turnaroundtime[i];
System.out.println(processid[i]+"\t"+arrivaltime[i]+"\t"+bursttime[i]+"\t"+completetime[i]+"\t"+turnaroundtime[i]+"\t"+waitingtime[i]);
}
System.out.println ("\naverage tat is "+ (float)(avgta/n));
System.out.println ("average wt is "+ (float)(avgwt/n));
sc.close();
}
}