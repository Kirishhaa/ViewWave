package kirishhaa.viewwave.core

import androidx.fragment.app.Fragment


fun <T : Fragment> wrapToClassFragment(clazz: Class<T>): Class<Fragment> {
    return clazz as Class<Fragment>
}