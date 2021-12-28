package v.kiselev.handler;

import v.kiselev.config.Init;
import v.kiselev.service.FileService;
import v.kiselev.service.SocketService;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class MethodHandlerFactory {

    public static MethodHandler create(SocketService socketService, FileService fileService) {
        List<Class> methods = new LinkedList<>();
        ClassLoader classLoader = MethodHandlerFactory.class.getClassLoader();
        URL url = classLoader.getResource(Init.getPATH_OF_HANDLER());

        File folder = new File(url.getPath());
        File[] classes = folder.listFiles();
        MethodHandler methodHandler = null;

        for (File aClass : classes) {
            int index = aClass.getName().indexOf(".");
            String className = aClass.getName().substring(0, index);
            String classNamePath = Init.getPATH_OF_HANDLER() + "/" + className;
            String replace = classNamePath.replace("/", ".").substring(2);
            Class<?> repoClass = null;
            try {
                repoClass = Class.forName(replace);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Annotation[] annotations = repoClass.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == Handler.class) {
                    methods.add(repoClass);
                }
            }
        }


        MethodHandler methodHandlerPrev = null;
        Class aClass = methods.get(0);
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        Constructor declaredConstructor = declaredConstructors[0];
        String name = methods.get(0).getName().substring(18);
        int count = 0;
        for (int j = 1; j < name.length(); j++) {
            if (Character.isUpperCase(name.charAt(j))) {
                break;
            }
            count++;
        }
        String methodName = name.substring(0, count + 1);


        try {
            methodHandlerPrev = (MethodHandler) declaredConstructor.newInstance(methodName.toUpperCase(), null, socketService, fileService);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 1; i < methods.size(); i++) {
            name = methods.get(i).getName().substring(18);
            count = 0;
            for (int j = 1; j < name.length(); j++) {
                if (Character.isUpperCase(name.charAt(j))) {
                    break;
                }
                count++;
            }
            methodName = name.substring(0, count + 1);

            aClass = methods.get(i);
            declaredConstructors = aClass.getDeclaredConstructors();
            declaredConstructor = declaredConstructors[0];

            try {
                methodHandler = (MethodHandler) declaredConstructor.newInstance(methodName.toUpperCase(), methodHandlerPrev, socketService, fileService);
                methodHandlerPrev = methodHandler;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return methodHandler;


//        PutMethodHandler put = new PutMethodHandler("PUT", null, socketService, fileService);
//        PostMethodHandler post = new PostMethodHandler("POST", put, socketService, fileService);
//        return new GetMethodHandler("GET",
//                post,
//                socketService,
//                fileService);


    }
}
