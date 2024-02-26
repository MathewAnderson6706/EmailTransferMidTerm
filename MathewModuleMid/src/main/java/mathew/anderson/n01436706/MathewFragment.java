//Mathew Anderson, n01436706
package mathew.anderson.n01436706;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MathewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MathewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MathewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MathewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MathewFragment newInstance(String param1, String param2) {
        MathewFragment fragment = new MathewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mathew, container, false);

        TextView mathewTextView = rootView.findViewById(R.id.matTextView);
        AutoCompleteTextView emailAutoCompleteTextView = rootView.findViewById(R.id.matAutoCompleteTextView);
        Button submitButton = rootView.findViewById(R.id.matButton);

        ArrayAdapter<String> emailAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.mathew));
        emailAutoCompleteTextView.setAdapter(emailAdapter);

        submitButton.setOnClickListener(view -> {
            // Validate user input
            String email = emailAutoCompleteTextView.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                emailAutoCompleteTextView.setError(getString(R.string.error_empty_email));
            } else if (!isValidEmail(email)) {
                emailAutoCompleteTextView.setError(getString(R.string.error_invalid_email));
            } else {
                // Pass the email as an argument to AndersonFragment
                Bundle bundle = new Bundle();
                bundle.putString("data", email);
                getParentFragmentManager().setFragmentResult("dataFrom1", bundle);
                // Clear user input
                emailAutoCompleteTextView.setText("");
            }
        });

        return rootView;
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
