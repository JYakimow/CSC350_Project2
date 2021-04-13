//CSC350 Bankers algorithm avoiding deadlock simulation.
//by Jonathan Yakimow

import java.util.Scanner;

public class Driver extends theSystem
{
	public Driver(int[] ResourceArr, int[][] maxClaims, int[] allocationEdges, int[] requestEdges) {
		super(ResourceArr, maxClaims, allocationEdges, requestEdges);
	}

	public static void main(String[] args) //program driver
	{
		//initial line space.
		System.out.println(" ");
		
		//int[][] arr2d = { {1, 2, 3, 4}, {5, 6, 7, 8}, };
		
		//System.out.println(arr2d[1][3]);
		
		//String output = Driver.getInput("enter something");
		//System.out.println("this is the output: \n" + output);

		int[] ResourceArr = { 3, 4, 5, 1 };
		//int[][] maxClaims = { { 0, 0, 0, 0, 0, 0 }, { 3, 4, 5, 1 } };
		int[][] maxClaims = { 
				{ 3, 4, 5, 1 }, 
				{ 3, 4, 5, 1 }, 
				{ 3, 4, 5, 1 }, 
				{ 3, 4, 5, 1 } 
		};
		int[] allocationEdges = { 0, 0, 0, 0 };
		int[] requestEdges = { 0, 0, 0, 0 };
		
		theSystem sys = new theSystem(ResourceArr, maxClaims, allocationEdges, requestEdges);
		//example automatically run simulation
		System.out.println("all arrays are implemented in the source code and can be edited that way");

		System.out.println("user interactive mode initiated:");
		int x = 0;
		while(x == 0)
		{
			try 
			{
				int[] intArr = new int[3];
				String[] arr = new String[3];
				String requestInput = "";
				while(true)
				{
					String question = "\nWhat action would you like to perform? \n 1. request resource \n 2. release resource \n 3. exit simulation \n";
					String input = Driver.getInput(question);
					
					if (input.equals("1")) 
					{
						requestInput = Driver.getInput("\nplease enter the process, resource, and amount requested in that order seperated by commas. ex: '1,2,3' \n");
						arr = requestInput.split(",");
						for (int i = 0; i < 3; i++)
						{
							intArr[i] = Integer.parseInt(arr[i]);
						}
						sys.request(intArr[0], intArr[1], intArr[2]);
					}
					else if (input.equals("2")) 
					{
						requestInput = Driver.getInput("\nplease enter the process, resource, and amount to release in that order seperated by commas. ex: '1,2,3' \n");
						arr = requestInput.split(",");
						for (int i = 0; i < 3; i++)
						{
							intArr[i] = Integer.parseInt(arr[i]);
						}
						sys.release(intArr[0], intArr[1], intArr[2]);
					}
					else if (input.equals("3"))
					{
						System.out.println("exiting... \n");
						x = 1;
						break;
					}
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e);
				//Driver.run();
			}
			if (x == 1)
			{	
				break;
			}
		}
		
		System.out.println("the following is done automatically for testing purposes: ");
		sys.request(1, 2, 2);
		sys.request(1, 2, 2);
		sys.request(1, 2, 2);
		sys.release(1, 2, 4);
		sys.request(1, 2, 2);
		sys.request(1, 3, 3);
		sys.release(2, 1, 2);
		sys.request(3, 3, 2);
	}
	
	public static String getInput(String question)
	{
		//take user input
		Scanner input = new Scanner(System.in); //if i close this memory leak the program crashes so I left it open
		System.out.println(question);
		String output = input.nextLine();
		//input.close();
		return output;
	}
}
