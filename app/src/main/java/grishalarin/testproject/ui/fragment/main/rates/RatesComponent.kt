package grishalarin.testproject.ui.fragment.main.rates

import dagger.Subcomponent
import grishalarin.testproject.dagger.FragmentScope

/**
 * @author Sostavkin Grisha
 */
@FragmentScope
@Subcomponent
interface RatesComponent {
    fun inject(fragment: RatesFragment)
    fun presenter(): RatesPresenter
}