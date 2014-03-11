public class Resolver {
	private int startx;
	private int starty;
	private Integer[][] table;

	public Resolver(int e_x, int e_y, Integer[][] e_table) {
		startx = e_x;
		starty = e_y;
		table = e_table;

	}

	public void Start() {
		table = set(startx, starty, table, true);
		System.out.println("Started");
		table = cont(startx, starty, table);
	}

	
	private Integer[][] copytable(Integer[][] tbl)
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
	
	private Integer[][] set(int x, int y, Integer[][] tbl, boolean out) {
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
		Integer[][] temptbl = new Integer[8][8];
		temptbl = copytable(tbl);
		for (int j = 0; j < 7; j++) {
			if (x + 1 == 8) {
				return tbl;
			} else {
				if (tbl[x + 1][j] == 0) {
					Integer[][] mytbl = new Integer[8][8];
					mytbl = copytable(temptbl);
					set(x + 1, j, mytbl, false);
					if (cont(x + 1, j, mytbl) != temptbl) {
						set(x + 1, j,temptbl, true);
						temptbl = cont(x + 1, j , temptbl);
						System.out.println("column "+ (x + 1) + " is succesful");
						return temptbl;
					} else {
						if (j == 7) {
							return null;
						}
					}
				}
			}
		}
		return null;
	}


	public Integer[][] getTable() {
		return table;
	}

}
