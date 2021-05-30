package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.generator.LottoNumberGenerator;

import java.util.Scanner;

import static lotto.io.Message.*;
import static lotto.io.OutputView.*;

public class InputView {

    private static final Scanner scan = new Scanner(System.in);

    public static int requestPurchaseAmount() {
        try {
            print(REQUEST_PURCHASE_AMOUNT);
            return scan.nextInt();
        } catch (Exception e) {
            print(e.getMessage());
            return requestPurchaseAmount();
        }
    }

    public static Lotto requestWinningLotto() {
        String input = scan.next();
        try {
            return  new Lotto(LottoNumberGenerator.manualGenerate(input));
        } catch (Exception e) {
            print(e.getMessage());
            return requestWinningLotto();
        }
    }


}
