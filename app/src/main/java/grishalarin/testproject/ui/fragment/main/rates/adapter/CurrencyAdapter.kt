package grishalarin.testproject.ui.fragment.main.rates.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import grishalarin.localdb.model.Currency
import grishalarin.testproject.R
import grishalarin.testproject.helper.extension.autoNotify
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * @author Sostavkin Grisha
 */
class CurrencyAdapter @Inject constructor() : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {
    //region Other
    var itemListener: ((currency: Currency) -> Unit)? = null
    var items: List<Currency> by Delegates.observable(emptyList()) { prop, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.idSymbols == n.idSymbols}
    }
    //endRegion

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_currency, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name = view.findViewById<TextView>(R.id.item_name)
        private val course = view.findViewById<TextView>(R.id.item_course)
        private val summ = view.findViewById<TextView>(R.id.item_summ)
        private val nominal = view.findViewById<TextView>(R.id.item_nominal)

        fun bind(model: Currency) {
            name.text = model.name
            course.text = itemView.context.getString(R.string.item_currency_course, model.value)
            nominal.text = itemView.context.getString(R.string.item_currency_nominal, model.nominal)

            model.userValue.let {
                summ.text = itemView.context.getString(R.string.item_currency_summ, it)
            }
            itemView.setOnClickListener { itemListener?.invoke(model) }
        }
    }
}

