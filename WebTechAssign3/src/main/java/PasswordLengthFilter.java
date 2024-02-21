import jakarta.servlet.*;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/SignUp")
public class PasswordLengthFilter implements Filter {

    private static final int MIN_PASSWORD_LENGTH = 5;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String password = httpRequest.getParameter("password");

        if (password != null && password.length() < MIN_PASSWORD_LENGTH) {
            // Password length is less than the minimum required
            request.setAttribute("error", "Password must be at least " + MIN_PASSWORD_LENGTH + " characters long");
            request.getRequestDispatcher("/Signup.jsp").forward(request, response);
        } else {
            // Password length meets the requirement, proceed to the servlet
            chain.doFilter(request, response);
        }
    }

    // Other methods of the Filter interface

    public static class Preview {
    }
}
