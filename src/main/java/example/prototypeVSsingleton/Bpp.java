package example.prototypeVSsingleton;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.lang.reflect.Method;

@Component
public class Bpp implements BeanPostProcessor {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) factory.getBeanDefinition(beanName);
        if (beanDefinition.isPrototype()) {
            if (beanDefinition.getDestroyMethodName() != null) {
                printWarning();
                return bean;
            }
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(PreDestroy.class)) {
                    printWarning();
                }
            }
        }
        return bean;
    }

    private void printWarning() {
        System.err.println("WARNING: ТЫ ДУРАК!");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
