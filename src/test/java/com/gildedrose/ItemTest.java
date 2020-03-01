package com.gildedrose;

import com.gildedrose.item.AgedBrie;
import com.gildedrose.item.BackstagePassesTo_a_TAFKAL80ETC_Concert;
import com.gildedrose.item.OtherItem;
import com.gildedrose.item.SulfurasHandOfRagnaros;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    private static final int NOT_EXPIRED = Integer.MAX_VALUE ;

    private static final int HAS_EXPIRED = -1;

    private static final int ENOUGH_QUALITY = 30;

    private static final int MAX_QUALITY = 50;

    @Test
    public void should_add_1_quality_when_update_Aged_Brie_quality() {
        Item item = new AgedBrie("Aged Brie", NOT_EXPIRED,0);
        item.updateItem();
        assertEquals(1, item.getQuality());
    }

    @Test
    public void should_add_1_quality_when_update_Backstage_passes_to_a_TAFKAL80ETC_concert_quality() {
        Item item = new BackstagePassesTo_a_TAFKAL80ETC_Concert("Backstage passes to a TAFKAL80ETC concert", NOT_EXPIRED,0);
        item.updateItem();
        assertEquals(1, item.getQuality());
    }

    @Test
    public void should_not_add_1_quality_when_update_other_quality_and_is_not_expired() {
        Item item = new OtherItem("other item", NOT_EXPIRED,0);
        item.updateItem();
        assertEquals(0, item.getQuality());
    }

    @Test
    public void should_not_add_1_quality_when_update_other_quality_and_is_expired() {
        Item item = new OtherItem("other item", HAS_EXPIRED,0);
        item.updateItem();
        assertEquals(0, item.getQuality());
    }

    @Test
    public void should_add_2_quality_when_update_Aged_Brie_quality_and_is_expired() {
        Item item = new AgedBrie("Aged Brie", HAS_EXPIRED,0);
        item.updateItem();
        assertEquals(2, item.getQuality());
    }

    @Test
    public void should_not_add_quality_when_quality_is_50() {
        Item item = new AgedBrie("Aged Brie", NOT_EXPIRED,MAX_QUALITY);
        item.updateItem();
        assertEquals(50, item.getQuality());
    }

    @Test
    public void should_not_sub_sell_in_when_update_Sulfuras_Hand_of_Ragnaros() {
        Item item = new SulfurasHandOfRagnaros("Sulfuras, Hand of Ragnaros", 5, ENOUGH_QUALITY);
        item.updateItem();
        assertEquals(5, item.getSell_in());
    }

    @Test
    public void should_sub_1_sell_in_when_update_except_Sulfuras_Hand_of_Ragnaros() {
        List<Item> itemList = get5SellInItemsWithEnoughQualityExceptSulfurasHandOfRagnaros();
        itemList.forEach(item -> {
            item.updateItem();
            assertEquals(4, item.getSell_in());
        });
    }

    @Test
    public void should_set_quality_to_0_when_expired_and_update_Backstage_passes_to_a_TAFKAL80ETC_concert() {
        Item item = new BackstagePassesTo_a_TAFKAL80ETC_Concert("Backstage passes to a TAFKAL80ETC concert", HAS_EXPIRED, ENOUGH_QUALITY);
        item.updateItem();
        assertEquals(0, item.getQuality());
    }

    @Test
    public void should_sub_2_quality_when_expired_and_update_except_Aged_Brie_and_Backstage_passes_to_a_TAFKAL80ETC_concert_and_Sulfuras_Hand_of_Ragnaros() {
        Item item = new OtherItem("other item", HAS_EXPIRED,5);
        item.updateItem();
        assertEquals(3, item.getQuality());
    }

    private List<Item> get5SellInItemsWithEnoughQualityExceptSulfurasHandOfRagnaros(){
        return Lists.newArrayList(
                new AgedBrie("Aged Brie", 5, ENOUGH_QUALITY),
                new BackstagePassesTo_a_TAFKAL80ETC_Concert("Backstage passes to a TAFKAL80ETC concert", 5, ENOUGH_QUALITY),
                new OtherItem("other item", 5, ENOUGH_QUALITY)
        );
    }
}
