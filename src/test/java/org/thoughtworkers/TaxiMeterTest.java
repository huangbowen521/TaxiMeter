package org.thoughtworkers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 3/18/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaxiMeterTest {
    @Test
    public void shouldGetPriceWithDistanceLessThan3Km() throws Exception {
        //given
        double distance = 2;
        // when
        double price = new TaxiMeter().getPrice(distance,false);

        // then
        assertThat(price, is(8d));
    }

    @Test
    public void shouldGetPriceWithDistanceMoreThan3km() throws Exception {
        //given
        double distance = 4;
        //when
        double price = new TaxiMeter().getPrice(distance,false);

        //then
        assertThat(price, is(10d));
    }

    @Test
    public void shouldGetPriceWithDistanceLessThan3kmInNight() throws Exception {
        //given
        double distance = 1d;
        //when
        double price = new TaxiMeter().getPrice(distance, true);
        //then
        assertThat(price, is(10d));
    }

    @Test
    public void shouldGetPriceWithDistanceMoreThan3kmInNight()
    {
        //given
        double distance = 4d;

        // when
        double price = new TaxiMeter().getPrice(distance, true);

        // then
        assertThat(price,is(13d));
    }

    @Test
    public void shouldGetPriceWithStartInShuangliuAndWholeTravelInShuangliuAndLessThan3Km() throws Exception {
        // given
        double distance = 2d;
        Shuangliu shuangLiu = new Shuangliu();

        // when
        double price = new TaxiMeter(shuangLiu).getPrice(distance,false);

        // then
        assertThat(price,is(6d));

    }

    @Test
    public void shouldGetPriceWithStartInShuangliuAndWholeTravelInShuangliuAndMoreThan3Km() throws Exception {
        // given
        double distance = 5d;
        Shuangliu shuangLiu = new Shuangliu();

        // when
        double price = new TaxiMeter(shuangLiu).getPrice(distance,false);

        // then
        assertThat(price,is(9d));

    }
}
