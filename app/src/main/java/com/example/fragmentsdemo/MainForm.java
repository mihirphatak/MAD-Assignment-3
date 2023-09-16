package com.example.fragmentsdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fragmentsdemo.databinding.FragmentMainFormBinding;

public class MainForm extends Fragment {

    int selectedMood = -1;

    public void setSelectedMood(int value) {
        this.selectedMood = value;
    }

    public MainForm() {
        // Required empty public constructor
    }

    FragmentMainFormBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainFormBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSelectMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelector.gotoMoodSelector();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formName = binding.editTextName.getText().toString();
                String formAge = binding.editTextAge.getText().toString();
                int mood = selectedMood;
                if (formName != null && formName.length() > 0 && formAge != null && formAge.length() > 0 && mood != -1) {
                    User user = new User(formName, formAge, mood);
                    mSelector.gotoProfileDisplay(user);

                } else {
                    Toast.makeText(getActivity(), "Please enter all input fields", Toast.LENGTH_SHORT).show();
                }


            }
        });

        if(selectedMood == -1) {
            binding.textViewMoodCaption.setText("");
            binding.imageViewMoodView.setImageResource(0);
        }
        else {
            binding.textViewMoodCaption.setText(String.valueOf(selectedMood));
            switch (selectedMood) {
                case 0:
                    binding.imageViewMoodView.setImageResource(R.drawable.not_well);
                    break;
                case 1:
                    binding.imageViewMoodView.setImageResource(R.drawable.sad);
                    break;
                case 2:
                    binding.imageViewMoodView.setImageResource(R.drawable.ok);
                    break;
                case 3:
                    binding.imageViewMoodView.setImageResource(R.drawable.good);
                    break;
                case 4:
                    binding.imageViewMoodView.setImageResource(R.drawable.very_good);
                    break;
                default:
                    binding.imageViewMoodView.setImageDrawable(null);
            }
        }
    }

    SelectMoodFragmentListener mSelector;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mSelector = (SelectMoodFragmentListener) context;
    }

    interface SelectMoodFragmentListener {
        void gotoMoodSelector();
        void gotoProfileDisplay(User user);
    }
}