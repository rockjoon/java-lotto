package lotto.domain.generator;

import java.util.List;

@FunctionalInterface
public interface ManualGeneratable {

    List<Integer> manualGenerate(String input);

}
