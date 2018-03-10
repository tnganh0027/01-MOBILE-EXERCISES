# 01-MOBILE-EXERCISES

# FOR EXERCISE 1

#### This exercise used GEOCODING GOOGLE MAP REST API to find the address of a LatLong.

Pre-install for ex1:
1. Java 8 and later (I used java 9 for this exersise)
2. Tomcat server (Version 9 if you use java 9)
3. (Optional) Intelij IDEA (or you can use eclipse...)

Run ex1:
1. Fork this repo to your local with configurations(maven, springboot 5, tomcat...)
2. Run on your IDE
3. Enter the URL, in my case is "localhost:8080/location" for the index page.
4. Type the Latitude and Longtitude and click submmit to see result.
5. Re-enter the "localhost:8080/location" and re-do for another latittude and longtitude.

Image demo:

![Image of Demo1](https://github.com/tnganh0027/01-MOBILE-EXERCISES/tree/master/ex1/src/main/resources/static/cap1.PNG)

![Image of demo2](https://github.com/tnganh0027/01-MOBILE-EXERCISES/tree/master/ex1/src/main/resources/static/cap2.PNG)

# FOR EXERCISE 2

### In this exercise, i used the Haversine Formula (https://en.wikipedia.org/wiki/Haversine_formula) with Radius of Earth to calculate distance between 2 points(Lat,Long).
### I have not write the UI for client side so you will need Postman (https://www.getpostman.com/) to test the webservice Restful.
Pre-install for ex2 the same with ex1.

Run ex2:
1. Fork this repo to your local with configurations(maven, springboot 5, tomcat...)
2. Run on your IDE.
3. Open Postman and enter the "localhost:8080" (if you use another port, you will need to change it)
4. Click the Params button to enter 2 (lat,long) present for 2 location.
*Key  *value
lat1  -your latitude for 1st location
lon1  -your longtitude for 1st location
lat2  -your latitude for 2nd location
lon2  -your longtitude for 2nd location
>SEND the request when you complete all the params.

Image demo:
![Image of Demo1](https://github.com/tnganh0027/01-MOBILE-EXERCISES/blob/master/ex2/src/main/resources/static/cape1.PNG)

![Image of Demo1](https://github.com/tnganh0027/01-MOBILE-EXERCISES/blob/master/ex2/src/main/resources/static/cape2.PNG)
