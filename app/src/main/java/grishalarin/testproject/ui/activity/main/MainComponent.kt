package grishalarin.testproject.ui.activity.main

import dagger.Subcomponent
import grishalarin.testproject.ui.activity.base.ActivityModule
import grishalarin.testproject.ui.fragment.main.rates.RatesComponent
import grishalarin.testproject.dagger.ActivityScope

/**
 * @author Sostavkin Grisha
 */
@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
    fun mainPresenter(): MainPresenter
    fun ratesComponent(): RatesComponent
}