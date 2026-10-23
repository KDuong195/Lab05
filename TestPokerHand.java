import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class TestPokerHand {

	// Helper: tạo một tay bài từ 5 lá bài
	private static PokerHand createHand(Card... pCards) {
		return new PokerHand(pCards);
	}

	// Helper: gọi phương thức private isStraightFlush() bằng reflection
	private static boolean isStraightFlush(PokerHand pHand) {
		try {
			Method method = PokerHand.class.getDeclaredMethod("isStraightFlush");
			method.setAccessible(true);
			return (boolean) method.invoke(pHand);
		} catch (ReflectiveOperationException exception) {
			throw new AssertionError("Cannot invoke isStraightFlush", exception);
		}
	}

	// Test case có kết quả true: 5H 6H 7H 8H 9H
	@Test
	void testIsStraightFlush_True() {
		PokerHand hand = createHand(
				Card.get(Rank.FIVE, Suit.HEARTS),
				Card.get(Rank.SIX, Suit.HEARTS),
				Card.get(Rank.SEVEN, Suit.HEARTS),
				Card.get(Rank.EIGHT, Suit.HEARTS),
				Card.get(Rank.NINE, Suit.HEARTS));
		assertTrue(isStraightFlush(hand));
	}
}
