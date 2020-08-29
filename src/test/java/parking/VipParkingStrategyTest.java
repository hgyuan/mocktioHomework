package parking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VipParkingStrategyTest {

  @InjectMocks
  VipParkingStrategy vipParkingStrategy;

  @Mock
  CarDao carDao;

  @Test
  public void testPark_givenAVipCarAndAFullParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {
    //given
    Car car = Mockito.spy(new Car("carName"));
    List<ParkingLot> parkingLots = Mockito.spy(new ArrayList<>());
    ParkingLot parkingLotOne = Mockito.spy(new ParkingLot("richard", 1));
    parkingLots.add(parkingLotOne);
    VipParkingStrategy parkingStrategy = Mockito.spy(new VipParkingStrategy());
    //when
    doReturn(true).when(parkingStrategy).isAllowOverPark(car);
    Receipt receipt = parkingStrategy.park(parkingLots, car);
    //then
    Assert.assertEquals("carName", receipt.getCarName());
    verify(parkingStrategy, times(1)).createReceipt(parkingLotOne, car);

    /* Exercise 4, Write a test case on VipParkingStrategy.park()
     * With using Mockito spy, verify and doReturn */

  }

  @Test
  public void testPark_givenCarIsNotVipAndAFullParkingLog_thenGiveNoSpaceReceipt() {
    //given
    Car car = Mockito.spy(new Car("carName"));
    List<ParkingLot> parkingLots = Mockito.spy(new ArrayList<>());
    ParkingLot parkingLotOne = Mockito.spy(new ParkingLot("richard", 1));
    parkingLots.add(parkingLotOne);
    VipParkingStrategy parkingStrategy = Mockito.spy(new VipParkingStrategy());
    //when
    doReturn(false).when(parkingStrategy).isAllowOverPark(car);
    doReturn(true).when(parkingLotOne).isFull();
    Receipt receipt = parkingStrategy.park(parkingLots, car);
    //then
    Assert.assertEquals("carName", receipt.getCarName());
    verify(parkingStrategy, times(1)).createNoSpaceReceipt(car);

    /* Exercise 4, Write a test case on VipParkingStrategy.park()
     * With using Mockito spy, verify and doReturn */
  }

  @Test
  public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsVipCar_thenReturnTrue() {
    //given
    Car car = Mockito.spy(new Car("ACarName"));
    //when
    when(carDao.isVip(any())).thenReturn(true);
    Boolean result = vipParkingStrategy.isAllowOverPark(car);
    //then
    Assert.assertEquals(true,result);
    /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
     * You may refactor the code, or try to use
     * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
     */
  }

  @Test
  public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsVipCar_thenReturnFalse() {

    /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
     * You may refactor the code, or try to use
     * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
     */
  }

  @Test
  public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsNotVipCar_thenReturnFalse() {
    /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
     * You may refactor the code, or try to use
     * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
     */
  }

  @Test
  public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsNotVipCar_thenReturnFalse() {
    /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
     * You may refactor the code, or try to use
     * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
     */
  }

  private Car createMockCar(String carName) {
    Car car = mock(Car.class);
    when(car.getName()).thenReturn(carName);
    return car;
  }
}
