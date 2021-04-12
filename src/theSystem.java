//system object

public class theSystem 
{
	//class attributes
	int[] ResourceArr; //resource array
	int resourceArrLen;   //number of resources (size of array)
	int[][] maxClaims;
	int[] allocationEdges;
	int[] requestEdges;
	
	public theSystem(int[] ResourceArr, int[][] maxClaims, int[] allocationEdges, int[] requestEdges) //class constructor
	{
		this.ResourceArr = ResourceArr;
		this.maxClaims = maxClaims;
		this.allocationEdges = allocationEdges;
		this.requestEdges = requestEdges;
	}
	
	public void request(int processNum, int resourceNum, int numRequested)
	{
		//System.out.println(maxClaims[processNum][resourceNum]);
		int max = maxClaims[processNum][resourceNum];
		int allocated = allocationEdges[resourceNum];
		int diff = max - allocated;
		if (numRequested <= diff)
		{
			allocationEdges[resourceNum] = allocationEdges[resourceNum] + numRequested;
			//maxClaims[processNum][processNum] = allocationEdges[resourceNum];
			System.out.println("request granted");
		}
		else
		{
			System.out.println("request denied");
		}
	}
	
	public void release(int proccessNum, int resourceNum, int numRequested)
	{
		if (allocationEdges[resourceNum] > 0)
		{
			int temp = allocationEdges[resourceNum];
			allocationEdges[resourceNum] = allocationEdges[resourceNum] - numRequested;
			if (allocationEdges[resourceNum] < 0) 
			{
				allocationEdges[resourceNum] = temp;
				System.out.println("error: that number of resources are not held.");
				return;
			}
			System.out.println("release of resources successful.");
		}
		else
		{
			System.out.println("unable to handle request");
		}
	}
}