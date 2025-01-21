package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.CreateWeaponLogic;
import model.Weapon;

/**
 * Servlet implementation class CreateWeaponServlet
 */
@WebServlet("/CreateWeaponServlet")
public class CreateWeaponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String weaponId = request.getParameter("weaponIds");
		String flag = request.getParameter("flag");

		if (weaponId == null && flag == null) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/createWeapon.jsp");
			dispatcher.forward(request, response);

		} else if (weaponId == null && flag.equals("create")) {

			String type = request.getParameter("type");
			String name = request.getParameter("name");
			String range = request.getParameter("range");
			String damage = request.getParameter("damage");
			String sub = request.getParameter("sub");
			String special = request.getParameter("special");

			ValueCheck valueCheck = new ValueCheck();
			List<String> errors = valueCheck.weaponValueCheck(type, name, range, damage, sub, special);

			if (!errors.isEmpty()) {
				// エラーメッセージをリクエストに設定
				request.setAttribute("errors", errors);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/createWeapon.jsp");
				dispatcher.forward(request, response);
				return;
			}

			Weapon weapon = new Weapon(type, name, range, damage, sub, special);
			CreateWeaponLogic bo = new CreateWeaponLogic();
			boolean result = bo.execute(weapon);

			if (!result) {

				request.setAttribute("message", "登録に失敗しました");

			} else {

				request.setAttribute("message", "登録に成功しました");

			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/createWeaponResult.jsp");
			dispatcher.forward(request, response);

		} else {

			//チェックボックスをチェックしていたらリダイレクト
			response.sendRedirect("WeaponListServlet");

		}

	}

}
