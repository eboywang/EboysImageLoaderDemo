package com.example.administrator.myapplication.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Clazz extends BaseJsonableBean<Clazz> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1354327708777695808L;
	private String className;
	private ArrayList<String> students;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ArrayList<String> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<String> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ id :" + this.get_id() + " ,className: " + this.getClassName()
				+ ", students.size :" + this.getStudents().size() + " ]";
	}

}
