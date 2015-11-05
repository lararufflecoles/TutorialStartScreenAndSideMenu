package es.rufflecol.lara.tutorialstartscreenandsidemenu;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

class CustomPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    // The resources are in an array of ints because they are actually resource IDs.
    // If you find R.java you can see how the drawables are referenced as ints.
    private int[] resources = {
            R.drawable.first1, R.drawable.second2, R.drawable.third3,
    };

    private String[] text = {
            "I like cats, miaow!", "I like kittens, meow!", "I like pussies, mew!",
    };

    public CustomPagerAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item_tutorial, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(resources[position]);

        TextView textView = (TextView) itemView.findViewById(R.id.tutorial_screen_text);
        textView.setText(text[position]);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public int getCount() {
        return resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}