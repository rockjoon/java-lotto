package lotto.domain;

import lotto.domain.generator.AutoGenerator;
import lotto.domain.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static lotto.io.Message.PURCHASE_COUNT;
import static lotto.io.OutputView.*;

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
        printLottoNumbers(ticketCount);
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

    private void printLottoNumbers(int ticketCount) {
        print(ticketCount + PURCHASE_COUNT.message);
        for (Lotto lotto : lottos) {
            lotto.printLottoNumber();
        }
        print("");
    }


}
