package com.fratane.max.swiperecyclerview.view.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fratane.max.swiperecyclerview.R;
import com.fratane.max.swiperecyclerview.model.Player;
import com.fratane.max.swiperecyclerview.model.Team;
import com.fratane.max.swiperecyclerview.util.SwipeToDismiss;
import com.fratane.max.swiperecyclerview.view.adapter.ListPlayerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPlayersFragment extends Fragment {


    public ListPlayersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_players, container, false);

        setUpRecyclerView(view);

        return view;
    }

    public void setUpRecyclerView(View rootView){
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        final List<Player> list = getPlayers();
        ListPlayerAdapter listPlayerAdapter = new ListPlayerAdapter(list, getContext());
        listPlayerAdapter.setListPlayerAdapterListener(new ListPlayerAdapter.ListPlayerAdapterListener() {
            @Override
            public void onClickListener(int pos) {
                Player p = list.get(pos);
                Toast.makeText(getContext(), p.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(listPlayerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        SwipeToDismiss swipeToDismiss = new SwipeToDismiss(getContext(), ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        swipeToDismiss.setLeftBackgroundColor(R.color.colorAccent);
        swipeToDismiss.setRightBackgroundColor(R.color.colorPrimary);
        swipeToDismiss.setLeftImg(R.drawable.ic_adb);
        swipeToDismiss.setRightImg(R.drawable.ic_adb);
        swipeToDismiss.setSwipetoDismissCallBack(getCallback(listPlayerAdapter));

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeToDismiss);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private List<Player> getPlayers(){
        List<Player> list = new ArrayList<>();

        String meiaArmador = getResources().getString(R.string.meiaArmador);
        String zagueiro = getResources().getString(R.string.zagueiro);
        String atacante = getResources().getString(R.string.atacante);

        Team flamengo = getTeam("Flamengo", "https://seeklogo.com/images/C/Clube_de_Regatas_do_Flamengo-logo-35138A63C6-seeklogo.com.png");
        Team cruzeiro = getTeam("Cruzeiro", "https://dreamleaguesoccer.com.br/wp-content/uploads/2016/11/escudo-do-cruzeiro.png");
        Team santos = getTeam("Santos", "http://www.santosfc.com.br/wp-content/themes/santosfc-theme/assets/images/logo-santos.png");
        Team gremio = getTeam("Grêmio", "http://images.terra.com/2015/05/21/gremio.png");

        Player diegoRibas = getPlayer("Diego Ribas", meiaArmador, 80, flamengo, "https://cartolafcsportv.com/upload/images/98708ecaf48555700b1ca390667c77fb_140x140.png");
        Player lucasLima = getPlayer("Lucas Lima", meiaArmador, 80, santos, "http://s.glbimg.com/es/sde/f/2016/01/07/c43315c00f277200ad7b792b62eff7ae_300x300.png");
        Player pedroGeromel = getPlayer("Pedro Geromel", zagueiro, 79, gremio, "http://www.gremiopedia.com/images/b/b6/Geromel.png");
        Player guerrero = getPlayer("Paolo Guerrero", atacante, 79, flamengo, "http://s.glbimg.com/es/sde/f/2016/03/28/edc485bf3e0a9425879bf582b86200bf_300x300.png");
        Player thiagoNeves = getPlayer("Thiago Neves", meiaArmador, 79, cruzeiro, "https://s.glbimg.com/es/sde/f/2017/02/19/6bb6e70216d205ad23e44268eba27692_300x300.png");
        Player lucasBarrios = getPlayer("Lucas Barrios", atacante, 79, gremio, "https://s.glbimg.com/es/sde/f/2017/04/23/cfc485340a51d2cf63f5fd033c85b2f1_300x300.png");
        Player luan = getPlayer("Luan", atacante, 79, gremio, "https://s.glbimg.com/es/sde/f/2017/04/23/458569d2d0c260a004befc5988da9350_300x300.png");
        Player evertonRibeiro = getPlayer("Everton Ribeiro", meiaArmador, 79, flamengo, "https://s.glbimg.com/es/sde/f/2017/06/06/48433233628904b29b6ff9d418e57dc3_140x140.png");

        list.add(diegoRibas);
        list.add(lucasLima);
        list.add(pedroGeromel);
        list.add(guerrero);
        list.add(thiagoNeves);
        list.add(lucasBarrios);
        list.add(luan);
        list.add(evertonRibeiro);

        return list;
    }

    private Player getPlayer(String name, String position, int overall, Team team, String playerImg){
        Player player = new Player();

        player.setName(name);
        player.setPosition(position);
        player.setOverall(overall);
        player.setTeam(team);
        player.setPlayerImg(playerImg);

        return player;
    }

    private Team getTeam(String name, String imgUrl){
        Team team = new Team();

        team.setName(name);
        team.setImgUrl(imgUrl);

        return team;
    }

    private SwipeToDismiss.SwipetoDismissCallBack getCallback(final ListPlayerAdapter adapter){
        return new SwipeToDismiss.SwipetoDismissCallBack() {
            @Override
            public void onSwipedLeft(RecyclerView.ViewHolder viewHolder) {
                adapter.remove(viewHolder.getAdapterPosition());
            }

            @Override
            public void onSwipedRight(RecyclerView.ViewHolder viewHolder) {
                Toast.makeText(getContext(), "Another or same action", Toast.LENGTH_SHORT).show();
            }
        };
    }

}
