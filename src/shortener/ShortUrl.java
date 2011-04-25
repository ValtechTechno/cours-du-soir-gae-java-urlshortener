package shortener;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ShortUrl {

	@Persistent
	@PrimaryKey
	private String id;
	
	@Persistent
	private String longUrl;
	
	@Persistent
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
