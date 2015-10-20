package com.example.mtoebes.cameraopencv;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.core.Mat;

/*
 * CameraActivity opens the back camera and displays the view to the screen.
 * By calling takePhoto(), the current view is saved to a jpg file in mat format.
 * see http://www.jayrambhia.com/blog/beginning-android-opencv/ for help
 */
public class CameraActivity extends Activity implements CvCameraViewListener2 {
    private static final String TAG = "CameraActivity";

    private CameraBridgeViewBase mOpenCvCameraView;
    private Mat mRgba; // Mat to hold current camera frame in

    // Called as part of the activity lifecycle when this activity is starting.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        // TODO set mOpenCvCameraView to the JavaCameraView in the layout
        // TODO set mOpenCvCameraView's listener to this class
    }

    // Called as part of the activity lifecycle when this activity is no longer visible. close the camera
    @Override
    public void onPause() {
        super.onPause();
        //TODO disable the camera view
    }

    // Called as part of the activity lifecycle when this activity becomes visible. open the camera
    @Override
    public void onResume() {
        super.onResume();
        //TODO enable the camera view
    }

    // onClick event that is called when the button with id "take_photo_button" is pressed
    public void takePhoto(View view) {
        //TODO use PhotoHelper to save the mat to a file
    }

    // This method is invoked when camera preview has started.
    @Override
    public void onCameraViewStarted(int width, int height) {
        //TODO initialize mRgba to a new Mat
    }

    // This method is invoked when camera preview has been stopped for some reason.
    @Override
    public void onCameraViewStopped() { /* do nothing */}

    // This method is invoked when delivery of the frame needs to be done.
    @Override
    public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
        //TODO set mRgba to the current frame's rgba Mat
        //TODO return the frame's rgba Mat
        return null;
    }
}
