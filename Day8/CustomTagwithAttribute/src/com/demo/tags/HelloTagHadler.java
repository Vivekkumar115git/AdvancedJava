package com.demo.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTagHadler extends TagSupport {
	  private String firstName,lastName;
	  
	public int doStartTag() {
		
		  return EVAL_BODY_INCLUDE;
	  }
	  public int doEndTag() throws JspException {
		  JspWriter out=pageContext.getOut();
		  try {
			out.println("<h2> Hello  "+lastName+"  "+firstName+"</h2>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	  }
	  
	  public String getFirstName() {
			System.out.println("in getFirstname");
			return firstName;
		}
		public void setFirstName(String firstName) {
			System.out.println("in setFirstname");
			this.firstName = firstName;
		}
		public String getLastName() {
			System.out.println("in getlastname");
			return lastName;
		}
		public void setLastName(String lastName) {
			System.out.println("in setlastname");
			this.lastName = lastName;
		}

}
