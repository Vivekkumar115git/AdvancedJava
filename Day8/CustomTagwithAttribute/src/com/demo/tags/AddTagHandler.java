package com.demo.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AddTagHandler extends TagSupport {
	private int num1,num2;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	public int doEndTag() throws JspException {
		JspWriter out=pageContext.getOut();
		try {
			out.println("<h4>Adiition : "+(num1+num2)+"</h4>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
