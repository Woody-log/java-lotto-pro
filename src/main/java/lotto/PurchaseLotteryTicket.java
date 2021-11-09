package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseLotteryTicket {
    private List<LotteryTicket> purchaseLotteryTicket;

    public PurchaseLotteryTicket() {
        purchaseLotteryTicket = new ArrayList<>();
    }

    public void add(LotteryTicket lotteryTicket) {
        this.purchaseLotteryTicket.add(lotteryTicket);
    }

    public LotteryTicket get(int i) {
        return purchaseLotteryTicket.get(i);
    }

    public Map<Rank, Integer> countMatchInAllTicket(WinningNumber winningNumber) {
        Map<Rank, Integer> results = new HashMap<>();
        for (LotteryTicket lotteryTicket : purchaseLotteryTicket) {
            Rank rank = Rank.rank(lotteryTicket.countMatch(winningNumber));
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }
}