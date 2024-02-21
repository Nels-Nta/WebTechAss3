import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = session.getAttribute("email").toString();
        String password = session.getAttribute("password").toString();
        String loginEmail = req.getParameter("email");
        String loginPassword = req.getParameter("password");
        String test = email+" "+loginPassword+ " "+loginEmail;

        req.setAttribute("test",test);;

        if(loginEmail == null || loginEmail.isEmpty() ||  loginPassword == null || loginPassword.isEmpty() ){
            String error = "Please fill all Fields";
            req.setAttribute("error",error);
            getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(req,resp);

        }else{
            if(email.isEmpty() || password.isEmpty() || !email.matches(loginEmail) || !password.matches(loginPassword)){
                String result = "User does not Exist";
                req.setAttribute("result",result);
                getServletContext().getRequestDispatcher("/AdmissionPage.jsp").forward(req,resp);

            }
            else{
                System.out.println("Welcome");
                System.out.println("Okayyyy");
                resp.sendRedirect("/AdmissionPage.jsp");

            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Login.jsp").forward(req,resp);

    }
}
