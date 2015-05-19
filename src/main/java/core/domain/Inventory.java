package core.domain;

public class Inventory {
	private long iselNum;
	private int shelfNum;
	private int copyNum;

	public int getCopyNum() {
		return copyNum;
	}

	public void setCopyNum(int copyNum) {
		this.copyNum = copyNum;
	}

	public int getShelfNum() {
		return shelfNum;
	}

	public void setShelfNum(int shelfNum) {
		this.shelfNum = shelfNum;
	}

	public long getIselNum() {
		return iselNum;
	}

	public void setIselNum(long iselNum) {
		this.iselNum = iselNum;
	}
}
