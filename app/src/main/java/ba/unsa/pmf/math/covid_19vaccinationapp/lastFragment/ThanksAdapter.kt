package ba.unsa.pmf.math.covid_19vaccinationapp.lastFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import ba.unsa.pmf.math.covid_19vaccinationapp.fragments.list.ListFragmentDirections
import ba.unsa.pmf.math.covid_19vaccinationapp.model.User
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.fragment_thanks.view.*

class ThanksAdapter: RecyclerView.Adapter<ThanksAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()
    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.broj.text=currentItem.id.toString()
        holder.itemView.ime.text=currentItem.name
        holder.itemView.prezime.text=currentItem.surname
        holder.itemView.vakcina.text=currentItem.vaccine
        holder.itemView.zdravstvena_knjizica.text=currentItem.cardNumber
        holder.itemView.profesija.text=currentItem.profession
        holder.itemView.godina.text=currentItem.years.toString()
        holder.itemView.rowLayout.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }
    fun setData(user: List<User>){
        this.userList=user
        notifyDataSetChanged()
    }
}