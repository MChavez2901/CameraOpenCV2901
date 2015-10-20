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
import java.util.HashMap;
import java.util.Map;

/**
 * ViewActivity uses EXTRA_FILE_PATH to open the Mat sotred at that location
 * inorder to allow the use to perform a variety of image processsing on it
 */
public class ViewActivity extends Activity implements OnItemSelectedListener {
    private static final String TAG = "ViewActivity";

    // extra passed with intent so we know which file to open
    public static final String EXTRA_FILE_PATH = "extraFilePath";

    // List of tags we are expected to handle (should include all from @array/transforms)
    private static final String tag_red = "red";
    private static final String tag_green = "green";
    private static final String tag_blue = "blue";
    private static final String tag_gray = "gray";
    private static final String tag_sobel = "sobel";
    private static final String tag_sobel_x = "sobel_x";
    private static final String tag_sobel_y = "sobel_y";
    private static final String tag_laplacian = "laplacian";
    private static final String tag_gaussian = "gaussian";
    private static final String tag_canny = "canny";
    private static final String tag_hough = "hough";

    private Mat mSrcMat; // Unaltered Mat to use as base
    private File mFile; // File to get mSrcMat from
    private Bitmap mBitmap; // Bitmap use hold Mat's in View friendly form
    private ImageView mImage; // View to display mBitmap
    private Spinner mSpinner; // View to house menu options
    private Map<String,Mat> mMats = new HashMap<>(); // mapping of tags to Mats

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        // grab the extra denoting the filepath and use it to create a File
        //TODO grab filePath from inent Extra, create mFile with it

        //TODO set mImage to the ImageView in the layout

        // set up the spinner to listen for when an item is selected
        // spinner's items are set from @array/transforms
        //TODO set mSpinner to the Spinner in the layout
        //TODO set mSpinner's setOnItemSelectedListener to this class

        // get the Mat at mFile, create a bitmap from it, and set it as the display image
        //TODO open mFile and set mSrcMat to the Mat stored there
        //TODO create mBitmap as a Bitmap large enough to hold mSrcMat (use Bitmap.Config.ARGB_8888)
        setImage(mSrcMat);
    }

    /**
     * Sets mImage to display the given mat (by converting it to a bitmap first)
     * @param mat mat to display
     */
    protected void setImage(Mat mat) {
        //TODO convert mat into a bitmap (see Utils.matToBitmap)
        //TODO set mImage to show the bitmap
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
        // get the text of the view
        String tag = (String) ((TextView) view).getText();

        // get the corresponding mat
        Mat mat = getMat(tag);

        // set the image to show mat
        setImage(mat);
    }

    /**
     * Invoked when the selection disappears from the spinner (will not happen)
     * @param parent the spinner view
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) { /* do nothing */ }

    /**
     * returns the Mat corresponding to the given tag
     * @param tag tag to use to find desired mat
     * @return mat corresponding to the tag
     */
    public Mat getMat(String tag) {
        // If we already created the mat, return it
        //TODO check to see if mMat's contains tag as a key, if so, return the value for that key

        // Else create it
        Mat resMat;
        switch(tag) {
            case tag_hough:
                resMat = MatFilter.getHoughMat(getMat(tag_canny)); break;
            case tag_canny:
                resMat = MatFilter.getCanny(getMat(tag_gaussian)); break;
            case tag_gaussian:
                resMat = MatFilter.getGaussianBlur(getMat(tag_gray)); break;
            case tag_laplacian:
                resMat = MatFilter.getLaplacian(getMat(tag_gaussian)); break;
            case tag_sobel:
                resMat = MatFilter.getSobel(getMat(tag_gaussian),1,1); break;
            case tag_sobel_x:
                resMat = MatFilter.getSobel(getMat(tag_gaussian),1,0); break;
            case tag_sobel_y:
                resMat = MatFilter.getSobel(getMat(tag_gaussian),0,1); break;
            case tag_red:
                resMat = MatFilter.getChannel(mSrcMat, 0); break;
            case tag_green:
                resMat = MatFilter.getChannel(mSrcMat, 1); break;
            case tag_blue:
                resMat = MatFilter.getChannel(mSrcMat, 2); break;
            case tag_gray:
                resMat = MatFilter.getGrayScale(mSrcMat); break;
            default:
                resMat = mSrcMat; break;
        }

        // add the mat to the map so we remember it next time
        //TODO add key/value pair tag/resMat to mMats
        return resMat;
    }
}
