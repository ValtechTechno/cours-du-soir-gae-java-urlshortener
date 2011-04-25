package shortener;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ShortenerServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(ShortenerServlet.class.getName());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String longUrl = req.getParameter("url");
		log.info("url:" + longUrl);
		ShortenerService service = new ShortenerService();
		ShortUrl shortUrl = service.shorten(longUrl);
		req.getSession().setAttribute("shortenerResult", shortUrl.toString());
		resp.sendRedirect("/shortener.jsp");
	}

}
