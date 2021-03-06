package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.CheckBoxType;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.RadioButtonType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;

@Templated
@Page(path = "forms")
public class FormPage extends AbstractPage {

    @Inject
    @DataField
    private MaterialTextBox txtBox1, txtBoxLabel, txtBoxPlaceholder, txtBox2, txtBox3, txtDisTextBox, txtBoxRO, txtBoxTRO;

    @Inject
    @DataField
    private MaterialTextArea txtArea1, txtArea2, txtDisTextArea, txtAreaRO, txtAreaTRO;

    @Inject
    @DataField
    private MaterialTextBox txtCharCounter1, txtCharCounter2;

    @Inject
    @DataField
    private MaterialFloatBox txtFloat1, txtDisFloat, txtFloatRO, txtFloatTRO;

    @Inject
    @DataField
    private MaterialIntegerBox txtInteger1, txtDisInteger, txtIntegerRO, txtIntegerTRO;

    @Inject
    @DataField
    private MaterialDoubleBox txtDouble1, txtDisDouble, txtDoubleRO, txtDoubleTRO;

    @Inject
    @DataField
    private MaterialLongBox txtLong1, txtDisLong, txtLongRO, txtLongTRO;

    @Inject
    @DataField
    private MaterialTextBox txtBoxValueChange, txtBoxKey, txtBoxBlur, txtBoxFocus;

    @Inject
    @DataField
    private MaterialListBox lstBox1, lstBoxDisabled;

    @Inject
    @DataField
    private MaterialListBox lstBox2;

    @Inject
    @DataField
    private MaterialButton btnAddItem, btnInsertItem, btnClear, btnSetSelected, btnGetSelected, btnRemoveItem;

    @Inject
    @DataField
    private MaterialRadioButton rb1, rb2, rb3, rb4;

    @Inject
    @DataField
    private MaterialCheckBox cb1, cb2, cb3, cb4, cb5, cb6, cbAll, cb7, cb8, cb9, cb10, cb11;

    @Inject
    @DataField
    private MaterialSwitch switch1, switch2, switch3, switch4;

    @Inject
    @DataField
    private MaterialRange range;

    @Override
    public String getName() {
        return "Forms";
    }

    @Override
    public String getDescription() {
        return "Forms are the standard way to receive user inputted data. The transitions and " +
                "smoothness of these elements are very important because of the inherent user " +
                "interaction associated with forms.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildTextBox();
        buildTextBoxLabelAndPlaceholder();
        buildTextArea();
        buildCharCounter();
        buildNumber();
        buildDisabledValueBox();
        buildEventsValueBox();
        buildListBox();
        buildDynamicListBox();
        buildRadioButton();
        buildCheckBox();
        buildSwitch();
        buildRange();
        buildReadOnly(txtBoxRO, txtAreaRO, txtFloatRO, txtIntegerRO, txtDoubleRO, txtLongRO, false);
        buildReadOnly(txtBoxTRO, txtAreaTRO, txtFloatTRO, txtIntegerTRO, txtDoubleTRO, txtLongTRO, true);
    }

    private void buildTextBoxLabelAndPlaceholder() {
        txtBoxLabel.setLabel("This is a label");
        txtBoxPlaceholder.setPlaceholder("This is a placeholder");
    }

    private void buildReadOnly(MaterialTextBox txtBoxRO, MaterialTextArea txtAreaRO, MaterialFloatBox txtFloatRO, MaterialIntegerBox txtIntegerRO,
                               MaterialDoubleBox txtDoubleRO, MaterialLongBox txtLongRO, boolean toggleReadOnly) {
        txtBoxRO.setLabel("Text Box");
        txtBoxRO.setValue("Some Value");
        txtBoxRO.setReadOnly(true);
        txtBoxRO.setToggleReadOnly(toggleReadOnly);

        txtAreaRO.setLabel("Text Area");
        txtAreaRO.setValue("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam mauris, accumsan placerat lectus ac, tincidunt mattis nisl. Ut efficitur massa in libero gravida tincidunt. Vestibulum eget massa eget ex auctor tempus. Aenean vitae augue euismod, lacinia lectus ut, rhoncus enim. Sed vitae laoreet felis, eget ullamcorper nunc. Vivamus elit urna, varius et arcu vel, euismod auctor augue. Praesent scelerisque scelerisque libero sit amet euismod. Mauris eu est at felis feugiat tincidunt eu vel lectus. Ut pretium magna vitae massa sollicitudin, eu tincidunt sapien scelerisque. Maecenas gravida lorem non dui pretium, id vestibulum mi imperdiet. Fusce facilisis, dui nec ultrices molestie, nisi metus bibendum lacus, eget posuere est odio vitae nulla. Mauris laoreet non justo fringilla tempus. Mauris ut risus risus. Vivamus auctor accumsan gravida. Nam venenatis sapien nisl, quis accumsan odio dignissim non. Vestibulum aliquam semper condimentum. Suspendisse a eros elementum, dapibus quam in, aliquet lorem. Morbi mi dui, convallis at luctus ultricies, malesuada at leo. Morbi et turpis a ex vehicula ullamcorper. Vestibulum lacinia, orci eget elementum fermentum, lectus velit interdum erat, sit amet pharetra justo elit in tortor. Suspendisse ac vestibulum nisi.Nunc euismod metus nec elit sollicitudin blandit. Proin eleifend ex bibendum sodales blandit. Vestibulum varius pharetra arcu, sit amet pellentesque odio hendrerit nec. Integer faucibus imperdiet tortor a tempus. Sed accumsan condimentum nisl. Cras interdum sapien quis maximus commodo. Nulla malesuada imperdiet enim, non ornare elit auctor in. Fusce at ipsum eget turpis tincidunt maximus. Nunc sodales tortor nec tincidunt fringilla. Quisque sollicitudin ipsum at dolor faucibus, ultricies convallis ipsum convallis. Donec consequat velit vel molestie tempus. Donec et accumsan lacus, non sollicitudin quam. Morbi arcu lacus, blandit eu lacus nec, finibus tempus ligula.");
        txtAreaRO.setReadOnly(true);
        txtAreaRO.setToggleReadOnly(toggleReadOnly);

        txtFloatRO.setLabel("Float Box");
        txtFloatRO.setValue(1000.25f);
        txtFloatRO.setReadOnly(true);
        txtFloatRO.setToggleReadOnly(toggleReadOnly);

        txtIntegerRO.setLabel("Integer Box");
        txtIntegerRO.setValue(10);
        txtIntegerRO.setReadOnly(true);
        txtIntegerRO.setToggleReadOnly(toggleReadOnly);

        txtDoubleRO.setLabel("Double Box");
        txtDoubleRO.setValue(999.99);
        txtDoubleRO.setReadOnly(true);
        txtDoubleRO.setToggleReadOnly(toggleReadOnly);

        txtLongRO.setLabel("Long Box");
        txtLongRO.setValue(1000l);
        txtLongRO.setReadOnly(true);
        txtLongRO.setToggleReadOnly(toggleReadOnly);
    }

    private void buildRange() {
        range.setMin(10);
        range.setMax(50);
        range.setValue(25);
        range.setHelperText("Min : " + range.getMin() + ", Max : " + range.getMax() + ", Value : " + range.getValue());
        range.addChangeHandler(changeEvent -> {
            range.setHelperText("Min : " + range.getMin() + ", Max : " + range.getMax() + ", Value : " + range.getValue());
        });
    }

    private void buildSwitch() {
        switch1.setValue(true);

        switch2.setValue(false);
        switch2.setEnabled(false);

        switch3.setValue(true);
        switch3.setOnLabel("Male");
        switch3.setOffLabel("Female");

        switch4.addValueChangeHandler(valueChangeEvent -> {
            MaterialToast.fireToast("Value: " + valueChangeEvent.getValue());
        });
    }

    private void buildCheckBox() {
        cb1.setText("Blue");
        cb1.setValue(true);

        cb2.setText("Red");
        cb2.setValue(false);

        cb3.setText("Cyan");
        cb3.setValue(true);
        cb3.setType(CheckBoxType.FILLED);

        cb4.setText("Green");
        cb4.setValue(true);
        cb4.setEnabled(false);

        cb5.setText("Brown");
        cb5.setValue(false);
        cb5.setEnabled(false);

        cb6.setText("CheckBox 1: false");
        cb6.setValue(false);
        cb6.setType(CheckBoxType.FILLED);
        cb6.addValueChangeHandler(valueChangeEvent -> {
            cb6.setText("CheckBox 1: " + valueChangeEvent.getValue());
        });

        cbAll.setText("Check All");
        cbAll.setType(CheckBoxType.FILLED);

        cbAll.addValueChangeHandler(valueChangeEvent -> {
            cb7.setValue(valueChangeEvent.getValue());
            cb8.setValue(valueChangeEvent.getValue());
            cb9.setValue(valueChangeEvent.getValue());
            cb10.setValue(valueChangeEvent.getValue());
            cb11.setValue(valueChangeEvent.getValue());
        });

        cb7.setText("Blue");
        cb7.setType(CheckBoxType.FILLED);

        cb8.setText("Red");
        cb8.setType(CheckBoxType.FILLED);

        cb9.setText("Cyan");
        cb9.setType(CheckBoxType.FILLED);

        cb10.setText("Green");
        cb10.setType(CheckBoxType.FILLED);

        cb11.setText("Brown");
        cb11.setType(CheckBoxType.FILLED);

    }

    private void buildRadioButton() {
        rb1.setText("Red");
        rb1.setName("color");
        rb1.setType(RadioButtonType.GAP);

        rb2.setText("Yellow");
        rb2.setName("color");

        rb3.setText("Green");
        rb3.setName("color");

        rb4.setText("Brown");
        rb4.setName("color");
        rb4.setEnabled(false);
    }


    private void buildDynamicListBox() {
        lstBox2.setPlaceholder("ListBox");
        lstBox2.addValueChangeHandler(valueChangeEvent -> {
            MaterialToast.fireToast("Value : " + valueChangeEvent.getValue());
        });
        for (int i = 1; i <= 5; i++) {
            lstBox2.addItem("Option " + i);
        }

        btnAddItem.setText("Add");
        btnAddItem.addClickHandler(clickEvent -> {
            lstBox2.addItem("New Item");
        });

        btnInsertItem.setText("Insert");
        btnInsertItem.addClickHandler(clickEvent -> {
            lstBox2.insertItem("Inserted Item", 2);
        });

        btnRemoveItem.setText("Remove");
        btnRemoveItem.addClickHandler(clickEvent1 -> {
            lstBox2.removeItem(0);
        });

        btnClear.setText("Clear");
        btnClear.addClickHandler(clickEvent -> {
            lstBox2.clear();
        });

        btnSetSelected.setText("Set Selected");
        btnSetSelected.addClickHandler(clickEvent -> {
            lstBox2.setSelectedIndex(2);
        });

        btnGetSelected.setText("Get Selected");
        btnGetSelected.addClickHandler(clickEvent -> {
            MaterialToast.fireToast(lstBox2.getSelectedValue());
        });
    }

    private void buildListBox() {
        lstBox1.setPlaceholder("ListBox");
        for (int i = 1; i <= 5; i++) {
            lstBox1.addItem("Option " + i);
            lstBoxDisabled.addItem("Option " + i);
        }

        lstBoxDisabled.setPlaceholder("Disabled");
        lstBoxDisabled.setEnabled(false);
    }

    private void buildEventsValueBox() {
        txtBoxValueChange.setLabel("Value Change Event");
        txtBoxValueChange.addValueChangeHandler(valueChangeEvent -> {
            txtBoxValueChange.setHelperText("Value Changed to " + valueChangeEvent.getValue());
        });

        txtBoxKey.setLabel("Key Press Event");
        txtBoxKey.addKeyPressHandler(keyPressEvent -> {
            txtBoxKey.setHelperText("Key Pressed : " + txtBoxKey.getText());
        });

        txtBoxBlur.setLabel("Blur Event");
        txtBoxBlur.addBlurHandler(blurEvent -> {
            txtBoxBlur.setHelperText("TextBox on Blur");
        });

        txtBoxFocus.setLabel("Focus Event");
        txtBoxFocus.addFocusHandler(focusEvent -> {
            txtBoxFocus.setHelperText("TextBox on Focus");
        });
    }

    private void buildDisabledValueBox() {
        txtDisTextBox.setLabel("TextBox");
        txtDisTextBox.setEnabled(false);

        txtDisTextArea.setLabel("Text Area");
        txtDisTextArea.setEnabled(false);

        txtDisFloat.setLabel("FloatBox");
        txtDisFloat.setEnabled(false);

        txtDisInteger.setLabel("IntegerBox");
        txtDisInteger.setEnabled(false);

        txtDisDouble.setLabel("DoubleBox");
        txtDisDouble.setEnabled(false);

        txtDisLong.setLabel("LongBox");
        txtDisLong.setEnabled(false);
    }

    private void buildNumber() {
        txtFloat1.setLabel("Float value");
        txtFloat1.setValue(1000.25f);

        txtInteger1.setLabel("Integer value");
        txtInteger1.setValue(10);

        txtDouble1.setLabel("Double value");
        txtDouble1.setValue(999.99);

        txtLong1.setLabel("Long value");
        txtLong1.setValue(Long.valueOf(1000));
    }

    private void buildCharCounter() {
        txtCharCounter1.setLabel("Input Text");
        txtCharCounter1.setLength(10);

        txtCharCounter2.setLabel("Text Area");
        txtCharCounter2.setLength(120);
    }

    private void buildTextArea() {
        txtArea1.setResizeRule(MaterialTextArea.ResizeRule.AUTO);
        txtArea1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam mauris, accumsan placerat lectus ac, tincidunt mattis nisl. Ut efficitur massa in libero gravida tincidunt. Vestibulum eget massa eget ex auctor tempus. Aenean vitae augue euismod, lacinia lectus ut, rhoncus enim. Sed vitae laoreet felis, eget ullamcorper nunc. Vivamus elit urna, varius et arcu vel, euismod auctor augue. Praesent scelerisque scelerisque libero sit amet euismod. Mauris eu est at felis feugiat tincidunt eu vel lectus. Ut pretium magna vitae massa sollicitudin, eu tincidunt sapien scelerisque. Maecenas gravida lorem non dui pretium, id vestibulum mi imperdiet. Fusce facilisis, dui nec ultrices molestie, nisi metus bibendum lacus, eget posuere est odio vitae nulla. Mauris laoreet non justo fringilla tempus. Mauris ut risus risus. Vivamus auctor accumsan gravida. Nam venenatis sapien nisl, quis accumsan odio dignissim non. Vestibulum aliquam semper condimentum. Suspendisse a eros elementum, dapibus quam in, aliquet lorem. Morbi mi dui, convallis at luctus ultricies, malesuada at leo. Morbi et turpis a ex vehicula ullamcorper. Vestibulum lacinia, orci eget elementum fermentum, lectus velit interdum erat, sit amet pharetra justo elit in tortor. Suspendisse ac vestibulum nisi. Nunc euismod metus nec elit sollicitudin blandit. Proin eleifend ex bibendum sodales blandit. Vestibulum varius pharetra arcu, sit amet pellentesque odio hendrerit nec. Integer faucibus imperdiet tortor a tempus. Sed accumsan condimentum nisl. Cras interdum sapien quis maximus commodo. Nulla malesuada imperdiet enim, non ornare elit auctor in. Fusce at ipsum eget turpis tincidunt maximus. Nunc sodales tortor nec tincidunt fringilla. Quisque sollicitudin ipsum at dolor faucibus, ultricies convallis ipsum convallis. Donec consequat velit vel molestie tempus. Donec et accumsan lacus, non sollicitudin quam. Morbi arcu lacus, blandit eu lacus nec, finibus tempus ligula.");
        txtArea1.setLabel("Using AUTO");

        txtArea2.setResizeRule(MaterialTextArea.ResizeRule.FOCUS);
        txtArea2.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam mauris, accumsan placerat lectus ac, tincidunt mattis nisl. Ut efficitur massa in libero gravida tincidunt. Vestibulum eget massa eget ex auctor tempus. Aenean vitae augue euismod, lacinia lectus ut, rhoncus enim. Sed vitae laoreet felis, eget ullamcorper nunc. Vivamus elit urna, varius et arcu vel, euismod auctor augue. Praesent scelerisque scelerisque libero sit amet euismod. Mauris eu est at felis feugiat tincidunt eu vel lectus. Ut pretium magna vitae massa sollicitudin, eu tincidunt sapien scelerisque. Maecenas gravida lorem non dui pretium, id vestibulum mi imperdiet. Fusce facilisis, dui nec ultrices molestie, nisi metus bibendum lacus, eget posuere est odio vitae nulla. Mauris laoreet non justo fringilla tempus. Mauris ut risus risus. Vivamus auctor accumsan gravida. Nam venenatis sapien nisl, quis accumsan odio dignissim non. Vestibulum aliquam semper condimentum. Suspendisse a eros elementum, dapibus quam in, aliquet lorem. Morbi mi dui, convallis at luctus ultricies, malesuada at leo. Morbi et turpis a ex vehicula ullamcorper. Vestibulum lacinia, orci eget elementum fermentum, lectus velit interdum erat, sit amet pharetra justo elit in tortor. Suspendisse ac vestibulum nisi. Nunc euismod metus nec elit sollicitudin blandit. Proin eleifend ex bibendum sodales blandit. Vestibulum varius pharetra arcu, sit amet pellentesque odio hendrerit nec. Integer faucibus imperdiet tortor a tempus. Sed accumsan condimentum nisl. Cras interdum sapien quis maximus commodo. Nulla malesuada imperdiet enim, non ornare elit auctor in. Fusce at ipsum eget turpis tincidunt maximus. Nunc sodales tortor nec tincidunt fringilla. Quisque sollicitudin ipsum at dolor faucibus, ultricies convallis ipsum convallis. Donec consequat velit vel molestie tempus. Donec et accumsan lacus, non sollicitudin quam. Morbi arcu lacus, blandit eu lacus nec, finibus tempus ligula.");
        txtArea2.setLabel("Using FOCUS");
    }

    private void buildTextBox() {
        txtBox1.setLabel("First Name");

        txtBox2.setLabel("Email");
        txtBox2.setIconType(IconType.ACCOUNT_CIRCLE);

        txtBox3.setLabel("Information");
        txtBox3.setIconType(IconType.INFO);
        txtBox3.setHelperText("A brief info about you");
    }
}
