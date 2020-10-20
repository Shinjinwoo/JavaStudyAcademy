package October20;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Sprite {
	protected int x;
	protected int y;
	protected int dx;
	protected int dy;
	private Image image;
	
	public Sprite(Image image, int x, int y) {
		this.image = image;
		this.x=x;
		this.y=y;
		
	}
	public int getWidth() {
		return image.getWidth(null);
	}
	
	public int getHeight() {
		return image.getHeight(null);
	}
	public void draw(Graphics g) {
		g.drawImage(image, x, y,null);
	}
	
	public void move() {
		x += dx;
		y += dy;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	// dx를 반환한다.
	public int getDx() {
		return dx;
		}
	// dy를 반환한다
	public int getDy() {
		return dy;
		}
	// dx를 반환한다.
	public int getX() {
		return x;
	}
	// dy를 반환한다
	public int getY() {
		return y;
	}
	//다른 스프라이트와의 충돌 여부를 계산한다. 충돌이면 true를 반환한다.
	public boolean checkCollision(Sprite other) {
		Rectangle myRect = new Rectangle();
		Rectangle otherRect = new Rectangle();
		myRect.setBounds(x,y,getWidth(),getHeight());
		otherRect.setBounds(other.getX(),other.getY(),other.getWidth(),other.getHeight());
		
		return myRect.intersects(otherRect);
	}
	//호출을 처리한다.
	public void handleCollision(Sprite other) {

}
}