package gui.rightPanelView.slotContent;

import editor.EditorEnum;

public abstract class SlotContent {
        EditorEnum type;

        public EditorEnum getType() {
                return type;
        }

        public void setType(EditorEnum type) {
                this.type = type;
        }
}
