package tests.com.cake;

/**
 * Created by ishishov on 5/14/16.
 */
public class UniqueDeliveryId {

    public int findUniqueDeliveryId(int[] deliveryIds) {

        int uniqueDeliveryId = 0;

        for (int i = 0; i < deliveryIds.length; i++) {
            uniqueDeliveryId ^= deliveryIds[i];
        }

        return uniqueDeliveryId;
    }
}
