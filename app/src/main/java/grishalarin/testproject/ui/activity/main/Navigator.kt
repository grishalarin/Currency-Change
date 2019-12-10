package grishalarin.testproject.ui.activity.main

import grishalarin.testproject.dagger.ScreenScope
import grishalarin.testproject.ui.fragment.FragmentNavigator
import grishalarin.testproject.ui.fragment.main.rates.RatesFragment
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
@ScreenScope
class Navigator @Inject constructor(private val fragmentNavigator: FragmentNavigator) {

    fun navigateToRates() {
        val fragment = { RatesFragment.newInstance() }
        fragmentNavigator.newChain(fragment, Screen.ALBUMS)
    }

    object Screen {
        const val ALBUMS = "ALBUMS"
        const val ALBUM = "ALBUM"
    }
}