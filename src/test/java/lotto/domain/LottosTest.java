package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("구매 갯수 만큼 로또 생성 확인")
    @Test
    void name() {
        int ticketCount = 14;
        Lottos lottos = new Lottos(ticketCount);
        assertThat(lottos.getLottos()).hasSize(ticketCount);
    }
}