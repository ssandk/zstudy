package part8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("spring/context8.xml");
		Board board = ac.getBean("board", Board.class);
		board.boardWrite();
	}

}
