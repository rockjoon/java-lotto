package lotto.domain;

import lotto.domain.generator.AutoGenerator;
import lotto.domain.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int ticketCount) {
        AutoGenerator generator = new LottoNumberGenerator();
        this.lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = generator.autoGenerate();
            lottos.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getTotalWinningPrize(Lotto winningLotto) {
        int totalWinningPrize = 0;
        for (Lotto lotto : lottos) {
            int sameNumberCount = lotto.countSameNumber(winningLotto);
            totalWinningPrize += LottoResult.findPrizeByCount(sameNumberCount);
        }
        return totalWinningPrize;
    }

}
