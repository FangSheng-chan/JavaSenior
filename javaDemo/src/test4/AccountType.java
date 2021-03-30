package test4;

/**
 * @author fangsheng
 * @date 2021/3/25 上午11:23
 */
enum AccountType {
    SAVING, FIXED, CURRENT;

    private AccountType() {
        System.out.println("it is a account type");
    }
}
