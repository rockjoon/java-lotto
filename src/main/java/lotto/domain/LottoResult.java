package lotto.domain;

public class LottoResult {

    static final int PRICE_PER_TICKET = 1000;
    private int purchasePrice;
    private int ticketCount;

    public LottoResult(int purchasePrice) {
        if (purchasePrice < PRICE_PER_TICKET) {
            throw new IllegalArgumentException("구매 가능 최소 금액은 " + PRICE_PER_TICKET + "입니다.");
        }
        this.purchasePrice = purchasePrice - purchasePrice % PRICE_PER_TICKET;
        this.ticketCount = purchasePrice / PRICE_PER_TICKET;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
