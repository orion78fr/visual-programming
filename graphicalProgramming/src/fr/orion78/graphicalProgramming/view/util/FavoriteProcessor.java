package fr.orion78.graphicalProgramming.view.util;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

@SupportedAnnotationTypes(value = { "fr.orion78.graphicalProgramming.view.util.Favorite" })
public class FavoriteProcessor extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		Messager messager = processingEnv.getMessager();

		for (TypeElement te : annotations) {
			messager.printMessage(Kind.NOTE,
					"Traitement annotation " + te.getQualifiedName());

			for (Element element : roundEnv.getElementsAnnotatedWith(te)) {
				messager.printMessage(Kind.NOTE, "  Traitement element "
						+ element.getSimpleName());
				Favorite fav = element.getAnnotation(Favorite.class);

				if (fav != null) {
					messager.printMessage(Kind.NOTE, element.getKind().toString());
				}
			}
		}
		return true;
	}

}
