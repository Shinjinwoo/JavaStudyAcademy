package October20;

import java.awt.Image;

public class StarShipSprite extends Sprite {
	private GalagaGame game; // GalagaGame 객체의 참조값 생성자에서 받아서 저장 - 호출필요
	
	public StarShipSprite(GalagaGame game,Image image, int x, int y) {
		super(image,x,y);
		this.game = game;
		dx = 0;
		dy = 0;
	}
	@Override
	public void move() {
		if((dx<0)&&(x<10)) {
			return;
		}
		if((dx>0)&&(x>800)) {
			return;
		}
		super.move();
	}// 우주선을 움직이는 코드, 경계선에 닿으면 더이상 못가게 한다.
	@Override
	public void handleCollision(Sprite other) {
		if(other instanceof AlienSprite) {
			game.endGame();
			game.removeSprite(this); //우주선 소멸
			game.removeSprite(other); //우주선과 에일리언 같이 소멸
		}
	}

}
