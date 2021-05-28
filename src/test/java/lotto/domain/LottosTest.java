package lotto.domain;

import lotto.domain.generator.AutoGenerator;
import lotto.domain.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.domain.LottoResult.*;

class LottosTest {

    @DisplayName("구매 갯수 만큼 로또 생성 확인")
    @Test
    void lottos() {
        int ticketCount = 14;
        Lottos lottos = new Lottos(ticketCount);
        assertThat(lottos.getLottos()).hasSize(ticketCount);
    }

    @DisplayName("당첨된 로또들의 상금 합계 구하기")
    @Test
    void getTotalWinningPrize() {
        List<Lotto> lottoList = new ArrayList<>();
        //6개 일치
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        //5개 일치
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        //4개 일치
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lottos lottos = new Lottos(lottoList);

        //당첨 로또 번호
        List<Integer> winningNumbers = LottoNumberGenerator.manualGenerate("1, 2, 3, 4, 5, 6");
        Lotto winningLotto = new Lotto(winningNumbers);
        int totalPrize = lottos.getTotalWinningPrize(winningLotto);

        assertThat(totalPrize).isEqualTo(FIRST_PRIZE.prize + THIRD_PRIZE.prize + FOURTH_PRIZE.prize);
    }

}