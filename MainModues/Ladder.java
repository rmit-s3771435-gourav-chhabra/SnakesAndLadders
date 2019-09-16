package MainModules;


public class Ladder {
	private int length;
	private int startPoint;
	private int endPoint;
	
	public Ladder(int startPoint, int endPoint) throws Exception {
		this.length = endPoint - startPoint;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		
		if(startPoint < 2) {
			throw new Exception("Ladder cannot be placed at postion 1 or outside the board.");
		}
		if(endPoint > 99) {
			throw new Exception("Ladder cannot be placed at postion 100 or outside the board.");
		}
		if(length > 30) {
			throw new Exception("Ladder's length cannot exceed 30.");
		}	
	}
	
	public int getStartPoint() {
		return this.startPoint;
	}
	public int getEndPoint() {
		return this.endPoint;
	}
	public int getLadderLength() {
		return this.length;
	}
}
