package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class AllCharacterEncodingFilter implements Filter {
	
	private FilterConfig filterConfig;
	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { 
		// TODO Auto-generated method stub
		HttpServletRequest httpReq=(HttpServletRequest) request;
		HttpServletResponse httpResp=(HttpServletResponse) response;
        //从配置文件中获取编码方式
		String encode=filterConfig.getInitParameter("encoding");
		if(encode==null) encode="UTF-8";
		httpReq.setCharacterEncoding(encode);
		httpResp.setCharacterEncoding(encode);
		httpResp.setContentType("text/html;charset="+encode);
		MyHttpServletRequest mRequest=new MyHttpServletRequest(httpReq);
		chain.doFilter(mRequest, httpResp);
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
	}

}
class MyHttpServletRequest extends HttpServletRequestWrapper{
	public MyHttpServletRequest(HttpServletRequest request){
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(value==null)
			return value;
		//get请求方式asa
		String method = super.getMethod();
		if("get".equalsIgnoreCase(method)){
			try {
				value = new String(value.getBytes("ISO-8859-1"),super.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
}
