package ua.youdin.randomuserrestapi.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import ua.youdin.randomuserrestapi.data.RandomUserPaddingSourse.Companion.QUERY
import ua.youdin.randomuserrestapi.data.RandomUserPaddingSourse.Companion.START_PAGE
import ua.youdin.randomuserrestapi.data.randomuserApi.RandomUserServise
import ua.youdin.randomuserrestapi.data.randomuserApi.model.Data

class RandomUserRepository(private val service: RandomUserServise) {

    fun loadResult(): Flow<PagingData<Data>> =
        Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { RandomUserPaddingSourse(service) }
        ).flow

    companion object {
        const val PAGE_SIZE = 20
    }
}