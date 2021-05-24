package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> lotto;

    public Lotto() {
        this.lotto = new ArrayList<>();
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
