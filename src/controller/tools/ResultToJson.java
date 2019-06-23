package controller.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ResultToJson {

	public static void toJson(HttpServletResponse response, Map<String, Object> data)
			throws IOException {
		Gson gson = new Gson();
		String res = gson.toJson(data);
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
		PrintWriter out = response.getWriter();
		out.print(res);
		out.flush();
		out.close();
	}
	
}
