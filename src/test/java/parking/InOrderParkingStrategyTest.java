package parking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static parking.ParkingStrategy.NO_PARKING_LOT;


@RunWith(MockitoJUnitRunner.class)
public class InOrderParkingStrategyTest {
  @InjectMocks
  InOrderParkingStrategy inOrderParkingStrategy;

  @Test
  public void testCreateReceipt_givenACarAndAParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() throws NoSuchMethodException {
    //given
    Car car = mock(Car.class);
    ParkingLot parkingLot = mock(ParkingLot.class);
    //when
    when(parkingLot.getName()).thenReturn("parkingLotName");
    when(car.getName()).thenReturn("carName");
    Receipt receipt = inOrderParkingStrategy.createReceipt(parkingLot, car);
    //then
    Assert.assertEquals("carName", receipt.getCarName());
    Assert.assertEquals("parkingLotName", receipt.getParkingLotName());
    /* Exercise 1, Write a test case on InOrderParkingStrategy.createReceipt()
     * With using Mockito to mock the input parameter */

  }

  @Test
  public void testCreateNoSpaceReceipt_givenACar_thenGiveANoSpaceReceipt() {
    //given
    Car car = mock(Car.class);
    //when
    when(car.getName()).thenReturn("carName");
    Receipt receipt = inOrderParkingStrategy.createNoSpaceReceipt(car);
    //then
    Assert.assertEquals("carName", receipt.getCarName());
    Assert.assertEquals(NO_PARKING_LOT, receipt.getParkingLotName());

    /* Exercise 1, Write a test case on InOrderParkingStrategy.createNoSpaceReceipt()
     * With using Mockito to mock the input parameter */

  }

  @Test
  public void testPark_givenNoAvailableParkingLot_thenCreateNoSpaceReceipt() {
    //given
    Car car = Mockito.spy(new Car("carName"));
    List<ParkingLot> parkingLots = Mockito.spy(new ArrayList<>());
    InOrderParkingStrategy parkingStrategy = Mockito.spy(new InOrderParkingStrategy());
    //when
    Receipt receipt = parkingStrategy.park(parkingLots, car);
    //then
    Assert.assertEquals("carName", receipt.getCarName());
    Assert.assertEquals(NO_PARKING_LOT, receipt.getParkingLotName());
    verify(parkingStrategy, times(1)).createNoSpaceReceipt(car);

    /* Exercise 2: Test park() method. Use Mockito.spy and
    Mockito.verify to test the situation for no available parking lot */

  }

  @Test
  public void testPark_givenThereIsOneParkingLotWithSpace_thenCreateReceipt() {
    //given
    Car car = Mockito.spy(new Car("carName"));
    List<ParkingLot> parkingLots = Mockito.spy(new ArrayList<>());
    ParkingLot parkingLot = Mockito.spy(new ParkingLot("richard", 10));
    parkingLots.add(parkingLot);
    InOrderParkingStrategy parkingStrategy = Mockito.spy(new InOrderParkingStrategy());
    //when
    Receipt receipt = parkingStrategy.park(parkingLots, car);
    //then
    Assert.assertEquals("carName", receipt.getCarName());
    Assert.assertEquals("richard", receipt.getParkingLotName());
    verify(parkingStrategy, times(0)).createNoSpaceReceipt(car);
    verify(parkingStrategy, times(1)).createReceipt(parkingLot, car);
    /* Exercise 2: Test park() method. Use Mockito.spy and
    Mockito.verify to test the situation for one available parking lot */

  }

  @Test
  public void testPark_givenThereIsOneFullParkingLot_thenCreateReceipt() {

    //given
    Car car = Mockito.spy(new Car("carName"));
    List<ParkingLot> parkingLots = Mockito.spy(new ArrayList<>());
    ParkingLot parkingLot = Mockito.spy(new ParkingLot("richard", 0));
    parkingLots.add(parkingLot);
    InOrderParkingStrategy parkingStrategy = Mockito.spy(new InOrderParkingStrategy());
    //when
    Receipt receipt = parkingStrategy.park(parkingLots, car);
    //then
    verify(parkingStrategy, times(1)).createNoSpaceReceipt(car);
    verify(parkingStrategy, times(0)).createReceipt(parkingLot, car);
    /* Exercise 2: Test park() method. Use Mockito.spy and
    Mockito.verify to test the situation for one available parking lot but it is full */

  }

  @Test
  public void testPark_givenThereIsMultipleParkingLotAndFirstOneIsFull_thenCreateReceiptWithUnfullParkingLot() {

    /* Exercise 3: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for multiple parking lot situation */

  }


}
