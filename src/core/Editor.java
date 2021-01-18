package core;

import editor.EditorEnum;
import repository.slot.Slot;

public interface Editor {
    void choseContentType(Slot slot);
    void openImageContent(Slot slot);
    void openTextContent(Slot slot);
}
