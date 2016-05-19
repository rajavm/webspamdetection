/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maheswari
 */
@WebServlet(urlPatterns = {"/myservlet"})
public class myservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet myservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet myservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u=request.getParameter("inputurl");
         response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
    
    
      
      out.println("<html>");
    out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
           out.println("<title>Web Spam Detection</title>");
 out.println("<style>\n" +
".temp123\n" +
"{\n" +
"margin: 0 auto;\n" +
"margin-left: auto;\n" +
"margin-right: auto;\n" +
"text-align:center;\n" +
"}\n" +".alignleft {\n" +
"  float: left;\n" +
"  width:33.33333%;\n" +
"  text-align:left;\n" +
"}\n" +
".aligncenter {\n" +
"  float: left;\n" +
"  width:33.33333%;\n" +
"  text-align:center;\n" +
"}\n" +
".alignright {\n" +
" float: left;\n" +
" width:33.33333%;\n" +
" text-align:right;\n" +
"}​"+
"</style>");
    out.println("</head>");
    out.println("<body>");
 
       out.println("<h1 align=\"center\">Web Spam Detection System</h1>"); 
      out.println("<br><br>");
       out.println("<div class =\"temp123\">   URL is <textarea style=\"width: 20%; height: 4%; border:groove 3px;\">"+u+"</textarea></div>");

       out.println("<br>");
       
     //  out.println("<br>");
      /* out.println("<div >\n" +
"<p class=\"alignleft\"><b>Link Based Features</b></p>\n" +
"<p class=\"aligncenter\"><b>Content Based Features</b></p>\n" +
"<p class=\"alignright\"><b>LDA</b></p>\n" +
"</div>" );*/
      
       
        double slinkwt,nlinkwt,sldawt,nldawt;
      int depth;
       int linkflag,contentflag,ldaflag;
       out.println("<pre style=\"font-size:16px\"><b>       Link Based Features                             Content Based Features                                  LDA</b></pre>");
      
       
       
       
       String lop=webspam.cumulative_analysis.runmelink(u);
       slinkwt=webspam.cumulative_analysis.slinkwt;
       nlinkwt=webspam.cumulative_analysis.nlinkwt;
       linkflag=webspam.cumulative_analysis.linkflag;
       out.println("<textarea style=\"width: 30%; height: 40%;border:groove 3px; \">"+lop+"</textarea>");
       
       
       
       String cop=webspam.cumulative_analysis.runmecontent(u);
       depth=webspam.cumulative_analysis.depth;
       contentflag=webspam.cumulative_analysis.contentflag;
       out.println("<textarea style=\"width: 30%; height: 40%; border:groove 6px ;\">"+cop+"</textarea>");


       String ldaop=webspam.cumulative_analysis.runmelda(u);
       sldawt=webspam.cumulative_analysis.sldawt;
       nldawt=webspam.cumulative_analysis.nldawt;
       ldaflag=webspam.cumulative_analysis.ldaflag;
       out.println("<textarea style=\"width: 30%; height: 40%; border:groove 6px ;\">"+ldaop+"</textarea>");
         
       
       out.println("<br><br>");
       out.println("<pre style=\"font-size:16px\"><b>                                                           Result</pre></b>");
       
      
       
       int res=webspam.cumulative_analysis.analysis(slinkwt, nlinkwt, linkflag, depth, contentflag, sldawt, nldawt, ldaflag);
       String finres=webspam.cumulative_analysis.reslt;
       if(res==1)
       {
              if(finres==null)
           out.println("<div class =\"temp123\">  <textarea style=\"width: 25%; height: 18%; border:groove 6px ;\">"+"Given URL is SPAM"+"</textarea></div>");
      else
                            out.println("<div class =\"temp123\">  <textarea style=\"width: 25%; height: 18%; border:groove 6px ;\">"+finres+"Given URL is SPAM"+"</textarea></div>");
 
       }
       else if(res==0)
            out.println("<div class =\"temp123\">  <textarea style=\"width: 25%; height: 18%; border:groove 6px ;\">"+finres+"Given URL is NORMAL"+"</textarea> </div>");
       else if(res==2){
           if(finres==null)
         out.println("<div class =\"temp123\">  <textarea style=\"width: 25%; height: 18%; border:groove 6px ;\">"+"Given URL is UNDECIDED"+"</textarea> </div>");  
       else
          out.println("<div class =\"temp123\">  <textarea style=\"width: 25%; height: 18%; border:groove 6px ;\">"+finres+"Given URL is UNDECIDED"+"</textarea> </div>");
 
       }
       
       
       
        
     out.println("</body>");

    out.println("</html>");

        
        
        
       // processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
