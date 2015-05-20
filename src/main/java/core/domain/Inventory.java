package core.domain;

public class Inventory {
	private long iselNum = 0;
	private int shelfNum = 0;
	private int copyNum = 0;

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
