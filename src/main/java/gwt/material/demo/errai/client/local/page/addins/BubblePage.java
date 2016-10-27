package gwt.material.demo.errai.client.local.page.addins;

import com.google.gwt.dom.client.Style;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.bubble.MaterialBubble;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.Position;
import gwt.material.design.client.ui.MaterialLabel;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "bubble")
public class BubblePage extends PageBase {

    @Inject
    @DataField
    MaterialBubble bubble;

    @Inject
    @DataField
    MaterialBubble bubble2, bubble3, bubble4, bubble5;

    @PostConstruct
    public void init() {
        initPage(this, "Bubble", "Addin component for chat module, it display a good bubble view of messages withing the chat module.", ADDINS);
        buildBasic();
        buildPosition();
    }

    private void buildPosition() {
        bubble2.setBackgroundColor(Color.BLUE);
        bubble2.setPosition(Position.LEFT);
        buildBubble(bubble2);

        bubble3.setBackgroundColor(Color.RED);
        bubble3.setPosition(Position.TOP);
        buildBubble(bubble3);

        bubble4.setBackgroundColor(Color.GREEN);
        bubble4.setPosition(Position.BOTTOM);
        buildBubble(bubble4);

        bubble5.setBackgroundColor(Color.PURPLE);
        bubble5.setPosition(Position.RIGHT);
        buildBubble(bubble5);
    }

    private void buildBasic() {
        bubble.setBackgroundColor(Color.BLUE);
        buildBubble(bubble);
    }

    private void buildBubble(MaterialBubble bubble) {
        bubble.setMarginLeft(20);
        bubble.setTextColor(Color.WHITE);
        bubble.setFloat(Style.Float.LEFT);

        MaterialLabel lblMesssage = new MaterialLabel();
        lblMesssage.setText("Hello there, How are you?");
        MaterialLabel lblName = new MaterialLabel();
        lblName.setText("John Doe");
        lblName.setFontSize("0.8em");
        bubble.add(lblMesssage);
        bubble.add(lblName);
    }

}
