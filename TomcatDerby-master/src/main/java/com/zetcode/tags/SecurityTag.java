package com.zetcode.tags;

import java.io.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.zetcode.util.ReadData;

public class SecurityTag extends SimpleTagSupport {
	
	private String id = "___security";
	private float minutes = .25f;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		String js = ReadData.getFile(SecurityTag.class, "SecurityTag.js");
		js = js.replace("$id$", id)
				.replace("$minutes$", String.valueOf(minutes));
		out.println(js);
	}

	public float getMinutes() {
		return minutes;
	}

	public void setMinutes(float minutes) {
		this.minutes = minutes;
	}
}
