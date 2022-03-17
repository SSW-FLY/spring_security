package itcode.imp.enumeration;

/**
 * @author imp
 * @date 2022/3/10
 */
public enum DataType {

    /**
     *
     */
    offline_behavior(0),
    offline_order(1),
    offline_sku_info(2),
    offline_user(3),
    offline_comment(4);

    int value;

    DataType(int value) {
        this.value = value;
    }

}
