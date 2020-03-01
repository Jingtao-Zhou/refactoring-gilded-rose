package com.gildedrose;

import com.gildedrose.item.AgedBrie;
import com.gildedrose.item.BackstagePassesTo_a_TAFKAL80ETC_Concert;
import com.gildedrose.item.OtherItem;
import com.gildedrose.item.SulfurasHandOfRagnaros;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new OtherItem("+5 Dexterity Vest", 10, 20), //
                new AgedBrie(2, 0), //
                new OtherItem("Elixir of the Mongoose", 5, 7), //
                new SulfurasHandOfRagnaros(0, 80), //
                new SulfurasHandOfRagnaros(-1, 80),
                new BackstagePassesTo_a_TAFKAL80ETC_Concert(15, 20),
                new BackstagePassesTo_a_TAFKAL80ETC_Concert(10, 49),
                new BackstagePassesTo_a_TAFKAL80ETC_Concert(5, 49),
                new BackstagePassesTo_a_TAFKAL80ETC_Concert(1, 20),
                // this conjured item does not work properly yet
                new OtherItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 3;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateItems();
        }
    }

}
