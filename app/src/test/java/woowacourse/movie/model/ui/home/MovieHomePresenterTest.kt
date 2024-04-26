package woowacourse.movie.model.ui.home

import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import woowacourse.movie.model.data.MovieContentsImpl
import woowacourse.movie.ui.home.MovieHomeContract
import woowacourse.movie.ui.home.MovieHomePresenter

class MovieHomePresenterTest {
    private lateinit var presenter: MovieHomePresenter
    private lateinit var view: MovieHomeContract.View

    @BeforeEach
    fun setUp() {
        view = mockk<MovieHomeContract.View>()
        presenter = MovieHomePresenter(view, MovieContentsImpl)
    }

    @Test
    fun `영화 목록을 가져온다`() {
        // given
        every { view.showMovieContents(any()) } just runs

        // when
        presenter.loadMovieContents()

        // then
        verify { view.showMovieContents(any()) }
    }
}