package shortener;

import java.util.Date;

public class ShortUrl {

	private String id;
	
	private String longUrl;
	
	private Date creationDate;

	
	public ShortUrl(String id, String longUrl, Date creationDate) {
		super();
		this.id = id;
		this.longUrl = longUrl;
		this.creationDate = creationDate;
	}

	public String getId() {
		return id;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	
	
}
