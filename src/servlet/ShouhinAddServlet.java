package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HanbaiConnection;
import model.Shouhin;
import model.ShouhinDAO;

/**
 * Servlet implementation class ShouhinAddServlet
 */
@WebServlet("/shouhinadd")
public class ShouhinAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShouhinAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォームからのパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String sname = request.getParameter("sname");
		String tankaStr = request.getParameter("tanka");
		if( sname == "" || tankaStr =="") {
			/*
			request.setAttribute("title", "エラー");
			request.setAttribute("mes", "正しく入力してください。");
			request.setAttribute("url", "shouhin");

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/mes.jsp");
			rd.forward(request, response);
			*/
			ErrPage ep = new ErrPage(request, response);
			ep.show("正しく入力してください", "shouhin");
			return;
		}
		int tanka=0;
		try {
			tanka = Integer.parseInt(tankaStr);
		}catch(NumberFormatException e) {
			/*
			request.setAttribute("title", "エラー");
			request.setAttribute("mes", "正しく数字を入力してください。");
			request.setAttribute("url", "shouhin");

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/mes.jsp");
			rd.forward(request, response);
			*/
			ErrPage ep = new ErrPage(request, response);
			ep.show("正しく数字を入力してください", "shouhin");
			return;
		}

		// Modelクラスの生成と利用
		HanbaiConnection con = new HanbaiConnection();
		ShouhinDAO dao = new ShouhinDAO(con.getConnection());
		dao.insert(new Shouhin(0,sname,tanka));
		con.close();

		response.sendRedirect("shouhin");
	}

}
