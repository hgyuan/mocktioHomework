package parking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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

    /* Exercise 1, Write a test case on InOrderParkingStrategy.createNoSpaceReceipt()
     * With using Mockito to mock the input parameter */

  }

  @Test
  public void testPark_givenNoAvailableParkingLot_thenCreateNoSpaceReceipt() {

    /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for no available parking lot */

  }

  @Test
  public void testPark_givenThereIsOneParkingLotWithSpace_thenCreateReceipt() {

    /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot */

  }

  @Test
  public void testPark_givenThereIsOneFullParkingLot_thenCreateReceipt() {

    /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot but it is full */

  }

  @Test
  public void testPark_givenThereIsMultipleParkingLotAndFirstOneIsFull_thenCreateReceiptWithUnfullParkingLot() {

    /* Exercise 3: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for multiple parking lot situation */

  }


}
