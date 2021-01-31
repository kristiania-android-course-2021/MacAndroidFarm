# MacAndroidFarm
This session is mainly about two things.

- Fragments and how to use them
- Lists (Recyclerview)

With this, We will discuss about couple of things more such as
- View binding
- Themes
- Mediaplayer 

### Dependencies 
Android Meterial components for recyclerview
```groovy
implementation 'com.google.android.material:material:1.2.1'
```
Enable DataBinding in the app gradle.build file
```groovy
android {
    ... 
    
    buildFeatures {
        viewBinding = true
    }
}
```