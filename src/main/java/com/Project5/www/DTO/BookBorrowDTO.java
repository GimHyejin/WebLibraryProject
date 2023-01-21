package com.Project5.www.DTO;

public class BookBorrowDTO {
	/*단체*/
	private int bookNumber;
	private String bookName;
	private String bookColum;
	private boolean bookBorrow;
	private int countBorrow;
	
	/*개인*/
	private String id;
	//private int bookNumber;
	private boolean bookOverdue;
	private boolean bookSubmit;
	private String startTime;
	private String stopTime;
	
	
	
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookColum() {
		return bookColum;
	}
	public void setBookColum(String bookColum) {
		this.bookColum = bookColum;
	}
	public boolean isBookBorrow() {
		return bookBorrow;
	}
	public void setBookBorrow(boolean bookBorrow) {
		this.bookBorrow = bookBorrow;
	}
	
	public boolean isBookSubmit() {
		return bookSubmit;
	}
	public void setBookSubmit(boolean bookSubmit) {
		this.bookSubmit = bookSubmit;
	}
	public int getCountBorrow() {
		return countBorrow;
	}
	public void setCountBorrow(int countBorrow) {
		this.countBorrow = countBorrow;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public boolean isBookOverdue() {
		return bookOverdue;
	}
	public void setBookOverdue(boolean bookOverdue) {
		this.bookOverdue = bookOverdue;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	
	
	
}
