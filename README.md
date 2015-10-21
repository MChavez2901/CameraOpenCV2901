# CameraOpenCVSkeleton

The purpose of this Application is to allow us to access the camera in order to take and save images to file.
Once saved, we can perform several image processing techniques to parse information about the image such as identifying colors and lines. 

This project makes use of the OpenCV library to perform matrix operations that are normally very complicated to write in native java. 

There are several TODO's that need to be completed for this app to function. The more complicated ones are accompanied by links to api pages that explain the functionality you need to implement. Look at each activities import statments to get an idea of the classes you will be using in the code logic.

The work can be split up into several independant pieces:

1) PhotoHelper - Helper class to assist with saving and reading of images

2) CameraActivity - View that shows the back camera's image preview and allows the user to save that image to file  

3) ImageDisplayActivity - A view of an image and various image processing techniques performed on it

4) GalleryActivity- List view of all saved images that allows the use to open/delete individual images

5) MatFilter - Helper class that perform image processing on images

6) MainActivity - View with buttons allow the use to open the Camera and Gallery Activities 

javadocs

openCV : http://docs.opencv.org/java/ 

android : http://developer.android.com/reference/packages.html. 
