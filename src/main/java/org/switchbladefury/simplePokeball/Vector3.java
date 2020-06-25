package org.switchbladefury.simplePokeball;

public class Vector3 {
	private double x;
	private double y;
	private double z;

	Vector3(int x, int y, int z) {
		this.x = (double) x;
		this.y = (double) y;
		this.z = (double) z;
	}
	
	Vector3(float x, float y, float z) {
		this.x = (double) x;
		this.y = (double) y;
		this.z = (double) z;
	}
	
	Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//add 
	public Vector3 add(Vector3 v){
		return new Vector3(v.x + this.x, v.y + this.y, v.z + this.z);
	}
	
	public Vector3 add(int i) {
		return new Vector3(this.x + i, this.y + i, this.z + i);
	}
	
	//sub
	public Vector3 sub(Vector3 v){
		return new Vector3(v.x - this.x, v.y - this.y, v.z - this.z);
	}
	
	public Vector3 sub(int i) {
		return new Vector3(this.x - i, this.y - i, this.z - i);
	}
	
	//mult
	public Vector3 mult(Vector3 v){
		return new Vector3(v.x * this.x, v.y * this.y, v.z * this.z);
	}
	
	public Vector3 mult(int i) {
		return new Vector3(this.x * i, this.y * i, this.z * i);
	}
	
	//div
	public Vector3 div(Vector3 v){
		return new Vector3(this.x / v.x, this.y / v.y, this.z / v.z);
	}

	public Vector3 div(int i) {
		return new Vector3(this.x / i, this.y / i, this.z / i);
	}
	
	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.z;
	}
	
	public Vector3 floor() {
		return new Vector3(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
		
	}
}