package gwt.material.demo.errai.client.local.page.addins;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.demo.errai.client.local.page.addins.table.factory.CustomCategoryFactory;
import gwt.material.demo.errai.client.local.page.addins.table.factory.PersonRowFactory;
import gwt.material.demo.errai.client.local.page.addins.table.model.Person;
import gwt.material.demo.errai.client.local.page.addins.table.renderer.CustomRenderer;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.data.ListDataSource;
import gwt.material.design.client.data.SelectionType;
import gwt.material.design.client.data.component.RowComponent;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.pager.MaterialDataPager;
import gwt.material.design.client.ui.table.MaterialDataTable;
import gwt.material.design.client.ui.table.cell.Column;
import gwt.material.design.client.ui.table.cell.TextColumn;
import gwt.material.design.client.ui.table.cell.WidgetColumn;
import gwt.material.design.jquery.client.api.JQueryElement;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Templated
@Page(path = "datatable")
public class DataTablePage extends PageBase {

    @Inject
    @DataField
    MaterialDataTable<Person> standardTable, pageTable;

    @Inject
    @DataField
    MaterialCheckBox cbCategories, cbStickyHeader, cbRowExpansion;

    @Inject
    @DataField
    MaterialComboBox<SelectionType> comboSelection;

    private MaterialDataPager pager;
    private ListDataSource<Person> dataSource;

    @PostConstruct
    public void init() {
        initPage("Data Table", "Data tables display sets of raw data. They usually appear in desktop enterprise products. Material DataTable supports Standard, Infinite Table, Pager and Context Menu.", ADDINS);
    }

    @Override
    public void page() {
        super.page();
        buildStandardTable();
        buildPageTable();
    }

    public void buildPageTable() {
        pageTable.getTableTitle().setText("Page Table");
        pageTable.getScaffolding().getTopPanel().addStyleName(Color.RED.getCssName());
        pageTable.setShadow(1);
        pageTable.setHeight("400px");
        pageTable.setUseStickyHeader(false);
        pageTable.setUseCategories(false);
        pageTable.setUseRowExpansion(false);
        pageTable.setSelectionType(SelectionType.SINGLE);
        dataSource = new ListDataSource<>(pageTable, getAllPersons());
        pager = new MaterialDataPager<>(pageTable, dataSource);
        pager.setRowCountOptions(5, 10, 15, 20);
        pageTable.add(pager);
        buildTable(pageTable);
    }

    public void buildStandardTable() {
        cbCategories.setText("With Categories");
        cbCategories.setType(CheckBoxType.FILLED);
        cbCategories.addValueChangeHandler(event -> {
            standardTable.setUseCategories(event.getValue());
            standardTable.setRedraw(true);
            standardTable.refreshView();
        });

        cbStickyHeader.setText("With Sticky Header");
        cbStickyHeader.setType(CheckBoxType.FILLED);
        cbStickyHeader.addValueChangeHandler(event -> {
            standardTable.setUseStickyHeader(event.getValue());
            standardTable.setRedraw(true);
            standardTable.refreshView();
        });

        cbRowExpansion.setText("With Row Expansion");
        cbRowExpansion.setType(CheckBoxType.FILLED);
        cbRowExpansion.addValueChangeHandler(event -> {
            standardTable.setUseRowExpansion(event.getValue());
            standardTable.setRedraw(true);
            standardTable.refreshView();
        });
        buildSelection();

        standardTable.getTableTitle().setText("Standard Table");
        standardTable.getScaffolding().getTopPanel().addStyleName(Color.RED.getCssName());
        standardTable.setShadow(1);
        standardTable.setHeight("400px");
        standardTable.setUseStickyHeader(false);
        standardTable.setUseCategories(false);
        standardTable.setUseRowExpansion(false);
        standardTable.setSelectionType(SelectionType.SINGLE);
        buildTable(standardTable);
    }

    public void buildSelection() {
        comboSelection.setLabel("Selection Type");
        comboSelection.addItem("SINGLE", SelectionType.SINGLE);
        comboSelection.addItem("MULTIPLE", SelectionType.MULTIPLE);
        comboSelection.addItem("NONE", SelectionType.NONE);
        comboSelection.addSelectionHandler(selectionEvent -> {
            standardTable.setSelectionType(selectionEvent.getSelectedItem());
            standardTable.setRedraw(true);
            standardTable.refreshView();
        });
    }

    public void buildTable(MaterialDataTable<Person> table) {
        table.setRowFactory(new PersonRowFactory());
        table.setCategoryFactory(new CustomCategoryFactory());
        table.setRenderer(new CustomRenderer<>());

        Column<Person, ?> imageCol = new WidgetColumn<Person, MaterialImage>() {
            @Override
            public TextAlign getTextAlign() {
                return TextAlign.CENTER;
            }
            @Override
            public MaterialImage getValue(Person object) {
                MaterialImage image = new MaterialImage(object.getPicture());
                image.setWidth("28px");
                image.setHeight("28px");
                image.setMarginTop(8);
                image.setCircle(true);
                return image;
            }
        };
        table.addColumn(imageCol, "Picture");

        table.addColumn(new TextColumn<Person>() {
            @Override
            public Comparator<? super RowComponent<Person>> getSortComparator() {
                return (o1, o2) -> o1.getData().getFirstName().compareToIgnoreCase(o2.getData().getFirstName());
            }

            @Override
            public String getValue(Person object) {
                return object.getFirstName();
            }
        }, "Username");

        table.addColumn(new TextColumn<Person>() {
            @Override
            public Comparator<? super RowComponent<Person>> getSortComparator() {
                return (o1, o2) -> o1.getData().getFirstName().compareToIgnoreCase(o2.getData().getFirstName());
            }

            @Override
            public String getValue(Person object) {
                return object.getFirstName();
            }
        }, "First Name");

        table.addColumn(new TextColumn<Person>() {
            @Override
            public Comparator<? super RowComponent<Person>> getSortComparator() {
                return (o1, o2) -> o1.getData().getLastName().compareToIgnoreCase(o2.getData().getLastName());
            }

            @Override
            public String getValue(Person object) {
                return object.getLastName();
            }
        }, "Last Name");

        Column<Person, ?> buttonCol = new WidgetColumn<Person, MaterialButton>() {
            @Override
            public MaterialButton getValue(Person object) {
                MaterialButton btnAction = new MaterialButton();
                btnAction.setText("Update");
                btnAction.setIconType(IconType.UPDATE);
                btnAction.addClickHandler(clickEvent -> {
                    MaterialToast.fireToast("Clicked");
                });
                return btnAction;
            }
        };
        table.addColumn(buttonCol, "Action");

        table.setVisibleRange(0, 1000);
        table.setRowData(0, getAllPersons());

        // Here we are adding a row expansion handler.
        // This is invoked when a row is expanded.
        table.addRowExpandHandler((e, rowExpand) -> {
            JQueryElement section = rowExpand.getOverlay();

            if(rowExpand.isExpand()) {
                // Fake Async Task
                // This is demonstrating a fake asynchronous call to load
                // the data inside the expansion element.
                new Timer() {
                    @Override
                    public void run() {
                        // Clear the content first.
                        MaterialWidget content = new MaterialWidget(
                                rowExpand.getRow().find(".content").empty().asElement());

                        // Add new content.
                        MaterialBadge badge = new MaterialBadge("This content", Color.WHITE, Color.BLUE);
                        badge.getElement().getStyle().setPosition(Style.Position.RELATIVE);
                        badge.getElement().getStyle().setRight(0, Style.Unit.PX);
                        badge.setFontSize(12, Style.Unit.PX);
                        content.add(badge);

                        MaterialButton btn = new MaterialButton("was made");
                        btn.setIconType(IconType.POLYMER);
                        btn.getIcon().addStyleName(CssName.MATERIAL_ICONS);
                        content.add(btn);

                        MaterialTextBox textBox = new MaterialTextBox();
                        textBox.setText(" from an asynchronous");
                        textBox.setGwtDisplay(Style.Display.INLINE_TABLE);
                        textBox.setWidth("200px");
                        content.add(textBox);

                        MaterialIcon icon = new MaterialIcon(IconType.CALL);
                        icon.getElement().getStyle().setPosition(Style.Position.RELATIVE);
                        icon.getElement().getStyle().setTop(12, Style.Unit.PX);
                        content.add(icon);

                        // Hide the expansion elements overlay section.
                        // The overlay is retrieved using EowExpand#getOverlay()
                        section.css("display", "none");
                    }
                }.schedule(2000);
            }
            return true;
        });

        // Add a row select handler, called when a user selects a row.
        table.addRowSelectHandler((e, model, elem, selected) -> {
            GWT.log(model.getId() + ": " + selected);
            return true;
        });

        // Add a sort column handler, called when a user sorts a column.
        table.addSortColumnHandler((e, sortContext, columnIndex) -> {
            GWT.log("Sorted: " + sortContext.getSortDir() + ", columnIndex: " + columnIndex);
            table.refreshView();
            return true;
        });

        // Add a row count change handler, called when the row count changes.
        table.addRowCountChangeHandler((e, newCount, isExact) -> {
            GWT.log("Row Count Changed: " + newCount + ", isExact: " + isExact);
            return true;
        });

        // Add category opened handler, called when a category is opened.
        table.addCategoryOpenedHandler((e, categoryName) -> {
            GWT.log("Category Opened: " + categoryName);
            return true;
        });

        // Add category closed handler, called when a category is closed.
        table.addCategoryClosedHandler((e, categoryName) -> {
            GWT.log("Category Closed: " + categoryName);
            return true;
        });

        // Add a row double click handler, called when a row is double clicked.
        table.addRowDoubleClickHandler((e, mouseEvent, model, row) -> {
            // GWT.log("Row Double Clicked: " + model.getId() + ", x:" + mouseEvent.getPageX() + ", y: " + mouseEvent.getPageY());
            Window.alert("Row Double Clicked: " + model.getId());
            return true;
        });

        // Configure the tables long press duration configuration.
        // The short press is when a click is held less than this duration.
        table.setLongPressDuration(400);

        // Add a row long press handler, called when a row is long pressed.
        table.addRowLongPressHandler((e, mouseEvent, model, row) -> {
            //GWT.log("Row Long Pressed: " + model.getId() + ", x:" + mouseEvent.getPageX() + ", y: " + mouseEvent.getPageY());
            return true;
        });

        // Add a row short press handler, called when a row is short pressed.
        table.addRowShortPressHandler((e, mouseEvent, model, row) -> {
            //.log("Row Short Pressed: " + model.getId() + ", x:" + mouseEvent.getPageX() + ", y: " + mouseEvent.getPageY());
            return true;
        });
    }

    public List<Person> getAllPersons() {
        List<Person> people = new ArrayList<>();
        for (int j = 1; j <= 5; j++) {
            String category = "Category " + j;
            for (int i = 1; i <= 5; i++) {
                people.add(new Person(i, "UserName " + i , "https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png", "First Name " + j + "." + i, "Last Name " + j + "." + i, "Phone " + j + "." + i, category));
            }
        }

        return people;
    }
}