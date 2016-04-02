package application.security.wavsep.tests.util;

public class Url {
	
	private String url;
	private int count;
	private int offset;

	public Url(String testUrl, int linkCount){
		
		url = testUrl;
		count = linkCount;
		
	}
	
	public Url(String testUrl, int linkCount, int linkOffset){
		
		url = testUrl;
		count = linkCount;
		offset = linkOffset;
		
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
