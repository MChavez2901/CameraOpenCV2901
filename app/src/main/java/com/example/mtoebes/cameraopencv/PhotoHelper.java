package com.example.mtoebes.cameraopencv;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * PhotoHelper assists in saving and reading bitmaps from file
 */
public class PhotoHelper {
    private static final String LOG_TAG = "PhotoHelper";

    public static final String DEFAULT_TAG = "default";

    // Identifiers that make up a filename
    private static final String IMG = "IMG_";
    private static final String TAG = "_TAG_";
    private static final String EXT = ".jpg";

    // Name of the directory to store the images in
    private static final String IMAGE_DIRECTORY_NAME = "CameraOpenCV";

    // Directory of public storage for images
    private static final File PUBLIC_STORAGE =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

    // Directory of storage for our images
    private static final File IMAGE_DIRECTORY = createDirectory(PUBLIC_STORAGE, IMAGE_DIRECTORY_NAME);

    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd_HHmmss");

    /**
     * Saves a mat to a file
     * @param mat mat to save
     * @param file location to save to
     */
    public static void saveMatToFile(Mat mat, File file) {
        //TODO write mat to file (see Imgcodecs.imwrite)
    }

    /**
     * Saves a mat to file under IMAGE_DIRECTORY
     * filename will be based on current time and have the default tag
     * @param mat mat to save
     * @return location mat was saved to
     */
    public static File saveMat(Mat mat) {
        File newFile = null; // TODO generate new File with parent directory IMAGE_DIRECTORY
        // TODO save mat to newFile
        return newFile;
    }

    /**
     * Saves a mat to a file who's name has been updated with newTag
     * @param mat mat to save
     * @param file location to save at
     * @param newTag tag to update the filename with
     * @return location mat was saved to
     */
    public static File saveMat(Mat mat, File file, String newTag) {
         /* TODO generate new File
          * parent directory should be same as file's
          * filename should be same as file's with the tag replaced
          */
        File newFile = null;
        // TODO save mat to newFile
        return newFile;
    }

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
     * Reads mat from a file and returns it as a Bitmap
     * @param file file to read from
     * @return Bitmap of mat saved in file
     */
    public static Bitmap getBitmap(File file) {
        //TODO open mat from file
        //TODO create a bitmap and convert mat to it (see Utils.matToBitmap)
        return null;
    }

    /**
     * Remove the given File
     * @param file File to remove
     */
    public static void removeFile(File file) {
        //TODO delete file (see File.remove())
    }

    /**
     * Retrieves a List of all the bitmap Files that have the given tag
     * @param tag desired tag to filter by
     * @return List of Files with given tag
     */
    public static List<File> getBitmapFiles(String tag) {
        BitmapTagFilter filter = new BitmapTagFilter(tag);
        return new ArrayList<>(Arrays.asList(IMAGE_DIRECTORY.listFiles(filter)));
    }

    /**
     * Returns a File who's parent is directory and name is filename with TAG value newTag
     * if filename is null, a new filename is created
     * @param directory parent to create the file under
     * @param filename filename to use the IMG value from
     * @param newTag TAG value to use, if null, uses DEFAULT_TAG
     * @return File with save path as directory/filename but with the TAG newTag
     */
    private static File generateFile(File directory, String filename, String newTag) {
        String newFilename;

        if(filename == null) {
            // TODO if filename is null, call generateFilename() to create newFilename
        } else {
            // TODO if filename is not null, replace its tag to create newFilename
        }

        // TODO return a new file with path directory/newFilename;
        return null;
    }

    /**
     * Returns a filename based on the given img and tag values
     * @param img IMG value
     * @param tag TAG value
     * @return filename of the formate IMG_img_TAG_tag.jpg
     */
    private static String generateFilename(String img, String tag) {
        //TODO returns a string representing the filename with IMG value img and TAG value tag
        return null;
    }
    /**
     * Returns a unique filename based on the timestamp and with the default tag (DEFAULT_TAG)
     * @return unique filename with the given tag
     */
    private static String generateFilename() {
        String img = null; // TODO set img to the current time (see SimpleDateFormat.format(new Date()))
        String tag = null; // TODO set tag to DEFAULT_TAG
        return generateFilename(img,tag);
    }

    /**
     * Returns a new filename with the same IMG values as orgFilename but with TAg value newTag
     * @param orgFilename name of file to grab IMG value from
     * @param newTag TAG value to use in the new filename
     * @return new filename with the IMG value of orgFilename and the TAG value of newTag
     */
    private static String replaceTag(String orgFilename, String newTag) {
        String img = null; //TODO set img to the the img value of orgFilename
        return generateFilename(img,newTag);
    }

    /**
     * Gets the TAG value of the given filename
     * @param filename name of file to get tag from
     * @return tag of filename
     */
    private static String getTAG(String filename) {
        // TODO get the tag value from the filename (see String.substring)
        return null;
    }

    /**
     * Gets the IMG value of the given filename
     * @param filename name of the file to get img from
     * @return img of the filename
     */
    private static String getIMG(String filename) {
        // TODO get the img value from the filename (see String.substring)
        return null;
    }

    /**
     * Filter that can by applied to a File search to get only Files with the desired tag
     */
    private static class BitmapTagFilter implements FileFilter {
        String mTag;

        public BitmapTagFilter(String tag) {
            mTag = tag;
        }

        public boolean accept(File file) {
            String filename = file.getName();
            return filename.endsWith(EXT) && mTag.equals(getTAG(filename));
        }
    }

    /**
     * Attempt to create a new directory at parent/directoryName, does nothing if it alreasy exists
     * @param parent parent to create this directory under
     * @param directoryName name of new directory
     * @return path to created directory
     */
    private static File createDirectory(File parent, String directoryName) {
        // TODO make a file with path parent/directoryName
        // TODO if file does not exist, make it (see File.exists() and File.mkdirs())
        return null;
    }
}
