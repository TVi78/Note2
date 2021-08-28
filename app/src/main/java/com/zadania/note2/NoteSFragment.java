package com.zadania.note2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NoteSFragment extends Fragment {

    public static NoteSFragment newInstance() {
        return new NoteSFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_open, container, false);
        String[] noteName = getResources().getStringArray(R.array.note_name);
        String[] noteDescription = getResources().getStringArray(R.array.note_description);
        String[] noteData = getResources().getStringArray(R.array.note_data);
        TextView textView = view.findViewById(R.id.textView);
        TextView textView1 = view.findViewById(R.id.textView1);
        TextView textView2 = view.findViewById(R.id.textView2);
        TextView textView3 = view.findViewById(R.id.textView3);
        textView1.setText(noteName[1]);
        textView2.setText(noteDescription[1]);
        textView3.setText(noteData[1]);
        return view;
    }
}
