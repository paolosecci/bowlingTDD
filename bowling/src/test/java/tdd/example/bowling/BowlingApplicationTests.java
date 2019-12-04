package tdd.example.bowling;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void doesGameStartWithZeroTotalScore(){
		Game g = new Game();
		assertEquals(0, g.getTotalScore());
	}

	@Test
	void firstRollsWorks() {
		Game g = new Game();
		g.roll(4);
		assertEquals(4, g.getTotalScore());
	}

	@Test
	void firstFrameWorks(){
		Game g = new Game();
		g.roll(4);
		g.roll(3);
		assertEquals(7, g.getTotalScore());
	}

	@Test
	void firstTwoFramesWork(){
		Game g = new Game();
		g.roll(3);
		g.roll(3);
		g.roll(7);
		g.roll(2);
		assertEquals(15, g.getTotalScore());
	}

	@Test
	void standardSpareWorks(){
		Game g = new Game();
		g.roll(7);
		g.roll(3);
		g.roll(8);
		g.roll(1);
		assertEquals(27, g.getTotalScore());
	}

	@Test
	void standardStrikeWorks(){
		Game g = new Game();
		g.roll(10);
		g.roll(3);
		g.roll(4);
		assertEquals(24, g.getTotalScore());
	}

	@Test
	void multipleStrikesInARow(){
		Game g = new Game();
		g.roll(10);
		g.roll(10);
		g.roll(1);
		g.roll(2);
		assertEquals(37, g.getTotalScore());
	}

	@Test
	void spareAtEnd(){
		Game g = new Game();
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(1);
		g.roll(9);
		g.roll(3);
		assertEquals(31, g.getTotalScore());
	}

	@Test
	void perfectGame(){
		Game g = new Game();
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		assertEquals(300, g.getTotalScore());
	}
}
