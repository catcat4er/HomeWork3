import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragNDropTest {

    @Test
    void dragAndDrop() {

// Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

// Перенесите прямоугольник А на место В
        sleep(1000);
        $("#column-a").dragAndDropTo("#column-b");

// Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
