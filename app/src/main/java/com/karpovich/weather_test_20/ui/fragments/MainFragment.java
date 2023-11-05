package com.karpovich.weather_test_20.ui.fragments;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.Manifest;
import com.karpovich.weather_test_20.R;
import com.karpovich.weather_test_20.databinding.FragmentMainBinding;
import com.karpovich.weather_test_20.ui.viewmodels.MainViewModel;


public class MainFragment extends Fragment {
    MainViewModel mainViewModel;
    private FragmentMainBinding binding;

    private static final int REQUEST_CODE = 0;


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewModel();
        checkInternetState();
        launchFavoritesFragment(view);
    }

    private void setupViewModel(){
        mainViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(
                        requireActivity().getApplication())).get(MainViewModel.class);
    }

    private void checkInternetState(){
        if (isNetworkAvailable()){
            Log.d("ТАГ", "checkInternetState: true ");
            binding.errorMessageTextView.setVisibility(View.GONE);
            checkPermissions();
        } else {
            Log.d("ТАГ", "checkInternetState: false ");
            binding.errorMessageTextView.setText(R.string.no_internet_error_msg);
            binding.errorMessageTextView.setVisibility(View.VISIBLE);
            binding.group.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.GONE);
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private void checkPermissions(){
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){

        }
        else if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {


        } else {
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_CODE);
        }
    }


    private void launchFavoritesFragment(View view){
        binding.favoritesImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_mainFragment_to_favoritesFragment);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}