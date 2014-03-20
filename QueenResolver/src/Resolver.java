public class Resolver {
	private int startx;
	private int starty;
	private Integer[][] table;
	public int pass = 0;

	public Resolver(int e_x, int e_y, Integer[][] e_table) {
		startx = e_x;
		starty = e_y;
		table = copytable(e_table);
	}
	
	/**
	 * Initial method. The coordinates will be taken from the constructor
	 * @return the final table. Null if the input data is incompatible 
	 */
	public Integer[][] Start() {
		table = set(startx, starty, table, true);
		pass ++;
		System.out.println("Started");
		table = cont(startx, starty, table);
		if (table == null) {
			System.out.println("nullout");
		}else{
		printtbl(table);
		}
		return table;
	}

	/**
	 * Copies the content of a table to another without passing pointers
	 * @param tbl the table to copy the data from
	 * @return the target table
	 */
	Integer[][] copytable(Integer[][] tbl) {
		Integer[][] mytbl = new Integer[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				mytbl[x][y] = tbl[x][y];
			}
		}
		return mytbl;

	}
	
	
	/**
	 * Sets a queen in the given place and in the given table, and calculates the locked positions
	 * @param x Row coordinate
	 * @param y Column coordinate
	 * @param mytbl The Table to put the queen
	 * @param out Enables-Disables console output
	 * @return Updated table
	 */
	private Integer[][] set(int x, int y, Integer[][] mytbl, boolean out) {
		Integer[][] tbl = mytbl;
		tbl[x][y] = 2;
		if (out == true)
			System.out.println("Queen placed at: " + x + ", " + y);
		for (int t1 = 0; t1 < 8; t1++) {
			if (tbl[x][t1] != 2)
				tbl[x][t1] = 1;
			if (tbl[t1][y] != 2)
				tbl[t1][y] = 1;
			try {
				if (tbl[x - t1][y - t1] != 2)
					tbl[x - t1][y - t1] = 1;
			} catch (Exception ex) {
			}
			try {
				if (tbl[x - t1][y + t1] != 2)
					tbl[x - t1][y + t1] = 1;
			} catch (Exception ex) {
			}
			try {
				if (tbl[x + t1][y - t1] != 2)
					tbl[x + t1][y - t1] = 1;
			} catch (Exception ex) {
			}
			try {
				if (tbl[x + t1][y + t1] != 2)
					tbl[x + t1][y + t1] = 1;
			} catch (Exception ex) {
			}
		}
		return tbl;
	}

	/**
	 * The actual resolving method. Recursive and yet to be completed
	 * @param x The row of the last placed queen
	 * @param y The column of the last queen. Actually useless
	 * @param tbl The table to work on
	 * @return The table with all the calculation done stage-by-stage
	 */
	private Integer[][] cont(int x, int y, Integer[][] tbl) {
		Integer[][] temptbl = copytable(tbl);
		int myx = x + 1;
		Integer[][] next;
		System.out.println("phase 1");
		int myrowqueens = 0;
		if(myx > 7 & pass < 8)
		{	
			System.out.println("reset at pass " + pass + " " );
			myx = 0;
		}
		if(pass > 7)
			return tbl;
		if (myx >= 8) {
			return tbl;
		}
		for (int tx = 0; tx < 7; tx++)
		{
			if(tbl[myx][tx] == 2)
				myrowqueens ++;
		}
		if(myrowqueens > 0){
			System.out.println("found extra queen");
			return tbl;
		}
		for (int j = 0; j < 8; j++) {
			if (temptbl[myx][j] == 0) {
				System.out.println("phase 2");
				temptbl = set(myx, j, temptbl, true);
				pass += 1;
				next = cont(myx, j, temptbl);
				if (next != null) {
					System.out.println("succes");
					temptbl = copytable(next);
					return temptbl;
				} else {
					pass --;
					System.out.println("failed");
					temptbl = copytable(tbl);
				}
			}
		}
		return null;
	}
	
	
	/**
	 * Debug function. Prints out an 8x8 table
	 * @param tbl The table to print out.
	 */
	public void printtbl(Integer[][] tbl) {
		for (int x = 0; x < 8; x++) {
			System.out.println(" " + tbl[x][0] + " " + tbl[x][1] + " "
					+ tbl[x][2] + " " + tbl[x][3] + " " + tbl[x][4] + " "
					+ tbl[x][5] + " " + tbl[x][6] + " " + tbl[x][7]);
		}
	}

	/**
	 * @deprecated
	 * Returns the main object's table
	 * @return The table
	 */
	public Integer[][] getTable() {
		return table;
	}

}
