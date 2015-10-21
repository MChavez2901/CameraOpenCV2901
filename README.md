# CameraOpenCVSkeleton

The purpose of this Application is to allow us to access the camera in order to take and save images to file.
Once saved, we can perform several image processing techniques to parse information about the image such as identifying colors and lines.

This app makes use of OpenCV to perform matrix operations that are normally very complicated to write in native java. 

There are several TODO's in the project that need to be completed for this app to function. The more complicated ones are accompanied by links to api pages that explain the functionality you need to implement. Look at each activities import statments to get an idea of the classes you will be using to complete the code logic.

The work can be split up into several independant pieces:

1) PhotoHelper - allows reading/saving of images

2) CameraActivity - allows user to take images

3) ImageDisplayActivity - allows the user to view a image and various image processing techniques performed on it

4) GalleryActivity - allow the user to view a list of all saved images and open/delete them

5) MatFilter - perform image processing on images

6) MainActivity - allow user to start Camera/Gallery Activities 

javadocs

openCV : http://docs.opencv.org/java/ 

android : http://developer.android.com/reference/packages.html. 
