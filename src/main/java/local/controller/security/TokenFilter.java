package local.controller.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtHandlerAdapter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		
		String header = req.getHeader("Authorization");
		System.out.println(header);
		
		if (req.getMethod().equals("GET") || req.getMethod().equals("OPTIONS")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(header == null || !header.startsWith("Bearer ")) {
			 res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Inexistente ou inválido TOKEN!");
			 System.out.println("if do baerer");
			 return;
		}
		
		
		String token = null;
		
		try {
			token = header.split(" ")[1];
		} catch (Exception ex) {
			 res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Inexistente ou inválido TOKEN!");
			 System.out.println("catch do split");
			 return;
		}
		
		String usuarioToken = null;
		
		try {
			Jwts.parser().setSigningKey("mercadoweb").parseClaimsJws(token);
			usuarioToken = Jwts.parser().setSigningKey("mercadoweb")
                    .parse(token, new JwtHandlerAdapter<String>() {
                        @Override
                        public String onClaimsJws(Jws<Claims> jws) {
                            return jws.getBody().getSubject();
}	
			});
			
			System.out.println("TOKEN BODY: " + usuarioToken);
			
			
		} catch (ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            if (e instanceof ExpiredJwtException) {
                System.out.println("Expired TOKEN");
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Expired TOKEN!");
            } else {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid TOKEN!");
            }
            return;
		}
		
		 req.setAttribute("requestUser", usuarioToken);

		 chain.doFilter(req, res);
				
	}
	
}
