/**
 * 
 */
package com.myhealth.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myhealth.bean.EnrollServiceResponse;
import com.myhealth.delegate.EnrollSvcDelegate;
import com.myhealth.util.ResponseBuilder;

/**
 * Servlet implementation class InitiateEnrollment
 */
@WebServlet("/initiateenrollment")
public class InitiateEnrollment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitiateEnrollment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String token = request.getParameter("token");
		EnrollSvcDelegate delegate = new EnrollSvcDelegate();
		delegate.setSvcType("dataaccesssvc");
		EnrollServiceResponse svcResponse = delegate.performTask(new RequestBuilder().buildRequest(token));
		ResponseBuilder<EnrollServiceResponse> builder = new ResponseBuilder<EnrollServiceResponse>();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println(builder.buildResponseString(svcResponse));
		response.getWriter().append("\""+builder.buildResponseString(svcResponse)+"\"").flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
