package woowacourse.movie.ui.selection

import woowacourse.movie.model.data.MovieContents
import woowacourse.movie.model.movie.ReservationDetail
import woowacourse.movie.model.movie.Seat

class MovieSeatSelectionPresenter(
    private val view: MovieSeatSelectionContract.View,
    private val movieContents: MovieContents,
    reservationCount: Int,
) :
    MovieSeatSelectionContract.Presenter {
    private val reservationDetail = ReservationDetail(reservationCount)

    override fun loadMovieTitle(movieContentId: Long) {
        val movieContent = movieContents.find(movieContentId)
        view.showMovieTitle(movieContent.title)
    }

    override fun loadTotalSeatAmount() {
        view.showReservationTotalAmount(reservationDetail.totalSeatAmount())
    }

    override fun loadTheater() {
        view.showTheater(Seat.ROW_LEN, Seat.COL_LEN)
    }

    override fun selectSeat(
        row: Int,
        col: Int,
    ) {
        if (reservationDetail.selectedSeat.contains(Seat(row, col))) {
            reservationDetail.removeSeat(row, col)
            view.showUnSelectedSeat(row, col)
        } else {
            reservationDetail.addSeat(row, col)
            view.showSelectedSeat(row, col)
        }
        view.showReservationTotalAmount(reservationDetail.totalSeatAmount())
    }
}
