package com.example.mtoebes.cameraopencv;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * FileHelper assists in saving and reading bitmaps from file.
 * Files are saved under android's public storage directory in a subdirectory called CameraOpenCV
 * Filenames are of the format IMG_img.jpg,
 * IMG: the img value is set to the timestamp the original image was taken
 * see http://docs.opencv.org/java/org/opencv/highgui/Highgui.html for writing/reading files
 */

/* TODO this class is split into sections: SAVING FILES, READING FILES, REMOVING FILES, CREATING FILES, and SEARCHING FILES
 * TODO you should implement the methods in CREATING FILES prior to working on the other sections
 */

public class FileHelper {
    private static final String LOG_TAG = "FileHelper";

    // Identifiers that make up a filename
    private static final String IMG = "IMG_";
    private static final String EXT = ".jpg";

    // Name of the directory to store the images in
    private static final String IMAGE_DIRECTORY_NAME = "CameraOpenCV";

    // Directory of public storage for images
    private static final File PUBLIC_STORAGE =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

    // Directory of storage for our images
    private static final File IMAGE_DIRECTORY = createDirectory(PUBLIC_STORAGE, IMAGE_DIRECTORY_NAME);

    // Format for reading timestamp
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd_HHmmss");

    // **** SAVING FILES **** //

    /**
     * Saves a mat to a file
     * @param mat mat to save
     * @param file location to save to
     */
    public static void saveMat(Mat mat, File file) {
        //TODO write mat to file (see Imgcodecs.imwrite)
    }

    /**
     * Saves a mat to file under IMAGE_DIRECTORY
     * filename will be based on current time
     * @param mat mat to save
     * @return location mat was saved to
     */
    public static File saveMat(Mat mat) {
        File newFile = null; // TODO create new File with parent directory IMAGE_DIRECTORY
        // TODO write mat to newFile
        return newFile;
    }

    // **** READING FILES **** //

    /**
     * Reads mat from a file
     * @param file file to read from
     * @return mat saved in file
     */
    public static Mat getMat(File file) {
        //TODO read mat from file (see Imgcodecs.imread)
        return null;
    }

    /**
     * Reads mat from a file and returns it as a Bitmap (use Bitmap.Config.ARGB_8888)
     * @param file file to read from
     * @return Bitmap of mat saved in file
     */
    public static Bitmap getBitmap(File file) {
        //TODO open mat from file
        //TODO create a bitmap and convert mat to it (see Utils.matToBitmap)
        return null;
    }

    // **** REMOVING FILES **** //

    /**
     * Remove the given File
     * @param file File to remove
     */
    public static void removeFile(File file) {
        //TODO delete file (see File.delete())
    }

    // **** CREATING FILES **** //

    /**
     * Returns a unique filename based on the timestamp
     * @return filename of the format IMG_*timestamp*.jpg
     */
    private static String createFilename() {
        String img = null; // TODO set img to the current time using DATE_FORMAT (see SimpleDateFormat.format(new Date()))
        String filename = null; //TODO create filename usig img value
        return filename;
    }

    /**
     * Creates a new File under IMAGE_DIRECTORY based on the current time stamp
     * @return File with path directory/newFilename
     */
    private static File createFile() {
        String newFilename = createFilename();
        File newFile = null; // TODO create a new file with path IMAGE_DIRECTORY/newFilename;
        return newFile;
    }

    /**
     * Create a new directory at parent/directoryName, does nothing if it alreasy exists
     * @param parent parent to create this directory under
     * @param directoryName name of new directory
     * @return path to created directory
     */
    private static File createDirectory(File parent, String directoryName) {
        // TODO make a file with path parent/directoryName
        // TODO if file does not exist, make it (see File.exists() and File.mkdirs())
        return null;
    }

    // **** SEARCHING FILES  **** //

    /**
     * Retrieves a List of all the bitmap Files saved
     */
    public static List<File> getBitmapFiles() {
        return new ArrayList<>(Arrays.asList(IMAGE_DIRECTORY.listFiles()));
    }

}
