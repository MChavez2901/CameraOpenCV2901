# CameraOpenCVSkeleton

The purpose of this Application is to allow the user to access the camera in order to take and save images to file.
Once saved, we can perform several image processing techniques to parse information about the image such as identifying colors and lines

This app makes use of OpenCV to perform matrix operations that are normally very complicated in Java. 
Throughout the app, there are links to api pages to learn more about the methods. 
You can allow view the full javadoc at http://docs.opencv.org/java/

There are several TODO's throughout this app that need to be completed for this app to function. 
The work can be split up into several independant pieces:

1) PhotoHelper - allows reading/saving of images

2) CameraActivity - allows user to take images

3) ImageDisplayActivity - allows the user to view a image and various image processing techniques performed on it

4) GalleryActivity - allow the user to view a list of all saved images and open/delete them

5) MatFilter - perform image processing on images

6) MainActivity - allow user to start Camera/Gallery Activities 

read over the comments in eachclass to get an understanding for their purpose
