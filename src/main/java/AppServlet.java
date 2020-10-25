import repository.UserRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestUrl = request.getRequestURI();
        String[] splitUrl = requestUrl.split("/");
        if(splitUrl.length == 2 && splitUrl[1].equals("users")){
            response.getOutputStream().println(UserRepository.getInstance().getStringOfAllUsers());
        }
    }

}
