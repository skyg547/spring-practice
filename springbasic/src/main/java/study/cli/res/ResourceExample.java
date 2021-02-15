package study.cli.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourceExample{

    @Autowired
    private ResourceLoader resourceLoader;

    // aware 사용
//    @Override
//    public void setResourceLoader(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
//
    public void print(){
        System.out.println(resourceLoader);
    }

}
