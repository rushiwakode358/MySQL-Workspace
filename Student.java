package com.StudenManagement;

public class Student {

	private int studentId;
	private String studentName;
	private String studentClass;
	private String studentAddress;
	private long studentContactN0;

	public Student() {

	}

	public Student(long studentContactN0) {
		super();
		this.studentContactN0 = studentContactN0;
	}

	public Student(int studentId, String studentName, String studentClass, String studentAddress,
			long studentContactN0) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.studentAddress = studentAddress;
		this.studentContactN0 = studentContactN0;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public long getStudentContactN0() {
		return studentContactN0;
	}

	public void setStudentContactN0(long studentContactN0) {
		this.studentContactN0 = studentContactN0;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentClass=" + studentClass
				+ ", studentAddress=" + studentAddress + ", studentContactN0=" + studentContactN0 + "]";
	}

}
