
import ejb.AddBean;
import ejb.AddEjb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {
    
        @EJB
        AddEjb obj;
        public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
            PrintWriter out = res.getWriter();
            int i = Integer.parseInt(req.getParameter("t1"));
            int j = Integer.parseInt(req.getParameter("t2"));
             
           // AddBean obj = new AddBean();  //normal bean  wbc reference and object on diff machines
            obj.setI(i);
            obj.setJ(j);
            obj.add();
            int k = obj.getK();
            out.println("Addition is using EJB: " + k);
        }
        
}
