package com.sample.registration.annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("com.sample.registration.annotations.SampleAnnotation")
public class SampleAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(Element element: roundEnv.getElementsAnnotatedWith(SampleAnnotation.class)) {
            System.out.println("********** My sample annotation started executing ***********");
        }
        return true;
    }
}
