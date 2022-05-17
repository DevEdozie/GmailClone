package GmailClone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.builderpattern.R;

import java.util.ArrayList;

public class GMC_RecyclerViewAdapter extends RecyclerView.Adapter<GMC_RecyclerViewAdapter.MyViewHolder> {


    Context context;
    ArrayList<GmailCloneModel> gmailCloneModels;

    public GMC_RecyclerViewAdapter(Context context, ArrayList<GmailCloneModel> gmailCloneModels) {
        this.context = context;
        this.gmailCloneModels =  gmailCloneModels;
    }

    @NonNull
    @Override
    public GMC_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row_2,parent,false);
        return new GMC_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GMC_RecyclerViewAdapter.MyViewHolder holder, int position) {
      // assigning values to the views we created in the recycler_view_row layout file
      // based on the position of the recycler view
        holder.tvMessageText.setText(gmailCloneModels.get(position).getMessageText());
        holder.tvMessageTitle.setText(gmailCloneModels.get(position).getMessageTitle());
        holder.tvDate.setText(gmailCloneModels.get(position).getDate());
        holder.imageView.setImageResource(gmailCloneModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        //  the recycler view just wants to know the number of items you want displayed
        return  gmailCloneModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // grabbing the views from our recycler_view_row layout file
        // Kinda like int the onCreate method

        ImageView imageView;
        TextView tvMessageText,tvMessageTitle,tvDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //instantiate
            imageView = itemView.findViewById(R.id.vector_icon);
            tvMessageText = itemView.findViewById(R.id.text_textview);
            tvMessageTitle = itemView.findViewById(R.id.title_textview);
            tvDate = itemView.findViewById(R.id.date_textview);
        }
    }


    public void removeItem(int position) {
        gmailCloneModels.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, gmailCloneModels.size());
    }
}
