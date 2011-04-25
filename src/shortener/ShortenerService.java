package shortener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class ShortenerService {
	private static final Logger log = Logger.getLogger(ShortenerService.class
			.getName());

	public ShortUrl shorten(String longUrl) {
		ShortUrl shortUrl = new ShortUrl(getShortUrl(longUrl), longUrl,
				new Date());
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(shortUrl);
		} finally {
			pm.close();
		}

		return shortUrl;
	}
	
	public ShortUrl resolve(String id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		ShortUrl url = null;
		try {
			Query query = pm.newQuery(ShortUrl.class, "id == :target_id");
			List<ShortUrl> result = (List<ShortUrl>)query.execute(id);
			url = result.get(0);
		} finally {
			pm.close();
		}
		return url;
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
