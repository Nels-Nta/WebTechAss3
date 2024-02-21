import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admission")
public class AdmissionPage extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            String Firstname= request.getParameter("name");
            String email= request.getParameter("Email");

            request.setAttribute("name","name"+Firstname);
            request.setAttribute("Email","Email"+email);



            RequestDispatcher dispatcher = request.getRequestDispatcher("/preview.jsp");
            dispatcher.forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error","Error Occured");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admissionPage.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}