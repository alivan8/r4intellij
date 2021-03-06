## Acknowledgements

Original code was developed in https://github.com/sproshev/TheRPlugin_Device and imported with the author's [permission](https://github.com/ktisha/TheRPlugin/issues/33#issuecomment-296237071)

### HowToBuild

[Download](https://cmake.org/download/) and install cmake (which is a Makefile generator):
```bash
## add cmake to PATH
sudo /Applications/CMake.app/Contents/bin/cmake-gui --install=/usr/local/bin
```

Add required dependencies
```bash
## http://stackoverflow.com/questions/26024878/cmake-cannot-find-boost-on-os-x-with-brew
brew install boost-python
```

And finally build it
```bash
cd /Users/brandl/projects/rplugin/r4intellij/misc/graphics_device_library
cmake .
make

# to redo cmake clear files first
rm -rf CMakeCache.txt cmake_install.cmake Makefile

#find /Library/Frameworks/R.framework/ | grep Rinternals.h
```


## R Usage

when starting a new instance the following code will set our output device
```r
# dyn.load("~/Library/Caches/IntelliJIdea2017.1/plugins-sandbox/plugins/R4Intellij/classes/libtherplugin_device64.so")
dyn.load("/Users/brandl/projects/rplugin/r4intellij/misc/graphics_device_library/libtherplugin_device64.dylib")

jetbrains_ther_device_init <- function() { 
    .Call("jetbrains_ther_device_init", "/Users/brandl/projects/r4i__tests/r4i_test_project/.idea/snapshots") 
}
    
options(device=jetbrains_ther_device_init)
plot(1:3)
```

### Debug Usage

1. create a new R console in intellij
2. run (with adjusted paths)
```r
dyn.load("~/Library/Caches/IntelliJIdea2017.1/plugins-sandbox/plugins/R4Intellij/classes/libtherplugin_device64.dylib")
jetbrains_ther_device_init <- function() { .Call("jetbrains_ther_device_init", "/Users/brandl/IdeaProjects/untitled/.idea/snapshots") }
options(device=jetbrains_ther_device_init)
```

```
require(ggplot2); ggplot(iris,aes(Species)) + geom_bar() 

```


## Useful links

[How to check the operating system is MacOSX?](http://public.kitware.com/pipermail/cmake/2012-September/052049.html)

[Original Author comments on build issues](https://github.com/ktisha/TheRPlugin/issues/33#issuecomment-296237071)

