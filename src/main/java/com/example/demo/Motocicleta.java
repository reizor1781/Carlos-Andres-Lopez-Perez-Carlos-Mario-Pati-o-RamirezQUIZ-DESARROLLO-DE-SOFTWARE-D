package com.example.demo;
import java.util.UUID;
public class Motocicleta {
	private String id;
	private String marcaDeLaMotocicleta;
	private String cilindrajeDeMotocicleta;
	private String placaDeMotocicleta;
	private String color;
	private int costo;
	public Motocicleta(String marcaDeLaMotocicleta, String cilindrajeDeMotocicleta, String placaDeMotocicleta,
			String color, int costo) {
		this.id = UUID.randomUUID().toString();
		this.marcaDeLaMotocicleta = marcaDeLaMotocicleta;
		this.cilindrajeDeMotocicleta = cilindrajeDeMotocicleta;
		this.placaDeMotocicleta = placaDeMotocicleta;
		this.color = color;
		this.costo = costo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMarcaDeLaMotocicleta() {
		return marcaDeLaMotocicleta;
	}
	public void setMarcaDeLaMotocicleta(String marcaDeLaMotocicleta) {
		this.marcaDeLaMotocicleta = marcaDeLaMotocicleta;
	}
	public String getCiclajeDeMotocicleta() {
		return cilindrajeDeMotocicleta;
	}
	public void setCiclajeDeMotocicleta(String ciclajeDeMotocicleta) {
		this.cilindrajeDeMotocicleta = ciclajeDeMotocicleta;
	}
	public String getPlacaDeMotocicleta() {
		return placaDeMotocicleta;
	}
	public void setPlacaDeMotocicleta(String placaDeMotocicleta) {
		this.placaDeMotocicleta = placaDeMotocicleta;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	
}
