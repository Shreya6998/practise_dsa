package dsaProblems;

public class FunctionPractise {

	// swap() doesn't swap i and j
	public static void swap(Integer i, Integer j)
	{
		Integer temp = new Integer(i);
		i = j;
		j = temp;
	}
	
	// Overloaded methods
    public int fun(String name)
    {
        System.out.println("fun(Integer ) ");
		return 0;
    }
    public String fun(int name)
    {
        System.out.println("fun(String ) ");
		return null;
    }
    
	public static void main(String[] args)
	{
		Integer i = new Integer(10);
		Integer j = new Integer(20);
		swap(i, j);
		System.out.println(" i = " + i + ", j = " + j);
	}
}
