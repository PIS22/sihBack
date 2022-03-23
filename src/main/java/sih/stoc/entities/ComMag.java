package sih.stoc.entities;

public class ComMag {
	CommBlock blk;
	Magasin m;
	
	public ComMag(CommBlock blk, Magasin m) {
		super();
		this.blk = blk;
		this.m = m;
	}

	public CommBlock getBlk() {
		return blk;
	}

	public void setBlk(CommBlock blk) {
		this.blk = blk;
	}

	public Magasin getM() {
		return m;
	}

	public void setM(Magasin m) {
		this.m = m;
	}

}
