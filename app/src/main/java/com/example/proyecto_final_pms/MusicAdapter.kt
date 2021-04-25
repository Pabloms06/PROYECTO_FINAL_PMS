import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cbellmont.ejercicioadapterstarwars.databinding.MusicLayoutBinding


abstract class MusicAdapter : RecyclerView.Adapter<MusicAdapter.Music>() {

    lateinit var binding : MusicLayoutBinding

    class Music(root: View, var image: ImageView, var descrip: TextView, var anio: TextView, var song: TextView, var integrantes : TextView) : RecyclerView.ViewHolder(root)

    private var films = mutableListOf<Music>()

    fun updateFilms(filmsList: MutableList<Music>) {
        this.films = filmsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Music {
        binding = MusicLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return Music(binding.root,binding.fotobanda,binding.descripcion,binding.anio,binding.cancion,binding.integrantes)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    /*override fun onBindViewHolder(holder: MusicAdapter, position: Int) {

    }*/
}
