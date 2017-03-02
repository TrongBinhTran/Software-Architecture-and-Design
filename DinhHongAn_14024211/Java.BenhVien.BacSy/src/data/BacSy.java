package data;

public class BacSy {
	private String msbacsy;
	private String hotenbacsy;
	public BacSy(String msbacsy, String hotenbacsy) {
		super();
		this.msbacsy = msbacsy;
		this.hotenbacsy = hotenbacsy;
	}
	
	@Override
	public String toString() {
		return "BacSy [msbacsy=" + msbacsy + ", hotenbacsy=" + hotenbacsy + "]";
	}

	public String getMsbacsy() {
		return msbacsy;
	}
	public void setMsbacsy(String msbacsy) {
		this.msbacsy = msbacsy;
	}
	public String getHotenbacsy() {
		return hotenbacsy;
	}
	public void setHotenbacsy(String hotenbacsy) {
		this.hotenbacsy = hotenbacsy;
	}
	
	
}
