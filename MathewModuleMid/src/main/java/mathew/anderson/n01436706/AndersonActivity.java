//Mathew Anderson, n01436706
package mathew.anderson.n01436706;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class AndersonActivity extends AppCompatActivity {

    private Fragment pendingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(new MathewFragment());
        fragmentList.add(new AndersonFragment());
        fragmentList.add(new N01436706Fragment());

        // ViewPager2 setup
        ViewPager2 viewPager = findViewById(R.id.mathewViewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this, fragmentList));

        TabLayout tabLayout = findViewById(R.id.mathewTabLayout);

        // Set tab names based on position/index
        String[] tabNames = getResources().getStringArray(R.array.tab_names);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    // Customize the tab name based on position/index
                    tab.setText(tabNames[position]);
                }
        ).attach();



    }
}