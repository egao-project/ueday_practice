package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.UpdateWeapontLogic;
import model.Weapon;

/**
 * Servlet implementation class UpdateWeaponServlet
 */
@WebServlet("/UpdateWeaponServlet")
public class UpdateWeaponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int weaponId = Integer.parseInt(request.getParameter("weaponId"));
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String range = request.getParameter("range");
		String damage = request.getParameter("damage");
		String sub = request.getParameter("sub");
		String special = request.getParameter("special");

		//文字入力チェック
		ValueCheck valueCheck = new ValueCheck();
		List<String> errors = valueCheck.createWeaponValueCheck(type, name, range, damage, sub, special);

		if (!errors.isEmpty()) {
			// エラーメッセージをリクエストに設定
			request.setAttribute("errors", errors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editWeapon.jsp");
			dispatcher.forward(request, response);
			return;
		}

		Weapon editWeapon = new Weapon();

		editWeapon.setWeaponId(weaponId);
		editWeapon.setName(name);
		editWeapon.setType(type);
		editWeapon.setRange(range);
		editWeapon.setDamage(damage);
		editWeapon.setSub(sub);
		editWeapon.setSpecial(special);

		UpdateWeapontLogic bo = new UpdateWeapontLogic();
		boolean result = bo.execute(editWeapon);

		if (!result) {
			request.setAttribute("message", "更新に失敗しました");
		} else {
			request.setAttribute("message", "更新に成功しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateWeaponResult.jsp");
			dispatcher.forward(request, response);
		}

	}

}
