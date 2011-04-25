package shortener;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShortenerServiceTest {

		@Test
		public void getShortUrl() {
			ShortenerService service = new ShortenerService();
			String shortUrl = service.getShortUrl("http://google.com");
			assertNotNull(shortUrl);
			assertTrue(shortUrl.length() > 1);
		}
}
