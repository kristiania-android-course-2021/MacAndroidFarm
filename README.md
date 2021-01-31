# Old MacAndroid had a farm
This session is mainly about two things.

- Fragments and how to use them
- Lists (Recyclerview)

With this, We will discuss a couple of things more such as
- View binding
- Themes and shapes
- Media player 

You can use [Color Tool - Material Design](https://material.io/resources/color/) for deciding your own themes and colors.

### Dependencies 
Android Meterial components for recyclerview
```groovy
implementation 'com.google.android.material:material:1.2.1'
```
Enable DataBinding in the app gradle.build file
```groovy
android {
    
    buildFeatures {
        viewBinding = true
    }
}
```    
  
![MacAndroidFarm](farm.gif)