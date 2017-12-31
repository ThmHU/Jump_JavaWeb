package servlet;

import java.io.IOException;

import javax.mail.Flags.Flag;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.test.StaticFunctionTests;

import util.Adb;
import util.Constants;
import util.Distance;

public class JumpServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		Distance distance = new Distance();
		Adb adb = new Adb();
		
		//��ȡ����
		int x1 = (int) (Integer.parseInt(request.getParameter("x1"))/Constants.ZOOM_COEFFICIENT);
		int y1 = (int) (Integer.parseInt(request.getParameter("y1"))/Constants.ZOOM_COEFFICIENT);
		int x2 = (int) (Integer.parseInt(request.getParameter("x2"))/Constants.ZOOM_COEFFICIENT);
		int y2 = (int) (Integer.parseInt(request.getParameter("y2"))/Constants.ZOOM_COEFFICIENT);
		int d = distance.distance(x1, y1, x2, y2);
		
		//��һ����
		adb.jump(d);
		//��Ծ��Ҫʱ�䣬�����߳�����4S
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ͼ���ֻ�
		adb.getScreencap();
		//��ͼ��Ҫʱ�䣬�����߳�����0.5S
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ͽ�ͼ������
		adb.pullScreencap();
				
	}
		

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
