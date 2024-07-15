package aduana.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import aduana.data.camionDAO;
import aduana.model.Camion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/aduana24115")
public class AduanaServletController extends HttpServlet {

static Logger logger = LoggerFactory.getLogger(AduanaServletController.class);
  List<Camion> camionList = new ArrayList<>();
  ObjectMapper mapper = new ObjectMapper();


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String route = req.getParameter("action");
    logger.info("route : " + route);
    switch (route) {
      case "getAll":
      
        res.setContentType("application/json; charset=UTF-8");
        camionList = camionDAO.listar();
        logger.info("Dentro de getAll : " + camionList.size());
        //transformo en json y lo envio
        mapper.writeValue(res.getWriter(), camionList);
        logger.info(mapper.toString());
        break;
       
      default: 
        System.out.println("Parámetro no válido");
        
      }
    }
  
    }
  




