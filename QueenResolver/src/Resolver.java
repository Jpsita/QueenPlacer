
public class Resolver
{
	private int x;
	private int y;
	private Object[][] table;
	
	public Resolver(int e_x, int e_y, Object[][] e_table)
	{
		x = e_x;
		y = e_y;
		table = e_table;
	}
	


	public void Start() {
		set(x, y);
		int stat = 0;

	}
	
	private void set(int x, int y)
	{
		table[x][y] = 2;
		for (int t1 = 0; t1 < 8; t1++)
		{
			table[x][t1] = 1;
			table[t1][y] = 1;
			try{
			table[x - t1][y - t1] = 1;
			}catch(Exception ex){}
			try{
			table[x - t1][y + t1] = 1;	
			}catch(Exception ex){}
			try{
			table[x + t1][y - t1] = 1;
			}catch(Exception ex){}
			try{
			table[x + t1][y + t1] = 1;
			}catch(Exception ex){}
		}
			
	}
	
	public Object[][] getTable()
	{
		return table;
	}
			
}
	
