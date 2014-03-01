public class Resolver {
	private int startx;
	private int starty;
	private Object[][] table;
	private int totQueens = 0;

	public Resolver(int e_x, int e_y, Object[][] e_table) {
		startx = e_x;
		starty = e_y;
		table = e_table;

	}

	public void Start() {
		set(startx, starty);

	}

	private void set(int x, int y) {
		table[x][y] = 2;
		for (int t1 = 0; t1 < 8; t1++) {
			table[x][t1] = 1;
			table[t1][y] = 1;
			try {
				table[x - t1][y - t1] = 1;
			} catch (Exception ex) {
			}
			try {
				table[x - t1][y + t1] = 1;
			} catch (Exception ex) {
			}
			try {
				table[x + t1][y - t1] = 1;
			} catch (Exception ex) {
			}
			try {
				table[x + t1][y + t1] = 1;
			} catch (Exception ex) {
			}
		}

	}

	public int cont(int x, int y, int att, Object[][] tbl) {
		if (att <= 7) {
			Object[][] temptbl = tbl;
			int lastx = x;
			int lasty = y;
			int attempt = att;
			int stat = 0;
			if (totQueens >= 8) {
				for (int q = 0; q < 8; q++) {
					for (int r = 0; r < 8; r++) {
						if (temptbl[q][r + attempt - 1].equals(0)) {
							set(q, r);
							stat = 1;
							totQueens++;
							if (cont(q, r, 1, temptbl) == 0) {
								table = temptbl;
								return 0;
							} else if (cont(q, r, 1, temptbl) == 1) {
								totQueens--;
								if (cont(lastx, lasty, attempt + 1, tbl) == 1) {
									return 1;
								}
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

	public Object[][] getTable() {
		return table;
	}

}
