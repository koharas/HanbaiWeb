package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrPage {
	private HttpServletResponse response;
	private HttpServletRequest request;

	public ErrPage(HttpServletRequest request,HttpServletResponse response) {
		this.response = response;
		this.request = request;
	}

	void show(String mes,String url)  throws ServletException, IOException{
		request.setAttribute("title", "ErrorPage");
		request.setAttribute("mes", mes);
		request.setAttribute("url", url);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/mes.jsp");
		rd.forward(request, response);
	}
}
