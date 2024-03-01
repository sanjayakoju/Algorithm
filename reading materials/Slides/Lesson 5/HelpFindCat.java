public class HelpFindCat {
	public static boolean findCat(boolean[][] room, int lr, int hr, int lc, int hc) {
		System.out.println("Calling with lr = " + lr + " hr = " + hr + " lc = " + lc + " hc = " + hc);
		boolean found = false; 
		if (lr == hr && lc == hc) {
			if (room[lr][lc]) {
				System.out.println("Garfield is at (" + lr + "," + lc + ")");
			    found = true;
			}
		}
		else if (lr == hr) {
			int mc = (lc + hc)/2;
			found = findCat(room, lr, hr, lc, mc);
			if (!found) found = findCat(room, lr, hr, mc + 1, hc);
		}
		else if (lc == hc) {
			int mr = (lr + hr)/2;
			found = findCat(room, lr, mr, lc, hc);
			if (!found) found = findCat(room, mr + 1, hr, lc, hc);
		}
		else {
			int mc = (lc + hc)/2;
			int mr = (lr + hr)/2;
			found = findCat(room, lr, mr, lc, mc);
			if (!found) found = findCat(room, mr + 1, hr , lc, mc);
			if (!found) found = findCat(room, lr, mr, mc + 1, hc);
			if (!found) found = findCat(room, mr + 1, hr , mc + 1, hc);
		}	
		return found;
	}
	
	public static void main(String[] args) {
		int nRows = 16;
		int nCols = 7;
		
		boolean[][] myRoom = new boolean[nRows][nCols];
		int iPos = 12;
		int jPos = 5; // Cat is at (iPos, jPos)
		myRoom[iPos][jPos] = true;
			
		findCat(myRoom, 0, nRows-1, 0, nCols-1);
	}
}
