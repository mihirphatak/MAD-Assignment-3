package com.example.fragmentsdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentsdemo.databinding.FragmentProfileDisplayBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileDisplay#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileDisplay extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1_USER = "param1";

    // TODO: Rename and change types of parameters
    private User mUser;

    public ProfileDisplay() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProfileDisplay newInstance(User user) {
        ProfileDisplay fragment = new ProfileDisplay();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUser = (User) getArguments().getSerializable(ARG_PARAM1_USER);
        }
    }

    FragmentProfileDisplayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileDisplayBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.textViewNameValue.setText(mUser.getName());
        binding.textViewAgeValue.setText(mUser.getAge());
        switch (mUser.getMoodState()) {
            case 0:
                binding.imageViewDisplay.setImageResource(R.drawable.not_well);
                binding.textViewMoodTag.setText("not well");
                break;
            case 1:
                binding.imageViewDisplay.setImageResource(R.drawable.sad);
                binding.textViewMoodTag.setText("sad");
                break;
            case 2:
                binding.imageViewDisplay.setImageResource(R.drawable.ok);
                binding.textViewMoodTag.setText("ok");
                break;
            case 3:
                binding.imageViewDisplay.setImageResource(R.drawable.good);
                binding.textViewMoodTag.setText("good");
                break;
            case 4:
                binding.imageViewDisplay.setImageResource(R.drawable.very_good);
                binding.textViewMoodTag.setText("very good");
                break;
            default:
                binding.imageViewDisplay.setImageDrawable(null);
        }

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileDisplayListener.cancel();
            }
        });

    }



    ProfileDisplayListener profileDisplayListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        profileDisplayListener = (ProfileDisplayListener) context;
    }

    interface ProfileDisplayListener {
        void cancel();
    }


}