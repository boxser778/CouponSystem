package Coupon;

import java.time.LocalDate;
import java.util.Date;

public class Coupon {

	private long id;
	private String title;
	private int amount;
	private Date startDate;
	private Date endDate;
	private String type;
	private String msg;
	private double price;
	private String picture;

	public Coupon(long id, String title, int amount, Date startDate, Date endDate, String type, String msg,
			double price, String picture) {

		this.id = id;
		this.title = title;
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.msg = msg;
		this.price = price;
		this.picture = picture;
	}

	public Coupon() {

	}

	public String getType() {

		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", amount=" + amount + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", type=" + type + ", msg=" + msg + ", price=" + price + ", picture="
				+ picture + "]";
	}

}