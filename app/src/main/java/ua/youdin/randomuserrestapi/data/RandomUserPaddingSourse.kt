package ua.youdin.randomuserrestapi.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import ua.youdin.randomuserrestapi.data.RandomUserRepository.Companion.PAGE_SIZE
import ua.youdin.randomuserrestapi.data.randomuserApi.RandomUserServise
import ua.youdin.randomuserrestapi.data.randomuserApi.model.Data
import java.io.IOException

class RandomUserPaddingSourse(private val service: RandomUserServise) : PagingSource<Int, Data>() {
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val position = params.key ?: START_PAGE
        return try {
            val response = service.searchPerRage(QUERY, position, params.loadSize)
            val repos = response.items
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                position + (params.loadSize / PAGE_SIZE)
            }
            LoadResult.Page(
                data = repos,
                prevKey = if (position == START_PAGE) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    companion object {
        const val START_PAGE = 1
        const val QUERY = "Manager"
    }
}
