package comp208.dobra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // store last image flipped details
    int lastImgFlipped;
    ImageView lastImgView;

    // get table data
    int col = 3;
    int row = 4;
    TableLayout board;

    // Initialize classes used
    Game game = new Game();
    Card[] cards = {
            new Card(), new Card(), new Card(), new Card(), new Card(), new Card(),
            new Card(), new Card(), new Card(), new Card(), new Card(), new Card()
    };

    // set our 12 image resources that will be used for the game
    int[] resources = new int[]{
            R.drawable.blue, R.drawable.cyan, R.drawable.green,
            R.drawable.orange, R.drawable.pink, R.drawable.red,
            R.drawable.blue, R.drawable.cyan, R.drawable.green,
            R.drawable.orange, R.drawable.pink, R.drawable.red
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = (TableLayout) findViewById(R.id.matchBoard);
        shuffleResources();
        loadImages();
    }


    // loads cards with default images
    public void loadImages() {
        int cardIdx = 0;
        for(int x = 0; x < row; x++) {
            TableRow tr = (TableRow) board.getChildAt(x);
            for (int y = 0; y < col; y++) {
                // Get image
                ImageView iv = (ImageView) tr.getChildAt(y);
                // Change image to default
                iv.setImageResource(R.drawable.interrogation);

                // Set the card's resource id
                cards[cardIdx].setActualImgId(resources[cardIdx]);
                // Set the card's default look
                cards[cardIdx].setResourceId(R.drawable.interrogation);
                iv.setTag(cards[cardIdx]);
                cardIdx++;
            }
        }
    }

    // flips the card for the user to see
    public void flipCard(View view) {
        ImageView img = (ImageView) view;
        Card current = (Card)img.getTag();

        // make sure user can't click on discovered cards
        if(current.resourceId == R.drawable.interrogation) {
            // check if user is flipping the 2nd img of the pair
            if (game.score % 2 == 0) {
                lastImgView = img;
                lastImgFlipped = current.actualImgId;
                img.setImageResource(current.actualImgId);
            } else {
                // if so, check if images match
                img.setImageResource(current.actualImgId);
                if (lastImgFlipped == current.actualImgId) {
                    // add to score?
                } else {
                    // flip back images after 0.5 seconds
                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            lastImgView.setImageResource(R.drawable.interrogation);
                            img.setImageResource(R.drawable.interrogation);
                        }
                    }, 500);
                }
            }
            game.increaseScore();
        }
    }

    // shuffles our 12 img resources
    public void shuffleResources() {
        int index, temp;
        Random random = new Random();
        for (int i = resources.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = resources[index];
            resources[index] = resources[i];
            resources[i] = temp;
        }
    }
}