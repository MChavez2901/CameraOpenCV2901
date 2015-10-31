package com.example.mtoebes.cameraopencv;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.opencv.android.Utils;
import org.opencv.core.Mat;

import java.io.File;

/**
 * ImageDisplayActivity uses EXTRA_FILE_PATH to open the Mat stored at that location
 * In order to allow the use to perform a variety of image processsing on it
 * info on spinners: http://developer.android.com/guide/topics/ui/controls/spinner.html
 * info on hashmaps: http://beginnersbook.com/2013/12/hashmap-in-java-with-example/
 */
public class ImageDisplayActivity extends Activity implements OnItemSelectedListener {
    private static final String TAG = "ViewActivity";

    // extra passed with intent so we know which file to open
    public static final String EXTRA_FILE_PATH = "extraFilePath";

    private Mat mSrcMat; // Unaltered Mat to use as base
    private File mFile; // File to get mSrcMat from
    private Bitmap mBitmap; // Bitmap use hold Mat's in View friendly form
    private ImageView mImage; // View to display mBitmap
    private Spinner mSpinner; // drop-down of filter options
    private FilteredMat mFilteredMat; // Helper object to perfrom filters on Mats

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        // grab the extra denoting the filepath and use it to create a File
        //TODO grab filePath from intent Extra, create mFile with it (see https://androidcookbook.com/Recipe.seam?recipeId=809)

        //TODO set mImage to the ImageView in the layout

        // set up the spinner to listen for when an item is selected
        //TODO set mSpinner to the Spinner in the layout
        //TODO set mSpinner's setOnItemSelectedListener to this class

        // get the Mat at mFile, create a bitmap from it, and set it as the display image
        //TODO open mFile and set mSrcMat to the Mat stored there
        //TODO create mBitmap as a Bitmap large enough to hold mSrcMat (use Bitmap.Config.ARGB_8888)

        //TODO create mFilteredMat as a new FilteredMat
        //TODO update mFilteredMat with Mat mSrcMat
    }

    @Override
    protected void onResume() {
        super.onResume();

        // grabs the name (tag) of the currently selected option, else uses ""
        View view = mSpinner.getSelectedView();
        String tag = "";
        if(view != null) {
            tag = (String) ((TextView) view).getText();
        }

        Mat mat = null; //TODO use mFilteredMat to get a result Mat based on tag
        setImage(mat);  // set the image to show mat
    }

    /**
     * Sets mImage to display the given mat (by converting it to a bitmap first)
     * @param mat mat to display
     */
    protected void setImage(Mat mat) {
        //TODO convert mat into a bitmap (see Utils.matToBitmap)
        //TODO set mImage to show the bitmap (see ImageView.setImageBitmap())
    }

    /**
     * Invoked when an item in the spinner has been selected, set the image to the corresponding mat
     * @param parent the spinner view
     * @param view the view that was selected
     * @param position the position of the view in the spinner
     * @param id the id of the view
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String tag = (String) ((TextView) view).getText(); // get the text of the view
        Mat mat = null; //TODO use mFilteredMat to get a result Mat based on tag
        setImage(mat);  // set the image to show mat
    }

    /**
     * Invoked when the selection disappears from the spinner (will not happen)
     * @param parent the spinner view
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) { /* do nothing */ }

    public void openPrefs(View view) {
        // TODO start the FilterPreferenceActivity
    }
}
