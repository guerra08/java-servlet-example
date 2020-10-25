import org.json.JSONException;
import org.json.JSONObject;
import repository.UserRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class AppServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestUrl = request.getRequestURI();
        String[] splitUrl = requestUrl.split("/");
        int userId;
        if(splitUrl.length == 2 && splitUrl[1].equals("users")){
            response.getOutputStream().println(UserRepository.getInstance().getStringOfAllUsers());
        }
        if(splitUrl.length == 3 && splitUrl[1].equals("users")){
            userId = Integer.parseInt(splitUrl[2]);
            response.getOutputStream().println(UserRepository.getInstance().getUser(userId));
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestUrl = request.getRequestURI();
        String[] splitUrl = requestUrl.split("/");
        if(splitUrl.length == 2 && splitUrl[1].equals("users")){
            try{
                JSONObject json = new JSONObject(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
                UserRepository.getInstance().addUser(json.getInt("id"), json.getString("name"));
                response.getOutputStream().println(json.toString());
            }catch (JSONException e){
                response.setStatus(400);
            }

        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestUrl = request.getRequestURI();
        String[] splitUrl = requestUrl.split("/");
        int userId;
        if(splitUrl.length == 3 && splitUrl[1].equals("users")){
            userId = Integer.parseInt(splitUrl[2]);
            String deleted = UserRepository.getInstance().deleteUser(userId);
            if(deleted == null)
                response.setStatus(204);
            else
                response.getOutputStream().println(deleted);
        }
    }

}
