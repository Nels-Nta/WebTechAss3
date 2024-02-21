import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Signup.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("email");
        String password = req.getParameter("password");

        String ConfirmPassword = req.getParameter("ConfirmPassword");
        if(username.isEmpty() || password == null  || password.isEmpty() || ConfirmPassword.isEmpty() ) {
            String error = "You must Fill Everything";
        }
        else{
            HttpSession session =  req.getSession();

            if(password.matches(ConfirmPassword)) {
                session.setAttribute("email", username);
                session.setAttribute("password", password);
                resp.sendRedirect("/LoginPage.jsp");

            }

        }


    }
}
