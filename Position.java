public class Position {
	private final int x;
	private final int y;
	private final int z;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	
	public Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
}