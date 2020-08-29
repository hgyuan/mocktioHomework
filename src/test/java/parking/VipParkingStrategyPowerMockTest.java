package parking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ParkingLot.class})
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

    /* Exercise 6: Write test case for VipParkingStrategy calculateHourlyPrice
     * by using PowerMock to mock static method */


  }
}
