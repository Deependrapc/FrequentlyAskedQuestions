package com.example.faqs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private ExpandableListView expandableListView;
    private ExpandableListViewAdapter expandableListViewAdapter;
    private List<String> listDataGroup;
    private HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();     //initializing the views
        initListeners(); //initializing the listeners
        initObjects();   //initializing the objects
        initListData();  // preparing list data
    }

    //method to initialize the views
    private void initViews()
    {
        expandableListView = findViewById(R.id.expandableListView);
    }

    //method to initialize the listeners
    private void initListeners()
    {
        // ExpandableListView on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
        {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
            {
                return false;
            }
        });
    }

    //method to initialize the objects
    private void initObjects()
    {
        listDataGroup = new ArrayList<>(); // initializing the list of groups
        listDataChild = new HashMap<>();   // initializing the list of child
        expandableListViewAdapter = new ExpandableListViewAdapter(this, listDataGroup, listDataChild); // initializing the adapter object
        expandableListView.setAdapter(expandableListViewAdapter); // setting list adapter
    }

     public String questions[] = {"Can I attend some or all of the event if I’m not registered?",
             "How do I form a team, and how big should it be?",
             "How will I know what someone else’s specialty is?",
             "Can my team and I work offsite?",
             "What if we need help solving a challenge?"};
     public String answers[] = {"While we would love to open up the event and presentations to more than just the participants, we have a limited capacity in the room due to fire safety regulations. Unfortunately you will only be able to attend if you’ve registered already.",
             "Start by taking a good look through the challenges and select a few that interest you. At the start of the event, all registrants will receive login information to an online collaboration place, where prospective team members can share information together. We recommend a team is at least 3 people, ideally 4-6. If there is a lot of demand for a particular challenge you can all work together but form sub-teams.",
             "Networking is important here. To put a great team together, you’ll have to walk around and talk to people. Everybody has something they can offer.",
             "We encourage everyone to be onsite for most if not all of the weekend, because part of the fun is working alongside, and being inspired by, your fellow participants. But, we do have teams and individuals who work offsite. And there’s no problem at all if you have to step in and out over the weekend – just be courteous and let your teammates know.",
             "We have mentors and volunteers onsite all weekend – they can provide as much or as little help as you need. We have additional assistance from the Canadian Space Agency who can provide expert help on their challenges and data. We also have a Slack network that allows us to communicate with our fellow Canadian cities. And last but definitely not least – we encourage teams to help each other out over the weekend – so if you get stuck there is somebody to help you get “unstuck”!"};

     private void initListData()
     {
         // Loop to insert all questions in the expandable list
        for (int i = 0; i <= (questions.length -1); i++)
        {
            listDataGroup.add(questions[i]);
        }

        // Loop to insert all answers
        List<String> ans_zero = new ArrayList<>();
        ans_zero.add(answers[0]);

        List<String> ans_one = new ArrayList<>();
        ans_one.add(answers[1]);

        List<String> ans_two = new ArrayList<>();
        ans_two.add(answers[2]);

        List<String> ans_three = new ArrayList<>();
        ans_three.add(answers[3]);

        List<String> ans_four = new ArrayList<>();
        ans_four.add(answers[4]);

        // Adding child data
        listDataChild.put(listDataGroup.get(0), ans_zero);
        listDataChild.put(listDataGroup.get(1), ans_one);
        listDataChild.put(listDataGroup.get(2), ans_two);
        listDataChild.put(listDataGroup.get(3), ans_three);
        listDataChild.put(listDataGroup.get(4), ans_four);
        expandableListViewAdapter.notifyDataSetChanged(); // notify the adapter
     }
}