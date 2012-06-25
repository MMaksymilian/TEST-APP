package app.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * TODO: comment tkuchna
 */
public class RequestLogger implements javax.servlet.Filter {
    public static final Logger log = LoggerFactory.getLogger(RequestLogger.class);

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        long start = System.currentTimeMillis();
        String source = httpRequest.getParameter("javax.faces.source");
        if (source!=null && source.equals("undefined"))
            log.warn("Undefined source");
        log.debug("Started {} {} {}", new Object[]{
                httpRequest.getMethod(),
                source,
                httpRequest.getRequestURI()
        });
        try {
            chain.doFilter(request, response);
        } finally {
            long end = System.currentTimeMillis();
            log.debug("Completed {} in {}ms", httpRequest.getRequestURI(), end - start);
        }

    }

    public void destroy() {
    }
}
