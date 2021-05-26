package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.domain.LottoResult.*;

class LottoResultTest {

    @DisplayName("당첨 종류에 따라 상금 구하기")
    @Test
    void findPrize() {
        for (LottoResult result : values()) {
            int prize = findPrizeByCount(result.sameCount);
            assertThat(prize).isEqualTo(result.prize);
        }
    }
}