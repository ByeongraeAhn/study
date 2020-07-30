package com.quantvalley.batch.model;

/**
 * The Class StockPriceDetails.
 *
 * @author ashraf
 */
public class StockPriceDetails {

	private String stock;
	private double open;
	private double close;
	private double low;
	private double high;

	public StockPriceDetails(String stock, double open, double close, double low, double high) {
		super();
		this.stock = stock;
		this.open = open;
		this.close = close;
		this.low = low;
		this.high = high;
	}

	public String getStock() {
		return stock;
	}

	public double getOpen() {
		return open;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	@Override
	public String toString() {
		return "StockPriceDetails [stock=" + stock + ", open=" + open + ", close=" + close + ", low=" + low + ", high="
				+ high + "]";
	}

}
