package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultTest {

    @DisplayName("로또 티켓 수 구하기")
    @Test
    void ticketCount() {
        int purchasePrice = 14500;
        int ticketCount = purchasePrice / LottoResult.PRICE_PER_TICKET;
        LottoResult lottoResult = new LottoResult(purchasePrice);
        assertThat(lottoResult.getTicketCount()).isEqualTo(ticketCount);
    }

    @DisplayName("구매 가능 금액 미달 시 IllegalArgumentException 발생")
    @Test
    void validatePurchasePrice() {
        int purchasePrice = -1;
        assertThatThrownBy(() -> new LottoResult(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}