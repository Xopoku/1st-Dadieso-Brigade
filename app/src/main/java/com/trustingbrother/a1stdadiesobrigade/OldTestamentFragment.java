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

@SuppressWarnings("ALL")
public class OldTestamentFragment extends Fragment {
    RecyclerView recyclerView;
    Context context;
    private List<Subject> subjects;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_old_testament, container, false);

        recyclerView = view.findViewById(R.id.canticlerecyclerview);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        OldTestamentRecyclerViewAdapter adapter = new OldTestamentRecyclerViewAdapter(subjects);
        recyclerView.setAdapter(adapter);

        initializeData();
        initializeAdapter();
        return view;
    }
    //this is where to stream the item from the database.
    private void initializeData(){
        subjects = new ArrayList<>();
        //the add must be the first option not subject e
        subjects.add(new OldTestamentFragment.Subject("1","Creation - How the World was Made"));
        subjects.add(new OldTestamentFragment.Subject("2","The Garden of Eden"));
        subjects.add(new OldTestamentFragment.Subject("3","Cain & Abel - The First Children"));
        subjects.add(new OldTestamentFragment.Subject("4","Noah's Ark and why it was built"));
        subjects.add(new OldTestamentFragment.Subject("5","The Tower of Babel"));
        subjects.add(new OldTestamentFragment.Subject("6","Abraham, the Father of all Nation"));
        subjects.add(new OldTestamentFragment.Subject("7","How Abraham Ended a Quarrel"));
        subjects.add(new OldTestamentFragment.Subject("8","Lot's Choice & How it Brought Trouble"));
        subjects.add(new OldTestamentFragment.Subject("9","Hagar, Ismael & God's promise to Abraham"));
        subjects.add(new OldTestamentFragment.Subject("10","Abraham Gets Strange visitors"));
        subjects.add(new OldTestamentFragment.Subject("11","Sodom and Gomorrah"));
        subjects.add(new OldTestamentFragment.Subject("12","Ismael, the great hunter"));
        subjects.add(new OldTestamentFragment.Subject("13","Abraham Sacrificed Isaac to God"));
        subjects.add(new OldTestamentFragment.Subject("14","How Abraham found wife for Isaac"));
        subjects.add(new OldTestamentFragment.Subject("15","The item of Jacob"));
        subjects.add(new OldTestamentFragment.Subject("16","The Ladder that reached to heaven"));
        subjects.add(new OldTestamentFragment.Subject("17","Jacob and Rachel"));
        subjects.add(new OldTestamentFragment.Subject("18","Jacob and Esau"));
        subjects.add(new OldTestamentFragment.Subject("19","Joseph and His Coat of many colors"));
        subjects.add(new OldTestamentFragment.Subject("20","Pharaoh's Dream"));
        subjects.add(new OldTestamentFragment.Subject("21","Joseph and His brethren"));
        subjects.add(new OldTestamentFragment.Subject("22","The Mystery of the lost brother"));
        subjects.add(new OldTestamentFragment.Subject("23","The child who was found in the river"));
        subjects.add(new OldTestamentFragment.Subject("24","The Israelites Burdens"));
        subjects.add(new OldTestamentFragment.Subject("25","Pharaoh's Overthrow"));
        subjects.add(new OldTestamentFragment.Subject("26","Moses Smites the Rock"));
        subjects.add(new OldTestamentFragment.Subject("27","Aaron's Golden Calf"));
        subjects.add(new OldTestamentFragment.Subject("28","The ten Commandments"));
        subjects.add(new OldTestamentFragment.Subject("29","The return of the spies"));
        subjects.add(new OldTestamentFragment.Subject("30","The Brazen Serpent"));
        subjects.add(new OldTestamentFragment.Subject("31","Balaan and the Ass"));
        subjects.add(new OldTestamentFragment.Subject("32","Josuah at Jericho"));
        subjects.add(new OldTestamentFragment.Subject("33","The Item of Gideon"));
        subjects.add(new OldTestamentFragment.Subject("34","Jephthah's Daughter"));
        subjects.add(new OldTestamentFragment.Subject("35","Sampson and the Lion"));
        // how sampson lost his strength comes from the sunday school stories app
        subjects.add(new OldTestamentFragment.Subject("36","How sampson lost his strength"));
        subjects.add(new OldTestamentFragment.Subject("37","Sampson and the Gate of GAZA"));
        subjects.add(new OldTestamentFragment.Subject("38","Naomi and Ruth"));
        subjects.add(new OldTestamentFragment.Subject("39","Hanna Dedicates Samuel"));
        subjects.add(new OldTestamentFragment.Subject("40","Samuel's First Prophesy"));
        subjects.add(new OldTestamentFragment.Subject("41","David the anointed king"));
        subjects.add(new OldTestamentFragment.Subject("42","The item of Saul"));
        subjects.add(new OldTestamentFragment.Subject("43","David and Goliath"));
        subjects.add(new OldTestamentFragment.Subject("44","David playing before Saul"));
        subjects.add(new OldTestamentFragment.Subject("45","David & Jonathan"));
        subjects.add(new OldTestamentFragment.Subject("46","David Crowned King"));
        subjects.add(new OldTestamentFragment.Subject("47","Solomon Crowned King"));
        subjects.add(new OldTestamentFragment.Subject("48","The Judgement of Solomon"));
        subjects.add(new OldTestamentFragment.Subject("49","The Queen of Sheba's visit to Solomon"));
        subjects.add(new OldTestamentFragment.Subject("50","Elijah Fed by Ravens"));
        subjects.add(new OldTestamentFragment.Subject("51","Elijah restores the widow's son"));
        subjects.add(new OldTestamentFragment.Subject("52","Elijah taken to Heaven"));
        subjects.add(new OldTestamentFragment.Subject("53","The item of Elisha"));
        subjects.add(new OldTestamentFragment.Subject("54","Johoash the boy king"));
        subjects.add(new OldTestamentFragment.Subject("55","The sad ending of the kingdom of Israel"));
        subjects.add(new OldTestamentFragment.Subject("56","The prophet who tried to run from God"));
        subjects.add(new OldTestamentFragment.Subject("57","The Good king Hezekiah"));
        subjects.add(new OldTestamentFragment.Subject("58","King Josiah and the item of a forgotten Book"));
        subjects.add(new OldTestamentFragment.Subject("59","Jeremiah, the weeping prophet"));
        subjects.add(new OldTestamentFragment.Subject("60","The People of Judah live in a Strange Land "));
        subjects.add(new OldTestamentFragment.Subject("61","Daniel and his friend stand before a King"));
        subjects.add(new OldTestamentFragment.Subject("62","Nebuchadnezzar's Dream"));
        subjects.add(new OldTestamentFragment.Subject("63","Shadrach, Meshach and Abednego"));
        subjects.add(new OldTestamentFragment.Subject("64","God Humbles Nebuchadnezzar's proud heart"));
        subjects.add(new OldTestamentFragment.Subject("65","The Strange handwriting on the wall.."));
        subjects.add(new OldTestamentFragment.Subject("66","Daniel in the lion's Den"));
        subjects.add(new OldTestamentFragment.Subject("67","The home-coming of the Jews"));
        subjects.add(new OldTestamentFragment.Subject("68","How the new temple was built in Jerusalem"));
        subjects.add(new OldTestamentFragment.Subject("69","Esther, the beautiful girl became a queen"));
        subjects.add(new OldTestamentFragment.Subject("70","Haman's Plants to Destroy all the Jews"));
        subjects.add(new OldTestamentFragment.Subject("71","How Esther save the lives of her people"));
        subjects.add(new OldTestamentFragment.Subject("72","Ezra, the good man who taught God's law"));
        subjects.add(new OldTestamentFragment.Subject("73","Nehemiah, the king's cupbearer"));
        subjects.add(new OldTestamentFragment.Subject("74","Nehemiah rebuilds the walls of Jerusalem"));

    }

    private void initializeAdapter(){
        OldTestamentRecyclerViewAdapter adapter = new OldTestamentRecyclerViewAdapter(subjects);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickedListener(new OldTestamentRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemCliked(int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(),Old1.class));
                        break;

                    case 1:
                        startActivity(new Intent(getActivity(),Old2.class));
                        break;

                    case 2:
                        startActivity(new Intent(getActivity(),Old3.class));
                        break;

                    case 3:
                        startActivity(new Intent(getActivity(),Old4.class));
                        break;

                    case 4:
                        startActivity(new Intent(getActivity(),Old5.class));
                        break;

                    case 5:
                        startActivity(new Intent(getActivity(),Old6.class));
                        break;

                    case 6:
                        startActivity(new Intent(getActivity(),Old7.class));
                        break;

                    case 7:
                        startActivity(new Intent(getActivity(),Old8.class));
                        break;

                    case 8:
                        startActivity(new Intent(getActivity(),Old9.class));
                        break;

                    case 9:
                        startActivity(new Intent(getActivity(),Old10.class));
                        break;

                    case 10:
                        startActivity(new Intent(getActivity(),Old11.class));
                        break;

                    case 11:
                        startActivity(new Intent(getActivity(),Old12.class));
                        break;

                    case 12:
                        startActivity(new Intent(getActivity(),Old13.class));
                        break;

                    case 13:
                        startActivity(new Intent(getActivity(),Old14.class));
                        break;

                    case 14:
                        startActivity(new Intent(getActivity(),Old15.class));
                        break;

                    case 15:
                        startActivity(new Intent(getActivity(),Old16.class));
                        break;

                    case 16:
                        startActivity(new Intent(getActivity(),Old17.class));
                        break;

                    case 17:
                        startActivity(new Intent(getActivity(),Old18.class));
                        break;

                    case 18:
                        startActivity(new Intent(getActivity(),Old19.class));
                        break;

                    case 19:
                        startActivity(new Intent(getActivity(),Old20.class));
                        break;

                    case 20:
                        startActivity(new Intent(getActivity(),Old21.class));
                        break;

                    case 21:
                        startActivity(new Intent(getActivity(),Old22.class));
                        break;

                    case 22:
                        startActivity(new Intent(getActivity(),Old23.class));
                        break;

                    case 23:
                        startActivity(new Intent(getActivity(),Old24.class));
                        break;

                    case 24:
                        startActivity(new Intent(getActivity(),Old25.class));
                        break;

                    case 25:
                        startActivity(new Intent(getActivity(),Old26.class));
                        break;

                    case 26:
                        startActivity(new Intent(getActivity(),Old27.class));
                        break;

                    case 27:
                        startActivity(new Intent(getActivity(),Old28.class));
                        break;

                    case 28:
                        startActivity(new Intent(getActivity(),Old29.class));
                        break;

                    case 29:
                        startActivity(new Intent(getActivity(),Old30.class));
                        break;

                    case 30:
                        startActivity(new Intent(getActivity(),Old31.class));
                        break;

                    case 31:
                        startActivity(new Intent(getActivity(),Old32.class));
                        break;

                    case 32:
                        startActivity(new Intent(getActivity(),Old33.class));
                        break;

                    case 33:
                        startActivity(new Intent(getActivity(),Old34.class));
                        break;

                    case 34:
                        startActivity(new Intent(getActivity(),Old35.class));
                        break;

                    case 35:
                        startActivity(new Intent(getActivity(),Old36.class));
                        break;

                    case 36:
                        startActivity(new Intent(getActivity(),Old37.class));
                        break;

                    case 37:
                        startActivity(new Intent(getActivity(),Old38.class));
                        break;

                    case 38:
                        startActivity(new Intent(getActivity(),Old39.class));
                        break;

                    case 39:
                        startActivity(new Intent(getActivity(),Old40.class));
                        break;

                    case 40:
                        startActivity(new Intent(getActivity(),Old41.class));
                        break;

                    case 41:
                        startActivity(new Intent(getActivity(),Old42.class));
                        break;

                    case 42:
                        startActivity(new Intent(getActivity(),Old43.class));
                        break;

                    case 43:
                        startActivity(new Intent(getActivity(),Old44.class));
                        break;

                    case 44:
                        startActivity(new Intent(getActivity(),Old45.class));
                        break;

                    case 45:
                        startActivity(new Intent(getActivity(),Old46.class));
                        break;

                    case 46:
                        startActivity(new Intent(getActivity(),Old47.class));
                        break;

                    case 47:
                        startActivity(new Intent(getActivity(),Old48.class));
                    break;

                    case 48:
                        startActivity(new Intent(getActivity(),Old49.class));
                        break;

                    case 49:
                        startActivity(new Intent(getActivity(),Old50.class));
                        break;

                    case 50:
                        startActivity(new Intent(getActivity(),Old51.class));
                        break;

                    case 51:
                        startActivity(new Intent(getActivity(),Old52.class));
                        break;

                    case 52:
                        startActivity(new Intent(getActivity(),Old53.class));
                        break;

                    case 53:
                        startActivity(new Intent(getActivity(),Old54.class));
                        break;

                    case 54:
                        startActivity(new Intent(getActivity(),Old55.class));
                        break;

                    case 55:
                        startActivity(new Intent(getActivity(),Old56.class));
                        break;

                    case 56:
                        startActivity(new Intent(getActivity(),Old57.class));
                        break;

                    case 57:
                        startActivity(new Intent(getActivity(),Old58.class));
                        break;


                    case 58:
                        startActivity(new Intent(getActivity(),Old59.class));
                        break;

                    case 59:
                        startActivity(new Intent(getActivity(),Old60.class));
                        break;

                    case 60:
                        startActivity(new Intent(getActivity(),Old61.class));
                        break;

                    case 61:
                        startActivity(new Intent(getActivity(),Old62.class));
                        break;

                    case 62:
                        startActivity(new Intent(getActivity(),Old63.class));
                        break;

                    case 63:
                        startActivity(new Intent(getActivity(),Old64.class));
                        break;

                    case 64:
                        startActivity(new Intent(getActivity(),Old65.class));
                        break;

                    case 65:
                        startActivity(new Intent(getActivity(),Old66.class));
                        break;

                    case 66:
                        startActivity(new Intent(getActivity(),Old67.class));
                        break;

                    case 67:
                        startActivity(new Intent(getActivity(),Old68.class));
                        break;

                    case 68:
                        startActivity(new Intent(getActivity(),Old69.class));
                        break;

                    case 69:
                        startActivity(new Intent(getActivity(),Old70.class));
                        break;

                    case 70:
                        startActivity(new Intent(getActivity(),Old71.class));
                        break;

                    case 71:
                        startActivity(new Intent(getActivity(),Old72.class));
                        break;

                    case 72:
                        startActivity(new Intent(getActivity(),Old73.class));
                        break;

                    case 73:
                        startActivity(new Intent(getActivity(),Old74.class));
                        break;

                }
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
