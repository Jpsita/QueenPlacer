
public class Resolver
{
	private int x;
	private int y;
	private Object[][] table;
	
	public Resolver(int e_x, int e_y)
	{
		x = e_x;
		y = e_y;
	}
	
	public void setTableArray(Object[][] e_table)
	{
		table = e_table;
	}

	public void Start() {
		table[x][y] = 1;
		int stat = 0;
		for (int count = 0; count < 7; count++) {
			for (int z = 0; z < 8; z++) {
				for (int w = 0; w < 8; w++) {
					
					if(table[w][z].equals(0))
					{
						for(int z2 = 0; z2 < 8; z2++)
						{
							for (int w2 = 0; z2 < 8; z2++ )
							{
								
							}
						}
					}
				}
			}
		}
	}
}
