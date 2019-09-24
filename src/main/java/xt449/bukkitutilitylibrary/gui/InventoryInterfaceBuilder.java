package xt449.bukkitutilitylibrary.gui;

import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class InventoryInterfaceBuilder {

	private ClickHandler clickHandler = event -> {};
	private DragHandler dragHandler = event -> {};
	/*private CreativeHandler creativeHandler = event -> {};*/
	private OpenHandler openHandler = event -> {};
	private CloseHandler closeHandler = event -> {};

	private final InventoryInterface inventoryInterface;

	public InventoryInterfaceBuilder(int rows, @NotNull String title, boolean autoUpdate) {
		inventoryInterface = new AbstractInventoryInterface(rows, title, autoUpdate) {
			@Override
			public void onClick(@NotNull InventoryClickEvent event) {
				clickHandler.onClick(event);
			}
			@Override
			public void onDrag(@NotNull InventoryDragEvent event) {
				dragHandler.onDrag(event);
			}
			/*@Override
			public void onCreative(@NotNull InventoryCreativeEvent event) {
				creativeHandler.onCreative(event);
			}*/
			@Override
			public void onOpen(@NotNull InventoryOpenEvent event) {
				openHandler.onOpen(event);
			}
			@Override
			public void onClose(@NotNull InventoryCloseEvent event) {
				closeHandler.onClose(event);
			}
		};
	}

	public InventoryInterfaceBuilder(@NotNull Inventory inventory, boolean autoUpdate) {
		inventoryInterface = new AbstractInventoryInterface(inventory, autoUpdate) {
			@Override
			public void onClick(@NotNull InventoryClickEvent event) {
				clickHandler.onClick(event);
			}
			@Override
			public void onDrag(@NotNull InventoryDragEvent event) {
				dragHandler.onDrag(event);
			}
			@Override
			public void onOpen(@NotNull InventoryOpenEvent event) {
				openHandler.onOpen(event);
			}
			@Override
			public void onClose(@NotNull InventoryCloseEvent event) {
				closeHandler.onClose(event);
			}
		};
	}

	public InventoryInterfaceBuilder setClickHandler(@NotNull ClickHandler clickHandler) {
		this.clickHandler = clickHandler;
		return this;
	}

	public InventoryInterfaceBuilder setDragHandler(@NotNull DragHandler dragHandler) {
		this.dragHandler = dragHandler;
		return this;
	}

	/*public InventoryInterfaceBuilder setCreativeHandler(@NotNull CreativeHandler creativeHandler) {
		this.creativeHandler = creativeHandler;
		return this;
	}*/

	public InventoryInterfaceBuilder setOpenHandler(@NotNull OpenHandler openHandler) {
		this.openHandler = openHandler;
		return this;
	}

	public InventoryInterfaceBuilder setCloseHandler(@NotNull CloseHandler closeHandler) {
		this.closeHandler = closeHandler;
		return this;
	}

	public InventoryInterfaceHolder build() {
		return inventoryInterface.getHolder();
	}

	public static interface ClickHandler {
		void onClick(@NotNull InventoryClickEvent event);
	}
	public static interface DragHandler {
		void onDrag(@NotNull InventoryDragEvent event);
	}
	/*@Deprecated
	public static interface CreativeHandler {
		void onCreative(@NotNull InventoryCreativeEvent event);
	}*/
	public static interface OpenHandler {
		void onOpen(@NotNull InventoryOpenEvent event);
	}
	public static interface CloseHandler {
		void onClose(@NotNull InventoryCloseEvent event);
	}
}
