package com.training.bean;

public class ContactFormBean {
	private String Name;
	private String Email;
	private String Subject;
	private String Message;

	public ContactFormBean() {
	}

	public ContactFormBean(String Name, String Email, String Subject, String Message) {
		super();
		this.Name = Name;
		this.Email = Email;
		this.Subject = Subject;
		this.Message = Message;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String Subject) {
		this.Subject = Subject;
	}
	
	public String getMessage() {
		return Message;
	}

	public void setMessage(String Message) {
		this.Message = Message;
	}
	
	@Override
	public String toString() {
		return "ContactFormBean [Name=" + Name + ", Email=" + Email + ", Subject=" + Subject + ",Message=" + Message + "]";
	}
}
