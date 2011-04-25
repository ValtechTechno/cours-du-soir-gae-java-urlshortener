package shortener;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ResolverServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String shortUrl = req.getPathInfo();
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world " + shortUrl.substring(1));
	}
}
