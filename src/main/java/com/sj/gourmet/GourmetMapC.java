package com.sj.gourmet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GourmetMapC")
public class GourmetMapC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GourmetM.mapGourmet(request);
		GourmetM.searchGourmet(request, response);
		request.setAttribute("mapPage", "gourmetMap.jsp");
		request.setAttribute("contentPage", "gourmetResult.jsp");
		request.getRequestDispatcher("gourmetjsp/gourmet.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
