public class Resolver {
	private int startx;
	private int starty;
	private Integer[][] table;
	private int totQueens = 0;

	public Resolver(int e_x, int e_y, Integer[][] e_table) {
		startx = e_x;
		starty = e_y;
		table = e_table;

	}

	public void Start() {
		set(startx, starty);
		totQueens++;
		System.out.println("Started");
		cont(startx, starty, 1, table);
	}

	private void set(int x, int y) {
		table[x][y] = 2;
		System.out.println("Queen placed at: "+ x + ", " + y);
		for (int t1 = 0; t1 < 8; t1++) {
			if(table[x][t1] != 2)
				table[x][t1] = 1;
			if(table[t1][y] != 2)
				table[t1][y] = 1;
			try {
				if(table[x -t1][y - t1] != 2)
					table[x - t1][y - t1] = 1;
			} catch (Exception ex) {
			}
			try {
				if(table[x - t1][ y + t1] != 2)
					table[x - t1][y + t1] = 1;
			} catch (Exception ex) {
			}
			try {
				if(table[x + t1][y - t1] != 2)
					table[x + t1][y - t1] = 1;
			} catch (Exception ex) {
			}
			try {
				if(table[x + t1][y + t1] != 2)
					table[x + t1][y + t1] = 1;
			} catch (Exception ex) {
			}
		}
	}
	//return 0 = fatto
	//return 1 = impossibile
	//return 2 = finito
	public int cont(int x, int y, int att, Integer[][] tbl) {
		if (att <= 7) {
			Integer[][] temptbl = tbl;
			int lastx = x;
			int lasty = y;
			int attempt = att;
			int stat = 0;
			if (totQueens <= 8) {
				for (int q = 0; q < 8; q++) {
					for (int r = 0; r < 8; r++) {
						if (temptbl[q][r + attempt - 1].equals(0)) {
							set(q, r + attempt - 1);
							stat = 1;
							totQueens++;
							if (cont(q, r + attempt - 1, 1, temptbl) == 0) {
								table = temptbl;
								return 0;
							} else if (cont(q, r + attempt - 1, 1, temptbl) == 1) {
								totQueens--;
								if (cont(lastx, lasty, attempt + 1, tbl) == 1) {
									return 1;
								}
							}
						}else if(temptbl[q + attempt -1][r] == 0)
						{
							set(q + attempt -1, r);
							stat = 1;
							totQueens++;
							if (cont(q + attempt - 1, r, 1, temptbl) == 0) {
								table = temptbl;
								return 0;
							} else if (cont(q + attempt - 1, r, 1, temptbl) == 1) {
								totQueens--;
								if (cont(lastx, lasty, attempt + 1, tbl) == 1) {
									return 1;
								}
							}
						}else if(temptbl[q][r - attempt + 1] == 0)
						{
							set(q, r - attempt + 1);
							stat = 1;
							totQueens++;
							if (cont(q, r - attempt + 1, 1, temptbl) == 0) {
								table = temptbl;
								return 0;
							} else if (cont(q, r - attempt + 1, 1, temptbl) == 1) {
								totQueens--;
								if (cont(lastx, lasty, attempt + 1, tbl) == 1) {
									return 1;
								}
							}
						}else if(temptbl[q - attempt + 1][r] == 0)
						{
							set(q - attempt +1, r);
							stat = 1;
							totQueens++;
							if (cont(q - attempt + 1, r, 1, temptbl) == 0) {
								table = temptbl;
								return 0;
							} else if (cont(q - attempt + 1, r, 1, temptbl) == 1) {
								totQueens--;
								if (cont(lastx, lasty, attempt + 1, tbl) == 1) {
									return 1;
								}
							}else{
								return 1;
							}
						}
					}
				}
			} else {
				return 0;
			}
		}
		return 2;
	}

	public Integer[][] getTable() {
		return table;
	}

}
