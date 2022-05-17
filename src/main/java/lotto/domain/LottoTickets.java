package lotto.domain;

import lotto.infrastructure.error.LottoTicketsErrorCode;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        validateNullOrEmpty(lottoTickets);
        this.lottoTickets = lottoTickets;
    }

    public int getLottoTicketsCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getReadOnlyLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public LottoWinningResult compareWinningLottoTicket(WinningLottoTicket winningLottoTicket) {
        LottoWinningResult lottoWinningResult = new LottoWinningResult();

        for (LottoTicket lottoTicket : lottoTickets) {
            lottoWinningResult.countLottoRank(winningLottoTicket, lottoTicket);
        }

        return lottoWinningResult;
    }

    private void validateNullOrEmpty(List<LottoTicket> lottoTickets) {
        if (Objects.isNull(lottoTickets) || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException(LottoTicketsErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
        }
    }
}