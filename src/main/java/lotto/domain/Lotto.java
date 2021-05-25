package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> lotto;

    public Lotto(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBERS_SIZE + "자리로 입력해주세요");
        }
        this.lotto = numbers;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

}
