package kirishhaa.viewwave.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory<VM : ViewModel>(
    private val createdFunctionViewModel: () -> VM,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return createdFunctionViewModel() as T
    }
}

inline fun <reified VM : ViewModel> Fragment.createViewModel
            (noinline createdFunctionViewModel: () -> VM): Lazy<VM> {
    return viewModels { ViewModelFactory(createdFunctionViewModel) }
}