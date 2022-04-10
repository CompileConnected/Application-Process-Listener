# Application-Process-Listener

[![GitHub license](https://img.shields.io/github/license/CompileConnected/Application-Process-Listener)](https://github.com/CompileConnected/Application-Process-Listener/blob/main/LICENSE)
[![Release](https://jitpack.io/v/CompileConnected/Application-Process-Listener.svg)](https://jitpack.io/#CompileConnected/Application-Process-Listener)


Simple Android Library to listen if application on Foreground or Background

Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency
```groovy
	dependencies {
        implementation 'com.github.CompileConnected:Application-Process-Listener:1.0.0'
    }
```


How to use, first make your own ApplicationProcessListener
```kotlin
    class SampleAppProcessListener : ApplicationProcessListener {
        override fun onApplicationStateChanged(
            context: Context,
            state: ApplicationProcessListener.State
        ) {
            when (state) {
                ApplicationProcessListener.State.BACKGROUND -> /*handle background*/
                else -> /*handle foreground*/
            }
        }
    }

```


Then add the process listener in your Application
```kotlin
   class SampleApplication : Application() {

        override fun onCreate() {
            super.onCreate()
            val applicationProcess = ApplicationProcess.Builder.Default()
                .add(SampleAppProcessListener())
                .build()
    
            applicationProcess.registerToApplication(this)
        }
    }

```