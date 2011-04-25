package shortener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Logger;

public class ShortenerService {
	private static final Logger log = Logger.getLogger(ShortenerService.class.getName());

	
	public ShortUrl shorten(String longUrl) {
		ShortUrl shortUrl = new ShortUrl(getShortUrl(longUrl), longUrl, new Date());
		return shortUrl;
	}

	public String getShortUrl(String longUrl) {
		String shortUrl = null;
		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA1");
			shortUrl = sha1.digest(longUrl.getBytes()).toString().substring(3);
		} catch (NoSuchAlgorithmException e) {
			log.severe("should not append " + e.getMessage());
		}
		return shortUrl;
	}
	

}
