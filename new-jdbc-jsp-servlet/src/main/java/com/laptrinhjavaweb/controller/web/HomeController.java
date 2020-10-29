package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet (urlPatterns = {"/trang-chu","/dang-nhap"})
public class HomeController extends HttpServlet{

	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewsService newsService;
	
	@Inject
	private IUserService userSercive;
	private static final long serialVersionUID = 2686801510274002166L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else if(action != null && action.equals("logout")) {
			
		} else {
			req.setAttribute("categories", categoryService.findAll());
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			model = userSercive.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
			if(model != null) {
				if(model.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/trang-chu");
				}else if (model.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				}
			}else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login");
			}
		}
	}
}
