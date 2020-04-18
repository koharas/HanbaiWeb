package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HanbaiConnection;
import model.Shouhin;
import model.ShouhinDAO;

/**
 * Servlet implementation class UeiageServlet
 */
@WebServlet("/uriage")
public class UriageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UriageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォームからのパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String sidStr = request.getParameter("sid");
		int sid = Integer.parseInt(sidStr);

		// Modelクラスの生成と利用
		HanbaiConnection con = new HanbaiConnection();
		ShouhinDAO dao = new ShouhinDAO(con.getConnection());
		Shouhin shouhin = dao.findById(sid);
		con.close();

		// ModelクラスをリクエストスコープでJSPに渡す
		request.setAttribute("shouhin", shouhin);

		// JSPの呼び出し（フォワード）
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/uriage.jsp");
		rd.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
