package parking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ParkingLot.class, Calendar.class})
public class VipParkingStrategyPowerMockTest {

  @InjectMocks
  VipParkingStrategy vipParkingStrategy;

  @Test
  public void testCalculateHourlyPrice_givenSunday_thenPriceIsDoubleOfSundayPrice() {
    //given
    PowerMockito.mockStatic(ParkingLot.class);
    //when
    Mockito.when(ParkingLot.getBasicHourlyPrice()).thenReturn(25);
    Integer price = vipParkingStrategy.calculateHourlyPrice();
    //then
    Assert.assertEquals(String.valueOf(50), String.valueOf(price));

    /* Exercise 6: Write test case for VipParkingStrategy calculateHourlyPrice
     * by using PowerMock to mock static method */

  }

  @Test
  public void testCalculateHourlyPrice_givenNotSunday_thenPriceIsDoubleOfNonSundayPrice() {
    //given
    PowerMockito.mockStatic(Calendar.class);
    //when
    Mockito.when(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)).thenReturn(Calendar.MONDAY);
    Integer price = vipParkingStrategy.calculateHourlyPrice();
    //then
    Assert.assertEquals(String.valueOf(40), String.valueOf(price));

    /* Exercise 6: Write test case for VipParkingStrategy calculateHourlyPrice
     * by using PowerMock to mock static method */


  }
}
