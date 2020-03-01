package com.gildedrose;

import com.gildedrose.item.OtherItem;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new OtherItem("foo", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals("foo", app.items[0].getName());
        assertThat(app.items[0].getQuality(), is(4));
        assertThat(app.items[0].getSell_in(), is(0));
    }

}
