package tech.hamimitbd.shikkha;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    public Context context;
    public ArrayList<String> name;
    public ArrayList<Integer> icon;
    public LayoutInflater mInflater;

    public CustomAdapter(Context context, ArrayList<String> name, ArrayList<Integer> icon) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.name = name;
        this.icon = icon;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.button_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CustomAdapter.ViewHolder holder, int position) {
        holder.iconImg.setImageResource(icon.get(position));
        holder.nameTV.setText(name.get(position));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV;
        ImageView iconImg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.button_txt_id);
            iconImg = itemView.findViewById(R.id.button_img_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {

                        Intent intent = null;

                        switch (nameTV.getText().toString()) {
                            case "MES":
                                intent = new Intent(v.getContext(), MES.class);
                                break;

                            case "MEP":
                                intent = new Intent(v.getContext(),MEP.class);
                                break;

                            case "Institute Registration":
                                intent = new Intent(v.getContext(),Registration.class);
                                break;




                            default:
                                Toast.makeText(v.getContext(), "sohag", Toast.LENGTH_SHORT).show();
                        }


                        
                        
                        
                        // Toast.makeText(v.getContext(), "Welcome to the future", Toast.LENGTH_SHORT).show();
                        v.getContext().startActivity(intent);

                    } catch (Exception e) {

                        Toast.makeText(v.getContext(), "nothing Found", Toast.LENGTH_SHORT).show();

                    }
                }
            });


        }
    }


}
