# MAJnidemo
JNI 开发

android studio 引用so 文件：
 main 文件下：新建 jniLibs 直接放里面

JNI 生成c文件	
1.点击rebuild project 会生成app/build/intermediates/classes/debug 目录

2.进入这个目录  cd app/build/intermediates/classes/debug
  输入命令： javah -jni com.wobiancao.ndkjnidemo.ndk.JniUtils
  当前目录生成一个.h文件 com_wobiancao_ndkjnidemo_ndk_JniUtils.h
  
3.然后在src/main下新建文件夹jni ，将.h文件拷贝到下面，修改为.c后缀

4.在gradle.properties文件末尾添加android.useDeprecatedNdk=true
  然后在app文件下得build.gradle ->defaultConfig括号内添加如下代码
  ndk {
   moduleName "NdkJniDemo"          //生成的so名字 
   abiFilters "armeabi", "armeabi-v7a", "x86" //输出指定三种abi体系结构下的so库，目前可有可无。 生成的so 文件Jnidemo/app/build/intermediates/ndk/debug/lib
   }

5.在JniUtils类里面添加如下代码
  static {
   System.loadLibrary("NdkJniDemo");//之前在build.gradle里面设置的so名字，必须一致
  }
