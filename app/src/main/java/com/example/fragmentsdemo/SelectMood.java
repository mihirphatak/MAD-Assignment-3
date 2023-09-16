package com.example.fragmentsdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.fragmentsdemo.databinding.FragmentSelectMoodBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectMood#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectMood extends Fragment {

    public SelectMood() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentSelectMoodBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelectMoodBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.seekBarMood.setProgress(2);
        binding.imageViewMood.setImageResource(R.drawable.ok);
        binding.textViewMoodValue.setText(String.valueOf(2));

        binding.seekBarMood.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textViewMoodValue.setText(String.valueOf(i));
                switch (i) {
                    case 0:
                        binding.imageViewMood.setImageResource(R.drawable.not_well);
                        break;
                    case 1:
                        binding.imageViewMood.setImageResource(R.drawable.sad);
                        break;
                    case 2:
                        binding.imageViewMood.setImageResource(R.drawable.ok);
                        break;
                    case 3:
                        binding.imageViewMood.setImageResource(R.drawable.good);
                        break;
                    case 4:
                        binding.imageViewMood.setImageResource(R.drawable.very_good);
                        break;
                    default:
                        binding.imageViewMood.setImageDrawable(null);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.buttonMoodSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.selectMood(binding.seekBarMood.getProgress());
            }
        });

        binding.buttonMoodCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.cancel(-1);
            }
        });
    }

    SelectMoodFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectMoodFragmentListener) context;
    }

    interface SelectMoodFragmentListener {
        void selectMood(int value);
        void cancel(int value);
    }
}