public class Resolver {
	private int startx;
	private int starty;
	private Integer[][] table;
	public int pass = 0;

	public Resolver(int e_x, int e_y, Integer[][] e_table) {
		startx = e_x;
		starty = e_y;
		table =copytable( e_table);

	}

	public Integer[][] Start() {
		table = set(startx, starty, table, true);
		System.out.println("Started");
		table = cont(startx, starty, table);
		if (table == null)
		{
			System.out.println("nullout");
		}
		printtbl(table);
		return getTable();
		
	}

	
	Integer[][] copytable(Integer[][] tbl)
	{
		Integer[][] mytbl = new Integer[8][8];
		for(int x = 0; x < 8; x++)
			{
				for (int y = 0; y < 8; y++)
				{
					mytbl[x][y] = tbl[x][y];
				}
			}
		return mytbl;
		
	}
	
	private Integer[][] set(int x, int y, Integer[][] mytbl, boolean out) {
		pass += 1;
		Integer[][] tbl = mytbl;
		tbl[x][y] = 2;
		if(out == true)
			System.out.println("Queen placed at: "+ x + ", " + y);
		for (int t1 = 0; t1 < 8; t1++) {
			if(tbl[x][t1] != 2)
				tbl[x][t1] = 1;
			if(tbl[t1][y] != 2)
				tbl[t1][y] = 1;
			try {
				if(tbl[x -t1][y - t1] != 2)
					tbl[x - t1][y - t1] = 1;
			} catch (Exception ex) {
			}
			try {
				if(tbl[x - t1][ y + t1] != 2)
					tbl[x - t1][y + t1] = 1;
			} catch (Exception ex) {
			}
			try {
				if(tbl[x + t1][y - t1] != 2)
					tbl[x + t1][y - t1] = 1;
			} catch (Exception ex) {
			}
			try {
				if(tbl[x + t1][y + t1] != 2)
					tbl[x + t1][y + t1] = 1;
			} catch (Exception ex) {
			}
		}
		return tbl;
	}
	//return 0 = fatto
	//return 1 = impossibile
	//return 2 = finito
	private Integer[][] cont (int x, int y, Integer[][] tbl) {
		Integer[][] temptbl = copytable(tbl);
		int myx = x + 1;
		Integer[][] next;
		System.out.println("phase 1");
		if(myx >= 8)
		{
			return tbl;
		}
		for(int j = 0; j < 8; j++)
		{
			if(temptbl[myx][j] == 0)
			{
				System.out.println("phase 2");
				temptbl = set(myx, j, temptbl, true);
				next = cont(myx, j, temptbl);
				if(next != null)
				{
					System.out.println("succes");
					temptbl = copytable(next);
					return temptbl;
				}else{
					System.out.println("failed");
					temptbl = copytable(tbl);
				}
			}
		}
		return null;
	}

	public void printtbl(Integer[][] tbl)
	{
		for (int x = 0; x < 8; x ++)
		{
				System.out.println(" " + tbl[x][0] + " " + tbl[x][1] + " " +tbl[x][2] + " " + tbl[x][3] + " " + tbl[x][4] + " " + tbl[x][5] + " " + tbl[x][6] + " " + tbl[x][7]);
		}
	}
	
	
	public Integer[][] getTable() {
		return table;
	}

}
