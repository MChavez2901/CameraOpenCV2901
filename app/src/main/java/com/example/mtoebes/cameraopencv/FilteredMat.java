package com.example.mtoebes.cameraopencv;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

/**
 * FilterMat is a object that performs different filters on an mat depending on the provided tag
 * the majority of the work will be done using functions within http://docs.opencv.org/java/3.0-rc1/org/opencv/imgproc/Imgproc.html
 * You should research the filter before you implement them so that you understand the paramteres they require and the logic they perform
 */
public class FilteredMat {
    private static final String TAG = "FilterMat";
    private static final int DEPTH = CvType.CV_8U;
    private static final double D_RHO = 1;
    private static final double D_THETA = Math.PI/90;

    private static final String
            orignal_tag = "Original", gray_tag = "Gray Mask", color_tag = "Color Mask", blur_tag = "Gaussian",
            sobel_tag = "Sobel", laplacian_tag = "Laplacian", canny_tag = "Canny", hough_tag = "Hough";

    private static int channel_num;
    private static int gaussian_ksize;
    private static int sobel_ksize, sobel_dir, sobel_dx, sobel_dy;
    private static int laplacian_ksize;
    private static int canny_lowerThreshold, canny_upperThreshold;
    private static int hough_threshold, hough_minLinLength, hough_maxLineGap;
    private static String hough_mode;

    Mat mSrcMat;
    String mTag = orignal_tag;
    public FilteredMat(Context context) {
        loadPreferences(context);
        mSrcMat = new Mat();
    }

    public Mat update(Mat srcMat) {
        mSrcMat = srcMat;
        return get();
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public Mat get() {
        return get(mTag);
    }

    public Mat get(String tag) {
        Mat resMat = new Mat();
        switch (tag) {
            case orignal_tag:
                return mSrcMat;
            case blur_tag:
                return getGaussianBlur(get(gray_tag), resMat);
            case gray_tag:
                return getGrayScale(mSrcMat, resMat);
            case color_tag:
                return getChannel(mSrcMat, resMat);
            case sobel_tag:
                return getSobel(get(blur_tag), resMat);
            case laplacian_tag:
                return getLaplacian(get(blur_tag), resMat);
            case canny_tag:
                return getCanny(get(blur_tag), resMat);
            case hough_tag:
                Mat houghSrcMat = get(hough_mode);
                return getHoughMat(houghSrcMat, resMat);
            default:
                return mSrcMat;
        }
    }

    /**
     * gets the grayscale mat resulting from the given mat
     */
    public Mat getGrayScale(Mat srcMat, Mat resMat) {
        Log.v(TAG, "getGrayScale");
        //TODO convert SrcMat to be grayscale (see Imgproc.cvtColor and Imgproc.COLOR_BGRA2GRAY)
        return resMat;
    }

    /**
     * get the rbg mat result from the given mat
     */
    public static Mat getRBG(Mat srcMat, Mat resMat) {
        //TODO convert SrcMat to be rbg (see Imgproc.cvtColor and Imgproc.COLOR_GRAY2BGRA)
        return resMat;
    }

    public Mat getGaussianBlur(Mat srcMat, Mat resMat) {
        Log.v(TAG, "getGaussianBlur gaussian_ksize " + gaussian_ksize);
        //TODO perform gaussian blur
        return resMat;
    }

    public Mat getCanny(Mat srcMat, Mat resMat) {
        Log.v(TAG, "getCanny  canny_lowerThreshold " + canny_lowerThreshold + " canny_upperThreshold " + canny_upperThreshold);
        //TODO perform canny
        return resMat;
    }

    public Mat getSobel(Mat srcMat, Mat resMat) {
        Log.v(TAG, "getSobel sobel_dx " + sobel_dx + " sobel_dy " + sobel_dy + " sobel_ksize " + sobel_ksize);
        //TODO perform sobel
        return resMat;
    }

    public Mat getLaplacian(Mat srcMat, Mat resMat) {
        Log.v(TAG, "getLaplacian laplacian_ksize " + laplacian_ksize);
        //TODO perfrom lapliacian
        return resMat;
    }

    public Mat getChannel(Mat srcMat, Mat resMat) {
        Log.v(TAG, "getChannel channel_num " + channel_num);
        if(channel_num < 3) {
            List<Mat> channels = new ArrayList<>(3);
            Core.split(srcMat, channels);
            resMat = channels.get(channel_num);
        } else {
            getGrayScale(srcMat, resMat);
        }
        return resMat;
    }

    /**
     * Performs HoughLinesP to find all lines in srcMat
     * @return Mat of lines of form [x1,y1,x2,y2]
     */
    private static Mat getHoughLines(Mat srcMat) {
        Mat lines = new Mat();
        // TODO perform HoughLinesP
        return lines;
    }

    /**
     * Draws lines on srcMat see
     * @param lines a Mat of lines of the form [x1,y1,x2,y2]
     * @return Mat that is srcMat with the given lines drawn on
     */
    private static Mat drawHoughLines(Mat srcMat, Mat lines) {
        Mat resMat = null; // TODO set resMAt to be rbg of srcMat
        for(int index = 0; index < lines.rows(); index++) {
            double[] line = lines.get(index, 0);
            // TODO draw line on resMat (see Imgproc.line)
        }
        return resMat;
    }

    public Mat getHoughMat(Mat srcMat, Mat resMat) {
        Log.v(TAG, "getHoughMat hough_threshold " + hough_threshold + " hough_minLinLength " + hough_minLinLength + " hough_maxLineGap " + hough_maxLineGap);
        getRBG(srcMat, resMat);
        Mat lines = getHoughLines(srcMat);
        drawHoughLines(resMat, lines);
        return resMat;
    }

    // Loads all the preferences for the filter options, should be called everytime a preference changes
    public static void loadPreferences(Context context) {
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(context);
        channel_num = Integer.parseInt(SP.getString("color_channel_pref", "0"));
        gaussian_ksize = Integer.parseInt(SP.getString("gaussian_ksize_pref", "5"));
        sobel_ksize = Integer.parseInt(SP.getString("sobel_ksize_pref", "5"));
        sobel_dir = Integer.parseInt(SP.getString("sobel_dir_pref", "3"));
        sobel_dx = sobel_dir%2;
        sobel_dy = sobel_dir/2;
        laplacian_ksize = Integer.parseInt(SP.getString("laplacian_ksize_pref", "5"));
        canny_lowerThreshold = Integer.parseInt(SP.getString("canny_lower_thresh_pref", "100"));
        canny_upperThreshold = Integer.parseInt(SP.getString("canny_upper_thresh_pref", "200"));
        hough_threshold = Integer.parseInt(SP.getString("hough_threshold_pref", "80"));
        hough_minLinLength = Integer.parseInt(SP.getString("hough_min_len_pref", "10"));
        hough_maxLineGap = Integer.parseInt(SP.getString("hough_max_gap_pref", "30"));
        hough_mode = SP.getString("hough_detection_mode_pref", canny_tag);
    }
}
