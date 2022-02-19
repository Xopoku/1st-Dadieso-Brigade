package com.trustingbrother.a1stdadiesobrigade;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewTTestamentFragment extends Fragment {
    RecyclerView recyclerView;
    Context context;
    private List<NewTTestamentFragment.Subject> subjects;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nnew_testament, container, false);

        recyclerView = view.findViewById(R.id.newtestamentecyclerview);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        NewTestamentRecyclerViewAdapter adapter = new NewTestamentRecyclerViewAdapter(subjects);
        recyclerView.setAdapter(adapter);

        initializeData();
        initializeAdapter();
        return view;
    }
    //this is where to stream the item from the database.
    private void initializeData(){
        subjects = new ArrayList<>();
        //the add must be the first option not subject e
        subjects.add(new NewTTestamentFragment.Subject("1","An Angel Visits Zacharias"));
        subjects.add(new NewTTestamentFragment.Subject("2","A Heavenly Messenger Visits Mary"));
        subjects.add(new NewTTestamentFragment.Subject("3","Zacharias and Elizabeth Name Their Child"));
        subjects.add(new NewTTestamentFragment.Subject("4","The Birth of Jesus"));
        subjects.add(new NewTTestamentFragment.Subject("5","The Wise Men Who Followed a Star"));
        subjects.add(new NewTTestamentFragment.Subject("6","Jesus in the Temple at Twelve Years Old"));
        subjects.add(new NewTTestamentFragment.Subject("7","John the Baptist"));
        subjects.add(new NewTTestamentFragment.Subject("8","The Temptations of Jesus"));
        subjects.add(new NewTTestamentFragment.Subject("9","Five men Meet Jesus"));
        subjects.add(new NewTTestamentFragment.Subject("10","Judas Betrayed Jesus"));
        subjects.add(new NewTTestamentFragment.Subject("11","Jesus and the Samaritan Woman at the well"));
        subjects.add(new NewTTestamentFragment.Subject("12","Jesus Heals the Nobleman's Son"));
        subjects.add(new NewTTestamentFragment.Subject("13","Jesus is Rejected in Nazareth"));
        subjects.add(new NewTTestamentFragment.Subject("14","Four Fishermen Follow Jesus"));
        subjects.add(new NewTTestamentFragment.Subject("15","Matthew the Publican Becomes a Disciple"));
        subjects.add(new NewTTestamentFragment.Subject("16","Jesus Heals a Cripple"));
        subjects.add(new NewTTestamentFragment.Subject("17","The Twelve Men Called Apostles"));
        subjects.add(new NewTTestamentFragment.Subject("18","The Sermon on the Mount"));
        subjects.add(new NewTTestamentFragment.Subject("19","Jesus Heals a Leprous Man"));
        subjects.add(new NewTTestamentFragment.Subject("20","Jesus Heals the Roman Centurian's Servant"));
        subjects.add(new NewTTestamentFragment.Subject("21","Down Through the Roof"));
        subjects.add(new NewTTestamentFragment.Subject("22","Jesus Raises a widow's Son from dead"));
        subjects.add(new NewTTestamentFragment.Subject("23","The Pharisee, a sinful woman and the saviour"));
        subjects.add(new NewTTestamentFragment.Subject("24","The parable of the kingdom of heaven"));
        subjects.add(new NewTTestamentFragment.Subject("25","Jesus Calms the sea"));
        subjects.add(new NewTTestamentFragment.Subject("26","Jesus Raises Jairus' Daughter from dead"));
        subjects.add(new NewTTestamentFragment.Subject("27","Jesus feeds the five thousand"));
        subjects.add(new NewTTestamentFragment.Subject("28","Jesus Walks on water"));
        subjects.add(new NewTTestamentFragment.Subject("29","Jesus cast demon from gentile woman's daughter"));
        subjects.add(new NewTTestamentFragment.Subject("30","Jesus heals the Sick"));
        subjects.add(new NewTTestamentFragment.Subject("31","The Blind man of Bethsaida"));
        subjects.add(new NewTTestamentFragment.Subject("32","The transfiguration of Jesus"));
        subjects.add(new NewTTestamentFragment.Subject("33","Jesus Cast a demon out of a child"));
        subjects.add(new NewTTestamentFragment.Subject("34","Jesus and his Disciple in Capernaum"));
        subjects.add(new NewTTestamentFragment.Subject("35","The Parable of unforgiven servant"));
        subjects.add(new NewTTestamentFragment.Subject("36","The unfriendly Samaritans"));
        subjects.add(new NewTTestamentFragment.Subject("37","Jesus at the Great Feast in Jerusalem"));
        subjects.add(new NewTTestamentFragment.Subject("38","Jesus and the adulterous woman"));
        subjects.add(new NewTTestamentFragment.Subject("39","Jesus Heals a man born Blind"));
        subjects.add(new NewTTestamentFragment.Subject("40","Jesus Blesses the Children"));
        subjects.add(new NewTTestamentFragment.Subject("41","The good samaritan"));
        subjects.add(new NewTTestamentFragment.Subject("42","Jesus Raises Lazarus from the dead"));
        subjects.add(new NewTTestamentFragment.Subject("43","The parable of the great supper"));
        subjects.add(new NewTTestamentFragment.Subject("44","The Prodigal Son"));
        subjects.add(new NewTTestamentFragment.Subject("45","Jesus in Jerusalem for the Passover"));
        subjects.add(new NewTTestamentFragment.Subject("46","Blind Bartimaeus receives his sight"));
        subjects.add(new NewTTestamentFragment.Subject("47","Zacchaeus"));
        subjects.add(new NewTTestamentFragment.Subject("48","Palm Sunday"));
        subjects.add(new NewTTestamentFragment.Subject("49","Jesus teaching on the Mount of Olives"));
        subjects.add(new NewTTestamentFragment.Subject("50","The Last Supper"));
        subjects.add(new NewTTestamentFragment.Subject("51","The Crucifixion of Jesus Christ"));

    }

    private void initializeAdapter(){
        NewTestamentRecyclerViewAdapter adapter = new NewTestamentRecyclerViewAdapter(subjects);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickedListener(position -> {
            switch (position) {
                case 0:
                    startActivity(new Intent(getActivity(),new1.class));
                    break;

                case 1:
                    startActivity(new Intent(getActivity(),new2.class));
                    break;

                case 2:
                    startActivity(new Intent(getActivity(),New3.class));
                    break;

                case 3:
                    startActivity(new Intent(getActivity(),new4.class));
                    break;

                case 4:
                    startActivity(new Intent(getActivity(),new5.class));
                    break;

                case 5:
                    startActivity(new Intent(getActivity(),new6.class));
                    break;

                case 6:
                    startActivity(new Intent(getActivity(),new7.class));
                    break;

                case 7:
                    startActivity(new Intent(getActivity(),new8.class));
                    break;

                case 8:
                    startActivity(new Intent(getActivity(),new9.class));
                    break;

                case 9:
                    startActivity(new Intent(getActivity(),new10.class));
                    break;

                case 10:
                    startActivity(new Intent(getActivity(),new11.class));
                    break;

                case 11:
                    startActivity(new Intent(getActivity(),new12.class));
                    break;

                case 12:
                    startActivity(new Intent(getActivity(),new13.class));
                    break;

                case 13:
                    startActivity(new Intent(getActivity(),new14.class));
                    break;

                case 14:
                    startActivity(new Intent(getActivity(),new15.class));
                    break;

                case 15:
                    startActivity(new Intent(getActivity(),new16.class));
                    break;

                case 16:
                    startActivity(new Intent(getActivity(),new17.class));
                    break;

                case 17:
                    startActivity(new Intent(getActivity(),new18.class));
                    break;

                case 18:
                    startActivity(new Intent(getActivity(),new19.class));
                    break;

                case 19:
                    startActivity(new Intent(getActivity(),new20.class));
                    break;

                case 20:
                    startActivity(new Intent(getActivity(),new21.class));
                    break;

                case 21:
                    startActivity(new Intent(getActivity(),new22.class));
                    break;

                case 22:
                    startActivity(new Intent(getActivity(),new23.class));
                    break;

                case 23:
                    startActivity(new Intent(getActivity(),new24.class));
                    break;

                case 24:
                    startActivity(new Intent(getActivity(),new25.class));
                    break;

                case 25:
                    startActivity(new Intent(getActivity(),new26.class));
                    break;

                case 26:
                    startActivity(new Intent(getActivity(),new27.class));
                    break;

                case 27:
                    startActivity(new Intent(getActivity(),new28.class));
                    break;

                case 28:
                    startActivity(new Intent(getActivity(),new29.class));
                    break;

                case 29:
                    startActivity(new Intent(getActivity(),new30.class));
                    break;

                case 30:
                    startActivity(new Intent(getActivity(),new31.class));
                    break;

                case 31:
                    startActivity(new Intent(getActivity(),new32.class));
                    break;

                case 32:
                    startActivity(new Intent(getActivity(),new33.class));
                    break;

                case 33:
                    startActivity(new Intent(getActivity(),new34.class));
                    break;

                case 34:
                    startActivity(new Intent(getActivity(),new35.class));
                    break;

                case 35:
                    startActivity(new Intent(getActivity(),new36.class));
                    break;

                case 36:
                    startActivity(new Intent(getActivity(),new37.class));
                    break;

                case 37:
                    startActivity(new Intent(getActivity(),new38.class));
                    break;

                case 38:
                    startActivity(new Intent(getActivity(),new39.class));
                    break;

                case 39:
                    startActivity(new Intent(getActivity(),new40.class));
                    break;

                case 40:
                    startActivity(new Intent(getActivity(),new41.class));
                    break;

                case 41:
                    startActivity(new Intent(getActivity(),new42.class));
                    break;

                case 42:
                    startActivity(new Intent(getActivity(),new43.class));
                    break;

                case 43:
                    startActivity(new Intent(getActivity(),new44.class));
                    break;

                case 44:
                    startActivity(new Intent(getActivity(),new45.class));
                    break;

                case 45:
                    startActivity(new Intent(getActivity(),new46.class));
                    break;

                case 46:
                    startActivity(new Intent(getActivity(),new47.class));
                    break;

                case 47:
                    startActivity(new Intent(getActivity(),new48.class));
                    break;

                case 48:
                    startActivity(new Intent(getActivity(),new49.class));
                    break;

                case 49:
                    startActivity(new Intent(getActivity(),new50.class));
                    break;

                case 50:
                    startActivity(new Intent(getActivity(),new51.class));
                    break;
            }
        });
    }

    static class Subject{
        String name;
        String name2;


        Subject(String name, String name2){
            this.name = name;
            this.name2 = name2;
        }
    }


}
