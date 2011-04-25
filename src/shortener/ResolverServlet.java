package shortener;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ResolverServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(ResolverServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String id = req.getPathInfo().substring(1);
		log.info("id:" + id);
		ShortenerService service = new ShortenerService();
		ShortUrl shortUrl = service.resolve(id);
		log.info("shortUrl " + shortUrl.getLongUrl());
		resp.sendRedirect(shortUrl.getLongUrl());
	}
}
