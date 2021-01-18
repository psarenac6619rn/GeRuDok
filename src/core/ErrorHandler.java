package core;

import error.ErrorEnum;
import observer.IObserver;

public interface ErrorHandler extends IObserver {

	void generateError(ErrorEnum type);

}