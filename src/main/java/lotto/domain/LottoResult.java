package lotto.domain;

import java.util.Arrays;

public enum LottoResult {

    FIRST_PRIZE(6, 2000000000),
    THIRD_PRIZE(5, 1500000),
    FOURTH_PRIZE(4, 50000),
    FIFTH_PRIZE(3, 5000),
    NONE(0, 0)
    ;

    final int sameCount;
    final int prize;

    LottoResult(int sameCount, int prize) {
        this.sameCount = sameCount;
        this.prize = prize;
    }

    static int findPrizeByCount(int sameCount) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.sameCount == sameCount)
                .findFirst().orElse(NONE).prize;
    }

}
