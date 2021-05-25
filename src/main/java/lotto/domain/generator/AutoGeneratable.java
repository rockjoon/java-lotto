package lotto.domain.generator;

import java.util.List;

@FunctionalInterface
public interface AutoGeneratable {

    List<Integer> autoGenerate();

}
