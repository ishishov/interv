import tests.com.cake.appleStocks.AppleStocksNotSameDay;
import tests.com.cake.appleStocks.AppleStocksSameDay;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ishishov on 5/5/16.
 */
public class AppleStocksTest {

    @Test
    public void testAppleStocksNLOGNN() {
        int[] salesleft = {1, 8, 7, 2, 8, 5, 3, 7,1};
        int[] salesright = {2, 4, 7, 3, 8, 5, 1, 9};
        int[] salesmid = {1, 4, 7, 5, 3, 2, 10, 7};
        int[] salesSame = {10,9,8,7,6,6,5,4,3,2};
        int[] salesNegative = {10,9,8,7,6,5,4,3,2};
        Assert.assertEquals(7, new AppleStocksSameDay().getMaxProfit(salesleft));
        Assert.assertEquals(8, new AppleStocksSameDay().getMaxProfit(salesright));
        Assert.assertEquals(9, new AppleStocksSameDay().getMaxProfit(salesmid));
        Assert.assertEquals(0, new AppleStocksSameDay().getMaxProfit(salesSame));
        Assert.assertEquals(0, new AppleStocksSameDay().getMaxProfit(salesNegative));
    }

    @Test
    public void testAppleStocksNLOGN1() {
        int[] salesleft = {1, 8, 7, 2, 8, 5, 3, 7,1};
        int[] salesright = {2, 4, 7, 3, 8, 5, 1, 9};
        int[] salesmid = {1, 4, 7, 5, 3, 2, 10, 7};
        int[] salesSame = {10,9,8,7,6,6,5,4,3,2};
        int[] salesNegative = {10,9,8,7,6,5,4,3,2};
        Assert.assertEquals(7, new AppleStocksSameDay().getMaxProfitOptimized(salesleft));
        Assert.assertEquals(8, new AppleStocksSameDay().getMaxProfitOptimized(salesright));
        Assert.assertEquals(9, new AppleStocksSameDay().getMaxProfitOptimized(salesmid));
        Assert.assertEquals(0, new AppleStocksSameDay().getMaxProfitOptimized(salesSame));
        Assert.assertEquals(0, new AppleStocksSameDay().getMaxProfitOptimized(salesNegative));
    }

    @Test
    public void testAppleStocksN1() {
        int[] salesleft = {1, 8, 7, 2, 8, 5, 3, 7,1};
        int[] salesright = {2, 4, 7, 3, 8, 5, 1, 9};
        int[] salesmid = {1, 4, 7, 5, 3, 2, 10, 7};
        int[] salesSame = {10,9,8,7,6,6,5,4,3,2};
        int[] salesNegative = {10,9,8,7,6,5,4,3,2};
        Assert.assertEquals(7, new AppleStocksNotSameDay().getMaxProfitDynamic(salesleft));
        Assert.assertEquals(8, new AppleStocksNotSameDay().getMaxProfitDynamic(salesright));
        Assert.assertEquals(9, new AppleStocksNotSameDay().getMaxProfitDynamic(salesmid));
        Assert.assertEquals(0, new AppleStocksNotSameDay().getMaxProfitDynamic(salesSame));
        Assert.assertEquals(0, new AppleStocksSameDay().getMaxProfitDynamic(salesNegative));
        Assert.assertEquals(-1, new AppleStocksNotSameDay().getMaxProfitDynamic(salesNegative));
    }
}
