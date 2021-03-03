package ua.youdin.randomuserrestapi.data

import ua.youdin.randomuserrestapi.data.randomuserApi.model.Data


sealed class RepoLoadResult<out R> {
    data class Success(val data: List<Data>) : RepoLoadResult<List<Data>>()
    data class Error(val error: Exception) : RepoLoadResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data = $data]"
            is Error -> "Error[exeption = $error"
        }
    }
}