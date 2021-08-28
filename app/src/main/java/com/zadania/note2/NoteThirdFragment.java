package com.zadania.note2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;


public class NoteThirdFragment extends Fragment {

    public static NoteThirdFragment newInstance() {
        return new NoteThirdFragment();
    }

    RadioButton radioButtonAdd;
    RadioButton radioButtonReplace;

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
        textView1.setText(noteName[2]);
        textView2.setText(noteDescription[2]);
        textView3.setText(noteData[2]);
        return view;
    }


    private void initView(View v) {
        radioButtonAdd = v.findViewById(R.id.radioButtonAdd);
        radioButtonReplace = v.findViewById(R.id.radioButtonReplace);
        SwitchCompat switchBackStack = v.findViewById(R.id.switchBackStack);
        SwitchCompat switchBackAsRemove = v.findViewById(R.id.switchBackAsRemove);
        SwitchCompat switchDeleteBeforeAdd = v.findViewById(R.id.switchDeleteBeforeAdd);

        switchDeleteBeforeAdd.setChecked(Settings.isDeleteFragment);
        switchBackAsRemove.setChecked(Settings.isBackIsRemove);
        switchBackStack.setChecked(Settings.isBackStack);
        radioButtonReplace.setChecked(Settings.isReplaceFragment);
        radioButtonAdd.setChecked(Settings.isAddFragment);
        radioButtonAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isAddFragment = isChecked;
                writeSettings();
            }
        });
        radioButtonReplace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isReplaceFragment = isChecked;
                writeSettings();
            }
        });
        switchBackStack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isBackStack = isChecked;
                writeSettings();
            }
        });
        switchBackAsRemove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isBackIsRemove = isChecked;
                writeSettings();
            }
        });

        switchDeleteBeforeAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isDeleteFragment = isChecked;
                writeSettings();
            }
        });
    }

    private void writeSettings() {
        SharedPreferences sharedPreferences = requireActivity()
                .getSharedPreferences(Settings.SHARED_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Settings.IS_ADD_FRAGMENT_USED, Settings.isAddFragment);
        editor.putBoolean(Settings.IS_REPLACE_FRAGMENT_USED, Settings.isReplaceFragment);
        editor.putBoolean(Settings.IS_BACK_STACK_USED, Settings.isBackStack);
        editor.putBoolean(Settings.IS_BACK_IS_REMOVE_FRAGMENT, Settings.isBackIsRemove);
        editor.putBoolean(Settings.IS_DELETE_FRAGMENT_BEFORE_ADD, Settings.isDeleteFragment);
        editor.apply();
    }
}