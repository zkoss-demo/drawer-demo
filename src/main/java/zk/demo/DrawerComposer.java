package zk.demo;

import org.zkoss.addon.Drawer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Radiogroup;

public class DrawerComposer extends SelectorComposer<Component> {
	@Wire
	private Button open;

	@Wire
	private Drawer drawer;

	@Wire
	private Radiogroup position;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}

	@Listen("onClick = #open")
	public void handleOpen() {
		drawer.open();
	}

	@Listen("onCheck = #position")
	public void handlePositionChange() {
		drawer.setPosition(position.getSelectedItem().getLabel());
	}

	@Listen("onClick = #mask")
	public void handleMaskToggle() {
		drawer.setMask(!drawer.isMask());
	}

	@Listen("onClick = #closable")
	public void handleClosableToggle() {
		drawer.setClosable(!drawer.isClosable());
	}
}
