package com.example.creatime.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.*;
import android.widget.*;

import com.example.creatime.R;
import com.example.creatime.model.Suplemento;

import java.util.List;

public class SuplementoAdapter extends RecyclerView.Adapter<SuplementoAdapter.SuplementoViewHolder>{

        private List<Suplemento> suplementos;
        private OnItemClickListener listener;

        public interface OnItemClickListener {
            void onTomadoClick(Suplemento suplemento);

            void onExcluirClick(Suplemento suplemento);
        }

        public SuplementoAdapter(List<Suplemento> suplementos, OnItemClickListener listener) {
            this.suplementos = suplementos;
            this.listener = listener;
        }

        @NonNull
        @Override
        public SuplementoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_suplemento, parent, false);
            return new SuplementoViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SuplementoViewHolder holder, int position) {
            Suplemento suplemento = suplementos.get(position);
            holder.bind(suplemento);
        }

        @Override
        public int getItemCount() {
            return suplementos.size();
        }

        class SuplementoViewHolder extends RecyclerView.ViewHolder {
            TextView tvNome, tvDosagem, tvHorario;
            ImageView icone;

            public SuplementoViewHolder(@NonNull View itemView) {
                super(itemView);
                tvNome = itemView.findViewById(R.id.tvNome);
                tvDosagem = itemView.findViewById(R.id.tvDosagem);
                tvHorario = itemView.findViewById(R.id.tvHorario);
                icone = itemView.findViewById(R.id.icone);
            }

            void bind(Suplemento suplemento) {
                tvNome.setText(suplemento.getNome());
                tvDosagem.setText(suplemento.getDosagem());

                String horaFormatada = String.format("%02d:%02d", suplemento.getHora(), suplemento.getMinuto());
                tvHorario.setText(horaFormatada);

                // Clique longo para mostrar opções
                itemView.setOnLongClickListener(v -> {
                    PopupMenu popup = new PopupMenu(itemView.getContext(), itemView);
                    popup.getMenuInflater().inflate(R.menu.menu_suplemento_item, popup.getMenu());
                    popup.setOnMenuItemClickListener(menuItem -> {
                        int itemId = menuItem.getItemId();

                        if (itemId == R.id.action_tomado) {
                            listener.onTomadoClick(suplemento);
                            return true;
                        } else if (itemId == R.id.action_excluir_alarme) {
                            listener.onExcluirClick(suplemento);
                            return true;
                        } else {
                            return false;
                        }
                    });
                    popup.show();
                    return true;
                });
            }
        }
        }
