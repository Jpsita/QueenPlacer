public class Resolver {
	private int x;
	private int y;
	private Object[][] table;
	private int totQueens = 0;

	public Resolver(int e_x, int e_y, Object[][] e_table) {
		x = e_x;
		y = e_y;
		table = e_table;

	}

	public void Start() {
		set(x, y);

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

	public boolean cont(int x, int y, int att) {
		int lastx = x;
		int lasty = y;
		int attempt = att;
		int stat = 0;
		if (totQueens >= 8) {
		for (int q = 0; q < 8; q++) {
			for (int r = 0; r < 8; r++) {
					if (table[q+attempt-1][r+attempt-1].equals(0)) {
						set(q, r);
						stat = 1;
						totQueens += 1;
						if (cont(q, r, 1) == true) {
							return true;
						}else{
							totQueens -= 1;	
							if(cont(lastx, lasty, 2) != true)
							{
							return false;	
							}
						}
						
					}
				}
			}
		}else{
			return true;
		}
		return false;
	}

	public Object[][] getTable() {
		return table;
	}

}
