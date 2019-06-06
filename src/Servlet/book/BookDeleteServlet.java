package Servlet.book;

import Dao.BookDao;
import Dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookDeleteServlet",value = {"/BookDeleteServlet"})
public class BookDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bookNo = request.getParameter("book_no");

        BookDao bookDao= new BookDao();

        String outMassage;
        try {
            bookDao.delete(bookNo);
            outMassage = "删除成功";
        } catch (Exception e) {
            outMassage = "删除失败";
            e.printStackTrace();
        }

        request.setAttribute("outputMessage",outMassage);
        request.getRequestDispatcher("show.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
