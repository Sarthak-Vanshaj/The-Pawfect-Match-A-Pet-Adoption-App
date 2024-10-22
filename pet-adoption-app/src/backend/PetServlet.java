package backend;

import com.google.gson.Gson;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class PetServlet extends HttpServlet {
    private PetController petController = new PetController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pet> pets = petController.getAllPets();
        String json = new Gson().toJson(pets);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}
